public class Main {
    public static void main(String[] args) {
        // Create a BankAccount object with initial balance and PIN (1234)
        BankAccount userAccount = new BankAccount(1000.00, 1234);

        // Create ATM object linked with the account
        ATM atm = new ATM(userAccount);

        // Start ATM simulation
        atm.run();
    }
}
