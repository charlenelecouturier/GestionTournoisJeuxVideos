<%--
  Created by IntelliJ IDEA.
  User: vikto
  Date: 24/10/2019
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="/struts-tags" prefix="s"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="../style/style.css">


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administrator Home Page</title>
</head>
<body>

<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand " href="../index.jsp">Home</a>
    <s:a action="LogoutAction">Log Out</s:a>
</nav>

Hello <s:property value="#session.email"/>

</body>
</html>