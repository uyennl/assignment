<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.entity.Dish" %>
<%@page import="model.dao.DishDAO" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Edit Dish</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
            }

            .container {
                max-width: 600px;
                margin: 20px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h2 {
                margin-bottom: 20px;
                text-align: center;
            }

            form {
                margin-top: 20px;
            }

            label {
                display: block;
                margin-bottom: 8px;
            }

            input[type="text"],
            select {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            .back-link {
                display: block;
                text-align: center;
                margin-top: 20px;
                color: #666;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Edit Dish</h2>
            <%-- Lấy thông tin của sản phẩm từ request --%>
            <% 
                DishDAO dishDAO = new DishDAO();
                int idDish = Integer.parseInt(request.getParameter("idDish"));           
                Dish dish = dishDAO.selectByID(idDish);
            %>
            <form action="edit-dish" method="post">
                <input type="hidden" name="idDish" value="<%= idDish %>">
                <!-- Điền thông tin sản phẩm vào các trường chỉnh sửa -->
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" value="<%= dish.getTitle() %>">

                <label for="subTitle">Sub Title:</label>
                <input type="text" id="subTitle" name="subTitle" value="<%= dish.getSubTitle() %>">

                <label for="price">Price:</label>
                <input type="text" id="price" name="price" value="<%= dish.getPrice() %>">

                <label for="image">Image URL:</label>
                <input type="text" id="image" name="image" value="<%= dish.getImage() %>">

                <label for="status">Status:</label>
                <select id="status" name="status">
                    <option value="true" <%= dish.isStatus() ? "selected" : "" %>>Còn hàng</option>
                    <option value="false" <%= !dish.isStatus() ? "selected" : "" %>>Hết hàng</option>
                </select>
                
                <label>Category</label>
                <select name="category">
                    <c:forEach items="${cateList}" var="ca">
                        <option value="${ca.idCategory}">${ca.nameCategory}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Update Dish"/>
            </form>
            <!-- Các liên kết hoặc nút để quay lại trang danh sách nếu cần -->
            <a href="list-dish" class="back-link">Back to List</a>
        </div>
    </body>
</html>
