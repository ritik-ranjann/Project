package com.jsp.jdbc_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateStudentController {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Student id:");
		int id = sc.nextInt();
		
		System.out.println("Enter Student Name: ");
		String Studentname = sc.next();
		
		System.out.println("Enter email: ");
		String email= sc.next();
		
		System.out.println("Enter Address: ");
		String address=sc.next();
		
		System.out.println("Enter phone number : ");
		long phone = sc.nextLong();
		
		System.out.println("Enter dob(YYYY-MM-DD): ");
		String dob=sc.nextLine();
		Connection connection=null;
		Statement statement=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc-4.30pm";
			String user ="root";
			String pass ="ritik";
			
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println(connection);
			
			statement = connection.createStatement();
			
			String updateStudentQuery="Update student set Studentname ='rahul' where idStudent = 334";
			
			statement.execute(updateStudentQuery);
			System.out.println("-----data updated----");
			
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
