package com.jsp.jdbc_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class DisplayStudentConroller {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Student id:");
		int idStudent = sc.nextInt();
		
		System.out.println("Enter Student Name: ");
		String Studentname = sc.next();
		
		System.out.println("Enter email: ");
		String email= sc.next();
		
		System.out.println("Enter Address: ");
		String address=sc.next();
		
		System.out.println("Enter phone number : ");
		long phone = sc.nextLong();
		
		System.out.println("Enter dob(YYYY-MM-DD): ");
		
		System.out.println("enter year(YYYY) : ");
		int YYYY= sc.nextInt();
		
		System.out.println("Enter month");
		int MM = sc.nextInt();
		
		System.out.println("Enter Day");
		int DD = sc.nextInt();
		
		LocalDate dob = LocalDate.of(YYYY, MM, DD);
		
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/jdbc-4.30pm";
			String user ="root";
			String pass ="ritik";
			
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println(connection);
			
			statement= connection.createStatement();
			
			String displayStudentQuery="select * from student";
			
			ResultSet rs=statement.executeQuery(displayStudentQuery);
			rs.next();
			
			int id = rs.getInt("idStudent");
			
			System.out.println("idStudent" +id);
			
			System.out.println("-----data fetched----");
		} catch (ClassNotFoundException |SQLException e) {
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
