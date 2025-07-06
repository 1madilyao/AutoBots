package com.autobots.java.bankAplication;

public class BankDemo {
    public static void main(String[] args)throws Exception {
        Mbank aliiaMbank = new Mbank(123456789111L, 444444444);

        System.out.println(aliiaMbank.getBalance());
        aliiaMbank.deposit(20000);
        System.out.println(aliiaMbank.getBalance());

        System.out.println("--------");

        OptimaBank ulugbekOptima = new OptimaBank(123456789122L, 555555555);
        System.out.println(ulugbekOptima.getBalance());
        System.out.println("--------");

        Bank.transferFunds(aliiaMbank, ulugbekOptima, 500);
        System.out.println(aliiaMbank.getBalance());
        System.out.println(ulugbekOptima.getBalance());
        System.out.println("----6776----");

        Demir zinaidaDemir = new Demir(123333344555L, 666666666);
        System.out.println(zinaidaDemir.getBalance());
        zinaidaDemir.deposit(5000);
        System.out.println(zinaidaDemir.getBalance());

//        zinaidaDemir.withDraw(5000000); 

        System.out.println("-----54656586489---");

        BankBase.allBankRecords.stream().filter(n -> n.getBalance() > 100).forEach(System.out::println);
        double allSumOfBanks = BankBase.allBankRecords.stream().mapToDouble(Bank::getBalance).sum();
       System.out.println(allSumOfBanks);





    }
}
