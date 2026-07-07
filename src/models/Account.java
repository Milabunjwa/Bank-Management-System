package models;
import java.util.ArrayList;

public class Account {

    private String accountNumber;
    private Customer customer;
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance += amount;

        transactions.add(
                new Transaction(
                        "Deposit",
                        amount
                )
        );

        return true;
    }

    public boolean withdraw(double amount) {

        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        transactions.add(new Transaction("Withdrawal", amount));

        return true;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return accountNumber +
                " | " +
                customer.getName() +
                " | Balance: R" +
                balance;
    }
}