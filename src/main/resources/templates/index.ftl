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

<script type="text/javascript" src="js/main.js"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="page-header">
					<div class="row">
						<div id="logo" class="col-md-8">
							<h2>Catalog of coins</h2>
						</div>
						<div class="col-md-4">
							<form id="logout" action="/logout" method="POST">
								<input type="submit" class="btn btn-link" value="Sign Out" />
							</form>
						</div>
					</div>
				</div>
				<table id="list_coins" class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>Id</th>
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
								<h4 class="modal-title">Modal title</h4>
							</div>
							<div class="modal-body">
								<form id="popup" class="form-horizontal" method="post"
									role="form">
									<div class="form-group">
										<label class="col-sm-2 control-label" for="id">Id</label>
										<div class="col-sm-10">
											<input type="number" readonly class="form-control" name="id"
												placeholder="Id" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="currency">Currency</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="currency"
												placeholder="Currency" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="value">Value</label>
										<div class="col-sm-10">
											<input type="number" class="form-control" name="value"
												placeholder="Value" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="year">Year</label>
										<div class="col-sm-10">
											<input type="number" class="form-control" name="year"
												placeholder="Year" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label" for="mint">Mint</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="mint"
												placeholder="Mint" />
										</div>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
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
								<h4 class="modal-title">My Modal</h4>
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
			</div>
		</div>
	</div>
</body>
</html>