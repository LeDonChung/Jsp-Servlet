
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Dashboard</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body>

	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<div class="d-sm-flex align-items-center justify-content-between mb-4">
			<h1 class="h3 mb-0 text-gray-800">Category Manager</h1>
			<!-- Button to Open the Modal -->
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#showAdd">ADD</button>
		</div>

		<!-- Content Row -->
		<div class="row">
			<table class="table" style="background-color: #fff;">
				<thead>
					<tr>
						<td>ID</td>
						<td>Name</td>
						<td>Code</td>
						<td>Action</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="category" items="${ categories }">
						<tr>
							<td>${ category.id }</td>
							<td>${ category.name }</td>
							<td>${ category.code }</td>
							<td>
								<button type="button" class="btn btn-primary">Update</button>
								<button type="button" class="btn btn-warning">Delete</button>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>

	</div>
	<!-- /.container-fluid -->

	<!-- The Modal -->
	<div class="modal fade" id="showAdd">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Add category</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				
				<form id="formSubmit">
				
					<div class="form-group">
						<label for="name">Name</label>
						<input type="text" class="form-control" name="name" id="name" placeholder="Input name">
					</div>

					<div class="form-group">
						<label for="code">Code</label>
						<input type="text" class="form-control" name="code" id="code" placeholder="Input code">
					</div>
				
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
				

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

	<script>
		$(document).ready(function() {
			$('#formSubmit').submit(function(event) {
				// chặn sự kiện mặc địnhj cuar form
				event.preventDefault();

				// lấy data
				let nameValue = $('#name').val();
				let codeValue = $('#code').val();

				// tạo object
				let objectJson = {};
				// thêm value vào object theo cặp  {key: value}
				objectJson['name'] = nameValue;
				objectJson['code'] = codeValue;
 
				// convert object -> json
				// console.log(JSON.stringify(objectJson));

				// call api

				$.ajax({
						url : 'http://localhost:8080/first-project/api/categories',
						type : 'POST',
						contentType : 'application/json',
						dataType : 'json',
						data : JSON.stringify(objectJson),
						success : function(result) {
							console.log(result);
						},
						error : function(error) { 
							console.log(error);
						}
					});

			});
		});
	</script>
</body>
</html>