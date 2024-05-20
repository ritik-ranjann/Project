package com.jsp.jdbc_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;


public class InsertStudentController {
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
		
		System.out.println("Enter DOB");
		
		System.out.println("Enter year in value");
		int year = sc.nextInt();
		
		System.out.println("Enter month in value");
		int month =sc.nextInt();
		
		System.out.println("Enter day in value");
		int day=sc.nextInt();
		LocalDate dob = LocalDate.of(year, month,day);
		
		
		
		Connection connection=null;
		Statement statement=null;
		try {
			//step-1 register driver
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 create connection
			
			String url ="jdbc:mysql://localhost:3306/jdbc-4.30pm";
			String user = "root";
			String pass = "ritik";
			
			connection =DriverManager.getConnection(url,user,pass);
			System.out.println(connection);
			
			//step -3  create statement
			
			statement =connection.createStatement();
			
//			step-4 Execute Query
			String insertStudentQuery = "insert into student(idStudent, Studentname, Studentemail, address, phone, dob) values("+id+" '"+Studentname+"' '"+email+"' '"+address+"' "+phone+" '"+dob+"')";
			
			statement.execute(insertStudentQuery);
			
			System.out.println("-----data inserted------");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			//step -5 close connection
			try {
				connection.close();
				statement.close();
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}