package reports;

import core.BankSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DailyTransactionReportTest {

    @Test
    void testGenerateDoesNotThrowException() {

        BankSystem bankSystem = new BankSystem();

        Report report = new DailyTransactionReport(bankSystem);

        assertDoesNotThrow(report::generate);
    }
}
