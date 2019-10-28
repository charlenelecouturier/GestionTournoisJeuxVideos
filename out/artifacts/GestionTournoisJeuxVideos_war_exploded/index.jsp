<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style/index-style.css">
    <title>Home</title>
  </head>
  <body>
  <!-- As a link -->
    <nav class="navbar navbar-light bg-light">
      <a class="navbar-brand" href="user/register.jsp">Inscription</a>
      <a class="navbar-brand" href="user/login.jsp">LogIn</a>
    </nav>

    <div class ="container">
      <div class="form-group" >

        <s:form action="RechercheAction" >
          <s:actionmessage/>
          <table>
            <td><a >Recherche</a></td>
            <td classe="brecherche"><s:textfield type="search" class="form-control formstruts" /></td>
            <td><s:submit  class="btn btn-primary" value="Recherche" /></td>
          </table>
        </s:form>

        </div>
      </div>


    <div class="container">
      <br>
      <s:a action="tournoi_list">Liste des tournois</s:a>
      <br>
      <a href="administrateur/creerTournoi.jsp">Créer un nouveau tournoi</a>
      </div>



  </body>
</html>
