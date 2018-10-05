<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>DevOps Academy</title>
<link href="css/Header.css" rel="stylesheet" type="text/css">
<!-- Bootstrap -->
<link href="css/bootstrap_css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap_css/bootstrap-grid.css" rel="stylesheet">
<link href="css/bootstrap_css/bootstrap-reboot.css" rel="stylesheet">
<!-- Google Iocns -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Animate CSS-->
<link href="css/animate.css" rel="stylesheet" type="text/css">
<!--CSS files-->
<link href="css/User_management.css" rel="stylesheet" type="text/css">
<link href="css/Common.css" rel="stylesheet" type="text/css">
<link href="css/Notificatons.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/Sidebar.css">


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/Bootstrap_js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="js/Bootstrap_Noti/bootstrap-notify.js"
	type="text/javascript"></script>
<script src="js/noti_custom_js.js" type="text/javascript"></script>
<script src="js/Bootstrap_Noti/bootstrap-select.js"
	type="text/javascript"></script>
<!--JS Files-->
<script type="text/javascript" src="js/Common.js"></script>
</head>
<body class="scroll_css" ng-app>
	<!-- Header and Fixed Page Elements -->
	<div class="fixed-top">
		<div class="overlay"></div>
		<nav
			class="navbar navbar-expand-lg navbar-dark bg-white header_bg custom_padding_top_bottom">
			<div class="container-fluid">
							<a class="navbar-brand image_width no-gutters" href="#"> <img
					src="images/Brand_icon.png" alt="" width="130" class="" />
				</a>
				

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="material-icons text-dark">menu</i>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto mx-auto">
						<li><h1 class="noti_custom">DevOps Academy</h1></li>

					</ul>					
				</div>
			</div>
		</nav>
		<!--Title and Name for Page-->
		<div id="custom_bg_spacing" class="bg_spacing">
			<div class="custom_padding_BG">
				<div class="row custom_margin_BG">
					<div class="mx-2 my-0 color_black_custom">
						<h4>User Management</h4>
					</div>
					<div class="mx-2 my-1 opacity_50">
						<i class="fas fa-info-circle"></i>
					</div>
				</div>
				<hr class="mx-3 mt-2">
				<div class="alert alert-success" role="alert"
							ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
						<div class="alert alert-danger" role="alert"
							ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
			</div>
		</div>
	</div>
	<!-- BODY Elements -->
	<div id="custom_margin" class="custom_margin_BG py-7">
		<br>
		<hr>
		<div class="container shadow">
			<div
				class="row Genpact_custom_Blue_color color_white custom_radius_top_div">
				<div class="row mx-3 my-2 ">
					<h4>User</h4>
				</div>
			</div>
			<div class="row">
				<div class="container form_bg_modal p-0">

					<div>
					
						<form ng-submit="ctrl.submit()" name="myForm"
							class="row mx-3 mt-3 mb-0">
							<input type="hidden" ng-model="ctrl.user.id" />
							<div class="form-group col-6">
								<label for="uname">Name</label> <input type="text"
									class="form-control" ng-model="ctrl.user.name" id="uname"
									placeholder="Enter your Name." required ng-minlength="3" />
							</div>
							<!--Liquibase Part-->
							<!--<div class="form-group col-6">
								<label for="lastname">LastName</label> <input type="text"
									class="form-control" ng-model="ctrl.user.lastname" id="lastname"
									placeholder="Enter your LastName." ng-minlength="2" />
							</div>-->
							<div class="form-group col-6">
								<label for="age">Age</label> <input type="text"
									class="form-control" ng-model="ctrl.user.age" id="age"
									placeholder="Enter your Age." required
									ng-pattern="ctrl.onlyIntegers" />

							</div>
							<div class="form-group col-6">
								<label for="salary">Salary</label> <input type="text"
									class="form-control" ng-model="ctrl.user.salary" id="salary"
									placeholder="Enter your Salary." required
									ng-pattern="ctrl.onlyNumbers" />
							</div>

							<div class="px-1 pt-0 pb-1 mx-4" style="height: 54px;    margin-left: 41%!important;
    margin-top: 2%;">
								<div class="float-right">
									<button type="button" ng-click="ctrl.reset()"
										class="btn btn-secondary">RESET</button>
									
									<input type="submit"
										value="{{!ctrl.user.id ? 'Add' : 'Update'}}"
										class="btn btn-primary"
										ng-disabled="myForm.$invalid || myForm.$pristine">
								</div>

							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<br>
		<div class="container shadow Genpact_custom_Blue_color">
			<div
				class="row Genpact_custom_Blue_color color_white custom_radius_top_div">
				<div class="col-12 mx-3 my-2 p-1 ">
					<h4>List of Users</h4>
				</div>
				
			</div>
			<div class="row">
				<div class="container px-0">
					<table
						class="table table-hover custom_table_css Genpact_white_bg my-0">
						<thead class="thead-custom-color color_white">
							<tr>
								<th>ID</th>
								<th>Name</th>
								<!--Liquibase Part-->
							<!--<th>LastName</th>-->
								<th>Age</th>
								<th>Salary</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="u in ctrl.getAllUsers()">
								<td>{{u.id}}</td>
								<td>{{u.name}}</td>
								<!--Liquibase Part-->
								<!--<td>{{u.lastname}}</td>-->
								<td>{{u.age}}</td>
								<td>{{u.salary}}</td>
								
								<td><i class="fas fa-edit" ng-click="ctrl.editUser(u.id)"></i>
									<i class="fas fa-trash-alt" ng-click="ctrl.removeUser(u.id)"></i></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<br>
	</div>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/Bootstrap_js/popper.min.js" type="text/javascript"></script>
	<script src="js/Bootstrap_js/popover.js" type="text/javascript"></script>
	<script src="js/Bootstrap_js/bootstrap.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/User_Management.js"></script>
	<!-- jQuery Custom Scroller CDN -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>
</body>
</html>
