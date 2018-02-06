<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">\
	<%@ page import="com.model.Employee"%>
	<%@ page import="com.dao.EmployeeDao"%>
	<%@ page import="java.util.*"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List</title>
		<style> 
				body{
						margin-top: 150px;]
						font-family: Lucida Sans;
						font-size: 30px;
					}
				th{
					color: blue;
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
				  .button1 {background-color: #f44336;} /* Red */
				   .button2 {background-color: black;}
		</style>
	</head>

	<body  background="em.jpg">
			<center>
			<%
				ArrayList<Employee> employees =new ArrayList<Employee>();
				employees = (ArrayList<Employee>)request.getAttribute("employees");
			%>
			<form id="myForm" method="POST" action="EmployeeHandler">
			<table border="2">
				<tr>
					<th> </th>
					<th>Employee Id</th>
					<th>Employee Name</th>
					<th>Salary</th>
					
				</tr>
				<tr>
								<%
					for (Employee employee : employees) {
				%>
				<td> <input type="radio" name="radio" id="radio" value="<%=employee.getEmployeeId()%>" ></td>
				<td> <%=employee.getEmployeeId()%></td>
				<td><%=employee.getEmployeeName()%></td>
				<td><%=employee.getEmployeeSalary()%></td>
				</tr>
				<%
					}
				%>
               <tr></tr>
	           <tr></tr>
	           <tr>
	           </table>
		<input type="button" name="action1" id= "action1" value="Update" onclick="myFunc1(this.value);">&nbsp;
		<input type="button" name="action1" id= "action1" value="Delete" onclick="myFunc1(this.value);"/>
	    <input type="hidden" name="action" id="action" value="Delete">      
			
				
			
			</form>
			<p><a href="employee.jsp"> Add New Employee</a></p>
			</center>
			<script>
function myFunc1(a) {
//	alert("hello");
//	alert(a);
	var action1=a;
	alert(action1);
	if("Update"==action1){
		alert("equal");
		document.getElementById("action").value="Update";
//		alert(document.getElementById("action").value);
	}else
		document.getElementById("action").value="Delete";
	
//	document.location.href= "EmployeeHandler?action=" + action +"&radio="+ radio1; 
 //alert(action);
    document.getElementById("myForm").submit();
}
</script>
	</body>
</html>