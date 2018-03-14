<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Employee</title>
		
		<style> 
				body{
						margin-top: 150px;
						font-family: Lucida Sans;
						font-size: 30px;
					}
			.button {
   						 	background-color: #4CAF50;
    						border: none;
    						color: white;
    						padding: 15px 32px;
    						text-align: center;
    						text-decoration: none;
    						display: inline-block;
    						font-size: 16px;
    						margin: 4px 2px;
    						cursor: pointer;
					}
					
					.button1 {background-color:black;}
		</style>
	</head>
	<body background="em.jpg">
		<center>
		
		<form method="post" action="EmployeeHandler" >

		<input type="hidden" name="action" value="insert" />
		<br> <h1> <font color="brown"><b>Add New Employee Record </b> </h1> </font> 
		<table>
		
			<tr>
			
				<td>Employee ID</td>
				<td><input type="text" name="employeeId" /></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="employeeName" /></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary" /></td>
			</tr>
			</table>
			<p>
			<input type="submit" value="Submit" class="button"> &nbsp;
			<input type="reset"  value="Reset" class="button">
			
		</p>
		</form>
		<p>
		<a href="EmployeeHandler?action=listEmployee" >Show All Details</a>
			</p>
			</font>
	</center>
	</body>
</html>
