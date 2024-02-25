package com.jsp.jdbc_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadStudentController {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/jdbc-4.30pm";
			String user ="root";
			String pass ="ritik";
			
			connection= DriverManager.getConnection(url, user, pass);
			System.out.println(connection);
			
			statement = connection.createStatement();
			  
			String displayStudentQuery="select * from student";
			ResultSet resultset=statement.executeQuery(displayStudentQuery);
			resultset.next();
			
			int id = resultset.getInt("idStudent");
			
			System.out.println("idStudent "+id);
			
			System.out.println("data fetched successfully");

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				statement.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

}
