package com.autobots.java.bankAplication;

public interface Bank {
    // абстрактные методы
    double getBalance();           // запрос баланса
    void deposit(double amount);   // пополнение счета
    void withDraw(double amount);  // снятие денег

    static void transferFunds(Bank sender,Bank recipient , double transferAmount ){
        sender.withDraw(transferAmount);  // отправляет
        recipient.deposit(transferAmount); // получает
    }
}
