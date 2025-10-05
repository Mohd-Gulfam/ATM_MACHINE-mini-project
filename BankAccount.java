import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance; 
    private int pin; 
    private List<String> transactions; 

    public BankAccount(double initialBalance, int pin) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
        this.pin = pin;
        this.transactions = new ArrayList<>();
    }

    public boolean checkPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String record = "Deposited: $" + amount;
            addTransaction(record);
            System.out.println(record);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            String record = "Withdrew: $" + amount;
            addTransaction(record);
            System.out.println(record);
            return true;
        } else if (amount > balance) {
            System.out.println("Error: Insufficient balance.");
            return false;
        } else {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
    }

    private void addTransaction(String record) {
        if (transactions.size() == 5) {
            transactions.remove(0); // keep only last 5
        }
        transactions.add(record);
    }

    public void printMiniStatement() {
        System.out.println("\n----- Mini Statement (Last 5) -----");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String record : transactions) {
                System.out.println(record);
            }
        }
        System.out.println("-----------------------------------");
    }
}
