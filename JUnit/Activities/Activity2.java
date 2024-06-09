package activities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Activity2 {

    @Test
    void notEnoughFunds() {
        BankAccount account = new BankAccount(10);
        assertThrows(NotEnoughFundsException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                account.withdraw(2000);
            }
        });
    }

    @Test
    void enoughFunds() {
        BankAccount account = new BankAccount(100);
        assertDoesNotThrow(() -> account.withdraw(100));
    }

}
