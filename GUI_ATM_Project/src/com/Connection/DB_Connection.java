package com.Connection;
import java.sql.*;

public class DB_Connection {

	Connection conn;
	public Statement st;
	
	public DB_Connection() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/ATM_DB", "root", "root");
			st  = conn.createStatement();
			
		} catch (Exception Ex) {
			Ex.printStackTrace();
		}

	}
}
