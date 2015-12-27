<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 27.12.2015
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title>Add new recipe</title>
</head>
<body>
<form action="DishController" method="post">
  <fieldset>
    <div>
      <label for="id_dish">Recipe ID</label>
      <input type="text" name="id_dish" value="<c:out value="${dish.id_dish}" />" readonly="readonly" placeholder="Recipe ID" />
    </div>
    <div>
      <label for="name">Recipe name</label>
      <input type="text" name="name" value="<c:out value="${dish.name}" />" placeholder="Recipe name" />
    </div>
    <div>
      <label for="calories">Last Name</label>
      <input type="text" name="calories" value="<c:out value="${dish.calories}" />" placeholder="Calories" />
    </div>
    <div>
      <label for="list">Course</label>
      <input type="text" name="list" value="<c:out value="${dish.list}" />" placeholder="Ingridients list" />
    </div>
    <div>
      <label for="process">Year</label>
      <input type="text" name="process" value="<c:out value="${dish.process}" />" placeholder="Preparation process" />
    </div>
    <div>
      <input type="submit" value="Submit" />
    </div>
  </fieldset>
</form>
</body>
</html>
