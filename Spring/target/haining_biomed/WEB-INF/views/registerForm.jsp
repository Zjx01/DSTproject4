<%--
  Created by IntelliJ IDEA.
  User: Jessi
  Date: 2020/4/28
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%><%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册页面</title>
</head>
<body>
<h3>注册页面</h3>
<br>
<form action="register" method="post">
    <table>
        <tr>
            <td><label>username:</label></td>
            <td><input type="text" id="username" name="username"></td>
        </tr>
        <tr>
            <td><label>password：</label></td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td><label>email: </label></td>
            <td><input type="text" id="email" name="email"></td>
        </tr>

        <tr>
            <td><label>phone: </label></td>
            <td><input type="text" id="phone" name="phone"></td>
        </tr>
        <tr>
            <td><input id="submit" type="submit" value="registration"></td>
        </tr>
    </table>
</form>
</body>
</html>
