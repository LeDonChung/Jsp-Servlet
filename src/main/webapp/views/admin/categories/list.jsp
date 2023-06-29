
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
			<a class="btn btn-primary"
				href="<c:url value='/admin/categories?type=edit'/>">ADD</a>
		</div>

		<!-- Content Row -->
		<div class="row">
			<c:if test="${ message != null}">
				<div class="alert alert-success" role="alert">${ message }</div>
			</c:if> 

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
								<a href="<c:url value='/admin/categories?type=edit&id=${category.id}'/>" class="btn btn-primary">Update</a>
								<button type="button" id="btnDelete" onclick="handlerActionDelete(${ category.id })" class="btn btn-warning">Delete</button>
							</td>  
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>

	</div>
	<!-- /.container-fluid -->

	<!-- The Modal 
	
	<div class="modal fade" id="showAdd">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<h4 class="modal-title">Add category</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				
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
				

				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>
--->
	
	<script>
		function handlerActionDelete(id) {
			var data = {
				'id': id
			}
			// data['id'] = id;
			$.ajax({
						url : 'http://localhost:8080/first-project/api/categories',
						type : 'DELETE',
						contentType : 'application/json',
						dataType : 'json',
						data : JSON.stringify(data),
						success : function(result) { 
							window.location.href = 'http://localhost:8080/first-project/admin/categories?type=list&message=DELETE_CATEGORY_SUCCESS'
						},  
						error : function(error) { 
							window.location.href = 'http://localhost:8080/first-project/admin/categories?type=edit&message=SERVER_ERRORS'
						}
					});
		}
		
	</script> 
	
</body>
</html>