package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDao;
import com.model.Employee;


public class EmployeeHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmployeeHandler() {
        super();
      
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	 {
    	
    	
 //   	System.out.println(getServletContext().getInitParameter("employee"));
		EmployeeDao empDao=new EmployeeDao();
		String actionValue=request.getParameter("action");
		System.out.println(actionValue);
		if("insert".equalsIgnoreCase(actionValue))
		{
			int EmplId= Integer.parseInt(request.getParameter("employeeId"));
			String EmplName= request.getParameter("employeeName");
			int sal= Integer.parseInt(request.getParameter("salary"));
			
			Employee newEmployee= new Employee();
			newEmployee.setEmployeeId(EmplId);
			newEmployee.setEmployeeName(EmplName);
			newEmployee.setEmployeeSalary(sal);
			int a=empDao.addEmployee(newEmployee);
			if(a!=0)
			{
				response.sendRedirect("/success.jsp");
				
			}
			else{
				RequestDispatcher rd= request.getRequestDispatcher("/fail.jsp");
				rd.forward(request, response);
			}
		}
		
	 
		else if("delete".equalsIgnoreCase(actionValue))
		{
		//	PrintWriter pw = response.getWriter();
		//	response.setContentType("text/html");
			 
			String gender = request.getParameter("radio");
			System.out.println("radio value gender: "+gender);
			
			int empId= Integer.parseInt(request.getParameter("radio"));
		//	System.out.println("radio value gender: "+empId);
			empDao.deleteEmployee(empId);
			request.setAttribute("employees", empDao.getAllEmployees());
			RequestDispatcher rd= request.getRequestDispatcher("/employeeList.jsp");
			rd.forward(request, response);
		}
		else if ("update".equalsIgnoreCase(actionValue))
		{ 
			Employee employee= new Employee();
			int empId=Integer.parseInt(request.getParameter("radio"));
			employee= empDao.getEmployeeById(empId);
			request.setAttribute("employee", employee);
			RequestDispatcher rd= request.getRequestDispatcher("/editEmployee.jsp");
			rd.forward(request, response); 
		} 
		else if ("edit".equalsIgnoreCase(actionValue))
		{
	//		int empId= Integer.parseInt(request.getParameter("radio"));            
			Employee employee = new Employee();
			employee.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
			employee.setEmployeeName(request.getParameter("employeeName"));
			employee.setEmployeeSalary(Integer.parseInt(request.getParameter("salary")));
			empDao.editEmployee(employee);
			request.setAttribute("employees", empDao.getAllEmployees());
			RequestDispatcher rd= request.getRequestDispatcher("/employeeList.jsp");
			rd.forward(request, response);
		}

		else if ("listEmployee".equalsIgnoreCase(actionValue))
		{
			request.setAttribute("employees", empDao.getAllEmployees());
			RequestDispatcher rd= request.getRequestDispatcher("/employeeList.jsp");
			rd.forward(request, response);
		} 
		else 
		{
			RequestDispatcher rd= request.getRequestDispatcher("/employee.jsp");
			rd.forward(request, response);
		}

	 }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

	
    doGet(request, response);

    }
}
