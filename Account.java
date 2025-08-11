import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account {
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: Rs. " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: Rs. " + amount);
            System.out.println("Successfully deposited Rs. " + amount);
        } else {
            transactionHistory.add("Failed deposit attempt: Rs. " + amount);
            System.out.println("Deposit amount must be positive!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: Rs. " + amount);
            System.out.println("Successfully withdrew Rs. " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            transactionHistory.add("Failed withdrawal attempt: Rs. " + amount);
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: Rs. " + balance);
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for " + accountHolder + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
        System.out.println("Current balance: Rs. " + balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Deposit: Rs. ");
        double initialBalance = sc.nextDouble();
        sc.nextLine();

        Account account = new Account(name, initialBalance);

        boolean operation = true;
        while (operation) {
            System.out.println("\n--- Banking Operations ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: Rs. ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.printTransactionHistory();
                    break;
                case 5:
                    operation = false;
                    System.out.println("Exiting... Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
