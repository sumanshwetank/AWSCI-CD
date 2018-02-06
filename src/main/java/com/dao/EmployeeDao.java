package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.dbConnection.ConnectionProvider;
import com.model.Employee;


public class EmployeeDao {
	
	private Connection conn;
	public EmployeeDao() 
	{
		conn = ConnectionProvider.getConnection();
	}
	
	
	
	//Create/Add employee
	
	public int addEmployee(Employee newEmployee) {

		int a = 0;
		String sql= "Insert into employeedetails(employeeId,EmployeeName,Salary) values(?,?,?)";
		
		try {
			
			/* String driver = "com.mysql.jdbc.Driver";
             String url = "jdbc:mysql://localhost:3306/employee";
             String user = "root";
             String password = "root";
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);*/
            
		
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, newEmployee.getEmployeeId());
			ps.setString(2, newEmployee.getEmployeeName());
			ps.setInt(3, newEmployee.getEmployeeSalary());
			a=ps.executeUpdate();

		} catch (SQLException e) {
				e.printStackTrace();
				} catch(Exception e) {
					e.printStackTrace();
					}
		
			return a;
		}
		
	
		//delete employee
		public void deleteEmployee(int employeeId) {
		
			try {
				String sql = "DELETE FROM employeedetails WHERE employeeId=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, employeeId);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				}
		}
		
	//edit or update employee
		public void editEmployee(Employee employee) {    
			try {
			String sql = "UPDATE employeedetails SET employeeName=?, salary=?" +
			" WHERE employeeId=?";
			PreparedStatement ps = conn
			.prepareStatement(sql);
			ps.setString(1, employee.getEmployeeName());
			ps.setInt(2, employee.getEmployeeSalary());            
			ps.setInt(3, employee.getEmployeeId());
			ps.executeUpdate();            

			} catch (SQLException e) {
			e.printStackTrace();
			}
			}

		//view all employee
		public List<Employee> getAllEmployees() 
		{
			List<Employee> employees = new ArrayList<Employee>();
			try {
				String sql = "SELECT * FROM employeedetails";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) 
				{
					Employee employee = new Employee();
					employee.setEmployeeId(rs.getInt("employeeId"));
					employee.setEmployeeName(rs.getString("employeeName"));
					employee.setEmployeeSalary(rs.getInt("salary"));                             
					employees.add(employee);
				}
			} 
			
			catch (SQLException e) {
					e.printStackTrace();
			}

			return employees;
		}
		
		
		
		//for update
		public Employee getEmployeeById(int employeeId) {
			Employee employee = new Employee();
			try {
			String sql = "SELECT * FROM employeedetails WHERE employeeId=?";
			PreparedStatement ps = conn.
			prepareStatement(sql);
			ps.setInt(1, employeeId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
			employee.setEmployeeId(rs.getInt("employeeId"));
			employee.setEmployeeName(rs.getString("employeeName"));
			employee.setEmployeeSalary(rs.getInt("salary"));                           
			}
			} catch (SQLException e) {
			e.printStackTrace();
			}
			return employee;
			}

			}

