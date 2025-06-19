import java.util.ArrayList;

public class BankAccount {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactions;

    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        transactions.add("Account created for: " + accountHolder);
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        balance += amount;
        transactions.add("Deposited: ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
        transactions.add("Withdrawn: ₹" + amount);
    }

    public void printTransactions() {
        System.out.println("--- Transaction History ---");
        for (String t : transactions) {
            System.out.println(t);
        }
    }
}
