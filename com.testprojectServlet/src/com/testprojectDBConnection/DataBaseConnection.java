package com.testprojectDBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sun.security.jca.GetInstance;


public class DataBaseConnection {
	
	private static DataBaseConnection dbc=new DataBaseConnection();
	
	public Connection Connection;


	public DataBaseConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dhatri","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static DataBaseConnection getInstance(){
		return dbc;
		
	}
	
}
