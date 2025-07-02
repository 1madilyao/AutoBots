package com.autobots.java.bankApp;

public class CreditAccount extends BankAccount{

    private final double creditlimit =1000;
    public CreditAccount(Client owner, Currency currency) {
        super(owner, currency);
    }

    @Override
    public void deposit(double amount) {
        balance+=amount;
        addTransaction("Deposit",amount);
    }

    @Override
    public boolean withDrow(double amount) {
 if (amount <= balance+creditlimit){
     balance-=amount;
     addTransaction("WITH DROW",amount);
     return true;
 }
 return false;
    }
}
