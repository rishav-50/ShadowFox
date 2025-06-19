import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        BankAccount account = new BankAccount(name);

        int choice;
        do {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Transaction History\n5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    try {
                        account.deposit(deposit);
                        System.out.println("Deposit successful.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    try {
                        account.withdraw(withdraw);
                        System.out.println("Withdrawal successful.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 4:
                    account.printTransactions();
                    break;

                case 5:
                    System.out.println("Thank you for using the Bank Account System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
