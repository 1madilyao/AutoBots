package com.autobots.java.bankAplication;

public class Mbank extends BankBase {
    private double balance = 200;

    public Mbank(long accountNumber, long routingNumber) throws Exception{
        super(accountNumber, routingNumber);
        addToAllBankRecords(this); // ссылается на этот объект



    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {

        if (amount < 0 || amount >=200000){
            throw  new IllegalArgumentException("invalid amount can not  be amount");
        }
        balance += amount;
    }

    @Override
    public void withDraw(double amount) {

        if (amount<0 || amount >= 150000){
            throw new IllegalArgumentException("invalid amount can not be withDrew");
        }else {
            if (amount > balance){
                throw  new IllegalArgumentException("insufficient funds");
            }else {
                balance -= amount;
            }
        }

    }
}
