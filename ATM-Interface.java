import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Transaction class to store details of each transaction
class Transaction {
    private Date timestamp;
    private double amount;
    private String type; // "withdraw", "deposit", "transfer"

    public Transaction(double amount, String type) {
        this.timestamp = new Date();
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        return timestamp + "\t" + type + "\t$" + amount;
    }
}

// TransactionHistory class to manage a list of transactions
class TransactionHistory {
    private List<Transaction> history;

    public TransactionHistory() {
        this.history = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        history.add(transaction);
    }

    public List<Transaction> getHistory() {
        return history;
    }
}

// Account class to represent a bank account and perform transactions
class Account {
    private String accountNumber;
    private double balance;
    private TransactionHistory transactionHistory;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new TransactionHistory();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        Transaction transaction = new Transaction(amount, "deposit");
        transactionHistory.addTransaction(transaction);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            Transaction transaction = new Transaction(amount, "withdraw");
            transactionHistory.addTransaction(transaction);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            Transaction transaction = new Transaction(amount, "transfer");
            transactionHistory.addTransaction(transaction);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void printTransactionHistory() {
        List<Transaction> transactions = transactionHistory.getHistory();
        System.out.println("Transaction history for account: " + accountNumber);
        System.out.println("Timestamp\tType\tAmount");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

// ATMInterface class to interact with the user
public class ATMInterface {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Account account = new Account("12345"); // Example account number

        boolean quit = false;
        while (!quit) {
            System.out.println("\nATM Interface");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient account number: ");
                    String recipientAccountNumber = scanner.next();
                    Account recipientAccount = new Account(recipientAccountNumber);
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    account.transfer(recipientAccount, transferAmount);
                    break;
                case 5:
                    account.printTransactionHistory();
                    break;
                case 6:
                    quit = true;
                    System.out.println("Thank you for using ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }

        scanner.close();
    }
}
