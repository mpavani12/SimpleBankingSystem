package java1;

import java.util.*;
class Bank {
    int accNo;
    String name;
    double balance;
    void createAccount(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;

        System.out.println("Account created successfully!");
        System.out.println("Account No: " + accNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }

    double deposit(double amount) {
        balance = balance + amount;
        System.out.println("Successfully deposited amount " + amount);
        return balance;
    }

    double withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Transaction successful, withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
        return balance;
    }

    void balanceEnquiry() {
        System.out.println("Account No: " + accNo);
        System.out.println("Name: " + name);
        System.out.println("Available balance: " + balance);
    }
}
class SimpleBankingSystem extends Bank {
    static Scanner sc = new Scanner(System.in);
    void start() {
        try {
            System.out.println("Enter 1 for Create Account");
            System.out.println("Enter 2 for Deposit");
            System.out.println("Enter 3 for Withdraw");
            System.out.println("Enter 4 for Balance Enquiry");

            int n = sc.nextInt();

            if (n == 1) {
                System.out.print("Enter Account Number: ");
                int accNo = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Initial Balance: ");
                double bal = sc.nextDouble();

                createAccount(accNo, name, bal);
            }

            else if (n == 2) {
                System.out.print("Enter amount to deposit: ");
                System.out.println("Available balance = " + deposit(sc.nextDouble()));
            }

            else if (n == 3) {
                System.out.print("Enter amount to withdraw: ");
                System.out.println("Available balance = " + withdraw(sc.nextDouble()));
            }

            else if (n == 4) {
                balanceEnquiry();
            }

            else {
                System.out.println("Invalid choice");
            }

        } 
        catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }

        System.out.println("Press 1 for next transaction or any key to exit:");
        char ch = sc.next().charAt(0);

        if (ch == '1') {
            start();
        } else {
            System.out.println("Thank you, visit again!");
        }
    }

    public static void main(String[] args) {
    	SimpleBankingSystem obj = new SimpleBankingSystem();
        obj.start();
    }
}

