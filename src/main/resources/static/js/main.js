$(function() {

	//table.ajax.url( 'newData.json' ).load();
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
	            defaultContent: getHtmlText()
	        } ],
	        searching: false,
	        ordering:  false,
	        serverSide: true,
	        processing : true,
	    };
	var table = $('#list_coins').DataTable(dataTableOptions);
	
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
		return "<button class='dt-view'>View</button>" +
				"<button class='dt-edit'>Edit</button>" +
				"<button class='dt-delete'>Delete</button>";
	}
	
	function showModal(block) {
		block.modal({
        	escapeClose: false,
        	clickClose: false,
        	showClose: false
        });
	}
	
	table.on('draw.dt',function(){
		$(".dt-edit").each(function(){
	        $(this).click(function() {
	            var data = table.row($(this).parents('tr')).data();
//	            var form = $("form#popup").show();
	            showModal($("#dialog-form"));
	            $("input").attr("readonly", false);
	            fillForm(form, data);
	            form.find(".button_row").append("<input name='edit' type='submit' class='btn btnInputSize brown' value='Save'/>");
	            form.find("input[name='edit']").click(function(e) {
	            	e.preventDefault();
	            	$.post({
	                    url: 'api/coins/edit',
	                    data: form.serialize(),
	                    success: function(result) {
	                    	table.draw(false);
	                    	$.modal.close();
	                    },
	                    error: function(jqXHR, exception) {
	                    	console.log(jqXHR);
	                    }
	                  });
	            	
	            });
	        });
	    });
		$(".dt-view").each(function(){
	        $(this).click(function() {
	            var data = table.row($(this).parents('tr')).data();
	            showModal($("#dialog-form"));
	            $("input").attr("readonly", true);
	            fillForm(form, data);
	        });
	    });
		$(".dt-delete").each(function(){
	        $(this).click(function() {
	        	var data = table.row($(this).parents('tr')).data();
	        	$("#dialog-message").text("Are you sure you want to delete coin with id = "+ data.id);
	        	showModal($("#dialog-confirm"));
	        	$(".bt-confirm").one("click", function() {
	        		console.log("delete");
	        		$.ajax({
	        	        url: 'api/coins/delete/'+ data.id,
	        	        type: 'DELETE',
	        	        success: function(result) {
	        	        	table.draw(false);
	        	        	$.modal.close();
	        	        },
	        	        error: function(jqXHR, exception) {
		                    console.log(jqXHR);
		                }
	        		});
	        	});
	        });
	    });
	});
	
	$("#btn_add").click(function() {
		showModal($("#dialog-form"));
		$("input").attr("readonly", false);
		//$("input[type='text']").val("");
		//$("input[type='number']").val(0);
		form[0].reset();
		form.find(".button_row").append("<input name='add' type='submit' class='btn btnInputSize brown' value='Add'/>");
        form.find("input[name='add']").click(function(e) {
        	e.preventDefault();
        	$.post({
                url: 'api/coins/add',
                data: form.serialize(),
                success: function(result) {
                	table.draw(false);
                	$.modal.close();
                },
                error: function(jqXHR, exception) {
                	console.log(jqXHR);
                }
              });
        	
        });
		
	});
	
	$("#btn_search").click(function() {
		showModal($("#dialog-form"));
		$("input").attr("readonly", false);
		//$("input[type='text']").val("");
		//$("input[type='number']").val(0);
		form.find(".button_row").append("<input name='search' type='submit' class='btn btnInputSize brown' value='Search'/>");
        form.find("input[name='search']").click(function(e) {
        	e.preventDefault();
        	table.destroy();
        	dataTableOptions.ajax = {
                    dataSrc: "data",
                    url: "api/coins/search",
                    type: "POST",
                    data: function(d) {
                        var frm_data = $('form').serializeArray();
                        $.each(frm_data, function(key, val) {
                          d[val.name] = val.value;
                        });
                    }
                };
        	table = $('#list_coins').DataTable(dataTableOptions);
        	$.modal.close();
        });
		
	});
	
	$("#btn_show_all").click(function() {
		table.destroy();
    	dataTableOptions.ajax = {
            url: "api/coins/all",
            dataSrc: "data",
        };
    	table = $('#list_coins').DataTable(dataTableOptions);
	});
	
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
	}
			
	$(".bt-close").click(function(e) {
		e.preventDefault();
		$.modal.close();
	});	
	
	$(document).on($.modal.CLOSE, function(event, modal) {
		form.find("input[type='submit']").remove();
	});
	
});
