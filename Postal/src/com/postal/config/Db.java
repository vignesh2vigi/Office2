package com.postal.config;

import java.sql.Connection;
import java.sql.DriverManager;



public class Db {
	
	public Connection mysqlConnect(){
		Connection connection = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/postal_verification", "root", "root");
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return connection;
	}
	/*public static void main(String args[])
	{
		Db.mysqlConnect();
	}*/
	

}
