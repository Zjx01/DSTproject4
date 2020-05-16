<%--
  Created by IntelliJ IDEA.
  User: Jessi
  Date: 2020/4/28
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"
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
</html>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="<%=request.getContextPath()%>/static/css/signup.css" rel="stylesheet" />
    <title>sign up</title>
</head>
<body>

<div class="rg_layout">
    <div class="rg_left">
        <p>User registration</p>
    </div>

    <div class="rg_center">
        <div class="rg_form">
            <form action="<%=request.getContextPath()%>/register" method="post">
<%--                //<%=request.getContextPath()%>--%>
<%--                    返回项目路径 haining_biomed.war_exploded--%>
                <table>
                    <tr>
                        <td class="td_left"><label for="username">username</label></td>
                        <td class="td_right"><input type="text" name="username" id="username" placeholder="please enter your username"></td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="password">password</label></td>
                        <td class="td_right"><input type="password" name="password" id="password" placeholder="please enter your password"></td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="email">email</label></td>
                        <td class="td_right"><input type="email" name="email" id="email" placeholder="please enter your email"></td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="phone">phone</label></td>
                        <td class="td_right"><input type="text" name="phone" id="phone" placeholder="please enter your phone number"></td>
                    </tr>


                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="sign up" id="butt"></td>
                    </tr>

                </table>
            </form>
        </div>

    </div>

    <div class="rg_right">
        <p>Existing account? <a href="<%=request.getContextPath()%>/views/signin.jsp">sign in here</a></p>

    </div>
</div>


</body>
</html>
