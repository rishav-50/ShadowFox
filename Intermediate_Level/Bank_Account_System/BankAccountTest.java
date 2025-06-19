import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount("Rishav");
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount("Rishav");
        account.deposit(2000);
        account.withdraw(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    public void testInsufficientBalance() {
        BankAccount account = new BankAccount("Rishav");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(500);
        });
        assertEquals("Insufficient balance", exception.getMessage());
    }

    @Test
    public void testNegativeDeposit() {
        BankAccount account = new BankAccount("Rishav");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100);
        });
        assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    public void testTransactionHistory() {
        BankAccount account = new BankAccount("Rishav");
        account.deposit(100);
        account.withdraw(50);
        assertEquals(3, account.getTransactions().size()); // includes account creation message
    }
}
