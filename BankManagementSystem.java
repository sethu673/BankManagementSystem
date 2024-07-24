package bankManagementSystem;

import java.sql.SQLException;

public class BankManagementSystem {
    public static void main(String[] args) {
        try {
            CustomerDAO customerDAO = new CustomerDAO();
            customerDAO.addCustomer("John Doe", "john.doe@example.com", "1234567890");
            customerDAO.viewCustomers();

            AccountDAO accountDAO = new AccountDAO();
            accountDAO.createAccount(1, 1000.0);
            accountDAO.viewAccounts();

            TransactionDAO transactionDAO = new TransactionDAO();
            transactionDAO.addTransaction(1, "Deposit", 500.0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
