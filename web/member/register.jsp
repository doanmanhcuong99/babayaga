<%@ page import="com.t1708m1.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: doanm
  Date: 6/06/2019
  Time: 8:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getAttribute("user");
    if (user == null) {
        user = new User();
    }

%>
<html>
<head>
    <style>
        .container {
            width: 30%;
            margin: auto;
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

        input[type=password] {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
            resize: vertical;
        }

        input[type=text] {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
            resize: vertical;
        }

        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }
    </style>
    <title>Title</title>
</head>
<body>
<h1>Register page</h1>
<div class="container">
    <h2 align="center">REGISTER</h2>
    <form action="/member/register" method="post">
        <label>Username</label>
        <input type="text" name="username" value="<%=user.getUsername()%>">

        <label>Password</label>
        <input type="password" name="password" value="<%=user.getPassword()%>">

        <label>Confirm Password</label>
        <input type="password" name="confirmPassword">

        <label>Phone</label>
        <input type="text" name="phone" value="<%=user.getPhone()%>">

        <label>Email</label>
        <input type="text" name="email" value="<%=user.getEmail()%>">

        <label>Address</label>
        <input type="text" name="address" value="<%=user.getAddress()%>">
        <input type="submit" value="Submit">
    </form>
</div>

</body>
</html>
