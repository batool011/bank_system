package reports;

import core.BankSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LoggingDecoratorTest {

    @Test
    void testLoggingDecoratorWorks() {

        BankSystem bankSystem = new BankSystem();

        Report baseReport = new AccountSummaryReport(bankSystem);
        Report loggingReport = new LoggingDecorator(baseReport);

        assertDoesNotThrow(loggingReport::generate);
    }
}
