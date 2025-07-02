package com.autobots.java.bankAplication;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class BankBase implements Bank {
    private  long accountNumber;
    private long routingNumber;

    public static Set<BankBase>allBankRecords =new HashSet<>();


    public long getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(long routingNumber) {
        this.routingNumber = routingNumber;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankBase(long accountNumber, long routingNumber) {

        if(Long.toString(accountNumber).length()!=12){
            throw new IllegalArgumentException("Account number must be 12 digit");
        }else if (Long.toString(routingNumber).length()!=9){
            throw new IllegalArgumentException("Routing number must be 9 digit ");
        } else{
            this.accountNumber = accountNumber;
            this.routingNumber = routingNumber;
        }
    }

    public static void addToAllBankRecords(BankBase bank) throws Exception {
        for (BankBase bankBase : allBankRecords) {
            if (bankBase.getAccountNumber() == bank.getAccountNumber()) {
                throw new Exception(bankBase.getAccountNumber() + ": account number already exist");
            }
            if (bankBase.getRoutingNumber() == bank.getRoutingNumber()){
                throw new Exception(bankBase.getAccountNumber()+ ": routing number already exist");
            }

        }
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankBase bankBase = (BankBase) o;
        return accountNumber == bankBase.accountNumber && routingNumber == bankBase.routingNumber ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, routingNumber, allBankRecords);
    }

    @Override
    public String toString() {
        return "BankBase{" +
                "accountNumber=" + accountNumber +
                ", routingNumber=" + routingNumber +
                '}';
    }
}
