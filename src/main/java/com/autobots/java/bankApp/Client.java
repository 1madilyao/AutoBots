package com.autobots.java.bankApp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    private final String full_name;
    private final String client_id;
    private final String pin;
    private final List<BankAccount> accounts =new ArrayList<>();

    public Client(String full_name,  String pin) {
        this.full_name = full_name;
        this.pin = pin;
        this.client_id =String.valueOf(UUID.randomUUID());
    }

   public  boolean authenticate(String inoput_pin){
        return this.pin.equals(inoput_pin);
   }
   void Addaccount (BankAccount account){
        accounts.add(account);
   }

    public String getFull_name() {
        return full_name;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getPin() {
        return pin;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}
