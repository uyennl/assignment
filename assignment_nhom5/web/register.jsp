<%-- 
    Document   : register
    Created on : Mar 6, 2024, 4:05:47 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <script>
        function validateForm() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirmPassword").value;
            var firstName = document.getElementById("firstName").value;
            var lastName = document.getElementById("lastName").value;
            var phoneNumber = document.getElementById("phoneNumber").value;
            var city = document.getElementById("city").value;
            var address = document.getElementById("address").value;

            if (username == "" || password == "" || confirmPassword == "" || firstName == "" || lastName == "" || phoneNumber == "" || city == "" || address == "") {
                alert("Please fill in all fields");
                return false;
            }

            if (password !== confirmPassword) {
                alert("Password does not match!");
                return false;
            }

            // Add additional validation logic here if needed

            return true;
        }
    </script>
</head>
<body>
    <h2>Register</h2>
    <form action="register" method="post" onsubmit="return validateForm()">
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
        </div>
        <div>
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" required>
        </div>
        <div>
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" required>
        </div>
        <div>
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required>
        </div>
        <div>
            <label for="city">City:</label>
            <input type="text" id="city" name="city" required>
        </div>
        <div>
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>
        </div>
        <div>
            <button type="submit">Register</button>
        </div>
    </form>
</body>
</html>
