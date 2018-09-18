<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Catalog of coins</title>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div id="login" class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Login with Username and Password</h3>
					</div>
					<div class="panel-body">
						<#if logout>
							<div class="alert alert-info" role="alert">You've been logged out successfully.</div>
						</#if>
						<#if error>
							<div class="alert alert-danger" role="alert">Invalid Username or Password!</div>
						</#if>
						<form role="form" method="post">

							<div class="form-group">
								<label for="username">Username</label> <input type="text" class="form-control" id="username" placeholder="Username" name="username">
							</div>
							<div class="form-group">
								<label for="password">Password</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password">
							</div>
							<button type="submit" class="btn btn-default pull-right"><span class="glyphicon glyphicon-log-in"></span> Log in</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>