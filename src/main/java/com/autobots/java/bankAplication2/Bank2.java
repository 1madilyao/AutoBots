package com.autobots.java.bankAplication2;

import com.autobots.java.bankAplication.Bank;

public interface Bank2 {

        void withDraw(double amount);
        //списание баланса
        void deposit(double amount);
        //пополнение
        static void transaction(Bank2 sender, Bank2 recipient, double amount){
            sender.withDraw(amount);
            recipient.deposit(amount);

        }


}
