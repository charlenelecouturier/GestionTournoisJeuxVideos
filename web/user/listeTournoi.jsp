<%--
  Created by IntelliJ IDEA.
  User: Taher
  Date: 16/10/2019
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Gestion de Tournois</title>
  </head>

  <body>

  <!-- As a link -->
  <nav class="navbar navbar-light bg-light">
    <a class="navbar-brand " href="./index.jsp">Home</a>
  </nav>

  <br>



  <s:actionmessage />
<div class="container">
  <h2>Liste des tournois</h2>

  <table class="table">
    <thead>
    <tr>
      <th scope="col">Date de début</th>
      <th scope="col">Format</th>
      <th scope="col">Jeu</th>
      <th scope="col">Places</th>
      <th scope="col">Prix</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="listeTournoi">
      <tr>
        <td><s:property value="dateDeb"/></td>
        <td><s:property value="format"/></td>
        <td><s:property value="nomJeu"/></td>
        <td><s:property value="places"/></td>
        <td><s:property value="prix"/></td>
      </tr>
    </s:iterator>
    </tbody>
  </table>

<s:if test="#session.email != null && #session.usertype.equals('admin')">
  <s:form
          action="NewTournoiAction"  namespace="/user" >



    <s:submit  class="btn btn-primary" value="Creer un nouveau tournoi" />
</s:form>

</s:if>
</div>
  </body>
</html>
