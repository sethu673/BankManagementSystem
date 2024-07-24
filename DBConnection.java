package bankManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
     static String URL = "jdbc:mysql://localhost:3306/bank_db";
    static String USER = "root"; // replace with your MySQL username
    static String PASSWORD = "admin"; // replace with your MySQL password

    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Print a success message
            System.out.println("Connected to the database successfully!");
            
            // Close the connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}
