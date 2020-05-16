<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/12
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link href="https://cdn.bootcss.com/font-awesome/5.8.0/css/all.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/static/css/AboutUs.css" rel="stylesheet" />
    <title>Group HomePage</title>

</head>
<body>
<div class="box">
    <img src="img/timg1.jpg" alt="" class="box-img" />
    <h1>Group 4</h1>
    <h5>DST2 Course Project</h5>
    <p>
        This our group page. You can click the GitHub link below to find our source code for the project.
    </p>
    <ul>
        <li>
            <a href="https://github.com/Zjx01/DSTproject4"><i class="fab fa-github"></i></a>
        </li>
    </ul>
</div>
</body>
</html>
