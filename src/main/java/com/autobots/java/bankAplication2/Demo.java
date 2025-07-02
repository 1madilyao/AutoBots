package com.autobots.java.bankAplication2;

import com.autobots.java.bankAplication.Mbank;

public class Demo {
    public static void main(String[] args)  {
        Bank2 Kairat =new OprimaBank1(451236,"Kairat","Optima Bank");
        Bank2 Altynai =new ProblemaBank(345078,"Altynai","Problem Bank");
        Bank2 Beginay =new OprimaBank1(347678,"Beginay","Optima Bank");
        Bank2 Akinay =new ProblemaBank(349678,"Akinay","Problem Bank");
        Bank2.transaction(Altynai,Kairat,200);
        System.out.println(Altynai); //300
        System.out.println(Kairat); // 200
        System.out.println(BankBase.allBanksClients);
        BankBase.filterByBank("Optima Bank");
        BankBase.filterByBank("Problem Bank");
        System.out.println("_______________");
        BankBase.filterByBank();




    }
}
