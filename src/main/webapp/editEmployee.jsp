	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%@ page import="com.model.Employee"%>
	<%@ page import="com.dao.EmployeeDao"%>
	<%@ page import="java.util.*"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit</title>
		<style>
			body{
					margin-top: 150px;]
					font-family: Lucida Sans;
					font-size: 30px;
				}
			.button {
   						background-color: #4CAF50; /* green */
    					color: white;
    					padding: 8px 10px;
    					text-align: center;
    					text-decoration: none;
    					display: inline-block;
    					font-size: 16px;
    					margin: 4px 2px;
    					cursor: pointer;
					}
		</style>
	</head>
	
	<body background="bg.jpg">
		<center>
		<%
			EmployeeDao empDao = new EmployeeDao();
		%>
		<form method="POST" action="EmployeeHandler">

			<input type="hidden" name="action" value="edit" /> 
			<%
 			Employee employee = (Employee)request.getAttribute("employee");
 			%>
			<table>
				<tr>
					<td> ID</td>
					<td><input type="text" name="employeeId" readonly="readonly"
						value="<%=employee.getEmployeeId()%>"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="employeeName" value="<%=employee.getEmployeeName()%>"/></td>
				</tr>
				<tr>
					<td>Salary</td>
					<td><input type="text" name="salary" value="<%=employee.getEmployeeSalary()%>"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update" class="button" /></td>	
				</tr>
			</table>
		</form>
		</center>
	</body>
</html>