package accounts;

import security.User;

public class AccountFactory {

    public static Account create(AccountType type,
                                 String id,
                                 double balance,
                                 User user) {

        switch (type) {

            case SAVING:
                return new ProxyAbstractAccount(new SavingAccount(id, balance, 1000, 0.03) , user);

            case CHECKING:
                return new ProxyAbstractAccount(new CheckingAccount(id, balance, 2000) , user);

            case LOAN:
                return new ProxyAbstractAccount(new LoanAccount(id, balance, 0.05) , user) ;

            case INVESTMENT:
                return new ProxyAbstractAccount(new InvestmentAccount(id, balance, 0.02) , user) ;

            default:
                throw new IllegalArgumentException("Unknown account type");
        }
    }
}
