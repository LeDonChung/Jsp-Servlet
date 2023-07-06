<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="/common/taglib.jsp" %>
		<!DOCTYPE html>
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
			<div class="container">
				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div class="d-sm-flex align-items-center justify-content-between mb-4">
						<c:if test="${action == 'add'}">
							<h1 class="h3 mb-0 text-gray-800">Product Add</h1>
						</c:if>
						<c:if test="${action == 'update'}">
							<h1 class="h3 mb-0 text-gray-800">Product Update</h1>
						</c:if>
						<!-- Button to Open the Modal -->
						<a class="btn btn-primary" href="<c:url value='/admin/products?type=list'/>">BACK</a>
					</div>

					<!-- Content Row -->
					<div class="row">

						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<c:if test="${ message != null}">
								<div class="alert alert-danger" role="alert">${ message }</div>
							</c:if> 
							<form id="formSubmit">
								<c:if test="${ product.id != null}">
									<input id="id" name="id" value="${product.id}" type="hidden" />
								</c:if>
								<div class="form-group">
									<label for="productName">Product Name</label> <input type="text"
										value="${product.productName}" class="form-control" name="productName"
										id="productName" placeholder="Input Product Name">
								</div>

								<div class="form-group">
									<label for="salePrice">Sale Price</label> <input type="number"
										value="${product.salePrice}" class="form-control" name="salePrice"
										id="salePrice" placeholder="Input Sale Price">
								</div>
								<div class="form-group">
									<label for="costPrice">Cost Price</label> <input type="number"
										value="${product.costPrice}" class="form-control" name="costPrice"
										id="costPrice" placeholder="Input Cost Price">
								</div>
								<div class="form-group">
									<label for="quantity">Quantity</label> <input type="number"
										value="${product.quantity}" class="form-control" name="quantity" id="quantity"
										placeholder="Input Quantity">
								</div>

								<div class="form-group">
									<label for="description">Description</label>
									<textarea  class="form-control" name="description"
										id="description" placeholder="Input Description" cols="20" rows="5">${ product.description }</textarea>
								</div> 

								<div class="form-group">
									<label for="imageUrl">Image Link</label>
									<input type="text" value="${product.imageUrl}" class="form-control" name="imageUrl"
										id="imageUrl" placeholder="Input Image Link" />
								</div>
								
								<div class="form-group">
									<label for="categories">Category</label>
									<br>
									<select id="categories">
										<option value="null">All</option>
										<c:forEach var="category" items="${ categories }">
											<c:if test="${ category.id == product.categoryId }">
												<option value="${ category.id }" selected>${ category.name }</option>
											</c:if> 
											<c:if test="${ category.id != product.categoryId }">
												<option value="${ category.id }">${ category.name }</option>
											</c:if>
										</c:forEach>
										  
									</select>
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



				</div>
				<!-- /.container-fluid -->

			</div>

			<script>
				<!--Trang HTML load hết thì nó mới có -->
				$(document).ready(function () {
					$('#formSubmit').submit(function (e) {
						e.preventDefault();
						// Khởi tạo object
						let dataJson = {};

						// phân giải form ra mảng object
						let formData = $('#formSubmit').serializeArray();
						
						// duyệt từng phẩn tử trong mảng truyền {key, value} vào dataJson object
						formData.forEach(function (data, index) {
							dataJson[data.name] = data.value;
						});
						
						dataJson['categoryId'] = $("#categories option:selected").val();
						console.log(dataJson);
						
						let idElement = $('#id');
						if (idElement.length == 0) {
							addProduct(dataJson);
						} else {
							updateProduct(idElement.val(), dataJson);
						}
						


					});
					function updateProduct(id, data) {
						data['id'] = id;
						$.ajax({
							url: 'http://localhost:8080/first-project/api/products',
							type: 'PUT',
							contentType: 'application/json',
							dataType: 'json',
							data: JSON.stringify(data),
							success: function (result) {
								window.location.href = 'http://localhost:8080/first-project/admin/products?type=list&message=UPDATE_PRODUCT_SUCCESS'
							},
							error: function (error) {
								window.location.href = 'http://localhost:8080/first-project/admin/products?type=edit&message=SERVER_ERRORS'
							}
						});
					}
					function addProduct(data) {
						$.ajax({
							url: 'http://localhost:8080/first-project/api/products',
							type: 'POST',
							contentType: 'application/json',
							dataType: 'json',
							data: JSON.stringify(data),
							success: function (result) {
								window.location.href = 'http://localhost:8080/first-project/admin/products?type=list&message=ADD_PRODUCT_SUCCESS'
							},
							error: function (error) {
								window.location.href = 'http://localhost:8080/first-project/admin/products?type=edit&message=SERVER_ERRORS'
							}
						});
					}
				});
			</script>
		</body>

		</html>