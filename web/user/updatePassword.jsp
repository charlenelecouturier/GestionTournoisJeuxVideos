<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../style/style.css">

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Update</title>
    <s:head />
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand " href="../index.jsp">Home</a>
</nav>
<div class ="container" style="width:40%">
    <div class="form-group" >
        <h1 class="test">Change password</h1>
        <br>
        <s:form
                action="UpdatePasswordAction"  namespace="/user" >

            <s:actionmessage/>

            <s:password  label="Password" name="password" class="form-control formstruts" />
            <s:password label="New password" name="newPassword" class="form-control formstruts"/>

            <s:submit  class="btn btn-primary" value="Confirm change" />
        </s:form>
    </div>

</div>

</body>
</html>
