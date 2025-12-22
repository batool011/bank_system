package test;

import accounts.Account;
import accounts.InvestmentAccount;
import transactions.Transaction;
import transactions.TransactionType;
import transactions.processor.TransactionValidator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;

public class TransactionValidatorTest {

    @Test
    void validDeposit_shouldPass() {
        Transaction tx = new Transaction(500, TransactionType.DEPOSIT);

        Account target = new InvestmentAccount("1",0, 0.4);
        tx.setToAccount(target);

        assertDoesNotThrow(
                () -> new TransactionValidator().validate(tx));

//        System.out.println("Deposit validation test passed!");
    }

    @Test
    void depositNegativeAmount_shouldFail() {
        Transaction tx = new Transaction(-500, TransactionType.DEPOSIT);

        Account target = new InvestmentAccount("1",0, 0.4);

        tx.setToAccount(target);

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new TransactionValidator().validate(tx));

        assertEquals("Amount must be positive", exception.getMessage());
    }

    @Test
    void notTypeTransaction_shouldFail() {
        Transaction tx = new Transaction(500);

        Account target = new InvestmentAccount("1",0, 0.4);

        tx.setToAccount(target);

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new TransactionValidator().validate(tx));

        assertEquals("Transaction type is required", exception.getMessage());
    }

    @Test
    void noAccountReceiverAssignedForDeposit_shouldFail() {
        Transaction tx = new Transaction(500, TransactionType.DEPOSIT);

        Account target = new InvestmentAccount("1",0, 0.4);

        Exception exception = assertThrows(IllegalStateException.class,
                () -> new TransactionValidator().validate(tx));

        assertEquals("Deposit requires target account", exception.getMessage());
    }

    @Test
    void noAccountSourceAssignedForWithdraw_shouldFail() {
        Transaction tx = new Transaction(500, TransactionType.WITHDRAW);

        Account target = new InvestmentAccount("1",0, 0.4);

        Exception exception = assertThrows(IllegalStateException.class,
                () -> new TransactionValidator().validate(tx));

        assertEquals("Withdraw requires source account", exception.getMessage());
    }

    @Test
    void noAccountProvidedForTransferOperation_shouldFail() {
        Transaction tx = new Transaction(500, TransactionType.TRANSFER);

        Exception exception = assertThrows(IllegalStateException.class,
                () -> new TransactionValidator().validate(tx));

        assertEquals("Transfer requires both accounts", exception.getMessage());
    }

}
