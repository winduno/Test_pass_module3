<%--
  Created by IntelliJ IDEA.
  User: winds
  Date: 11/11/2020
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<p>
    <a href="/products">Back to list of products</a>
</p>
<form method="post">
    <fieldset>
        <legend>Insert Product Infor</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="number" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Color:</td>
                <td><input type="text" name="color" id="color"></td>
            </tr>
            <tr>
                <td>Quantity:</td>
                <td><input type="text" name="quantity" id="quantity"></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" name="description" id="description"></td>
            </tr>
            <tr>
                <td>Category:</td>
<%--                <td><input type="text" name="category" id="category"></td>--%>
                <td>
                    <select name="category" id="category">
                        <c:forEach items="${categoryList}" var="category">
                            <option value="${category.getCatName()}">${category.getCatName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <input type="submit" value="Create Product">
    </fieldset>
</form>
</body>
</html>
