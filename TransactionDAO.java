package bankManagementSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDAO {
    public void addTransaction(int accountNumber, String type, double amount) throws SQLException {
        String sql = "INSERT INTO transactions (account_number, type, amount) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, accountNumber);
            stmt.setString(2, type);
            stmt.setDouble(3, amount);
            stmt.executeUpdate();
        }
    }
}
