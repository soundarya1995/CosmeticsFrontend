<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1"> 
<title>UpdateSupplierPage</title>
</head>
<body>
<h3 align="center">Update Supplier</h3>
<form  method="post" action=<c:url value="/updateSupplier"/>>
<table>
<tr>
<td>Supplier ID</td>
<td><input type="text" name="supplierId" value="${supplier.supplierId}"/readonly></td>
</tr>
<tr>
<td>Supplier name</td>
<td><input type="text" name="supplierName" value="${supplier.supplierName}"/></td>
</tr>
<tr>
<td>Supplier Address</td>
<td><input type="text" name="supplierAddr" value="${supplier.supplierAddr}"/></td>
</tr>
<tr>
<td colspan="2">
<center>
<input type="submit" value="UPDATE"/>
<input type="reset" value="RESET"/></center>
</td>
</tr>
</table>
</form>

</body>
</html>