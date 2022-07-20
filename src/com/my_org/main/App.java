package com.my_org.main;

import java.math.BigDecimal;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.my_org.model.Worker;

public class App {
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
				System.out.println("Read//Retrieve operation:");
				String selectAllSql = """
						SELECT
						    *
						FROM
						Worker
						""";
				ResultSet result = statement.executeQuery(selectAllSql);
				//System.out.println("WORKER_ID\tFIRST_NAME\tLAST_NAME\tSALARY\tJOINING_DATE\tDEPARTMENT\tEMAIL");
//				while (result.next()) {
//					int workerId = result.getInt("WORKER_ID");
//					String firstName = result.getString("FIRST_NAME");
//					String lastName = result.getString("LAST_NAME");
//					int salary = result.getInt(4);
//					Timestamp joiningDate = result.getTimestamp("JOINING_DATE");
//					String department = result.getString(6);
//					String email = result.getString(7);
////					System.out.println(String.format("%d\t%s\t%s\t%d\t%s\t%s\t%s", workerId, firstName, lastName,
////							salary, joiningDate, department, email));
//				}
//				System.out.println();
				// Task 2.a)
				/*
				 * System.out.println("Update Email"); String updatecol=""" ALTER TABLE worker
				 * ADD email varchar(50) NOT NULL""";
				 * 
				 * selectAllSql = """ SELECT
				 *
				 * FROM Worker """;
				 * 
				 * statement.execute(updatecol); ResultSet result1 =
				 * statement.executeQuery(selectAllSql); //task2.b) while (result1.next()) { int
				 * id = result1.getInt("WORKER_ID"); String firstName =
				 * result1.getString("FIRST_NAME").toLowerCase().substring(0, 1); String
				 * lastName = result1.getString("LAST_NAME").toLowerCase(); String sql3 =
				 * String.format("UPDATE worker SET email='%s.%s@my_org.com' WHERE worker_id=%d"
				 * ,firstName,lastName,id); statement.addBatch(sql3); }
				 * statement.executeBatch();
				 * 
				 * ResultSet result2 = statement.executeQuery(selectAllSql); //task 2.c) while
				 * (result2.next()) { int id = result2.getInt("WORKER_ID");
				 * 
				 * String sql3 = String.
				 * format("UPDATE worker SET email=REPLACE(email,'com','in') WHERE worker_id=%d"
				 * , id); statement.addBatch(sql3); } statement.executeBatch();
				 */
				
				System.out.println("creating worker list........");
				ArrayList<Worker> wk = new ArrayList<>();

				while (result.next()) {
					Worker worker = new Worker();
					worker.setWorkerId(result.getInt(1));
					worker.setFirstname(result.getString(2));
					worker.setLastname(result.getString(3));
					worker.setSalary(result.getInt(4));
					worker.setJoiningdate(result.getTimestamp(5));
					worker.setDepartment(result.getString(6));
					worker.setEmail(result.getString(7));
					
					wk.add(worker);
				}
				System.out.println("print data list........");
				
				
				for (Worker obj : wk) {
					/*System.out.print("ID: " + obj.getWorkerId() + ", ");
					System.out.print("FirstName: " + obj.getFirstname() + ", ");
					System.out.print("LastName: " + obj.getLastname() + ", ");
					System.out.print("Salary: " + obj.getSalary() + ", ");
					System.out.print("Hire Date: " + obj.getJoiningdate() + ", ");
					System.out.print("Department: " + obj.getDepartment() + ", ");
					System.out.print("email: " + obj.getEmail());*/
					System.out.println(obj);
					System.out.println();
				}
				
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}
