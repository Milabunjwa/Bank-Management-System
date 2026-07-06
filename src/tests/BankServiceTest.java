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
}