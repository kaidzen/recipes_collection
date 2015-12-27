<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 27.12.2015
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Show all Recipes</title>
</head>
<body>

<table border="1">
  <tbody>
  <c:forEach items="${dishes}" var="resipe">
    <tr>
      <td><c:out value="${resipe.name}" /></td>
      <td><c:out value="${resipe.calories}" /></td>
    </tr>
    <tr>
      <td><c:out value="${resipe.list}" /></td>
    </tr>
    <tr>
      <td><c:out value="${resipe.process}" /></td>
    </tr>
    <tr>
      <td><a href="DishController?action=edit&resipeId=<c:out value="${resipe.id_dish }"/>">Update</a></td>
      <td><a href="DishController?action=delete&resipeId=<c:out value="${resipe.id_dish }"/>">Delete</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<p>
  <a href="<c:url value="/DishController?action=listDishes"/>">Add resipe</a>
</p>

</body>
</html>

