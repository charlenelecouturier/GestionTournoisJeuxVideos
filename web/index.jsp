<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style/index-style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <title>Home</title>
  </head>
  <body>


  <!-- As a link
  <nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="user/register.jsp">Inscription</a>
    <a class="navbar-brand" href="user/login.jsp">LogIn</a>
  </nav>-->

  <s:if test="#session.email != null">
  <nav class="navbar navbar-light bg-light">
    <a class="navbar-brand " href="index.jsp">Home</a>
    <div class="dropdown">
      <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Parameters
      </button>
      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <a class="dropdown-item" href="user/delete.jsp">Delete account</a>
      </div>
    </div>
    <s:a class="navbar-brand" action="LogoutAction">Log Out</s:a>
  </nav>
    Hello <s:property value="#session.email"/>
  </s:if>

  <s:else>
  <nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="user/register.jsp">Inscription</a>
    <a class="navbar-brand" href="user/login.jsp">LogIn</a>
  </nav>
  </s:else>


<div class="container">
  <br>
  <s:a action="tournoi_list">Liste des tournois</s:a>
  <br>
  <a href="administrateur/creerTournoi.jsp">Créer un nouveau tournoi</a>
  </div>
  <!-- As a link -->

    <div class ="container">
      <div class="form-group" >

        <s:form action="RechercheAction" >
          <s:actionmessage/>
          <table>
            <td><a >Recherche</a></td>
            <td classe="brecherche"><s:textfield name="search" type="search" class="form-control formstruts" /></td>
            <td><s:submit  class="btn btn-primary" value="Recherche" /></td>
          </table>
        </s:form>

        </div>
      </div>

  </body>
</html>
