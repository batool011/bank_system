package accounts;

import interest.InterestPolicy;
import notifications.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAccount implements Account {

    protected String accountId;
    protected double balance;
    protected AccountState state;
    protected List<NotificationObserver> observers = new ArrayList<>();

    public AbstractAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
        this.state = new ActivState(); // default
    }
    protected InterestPolicy interestPolicy;




    public void addBalance(double amount) {
        balance += amount;
    }

    public void reduceBalance(double amount) {
        balance -= amount;
    }
    @Override
    public String getAccountId() {
        return accountId;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        state.deposit(this, amount);
    }

    @Override
    public void withdraw(double amount) {
        state.withdraw(this, amount);
    }
    @Override
    public void setState(AccountState state) {
        this.state = state;
    }

    @Override
    public AccountState getState() {
        return state;
    }

    public void applyInterest() {
        if (interestPolicy != null) {
            interestPolicy.apply(this);
        }
    }

    public void addObserver(NotificationObserver observer ) {
        observers.add(observer);
    }

    public void notifyAll(String message) {
        observers.forEach(o -> o.notify(message));
    }
}

