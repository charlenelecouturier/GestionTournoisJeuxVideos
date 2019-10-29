<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../style/index-style.css">
    <title>Gestion de Tournois</title>
</head>

<body>

<!-- As a link -->
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand " href="index.jsp">Home</a>
</nav>

<s:form action="RechercheAvanceAction" >
    <s:actionmessage/>
    <table width="1200">
        <tr align="center">
            <td><a >Recherche</a></td>
            <td classe="brecherche"><s:textfield name="search" type="search" class="form-control formstruts" /></td>
        </tr>
        <tr>
            <td><a >Date </a></td>
            <td><s:textfield name="paramDate" type="date" format="dd-MM-yyyy" class="form-control formstruts" /></td>
            <td><a >Prix </a></td>
            <td><s:textfield name="paramPrix" type="number" class="form-control formstruts" min="0"/> </td>
            <td><a >Format</a></td>
            <td><s:select name = "paramFormat" list = "{'','1V1','2V2','3V3','4V4','5V5'}" class="form-control formstruts"/></td>
        </tr>
        <td><s:submit  class="btn btn-primary" value="Recherche" /></td>
        </tr>
    </table>
</s:form>


</body>
</html>
