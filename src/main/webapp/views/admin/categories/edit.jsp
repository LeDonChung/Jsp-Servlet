
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
	<div class="container">
		<!-- Begin Page Content -->
		<div class="container-fluid">

			<!-- Page Heading -->
			<div
				class="d-sm-flex align-items-center justify-content-between mb-4">
				<c:if test="${action == 'add'}">
					<h1 class="h3 mb-0 text-gray-800">Category Add</h1>
				</c:if>
				<c:if test="${action == 'update'}">
					<h1 class="h3 mb-0 text-gray-800">Category Update</h1>
				</c:if>
				<!-- Button to Open the Modal -->
				<a class="btn btn-primary"
					href="<c:url value='/admin/categories?type=list'/>">BACK</a>
			</div>

			<!-- Content Row -->
			<div class="row">
			<c:if test="${ message != null}">
				<div class="alert alert-danger" role="alert">${ message }</div>
			</c:if>  
				<form id="formSubmit">
				<c:if test="${ category.id != null}"> 
					<input id="id" name="id" value = "${category.id}" type="hidden"/>
				</c:if>
					
					 
					<div class="form-group">
						<label for="name">Name</label> <input type="text"
							value="${category.name}" class="form-control" name="name" id="name"
							placeholder="Input name"> 
					</div>
 
					<div class="form-group">
						<label for="code">Code</label> <input type="text"
							value="${category.code}" class="form-control" name="code" id="code"
							placeholder="Input code">
					</div>

					<c:if test="${action == 'add' }">
						<button type="submit" id="btnAdd" class="btn btn-primary">ADD</button>
					</c:if>

					<c:if test="${action == 'update' }">
						<button type="submit" id="btnUpdate" class="btn btn-primary">UPDATE</button>
					</c:if>
					
				</form>
			</div>

		</div>
		<!-- /.container-fluid -->

	</div>

<script> 
	<!--Trang HTML load hết thì nó mới có -->
	$(document).ready(function() {
		$('#formSubmit').submit(function(e) {
			e.preventDefault();
			// Khởi tạo object
			let dataJson = {};

			// phân giải form ra mảng object
			let formData = $('#formSubmit').serializeArray();

			// duyệt từng phẩn tử trong mảng truyền {key, value} vào dataJson object
			formData.forEach(function(data, index) {
				dataJson[data.name] = data.value;
			});
			
			let idElement = $('#id'); 
			if(idElement.length == 0) {
				addCategory(dataJson);
			} else {
				updateCategory(idElement.val(), dataJson);
			}


		});  
		function updateCategory(id, data) {
			data['id'] = id; 
			$.ajax({
						url : 'http://localhost:8080/first-project/api/categories',
						type : 'PUT',
						contentType : 'application/json',
						dataType : 'json',
						data : JSON.stringify(data),
						success : function(result) { 
							window.location.href = 'http://localhost:8080/first-project/admin/categories?type=list&message=UPDATE_CATEGORY_SUCCESS'
						},  
						error : function(error) { 
							window.location.href = 'http://localhost:8080/first-project/admin/categories?type=edit&message=SERVER_ERRORS'
						}
					});
		}
		function addCategory(data) { 
			$.ajax({
						url : 'http://localhost:8080/first-project/api/categories',
						type : 'POST',
						contentType : 'application/json',
						dataType : 'json',
						data : JSON.stringify(data),
						success : function(result) { 
							window.location.href = 'http://localhost:8080/first-project/admin/categories?type=list&message=ADD_CATEGORY_SUCCESS'
						},  
						error : function(error) { 
							window.location.href = 'http://localhost:8080/first-project/admin/categories?type=edit&message=SERVER_ERRORS'
						}
					});
		}
	});
</script>
</body>
</html>