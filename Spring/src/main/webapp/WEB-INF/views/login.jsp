<%--
  Created by IntelliJ IDEA.
  User: Jessi
  Date: 2020/4/28
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录页面</title>
</head>
<body>
<h3>登录页面</h3>
<br>
<form action="login" method="post">
    <table>
        <tr>
            <td><label>username/登录名：</label></td>
            <td><input type="text" id="username" name="username"></td>
        </tr>
        <tr>
            <td><label>password/密码：</label></td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td><input id="submit" type="submit" value="登录"></td>
            <td><input id="register" type="register" value="注册"></td>
        </tr>
    </table>
</form>
</body>
</html>
