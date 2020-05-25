<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 2019-12-3
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <head>
        <meta charset="UTF-8" />
        <title>Dashboard</title>
        <link href="<%=request.getContextPath()%>/static/css/index.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/static/css/button.css" rel="stylesheet">
    </head>
    <%-- <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     <meta name="description" content="">
     <meta name="author" content="">
     <meta name="generator" content="">
     <title>Dashboard Template · Bootstrap</title>

     <!-- Bootstrap core CSS -->
     <link href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.css" rel="stylesheet">
     <script src="<%=request.getContextPath()%>/static/jquery/jquery-3.4.1.js"></script>
     <script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.bundle.min.js"></script>
     <!-- Custom styles for this template -->
     <link href="<%=request.getContextPath()%>/static/css/app.css" rel="stylesheet">
     <style>
         .bd-placeholder-img {
             font-size: 1.125rem;
             text-anchor: middle;
             -webkit-user-select: none;
             -moz-user-select: none;
             -ms-user-select: none;
             user-select: none;
         }

         @media (min-width: 768px) {
             .bd-placeholder-img-lg {
                 font-size: 3.5rem;
             }
         }
     </style>--%>
</head>
<body>
<%--<jsp:include page="head.jsp" />--%>

<div class="services-section">
    <div class="inner-width">
        <h1 class="section-title">Medguide Knowledgebase</h1>
        <div class="border"></div>
        <div class="services-container">
            <div class="service-box">
                <div class="service-icon">
                    <!--                    <i class="fas fa-paint-brush"></i>-->
                </div>
                <div class="service-title"><a href="<%=request.getContextPath()%>/drugs" class="url">Durg list</a></div>
                <!--<div class="service-desc">
                    Click here to view our Durg list.
                </div>-->
            </div>
            <div class="service-box">
                <div class="service-icon">
                    <!--                    <i class="fas fa-brush"></i>-->
                </div>
                <div class="service-title"><a href="<%=request.getContextPath()%>/drugLabels">DurgLabel list</a></div>
                <!--<div class="service-desc">
                    Click here to view our DurgLabel list.
                </div>-->
            </div>
            <div class="service-box">
                <div class="service-icon">
                    <!--                    <i class="fas fa-object-ungroup"></i>-->
                </div>
                <div class="service-title"><a href="<%=request.getContextPath()%>/dosingGuideline">DrugGuidance list</a></div>
                <!--<div class="service-desc">
                    Click here to view our DurgGuidance list.
                </div>-->
            </div>
        </div>

        <div class="butt">
            <a href="<%=request.getContextPath()%>/matchingIndex">
<%--                前端与后端分离，所以加views--%>
                <button class="btn" id="butt1">Upload TSV file</button>
            </a>

            <a href="<%=request.getContextPath()%>/views/signin.jsp">
                <button class="btn" id="butt2">Sign in</button>
            </a>

            <a href="<%=request.getContextPath()%>/views/registerForm.jsp">
                <button class="btn" id="butt3">Sign up</button>
            </a>
        </div>



    </div>
</div>
<%--<div class="container-fluid">
    <div class="row">
        <jsp:include page="nav.jsp" >
            <jsp:param name="active" value="dashboard" />
        </jsp:include>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h2>Dashboard</h2>
            </div>
            <div class="table-responsive">
                <em>Welcome to use Precision Medicine Matching System</em>
            </div>
        </main>
    </div>
</div>--%>
</body>
</html>