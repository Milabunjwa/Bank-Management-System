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
}