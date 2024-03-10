<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.entity.Dish" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>List of Dishes</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-4">
            <form action="search-dish-by-name" method="post" object="dish">
                <input type="text" placeholder="Search by name" name="nameDish">
                <button type="submit">Search</button>
            </form>
            <h2>List of Dishes</h2>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Title</th>
                        <th scope="col">Sub Title</th>
                        <th scope="col">Price</th>
                        <th scope="col">Image</th>
                        <th scope="col">Status</th>
                        <th scope="col">Category</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${dishList}" var="dish">

                        <tr>
                            <td>${dish.idDish}</td>
                            <td>${dish.title}</td>
                            <td>${dish.subTitle}</td>
                            <td>${dish.price}</td>
                            <td><img src="${dish.image}" alt="{dish.title}" style="max-width: 70px;"></td>
                            <td>
                                <c:choose>
                                    <c:when test="${dish.status}">
                                        Còn hàng
                                    </c:when>
                                    <c:otherwise>
                                        Hết hàng
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>${dish.category.getNameCategory()}</td>
                            <td>
                                <form action="delete-dish" method="GET">
                                    <!--                                <input type="hidden" name="idDish" value="">-->
                                    <button type="submit" class="btn btn-danger"><a href="delete-dish?idDish=${dish.idDish}">Delete</a></button>
                                </form>
                                <form action="editDish.jsp" method="POST">
                                    <!--                                <input type="hidden" name="idDish" value="">-->
                                    <button type="submit" class="btn btn-danger"><a href="edit-dish?idDish=${dish.idDish}">Edit</a></button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <button type="submit" class="btn btn-success"><a href="add-dish">Add New Dish</a></button>
            <button><a href="admin-list">Back to Customer List</a></button>
        </div>

        <!-- Bootstrap JS and jQuery (Optional, for Bootstrap features) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
