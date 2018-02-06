<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
<style> 
				body{
						margin-top: 150px;
						font-family: Lucida Sans;
						font-size: 40px;
						text-align: center;
					}
					 .button {
					 background-color: black;
					 color: white;
					 }
					</style>
</head>
<body background="em.jpg">
You have Successfully Add one Employee !!!
<p><a href="employee.jsp"> <input type="button" value="Add New Employee" class="button"></a></p>
<a href="EmployeeHandler?action=listEmployee" ><input type="button" value="Show All Details" class="button"></a>
</body>
</html>