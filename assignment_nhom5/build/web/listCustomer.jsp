<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.entity.Customer" %>
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
                <input type="text" placeholder="Search by Customer" name="nameCustomer">
                <button type="submit">Search</button>
            </form>
            <h2>List of Customer</h2>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">UserName</th>
                        <th scope="col">PassWord</th>
                        <th scope="col">FirstName</th>
                        <th scope="col">LastName</th>
                        <th scope="col">Avatar</th>
                        <th scope="col">PhoneNumber</th>
                        <th scope="col">DateOfBirth</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cusList}" var="cus">

                        <tr>
                            <td>${cus.idCustomer}</td>
                            <td>${cus.userName}</td>
                            <td>${cus.passWord}</td>
                            <td>${cus.firstName}</td>
                            <td>${cus.lastName}</td>
                            <td><img src="${cus.avatar}" alt="{avatar}" style="max-width: 70px;"></td>
                            <td>${cus.phoneNumber}</td>
                            <td>${cus.dateOfBirth}</td>
<!--                            <td>
                                <form action="delete-dish" method="GET">
                                                                    <input type="hidden" name="idDish" value="">
                                    <button type="submit" class="btn btn-danger"><a href="delete-dish?idDish=">Delete</a></button>
                                </form>
                                <form action="editDish.jsp" method="POST">
                                                                    <input type="hidden" name="idDish" value="">
                                    <button type="submit" class="btn btn-danger"><a href="edit-dish?idDish=">Edit</a></button>
                                </form>
                            </td>-->
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <button type="submit" class="btn btn-success"><a href="list-dish">Back List Dish</a></button>

        </div>

        <!-- Bootstrap JS and jQuery (Optional, for Bootstrap features) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
