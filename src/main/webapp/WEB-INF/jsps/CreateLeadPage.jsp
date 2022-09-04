<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Lead</title>
</head>
<body>
<h2>Create New Lead!!</h2>
<hr/>
	<form action="createLead" method="post">
		<pre>
			First Name<input type="text" name="firstName"/>
			Last Name <input type="text" name="lastName"/>
			Email ID  <input type="email" name="email"/>
			Mobile    <input type="number" name="mobile"/>
			Email Text<input type="text" name="text"/>
			<input type="submit" value="create lead"/>
		</pre>
	</form>
	
	${msg}
</body>
</html>