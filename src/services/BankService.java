package services;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import models.Account;
import models.Customer;

import java.util.ArrayList;

public class BankService {

    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;

    public BankService() {
        customers = new ArrayList<>();
        accounts = new ArrayList<>();

        loadCustomers();
        loadAccounts();
    }

    public boolean addCustomer(String id, String name) {
        if (id == null || id.isBlank()) {
            return false;
        }

        if (name == null || name.isBlank()) {
            return false;
        }

        if (findCustomer(id) != null) {
            return false;
        }

        customers.add(new Customer(id, name));

        saveCustomers();

        return true;
    }

    public boolean addAccount(String accountNumber, String customerId) {

        if (accountNumber == null ||
                accountNumber.isBlank()) {
            return false;
        }

        if (findAccount(accountNumber) != null) {
            return false;
        }

        Customer customer =
                findCustomer(customerId);

        if (customer == null) {
            return false;
        }

        accounts.add(
                new Account(
                        accountNumber,
                        customer
                )
        );

        saveAccounts();

        return true;
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

        return account.deposit(amount);
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
        if (amount <= 0) {
            return false;
        }

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

    public void saveCustomers() {

        StringBuilder json = new StringBuilder();

        json.append("[\n");

        for (int i = 0; i < customers.size(); i++) {

            Customer customer = customers.get(i);

            json.append("  {\n");
            json.append("    \"id\": \"")
                    .append(customer.getCustomerId())
                    .append("\",\n");

            json.append("    \"name\": \"")
                    .append(customer.getName())
                    .append("\"\n");

            json.append("  }");

            if (i < customers.size() - 1) {
                json.append(",");
            }

            json.append("\n");

        }

        json.append("]");

        FileManager.save(
                "data/customers.json",
                json.toString()
        );

    }

    public void saveAccounts() {

        StringBuilder json = new StringBuilder();

        json.append("[\n");

        for (int i = 0; i < accounts.size(); i++) {

            Account account = accounts.get(i);

            json.append("  {\n");

            json.append("    \"accountNumber\": \"")
                    .append(account.getAccountNumber())
                    .append("\",\n");

            json.append("    \"customerId\": \"")
                    .append(account.getCustomer().getCustomerId())
                    .append("\"\n");

            json.append("  }");

            if (i < accounts.size() - 1) {
                json.append(",");
            }

            json.append("\n");

        }

        json.append("]");

        FileManager.save(
                "data/accounts.json",
                json.toString()
        );

    }

    public void loadCustomers() {

        String json =
                FileManager.load(
                        "data/customers.json"
                );

        if (json.isEmpty()) {
            return;
        }

        json = json.replace("[", "")
                .replace("]", "")
                .replace("{", "")
                .replace("}", "")
                .replace("\"", "");

        String[] objects = json.split(",");

        String id = "";
        String name = "";

        for (String line : objects) {

            line = line.trim();

            if (line.startsWith("id:")) {

                id = line.substring(3).trim();

            }

            if (line.startsWith("name:")) {

                name = line.substring(5).trim();

                customers.add(
                        new Customer(
                                id,
                                name
                        )
                );

            }

        }

    }

    public void loadAccounts() {

        String json =
                FileManager.load(
                        "data/accounts.json"
                );

        if (json.isEmpty()) {
            return;
        }

        json = json.replace("[", "")
                .replace("]", "")
                .replace("{", "")
                .replace("}", "")
                .replace("\"", "");

        String[] objects = json.split(",");

        String accountNumber = "";
        String customerId = "";

        for (String line : objects) {

            line = line.trim();

            if (line.startsWith("accountNumber:")) {

                accountNumber =
                        line.substring(14).trim();

            }

            if (line.startsWith("customerId:")) {

                customerId =
                        line.substring(11).trim();

                Customer customer =
                        findCustomer(customerId);

                if (customer != null) {

                    accounts.add(
                            new Account(
                                    accountNumber,
                                    customer
                            )
                    );

                }

            }

        }

    }


}