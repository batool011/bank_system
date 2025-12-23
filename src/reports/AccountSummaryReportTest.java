package reports;

import core.BankSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AccountSummaryReportTest {

    @Test
    void testGenerateDoesNotThrowException() {

        BankSystem bankSystem = new BankSystem();

        Report report = new AccountSummaryReport(bankSystem);

        assertDoesNotThrow(() -> {
            report.generate();
        });
    }
}
