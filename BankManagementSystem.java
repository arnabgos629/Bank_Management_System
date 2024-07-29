import java.util.Scanner;

// Account class to handle account details and operations
class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor to initialize an account
    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited " + amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Method to display account details
    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }
}

// Main class for the Bank Management System
public class BankManagementSystem {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Account account = null;
        int choice;

        do {
            System.out.println("\nBank Management System");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Display Account");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account = openAccount();
                    break;
                case 2:
                    if (account != null) {
                        depositMoney(account);
                    } else {
                        System.out.println("No account found. Please open an account first.");
                    }
                    break;
                case 3:
                    if (account != null) {
                        withdrawMoney(account);
                    } else {
                        System.out.println("No account found. Please open an account first.");
                    }
                    break;
                case 4:
                    if (account != null) {
                        account.displayAccount();
                    } else {
                        System.out.println("No account found. Please open an account first.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    }

    // Method to open a new account
    private static Account openAccount() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = scanner.next();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();
        Account account = new Account(accountNumber, accountHolderName, initialBalance);
        System.out.println("Account successfully created!");
        return account;
    }

    // Method to deposit money into the account
    private static void depositMoney(Account account) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    // Method to withdraw money from the account
    private static void withdrawMoney(Account account) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}
