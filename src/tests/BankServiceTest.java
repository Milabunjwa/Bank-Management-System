package tests;

import org.junit.jupiter.api.Test;
import services.BankService;

import static org.junit.jupiter.api.Assertions.*;

public class BankServiceTest {

    @Test
    public void testAddCustomer() {

        BankService bank = new BankService();

        bank.addCustomer("C001", "Mila");

        assertEquals(
                1,
                bank.getCustomers().size()
        );
    }

    @Test
    public void testFindCustomer() {

        BankService bank = new BankService();

        bank.addCustomer("C001", "Mila");

        assertNotNull(
                bank.findCustomer("C001")
        );
    }

    @Test
    public void testAddAccount() {

        BankService bank = new BankService();

        bank.addCustomer("C001", "Mila");

        bank.addAccount(
                "A001",
                "C001"
        );

        assertEquals(
                1,
                bank.getAccounts().size()
        );
    }

    @Test
    public void testInvalidCustomer() {

        BankService bank = new BankService();

        bank.addAccount(
                "A001",
                "INVALID"
        );

        assertEquals(
                0,
                bank.getAccounts().size()
        );
    }

    @Test
    public void testDeposit() {

        BankService bank = new BankService();

        bank.addCustomer("C001", "Mila");
        bank.addAccount("A001", "C001");

        bank.deposit("A001", 500);

        assertEquals(
                500,
                bank.findAccount("A001").getBalance()
        );
    }

    @Test
    public void testWithdraw() {

        BankService bank = new BankService();

        bank.addCustomer("C001", "Mila");
        bank.addAccount("A001", "C001");

        bank.deposit("A001", 500);

        assertTrue(
                bank.withdraw("A001", 200)
        );

        assertEquals(
                300,
                bank.findAccount("A001").getBalance()
        );
    }

    @Test
    public void testTransfer() {

        BankService bank = new BankService();

        bank.addCustomer("C001", "Mila");
        bank.addCustomer("C002", "John");

        bank.addAccount("A001", "C001");
        bank.addAccount("A002", "C002");

        bank.deposit("A001", 1000);

        assertTrue(
                bank.transfer(
                        "A001",
                        "A002",
                        400
                )
        );

        assertEquals(
                600,
                bank.findAccount("A001").getBalance()
        );

        assertEquals(
                400,
                bank.findAccount("A002").getBalance()
        );
    }

    @Test
    public void testInsufficientFunds() {

        BankService bank = new BankService();

        bank.addCustomer("C001", "Mila");
        bank.addAccount("A001", "C001");

        assertFalse(
                bank.withdraw("A001", 100)
        );
    }

    @Test
    public void testTransactionHistory() {

        BankService bank = new BankService();

        bank.addCustomer("C001", "Mila");
        bank.addAccount("A001", "C001");

        bank.deposit("A001", 100);

        assertEquals(
                1,
                bank.findAccount("A001")
                        .getTransactions()
                        .size()
        );
    }
}