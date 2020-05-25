<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/13
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link href="https://cdn.bootcss.com/font-awesome/5.8.0/css/all.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/static/css/search.css" rel="stylesheet" />
    <title>Search</title>
</head>
<body>
<div class="search-box">
    <form method="post" action="<%=request.getContextPath()%>/searchDrugs">
<%--        请求接口--%>
        <div class="box">
            <h1>Search</h1>
            <input type="text" name="query" id="query" placeholder="query" />
            <div class="butt">
                <button type="submit" class="submit">search</button>

            </div>
        </div>
    </form>
</div>
<div>
    </thead>
    <tbody>
<%--    <jsp:useBean id="druginfo" scope="request" type="java.util.List"/>--%>
    <c:forEach items="${druginfo}" var="item" varStatus="loop">
        <tr>
            <td>${item.name}</td>
            <td>${item.alternateDrugAvailable}</td>
            <td>${item.dosingInformation}</td>
            <td>${item.prescribingMarkdown}</td>
            <td>${item.source}</td>
            <td>${item.drugId}</td>
        </tr>
    </c:forEach>
<
    </tbody>
</div>
</body>
</html>
