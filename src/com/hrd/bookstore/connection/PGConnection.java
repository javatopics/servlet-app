package com.hrd.bookstore.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PGConnection {

	private static final String URL="jdbc:postgresql://localhost:5432/STUDENT_MG_DB";
	public static Connection getConnection(){
		Connection conn=null;
		try {
		
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection(URL,"postgres","123");
			System.out.println("connect suuccess");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}

		return conn;
		
	}
}
