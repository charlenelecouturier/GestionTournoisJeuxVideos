<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
</head>
<body style="background-color: lightgrey;">
<a href="index.jsp">Accueil</a>

	<div style="margin-left: 25%; margin-top: 50px;">
		<h1>Inscription</h1> <s:form
			action="Register.action">
		<s:textfield label="Name" name="name" />
			<s:textfield label="LastName" name="lastname" />
		<s:textfield label="Password" name="password" />
		<s:textfield label="Birth Date" name="birthdate" />

		<s:textfield label="Email" name="email" />
			<s:textfield label="City" name="city" />
			<s:submit value="Register" />
		</s:form>
</div>
</body>
</html>