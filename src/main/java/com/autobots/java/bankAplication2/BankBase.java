package com.autobots.java.bankAplication2;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BankBase implements Bank2 { //родитель всех банков
    private long accountNumber;
    private String client;
    public String bankName;

    static HashSet<BankBase> allBanksClients = new HashSet<>();
    //все банки будут класться в этот хешсет

    public BankBase(long accountNumber, String client,String bankName) {
        if(Long.toString(accountNumber).length()!=6){
            throw new IllegalArgumentException("Account number should be 6 digits");

        }else if(client.length()<5){
            throw new IllegalArgumentException("Account the name cant be less 5");

        }
        this.bankName=bankName;
        this.accountNumber = accountNumber;
        this.client = client;

    }
    public static void addToBase(BankBase bank){//в аргументы
        for (BankBase client:allBanksClients){
            if (client.getAccountNumber()==bank.getAccountNumber()){
                throw  new IllegalArgumentException("This account number already exicist");

            }
            if (client.getClient().equals(bank.getClient())){
                throw new IllegalArgumentException("Account already exist");
            }

        }
        allBanksClients.add(bank);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getClient() {
        return client;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setClient(String client) {
        this.client = client;
    }

     public static void filterByBank(String bank){

           List<BankBase> sorted =  allBanksClients.stream()  .filter(a->a.getBankName().equals(bank)).collect(Collectors.toList());
         System.out.println(bank+": "+sorted);
     }
  public String getBankName(){
        return bankName;
  }
    public static void filterByBank(){
        Map<String, Set<BankBase>> grouped =allBanksClients.stream().
                collect(Collectors.groupingBy(BankBase::getBankName,Collectors.toSet()));
        System.out.println(grouped);
        for (Map.Entry<String,Set<BankBase>> bank: grouped.entrySet()){
            System.out.println(bank);
        }
    }


}
