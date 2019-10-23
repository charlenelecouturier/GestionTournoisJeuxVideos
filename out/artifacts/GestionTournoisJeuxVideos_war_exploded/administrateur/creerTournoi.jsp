<%--
  Created by IntelliJ IDEA.
  User: Taher
  Date: 17/10/2019
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../style/style.css">

    <title>Gestion de Tournois</title>
    <s:head />

  </head>
  <body>

  <s:actionerror/>
  <s:actionmessage/>

  <!-- As a link -->
  <nav class="navbar navbar-light bg-light">
    <a class="navbar-brand " href="../index.jsp">Home</a>
  </nav>

  <div class="container" style="width:40%">
    <div class="form-group">
      <h1 class="test">Nouveau tournoi</h1>
      <s:form action="creer_Tournoi">
        <s:select name = "tournoi.format" label = "Format" list = "{'1V1','2V2','3V3','4V4','5V5'}" class="form-control formstruts" requiredLabel="true"/>
        <s:textfield name="tournoi.nomJeu" label="Jeu" class="form-control formstruts" requiredLabel="true"/>
        <s:textfield name="tournoi.dateDeb" label="Date Début" type="date"  format="dd-MM-yyyy"
                     class="form-control formstruts" requiredLabel="true"/>
        <s:textfield name="tournoi.prix" label="Prix" class="form-control formstruts" requiredLabel="true" />
        <s:submit  class="btn btn-primary" value="Confirmer" />
      </s:form>
    </div>
  </div>
  </body>
</html>
