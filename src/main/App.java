package main;
import java.math.BigDecimal;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); // optional

        final String url = "jdbc:mysql://localhost:3307/my_org";
        final String username = "root";
        final String password = "password";

        System.out.println("Establishing a connection to the database...\n");
        try (Connection connection = DriverManager.getConnection(url, username, password);) {
            /* Fetching some DB metadata */
            System.out.println("Connected to database server "
                    + connection.getMetaData().getDatabaseProductName()
                    + " version: "
                    + connection.getMetaData().getDatabaseProductVersion()
                    + "\n");

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
                System.out.println("WORKER_ID\tFIRST_NAME\tLAST_NAME\tSALARY\tJOINING_DATE\tDEPARTMENT");
                while (result.next()) {
                    int workerId = result.getInt("WORKER_ID");
                    String firstName = result.getString("FIRST_NAME");
                    String lastName = result.getString("LAST_NAME");
                    int salary = result.getInt(4);
                    Timestamp joiningDate = result.getTimestamp("JOINING_DATE");
                    String department = result.getString(6);
                    System.out.println(
                            String.format(
                                    "%d\t%s\t%s\t%d\t%s\t%s",
                                    workerId,
                                    firstName,
                                    lastName,
                                    salary,
                                    joiningDate,
                                    department));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
