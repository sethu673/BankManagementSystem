package bankManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    public void createAccount(int customerId, double initialBalance) throws SQLException {
        String sql = "INSERT INTO accounts (customer_id, balance) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            stmt.setDouble(2, initialBalance);
            stmt.executeUpdate();
        }
    }

    public void viewAccounts() throws SQLException {
        String sql = "SELECT * FROM accounts";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Account Number: " + rs.getInt("account_number"));
                System.out.println("Customer ID: " + rs.getInt("customer_id"));
                System.out.println("Balance: " + rs.getDouble("balance"));
                System.out.println("------");
            }
        }
    }
}
