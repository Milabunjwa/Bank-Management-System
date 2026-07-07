package services;

import models.Account;
import models.Customer;

import java.util.ArrayList;

public class BankService {

    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;

    public BankService() {
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    public void addCustomer(String id, String name) {
        customers.add(new Customer(id, name));
    }

    public void addAccount(String accountNumber, String customerId) {

        Customer customer = findCustomer(customerId);

        if (customer != null) {
            accounts.add(new Account(accountNumber, customer));
        }
    }

    public Customer findCustomer(String id) {

        for (Customer customer : customers) {

            if (customer.getCustomerId().equals(id)) {
                return customer;
            }
        }

        return null;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Account findAccount(String accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }

        }

        return null;
    }

    public boolean deposit(String accountNumber, double amount) {

        Account account = findAccount(accountNumber);

        if (account == null) {
            return false;
        }

        account.deposit(amount);

        return true;
    }

    public boolean withdraw(String accountNumber, double amount) {

        Account account = findAccount(accountNumber);

        if (account == null) {
            return false;
        }

        return account.withdraw(amount);
    }

    public boolean transfer(String fromAccount,
                            String toAccount,
                            double amount) {

        Account sender = findAccount(fromAccount);
        Account receiver = findAccount(toAccount);

        if (sender == null || receiver == null) {
            return false;
        }

        if (!sender.withdraw(amount)) {
            return false;
        }

        receiver.deposit(amount);

        return true;
    }


}