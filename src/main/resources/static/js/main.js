$(function() {

	var table;
	var admin;		
	var form = $("form#popup");
	var dataTableOptions = {
	        ajax: {
	            url: "api/coins/all",
	            dataSrc: "data",
	        },
	        columns: [
	            { data: "id" },
	            { data: "currency" },
	            { data: "value" },
	            { data: "year" },
	            { data: "mint" },
	            { data: null }
	        ],
	        columnDefs: [ {
	            targets: -1,
	            defaultContent: "",
	            width: 60,
	        } ],
	        searching: false,
	        ordering:  false,
	        serverSide: true,
	        processing : true,
	    };
	
	$.ajax({
        url: 'api/coins/edit',
        type: 'POST',
        complete: function(xhr, textStatus) {
        	admin = xhr.status != 403;
        	console.log(xhr.status);
        	console.log(admin);
        	initDateTable(dataTableOptions);
        	setEvents();
			//$("#popup").validator();
        } 
	});	
	
	$('#btn_test').click(function() {
		$.ajax({
	        url: 'api/coins/delete/2',
	        type: 'DELETE',
	        success: function(result) {
	        	table.draw(false);
	        }
		});	
	});
	
	function getHtmlText() {
		var str = "<div class='panel-act'><a href='#' class='dt-view act'><span class='glyphicon glyphicon-info-sign' data-toggle='tooltip' title='Show info'></span></a>";
		if (admin) {
			str+="<a href='#' class='dt-edit act'><span class='glyphicon glyphicon-pencil' data-toggle='tooltip' title='Edit'></span></a>" +
			"<a href='#' class='dt-delete act'><span class='glyphicon glyphicon-remove red' title='Delete'></span>";
		}
		str+="</div>";
		console.log(str);
		return str;
	}
	
	function showModal(block) {
/*		block.modal({
        	escapeClose: false,
        	clickClose: false,
        	showClose: false
        });*/
		block.modal({
			show: true,
            keyboard: false,
            backdrop: 'static'
        }); 
	}
	
	function initDateTable(dataTableOptions) {
		dataTableOptions.columnDefs[0].defaultContent = getHtmlText();
    	table = $('#list_coins').DataTable(dataTableOptions);
		var html = "<div id ='panel-btns'>";
		if (admin) {
			html+= "<a id='dt-add' class='act' href='#'><span class='glyphicon glyphicon-plus data-toggle='tooltip' title='Add coin'></span></a>"
		}
		html+="<a id='dt-show-all' class='act' href='#'><span class='glyphicon glyphicon-refresh data-toggle='tooltip' title='Show all'></span></a>" +
			"<a id='dt-search' class='act' href='#'><span class='glyphicon glyphicon-search data-toggle='tooltip' title='Search'></span></a></div>";
		$('#list_coins_wrapper div.row:first-child div:nth-child(2)').append(html);		
	}
	
	function setEvents() {
		table.on('draw.dt',function() {
			$(".dt-edit").each(function(){
		        $(this).click(function() {
		            var data = table.row($(this).parents('tr')).data();
//		            var form = $("form#popup").show();
//		            showModal($("#dialog-form"));
		            $("#modal-dialog input").attr("readonly", false);
		            $("#modal-dialog textarea").attr("readonly", false);
		            fillForm(form, data);
		            $("#modal-dialog .modal-title").text("Edit coin with id="+data.id);
		            $("#modal-dialog").find(".modal-footer").append("<input name='edit' type='submit' class='btn btn-primary' value='Save changes'/>");
					$("#modal-dialog form").off();
		            console.log("edit");
		            showModal($("#modal-dialog"));
		            $("#modal-dialog form").validator().on('submit', function(e) {
		            	if (!e.isDefaultPrevented()) {
			            	e.preventDefault();
			            	$.post({
			                    url: 'api/coins/edit',
			                    data: form.serialize(),
			                    success: function(result) {
			                    	table.draw(false);
			                    	$("#modal-dialog").modal("hide");
			                    },
			                    error: function(jqXHR, exception) {
			                    	console.log(jqXHR);
			                    }
			                  });
		            	}		            	
		            });
		        });
		    });
			$(".dt-view").each(function(){
		        $(this).click(function() {
		            var data = table.row($(this).parents('tr')).data();
		            console.log("show");
		            $("#modal-dialog .modal-title").text("Coin with id="+data.id);
		            $("#modal-dialog input").attr("readonly", true);
		            $("#modal-dialog textarea").attr("readonly", true);
		            fillForm(form, data);
		            showModal($("#modal-dialog"));
		        });
		    });
			$(".dt-delete").each(function(){
		        $(this).click(function() {
		        	var data = table.row($(this).parents('tr')).data();
		        	$("#modal-confirm .modal-body").text("Are you sure you want to delete the coin with id = "+ data.id);
		        	showModal($("#modal-confirm"));
		        	console.log("delete");
		        	$("#btn-confirm").one("click", function() {
		        		console.log("delete");
		        		$.ajax({
		        	        url: 'api/coins/delete/'+ data.id,
		        	        type: 'DELETE',
		        	        success: function(result) {
		        	        	table.draw(false);
		        	        	$("#modal-confirm").modal("hide");
		        	        },
		        	        error: function(jqXHR, exception) {
			                    console.log(jqXHR);
			                }
		        		});
		        	});
		        });
		    });
		});
		
		table.on('init.dt',function() {
			$("#dt-add").click(function() {
				$("#modal-dialog input").attr("readonly", false);
				$("#modal-dialog textarea").attr("readonly", false);
				form[0].reset();
				$("#modal-dialog").find(".modal-footer").append("<input name='add' type='submit' class='btn btn-primary' value='Add'>");
				$("#modal-dialog .modal-title").text("Add coin");				
				console.log("add");
				showModal($("#modal-dialog"));
				$("#modal-dialog form").off();
				$("#modal-dialog form").validator().on('submit', function(e) {
					console.log(e.isDefaultPrevented());
					if (!e.isDefaultPrevented()) {
			        	e.preventDefault();
			        	$.post({
			                url: 'api/coins/add',
			                data: form.serialize(),
			                success: function(result) {
			                	table.draw(false);
			                	$("#modal-dialog").modal("hide");
			                },
			                error: function(jqXHR, exception, error) {
			                	console.log(jqXHR);
			                	alert(jqXHR.responseText);
			                }
			            });
					}
		        	
		        });	
			});
			
			$("#dt-search").click(function() {
				showModal($("#modal-dialog"));
				console.log("search");
				$("#modal-dialog input").attr("readonly", false);
				$("#modal-dialog textarea").attr("readonly", false);
				//$("input[type='text']").val("");
				//$("input[type='number']").val(0);
				form[0].reset();
				$("#modal-dialog .modal-title").text("Search coin");
				$("#id").show();
				$("#modal-dialog").find(".modal-footer").append("<input name='search' type='submit' class='btn btn-primary' value='Search'/>");
				$("#modal-dialog").find("input[name='search']").click(function(e) {
		        	e.preventDefault();
		        	table.destroy();
		        	var data = new Array();
		        	var frm_data = $('form#popup').serializeArray();
                    $.each(frm_data, function(key, val) {
                      data[val.name] = val.value;
                    });
		        	dataTableOptions.ajax = {
		                    dataSrc: "data",
		                    url: "api/coins/search",
		                    type: "POST",
		                    data: data,
		                    error: function(jqXHR, exception, error) {
		                    	console.log(jqXHR);
		                    }
		                };
		        	initDateTable(dataTableOptions);
		        	$("#modal-dialog").modal("hide");
		        });
				
			});
			
			$("#dt-show-all").click(function() {
				table.destroy();
		    	dataTableOptions.ajax = {
		            url: "api/coins/all",
		            dataSrc: "data",
		        };
		    	//table = $('#list_coins').DataTable(dataTableOptions);
		    	initDateTable(dataTableOptions);
			});
		});
	}
	
	$.fn.serializeObject = function(){
		   var obj = {};		    
		   $.each( this.serializeArray(), function(i,o){
		      var n = o.name, v = o.value;		        
		      obj[n] = obj[n] === undefined ? v
		         : $.isArray( obj[n] ) ? obj[n].concat( v )
		         : [ obj[n], v ];
		   });		    
		   return obj;
	};
	
	function fillForm(form, data) {
		form.find( "input[name='id']" ).val(data.id);
		form.find( "input[name='currency']" ).val(data.currency);
		form.find( "input[name='value']" ).val(data.value);
		form.find( "input[name='year']" ).val(data.year);
		form.find( "input[name='mint']" ).val(data.mint);
		form.find( "textarea[name='description']" ).val(data.description);
	}

	$('#modal-dialog').on('hidden.bs.modal', function (e) {
		console.log("hide");
		$(this).find("input[type='submit']").remove();
		$("#popup").validator("destroy");
		$("#id").hide();
	})
/*	$(".bt-close").click(function(e) {
		e.preventDefault();
		$.modal.close();
	});	
	
	$(document).on($.modal.CLOSE, function(event, modal) {
		form.find("input[type='submit']").remove();
	});*/
	
});
