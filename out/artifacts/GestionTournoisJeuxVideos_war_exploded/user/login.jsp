<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="../style/style.css">

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
	<s:head />
</head>
<body >

<!-- As a link -->
<nav class="navbar navbar-light bg-light">
	<a class="navbar-brand " href="../index.jsp">Home</a>
</nav>

<br>







<div class ="container" style="width:40%">
	<div class="form-group" >
		<h1 class="test">Connexion</h1>
		<br>
		<s:form
			action="LoginAction"  namespace="/user" >

		<s:actionmessage/>


			<s:textfield  label="Email" name="email" class="form-control formstruts" />
			<s:password  label="Password" name="password" class="form-control formstruts" />


			<s:submit  class="btn btn-primary" value="LogIn" />
		</s:form>
</div>

	</div>
</body>

</html>
