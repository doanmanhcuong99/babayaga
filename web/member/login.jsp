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
    <title>Title</title>
</head>
<body>
<h2>Login Page</h2>
<%= user.getUsername()%>
<form action="/member/login" method="post">
    <div>
        Username<input type="text" name="username">
    </div>
    <div>
        Password<input type="password" name="password">
    </div>
    <div>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </div>
</form>
</body>
</html>
