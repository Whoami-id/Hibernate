package com.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutionException;

public class Test {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "root";
		String pass = "rootm";
		
		try {
			
			Connection  con = DriverManager.getConnection(url,user, pass );
			System.out.println("connection successfull");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
