package com.dbConnection;

import java.sql.*;

public class ConnectionProvider {
	
	private static Connection con = null;

    public static Connection getConnection() {
        if (con != null)
            return con;
        else {
            try {
                
            	 String driver = "com.mysql.jdbc.Driver";
	                String url = "jdbc:mysql://employees.ccvesqmhbtc4.ap-south-1.rds.amazonaws.com:3308/shwetank";
	                String user = "shwetank";
	                String password = "shwetank";
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException cnfe) {
                System.out.println(cnfe);
            } catch (SQLException sqe) {
                System.out.println(sqe);
            } 
            return con;
        }

    }
}

