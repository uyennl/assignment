<%-- 
    Document   : card
    Created on : Mar 6, 2024, 4:55:34 PM
    Author     : PC
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
    <h1>Shopping Cart</h1>
    <%     List<Dish> cartItems = getCartItems(request);

        // Add the new dish to the cart
        cartItems.add(dish);
cartItems.add(new Dish(1,"cơm","hhh",20,"https://vcdn1-dulich.vnecdn.net/2021/07/16/1-1626437591.jpg?w=460&h=0&q=100&dpr=2&fit=crop&s=i2M2IgCcw574LT-bXFY92g"));%>
    <%-- Kiểm tra xem giỏ hàng có sản phẩm không --%>
    <c:if test="${not empty cartItems}">
        <%-- Lặp qua từng sản phẩm trong giỏ hàng và hiển thị thông tin --%>
        <c:forEach items="${cartItems}" var="item">
            <div>
                <h2>${item.title}</h2>
                <p>Sub Title: ${item.subTitle}</p>
                <p>Price: ${item.price}</p>
                <img src="${item.image}" alt="Product Image">
                <form action="cart" method="post">
                    <%-- Tạo một input hidden để truyền id của sản phẩm muốn xóa --%>
                    <input type="hidden" name="action" value="remove">
                    <input type="hidden" name="idDish" value="${item.idDish}">
                    <button type="submit">Remove from Cart</button>
                </form>
            </div>
            <hr>
        </c:forEach>
        
        <%-- Nút để xóa tất cả các sản phẩm khỏi giỏ hàng --%>
        <form action="cart" method="post">
            <input type="hidden" name="action" value="clear">
            <button type="submit">Clear Cart</button>
        </form>
        
        <%-- Nút để thực hiện thanh toán --%>
        <form action="cart" method="post">
            <input type="hidden" name="action" value="checkout">
            <button type="submit">Checkout</button>
        </form>
    </c:if>
    
    <%-- Nếu giỏ hàng trống --%>
    <c:if test="${empty cartItems}">
        <p>Your cart is empty.</p>
    </c:if>
</body>
</html>

