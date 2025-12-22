package accounts;

import security.User;

public class ProxyAbstractAccount implements  Account{

    Account account ;
    User user;
   public ProxyAbstractAccount(Account account , User user){
       this.account = account;
       this.user = user;
    }
    @Override
    public String getAccountId() {
        return "";
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void deposit(double amount) {
        if(user.getAccessStrategy().canAddPalance()){
            account.deposit(amount);
        }
        System.out.println("User cant deposit");
    }

    @Override
    public void withdraw(double amount) {
    if(user.getAccessStrategy().canSubPalance()){
        account.deposit(amount);
     }
        System.out.println("User cant withdraw");
    }

    @Override
    public void setState(AccountState state) {
        if(user.getAccessStrategy().changeState()){
            account.setState(state);
        }
        System.out.println("User cant change state");
    }

    @Override
    public AccountState getState() {
        return null;
    }
}
