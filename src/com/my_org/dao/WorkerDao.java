package com.my_org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.my_org.model.Worker;

public class WorkerDao {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver"); // optional

		final String url = "jdbc:mysql://localhost:3307/my_org";
		final String username = "root";
		final String password = "password";

		System.out.println("Establishing a connection to the database...\n");
		try (Connection connection = DriverManager.getConnection(url, username, password);) {
			/* Fetching some DB metadata */
			System.out.println("Connected to database server " + connection.getMetaData().getDatabaseProductName()
					+ " version: " + connection.getMetaData().getDatabaseProductVersion() + "\n");
			 System.out.println("USING STATEMENT:: ");
	            try (Statement statement = connection.createStatement()) {
	            	Worker worker;
	            	String sql="INSERT INTO WORKER (`worker_id`,`first_name`, `last_name`, `DOB`, `gender`, `street`, `location`, `city`, `state`, `zip_code`, `mobile_no`, `email_id`) VALUES ('?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?')";
	            	statement.execute(sql);
	            }      	
		}
	}
}
