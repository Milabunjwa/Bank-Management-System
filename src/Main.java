import models.Account;
import models.Customer;
import models.Transaction;
import services.BankService;

public class Main {

    public static void main(String[] args) {

        BankService bank = new BankService();

        bank.addCustomer("C001", "Mila");
        bank.addCustomer("C002", "John");

        bank.addAccount("A001", "C001");
        bank.addAccount("A002", "C002");

        System.out.println("Customers");

        for (Customer customer : bank.getCustomers()) {
            System.out.println(customer);
        }

        System.out.println();

        System.out.println("Accounts");

        for (Account account : bank.getAccounts()) {
            System.out.println(account);
        }

        bank.deposit("A001", 1000);

        bank.withdraw("A001", 250);

        bank.transfer(
                "A001",
                "A002",
                300
        );

        System.out.println();

        for (Account account : bank.getAccounts()) {

            System.out.println(account);

            for (Transaction transaction : account.getTransactions()) {
                System.out.println("   " + transaction);
            }

            System.out.println();
        }
    }
}