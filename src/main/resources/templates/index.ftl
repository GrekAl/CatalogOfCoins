<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catalog of coins</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js"></script>
	

<script type="text/javascript" src="js/main.js"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
			<div class="header clearfix">
		        <form id="logout" action="/logout" method="POST" class="nav nav-pills pull-right">
					<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-log-out"></span> Log out</button>
				</form>
				<div id="logo">
		        	<h3>Catalog of coins</h3>
		        </div>
     		</div>				
				<table id="list_coins" class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Currency</th>
							<th>Value</th>
							<th>Year</th>
							<th>Mint</th>
							<th>Actions</th>
						</tr>
					</thead>
				</table>
				<div id="modal-dialog" class="modal fade" tabindex="-1"
					role="dialog">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title"></h4>
							</div>
							<div class="modal-body">
								<form id="popup" class="form-horizontal" method="post"
									role="form">
									<div id="id" class="form-group">
										<label class="col-sm-2 control-label" for="id">Id</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="id"/>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="currency">Currency</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="currency"
												required="required" data-error="This field is required"/>
											<div class="help-block with-errors"></div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="value">Value</label>
										<div class="col-sm-10">
											<input type="text" pattern="\d*" maxlength="4" class="form-control" name="value"
												required="required" data-error="Please, enter a valid value"/>
											<div class="help-block with-errors"></div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="year">Year</label>
										<div class="col-sm-10">
											<input type="text" pattern="\d*" maxlength="4" class="form-control" name="year"
												required="required" data-error="Please, enter a valid year"/>
											<div class="help-block with-errors"></div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="mint">Mint</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="mint"
												required="required" data-error="This field is required"/>
											<div class="help-block with-errors"></div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="description">Description</label>
										<div class="col-sm-10">
											<textarea class="form-control" name="description" rows="5"></textarea>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</form>
							</div>
						</div>
					</div>
					>
				</div>

				<div id="dialog-confirm" class="modal">
					<div id="dialog-message"></div>
					<div class="button_row">
						<button class='bt-close'>Cancel</button>
						<button class='bt-confirm'>Yes</button>
					</div>
				</div>

				<div id="modal-confirm" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">Сonfirm deletion</h4>
							</div>
							<div class="modal-body"></div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Cancel</button>
								<button id="btn-confirm" type="button" class="btn btn-primary">Yes</button>
							</div>
						</div>
					</div>
				</div>
				<footer class="footer">
        <p>© 2018 Catalog of coins</p>
      </footer>
			</div>
		</div>
	</div>
</body>
</html>