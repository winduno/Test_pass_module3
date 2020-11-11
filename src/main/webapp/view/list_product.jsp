<%--
  Created by IntelliJ IDEA.
  User: winds
  Date: 11/11/2020
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products List</title>
    <style>
        table{
            border: solid 1px;
            border-collapse: collapse;
            padding: 5px;
        }
        th, tr, td{
            border: solid 1px;
            border-collapse: collapse;
            padding: 5px;
        }
    </style>
</head>
<body>

<p>
    <a href="/products?action=create">Create Product</a>
</p>
<form action="/products?action=search" method="post">
    <input type="text" placeholder="Search here" name="search" id="search"><input type="submit" value="Search">
</form>
<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Color</th>
        <th>Quantity</th>
        <th>Description</th>
        <th>Category</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${productList}" var="product">
    <tr>
        <td><c:out value="${product.getName()}"></c:out></td>
        <td><c:out value="${product.getPrice()}"></c:out></td>
        <td><c:out value="${product.getColor()}"></c:out></td>
        <td><c:out value="${product.getQuantity()}"></c:out></td>
        <td><c:out value="${product.getDescription()}"></c:out></td>
        <td><c:out value="${product.getCategory().getCatName()}"></c:out></td>
        <td><a href="/products?action=edit&id=${product.getId()}">Edit</a> <a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
