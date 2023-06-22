<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%@ include file="/common/taglib.jsp" %>
		<html lang="en">

		<head>

			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<meta name="description" content="">
			<meta name="author" content="">

			<title>SB Admin 2 - Dashboard</title>

			<!-- Custom fonts for this template-->
			<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
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
					<h1 class="h3 mb-0 text-gray-800">
						<c:out value="${pageHeading}"></c:out>
					</h1>
					<button type="button" id="addCategory" data-toggle="modal" data-target="#addModal"
						class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Add
						Category</button>
				</div>

				<!-- Content Row -->
				<div class="row">
					<c:if test="${message != null}">
						<div class="col c-12 alert alert-primary text-center"><b><c:out value="${message}"></c:out></b></div>
					</c:if>	 
					
					<table class="table" style="background-color: #fff;">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Name</th>
								<th scope="col">Code</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="category" items="${categories}">
								<tr>
									<td>
										<c:out value="${category.id}"></c:out>
									</td>
									<td>
										<c:out value="${category.name}"></c:out>
									</td>
									<td>
										<c:out value="${category.code}"></c:out>
									</td>
									<th>
										<button class="btn btn-primary">Update</button>
										<button class="btn btn-warning">Delete</button>
									</th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
			<!-- /.container-fluid -->
			<!-- Modal -->
			<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Add category</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<form id="formSubmit">
								<div class="form-group">
									<label for="name">Category Name</label>
									<input type="text" class="form-control" id="name" name="name" placeholder="Name" />
								</div>
								<div class="form-group">
									<label for="code">Category Code</label>
									<input type="text" class="form-control" id="code" name="code" placeholder="Code" />
								</div>
								<button type="submit" class="btn btn-primary"> Submit </button>

							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>

			<script type="text/javascript">
				$(document).ready(function () {
					$('#formSubmit').submit(function (event) {
						
						event.preventDefault();
						let data = {};
						data['name'] = $('#name').val();
						data['code'] = $('#code').val();

						$.ajax({
								url: 'http://localhost:8080/first-project/api/categories',
								type: 'POST',
								contentType: 'application/json',
								dataType: 'json',
								data: JSON.stringify(data),
								success: function (result) {
									window.location.href="http://localhost:8080/first-project/admin/categories?type=list&message=ADD_SUCCESS";
								},
								error: function (error) {
									window.location.href="http://localhost:8080/first-project/admin/categories?type=list&message=ADD_FAIL";
								}
						});
					});
				});
			</script>
		</body>

		</html>