import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Enhanced Console Calculator ===");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    basicArithmetic(sc);
                    break;
                case 2:
                    scientificCalculator(sc);
                    break;
                case 3:
                    unitConversion(sc);
                    break;
                case 4:
                    System.out.println("Exiting Calculator. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }

    static void basicArithmetic(Scanner sc) {
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.println("Choose operation (+, -, *, /): ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+': System.out.println("Result = " + (a + b)); break;
            case '-': System.out.println("Result = " + (a - b)); break;
            case '*': System.out.println("Result = " + (a * b)); break;
            case '/':
                if (b != 0)
                    System.out.println("Result = " + (a / b));
                else
                    System.out.println("Error: Cannot divide by zero.");
                break;
            default:
                System.out.println("Invalid operator.");
        }
    }

    static void scientificCalculator(Scanner sc) {
        System.out.println("1. Square Root");
        System.out.println("2. Power");
        System.out.print("Choose operation: ");
        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                System.out.print("Enter number: ");
                double num = sc.nextDouble();
                System.out.println("Square root = " + Math.sqrt(num));
                break;
            case 2:
                System.out.print("Enter base: ");
                double base = sc.nextDouble();
                System.out.print("Enter exponent: ");
                double exp = sc.nextDouble();
                System.out.println("Result = " + Math.pow(base, exp));
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    static void unitConversion(Scanner sc) {
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. INR to USD (Assuming 1 USD = 83 INR)");
        System.out.print("Choose conversion: ");
        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                System.out.print("Enter Celsius: ");
                double c = sc.nextDouble();
                double f = (c * 9/5) + 32;
                System.out.println("Fahrenheit = " + f);
                break;
            case 2:
                System.out.print("Enter INR: ");
                double inr = sc.nextDouble();
                double usd = inr / 83;
                System.out.println("USD = " + usd);
                break;
            default:
                System.out.println("Invalid conversion.");
        }
    }
}
