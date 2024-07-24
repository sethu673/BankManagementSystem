package bankManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
    public void addCustomer(String name, String email, String phone) throws SQLException {
        String sql = "INSERT INTO customers (name, email, phone) VALUES (?, ?, ?)";
          System.out.println("love you!!");
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.executeUpdate();
        }
    }

    public void viewCustomers() throws SQLException {
        String sql = "SELECT * FROM customers";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("------");
            }
        }
    }
}
