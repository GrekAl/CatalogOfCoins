<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="panel-body">
		<#if logout>
		<div class="alert alert-info" role="alert">You've been logged
			out successfully.</div>
		</#if>
		<#if error>
		<div class="alert alert-danger" role="alert">Invalid Username or
			Password!</div>
		</#if>
		<form role="form" method="post">
		
			<div>
				<label for="username">Username</label> <input type="text"
					name="username" id="username" required autofocus />
			</div>
			<div>
				<label for="password">Password</label> <input type="password"
					name="password" id="password" required />
			</div>
			<button type="submit">Sign in</button>
		</form>
	</div>

</body>
</html>