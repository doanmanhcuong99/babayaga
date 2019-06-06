<%@ page import="com.t1708m1.entity.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: doanm
  Date: 6/06/2019
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<User> list = (ArrayList<User>) request.getAttribute("list");
%>
<html>
<head>
    <title>Title</title>
    <style>
        #customers {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #customers tr:hover {
            background-color: #ddd;
        }

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
<h1>List Student</h1>
<ul>

</ul>
<table id="customers">
    <tr>
        <th>User Name</th>
        <th>PassWord</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>


    </tr>
    <% for (int i = 0; i < list.size(); i++) {%>
    <tr>
        <td><%= list.get(i).getUsername()%>
        </td>
        <td><%= list.get(i).getPassword()%>
        </td>
        <td><%= list.get(i).getPhone()%>
        </td>
        <td><%= list.get(i).getEmail()%>
        </td>
        <td><%= list.get(i).getAddress()%>
        </td>
    </tr>
    <%}%>
</table>

</body>
</html>
