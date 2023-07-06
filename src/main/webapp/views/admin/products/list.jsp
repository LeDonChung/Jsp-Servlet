
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
			<h1 class="h3 mb-0 text-gray-800">Product Manager</h1>
			<!-- Button to Open the Modal -->
			<a class="btn btn-primary"
				href="<c:url value='/admin/products?type=edit'/>">ADD</a>
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
						<td>Product Name</td>
						<td>Sale Price</td>
						<td>Cost Price</td>
						<td>Quantity</td>
						<td>Image</td>
						<td>Category</td>
						<td>Action</td>
					</tr>
				</thead>
				<tbody>
				 
					<c:forEach var="product" items="${ products }">
						<tr>
							<td>${ product.id }</td>
							<td>${ product.productName }</td>
							<td>${ product.salePrice }</td> 
							<td>${ product.costPrice }</td> 
							<td>${ product.quantity }</td>
							<td>
								<img src="${ product.imageUrl }" style="width:100px;"></img>
							</td>
							
							<td>${ product.categoryId }</td>
							<td> 
								<a href="<c:url value='/admin/products?type=edit&id=${ product.id }'/>" class="btn btn-primary">Update</a>
								<c:if test="${ product.is_deleted == false}">
									<button type="button" id="btnActive" onclick="handlerActionEnable(${product.id})" class="btn btn-primary">Active</button>
								</c:if>   
								<c:if test="${ product.is_deleted == true }"> 
									<button type="button" id="btnDelete" onclick="handlerActionDisable(${product.id})" class="btn btn-warning">Delete</button>
								</c:if>  
							</td>  
						</tr>
					</c:forEach>
				 
				</tbody>
			</table>
		</div>

	</div>
	<!-- /.container-fluid -->
	
	<script>
		function handlerActionEnable(id) {
			let data = {
				"id": id
			}
			$.ajax({
						url : 'http://localhost:8080/first-project/api/products?enable',
						type : 'PUT',
						contentType : 'application/json',
						dataType : 'json',
						data : JSON.stringify(data),
						success : function(result) { 
							window.location.href = 'http://localhost:8080/first-project/admin/products?type=list&message=ENABLE_PRODUCT_SUCCESS'
						},  
						error : function(error) { 
							window.location.href = 'http://localhost:8080/first-project/admin/products?type=list&message=SERVER_ERRORS'
						}
					});
		}
		function handlerActionDisable(id) {
			let data = {
				"id": id
			}
			$.ajax({
						url : 'http://localhost:8080/first-project/api/products?disable',
						type : 'PUT',
						contentType : 'application/json',
						dataType : 'json',
						data : JSON.stringify(data),
						success : function(result) { 
							window.location.href = 'http://localhost:8080/first-project/admin/products?type=list&message=DELETE_PRODUCT_SUCCESS'
						},  
						error : function(error) { 
							window.location.href = 'http://localhost:8080/first-project/admin/products?type=list&message=SERVER_ERRORS'
						}
					});
		}
	</script>	
</body>

</html>