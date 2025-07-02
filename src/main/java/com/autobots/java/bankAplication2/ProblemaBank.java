package com.autobots.java.bankAplication2;

public class ProblemaBank extends BankBase{
    double funds = 500;

    public ProblemaBank(long accountNumber, String client, String bankName) {
        super(accountNumber, client, bankName);
        this.funds = funds;
        BankBase.addToBase(this);
    }

    @Override
    public void withDraw(double amount) {
        if (amount > 150000) {
            throw new IllegalArgumentException("You have limit 150000 to deposit");
        }
        funds-=amount;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 200000) {
            throw new IllegalArgumentException("You have limit 20000 to deposit");
        }
        funds += amount;
    }

    @Override
    public String toString() {
        return getClient() +"Problem Bank " +
                "funds=" + funds +
                '}';
    }
}
