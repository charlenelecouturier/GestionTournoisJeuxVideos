<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="../style/style.css">

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
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
		<h1 class="test">Inscription</h1>
		<br>
		<s:form
			action="RegisterAction" >

		<s:actionmessage/>
			<s:textfield
				elementcssClass="col-sm-8" label="Name"  name="userBean.name"  class="form-control formstruts" />

			<s:textfield  label="Last Name" id="lastname" name="userBean.lastname" class="form-control formstruts" />

			<s:radio   label="Gender" name="userBean.gender" list="{'M','F'}"   cssClass="radioMargin formstruts" />

			<s:password  label="Password" name="userBean.password" class="form-control formstruts" />

			<s:password label="Confirm Password"  name="confirmPassword" class="form-control formstruts" />

			<s:textfield label="Birth Date" name="userBean.birthdate" type="date"
					 format="dd-MM-yyyy"  class="form-control formstruts"  />

			<s:textfield label="Phone Number" name="userBean.phone" class="form-control formstruts" />

			<s:textfield  label="Email" name="userBean.email" class="form-control formstruts" />

			<s:textfield label="City" name="userBean.city" class="form-control formstruts" />

			<s:submit  class="btn btn-primary" value="Register" />
		</s:form>
</div>

	</div>
</body>

</html>
