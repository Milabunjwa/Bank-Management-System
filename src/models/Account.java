package models;

public class Account {

    private String accountNumber;
    private Customer customer;
    private double balance;

    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0;
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

    @Override
    public String toString() {
        return accountNumber +
                " | " +
                customer.getName() +
                " | Balance: R" +
                balance;
    }
}