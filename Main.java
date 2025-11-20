package project;

import java.util.*;

class BankAccount {
    private String accountNumber;
    private String name;
    private double balance;


    public BankAccount(String accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }


    public String getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

 
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Successfully deposited ₹" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

 
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Successfully withdrawn ₹" + amount);
        } else {
            System.out.println("❌ Insufficient balance or invalid amount!");
        }
    }

    @Override
    public String toString() {
        return "Account No: " + accountNumber + " | Name: " + name + " | Balance: ₹" + balance;
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 4 -> checkBalance();
                case 5 -> viewAllAccounts();
                case 6 -> System.out.println("👋 Thank you for using our Bank System!");
                default -> System.out.println("❌ Invalid choice!");
            }
        } while (choice != 6);
    }

    static void createAccount() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Deposit: ");
        double balance = sc.nextDouble();

        BankAccount acc = new BankAccount(accNo, name, balance);
        accounts.add(acc);
        System.out.println("🎉 Account created successfully!");
    }

    static BankAccount findAccount(String accNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNo))
                return acc;
        }
        return null;
    }

    static void depositMoney() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter Amount to Deposit: ");
            double amt = sc.nextDouble();
            acc.deposit(amt);
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter Amount to Withdraw: ");
            double amt = sc.nextDouble();
            acc.withdraw(amt);
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    static void checkBalance() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            System.out.println("💰 Current Balance: ₹" + acc.getBalance());
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    static void viewAllAccounts() {
        System.out.println("\n--- All Bank Accounts ---");
        if (accounts.isEmpty()) {
            System.out.println("No accounts found!");
        } else {
            for (BankAccount acc : accounts)
                System.out.println(acc);
        }
    }
}

