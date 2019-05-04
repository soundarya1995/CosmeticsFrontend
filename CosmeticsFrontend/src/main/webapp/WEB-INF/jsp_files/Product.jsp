<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1"> 
<title>Product</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<h3 align="center">Add Product</h3>
<form action="addProduct" method="post">
<table>
<tr>
<td>Select Category:</td>
<td><select name="categoryId">
<option value="" disabled selected>Select</option>
<c:forEach items="${listCategories}" var="category">
<option value="${category.categoryId}">${category.categoryName}</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>Select Supplier:</td>
<td><select name="supplierId">
<option value="" disabled selected>Select</option>
<c:forEach items="${listSuppliers}" var="supplier">
<option value="${supplier.supplierId}">${supplier.supplierName}</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>Product name</td>
<td><input type="text" name="productName"/></td>
</tr>
<tr>
<td>Product Description</td>
<td>
<input type="text" name="productDesc"/></td>
</tr>
<tr>
<td>Product Price</td>
<td><input type="text" name="productPrice"/></td>
</tr>
<tr>
<td>Product Stock</td>
<td><input type="text" name="productStock"/></td>
</tr>
<tr>
<td colspan="2">
<center><input type="submit" value="ADD">
<input type="reset" value="RESET"></center>
</td>
</tr>
</table>
</form>
<table>
 <tr>
		<td>Product ID</td>
		<td>Product Name</td>
		<td>Product Description</td>
		<td>Product Price</td>
        <td>Product Stock</td>
        <td>Category ID</td>
        <td>Supplier ID</td>
		<td>Operation</td>
       </tr>
	<c:forEach items="${listProducts}" var="product">
		<tr>
			<td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.productDesc}</td>
            <td>${product.price}</td>
            <td>${product.stock}</td>
            <td>${product.categoryId}</td>
            <td>${product.supplierId}</td>
			<td><a href="<c:url value="/editProduct/${product.productId}"/>">EDIT</a>/
				<a href="<c:url value="/deleteProduct/${product.productId}"/>">DELETE</a>
			</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>