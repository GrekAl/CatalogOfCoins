<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catalog of coins</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/datatable.min.css"
	media="screen">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/datatable.jquery.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>

</head>
<body>
	<h3>Catalog of coins</h3>
	<br>
	<br>
	<div class="mainHead">
            <form action="/logout" method="POST">
                <input type="submit" value="Sign Out"/>
                <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
            </form>
        </div>
	<div>
		<table id="list_coins" border="1">
			<thead>
				<tr>
					<th>id</th>
					<th>currency</th>
					<th>value</th>
					<th>year</th>
					<th>mint</th>
					<th>actions</th>
				</tr>
			</thead>
		</table>
		<button id="btn_test">Test</button>
		<button id="btn_add">Add coin</button>
		<button id="btn_search">Search</button>
		<button id="btn_show_all">Show all</button>
		<div id = "dialog-form" class="modal">
		<form id="popup"  method="post" name="showP">
		 <input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div class="content">
				<div class="info_row">
					<label>Id <input type="text" name="id" value="1"/></label> 
					<label> Currency <input type="text"
						name="currency" value="1"/>
					</label> <label> Value <input type="number" name="value" value="1"/>
					</label> <label> Year <input type="number" name="year" value="1"/>
					</label> <label> Mint <input type="text" name="mint" value="1"/>
					</label>
				</div>
				<div class="button_row">
					<button class='bt-close'>Close</button>
				</div>
			</div>
		</form>
		</div>
		<div id = "dialog-confirm" class="modal">
			<div id = "dialog-message"></div>
			<div class="button_row">
				<button class='bt-close'>Cancel</button>
				<button class='bt-confirm'>Yes</button>
			</div>
		</div>
	</div>
</body>
</html>