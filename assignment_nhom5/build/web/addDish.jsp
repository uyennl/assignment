<%-- 
    Document   : addDish
    Created on : Mar 7, 2024, 8:57:06 PM
    Author     : PC
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add New Dish</title>
    </head>
    <body>
        <h2>Add New Dish</h2>
        <form action="add-dish" method="post">
            Title: <input type="text" name="title"><br>
            Sub Title: <input type="text" name="subTitle"><br>
            Price: <input type="text" name="price"><br>
            Image URL: <input type="text" name="imageDish"><br>
            <label>Category</label>
                <select name="category">
                    <c:forEach items="${cate_list}" var="ca">
                        <option value="${ca.idCategory}">${ca.nameCategory}</option>
                    </c:forEach>
                </select>
            <br>
            <input type="submit" value="Add Dish">
        </form>
        <br>
        <a href="list-dish">Back to List</a>
    </body>
</html>
