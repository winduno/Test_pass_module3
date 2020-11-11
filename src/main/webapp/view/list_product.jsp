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
</head>
<body>

<p>
    <a href="/products?action=create">Create Product</a>
</p>
<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Color</th>
        <th>Description</th>
        <th>Category</th>
    </tr>
    <c:forEach items="${productList}" var="product">
    <tr>
        <td><c:out value="${product.getName()}"></c:out></td>
        <td><c:out value="${product.getPrice()}"></c:out></td>
        <td><c:out value="${product.getColor()}"></c:out></td>
        <td><c:out value="${product.getDescription()}"></c:out></td>
        <td><c:out value="${product.getCategory().getName()}"></c:out></td>
    </tr>
    </c:forEach>

</table>


</body>
</html>
