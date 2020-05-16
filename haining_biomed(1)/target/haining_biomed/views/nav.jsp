<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 2019-12-3
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page isELIgnored="false" %>
<%--<nav> 标签定义导航链接的部分--%>
<%--<nav class="col-md-2 d-none d-md-block bg-light sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class='nav-link ${param.active == "dashboard" ? "active" : ""}' href="<%=request.getContextPath()%>/">
                    <span data-feather="home"></span>
                    Dashboard <span class="sr-only">(current)</span>
                </a>
            </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>Precision Medicine Knowledge Base</span>
            <a class="d-flex align-items-center text-muted" href="#">
                <span data-feather="plus-circle"></span>
            </a>
        </h6>
        <ul class="nav flex-column mb-2">
            <li class="nav-item">
                <a class='nav-link ${param.active == "drugs" ? "active" : ""}' href="<%=request.getContextPath()%>/drugs">
                    <span data-feather="file-text"></span>
                    Drugs
                </a>
            </li>
            <li class="nav-item">
                <a class='nav-link ${param.active == "drug_labels" ? "active" : ""}' href="<%=request.getContextPath()%>/drugLabels">
                    <span data-feather="file-text"></span>
                    Drug Labels
                </a>
            </li>
            <li class="nav-item">
                <a class='nav-link ${param.active == "dosing_guideline" ? "active" : ""}' href="<%=request.getContextPath()%>/dosingGuideline">
                    <span data-feather="file-text"></span>
                    Dosing Guideline
                </a>
            </li>
        </ul>
    </div>
</nav>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Slide Menu Bar</title>
    <link href="<%=request.getContextPath()%>/static/css/nav.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.css">
</head>
<body>

<input type="checkbox" id="check">
<label for="check">
    <i class="fas fa-bars" id="btn"></i>
    <i class="fas fa-times" id="cancel"></i>
</label>

<div class="sidebar">
    <header>Menu</header>
    <ul>
        <li><a href="<%=request.getContextPath()%>/">Home</a></li>
        <li><a href="<%=request.getContextPath()%>/matchingIndex">Matching</a></li>
        <li><a href="<%=request.getContextPath()%>/samples">Samples</a></li>
        <li><a href="<%=request.getContextPath()%>/search">Search</a></li>
        <li><a href="<%=request.getContextPath()%>/drugs">Durg list</a></li>
        <li><a href="<%=request.getContextPath()%>/drugLabels">DurgLabel list</a></li>
        <li><a href="<%=request.getContextPath()%>/dosingGuideline">DrugGuidance list</a></li>
        <li><a href="<%=request.getContextPath()%>/aboutus">About us</a></li>
<%--        <li><a href="#"><i class="far fa-question-circle"></i>Help</a></li>--%>
    </ul>
</div>
<!--<section></section>-->
</body>
</html>