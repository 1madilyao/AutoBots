package com.autobots.java.bankApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Demo {
    static  Scanner scsan =new Scanner(System.in);
            static Map<String,Client> client =new HashMap<>();
    public static void main(String[] args) {

        Client asan =new Client("Asan uson","123");
        DepositAccount asanDeposit =new DepositAccount(asan,Currency.USD);
        CreditAccount asanCredit =new CreditAccount(asan,Currency.EUR);

        asan.Addaccount(asanDeposit);
        asan.Addaccount(asanCredit);
        System.out.println(asan.getClient_id());

        client.put(asan.getClient_id(),asan);
        System.out.println("========Welcome to Mbank!=========");
        System.out.print("Please enter client ID");
        String clientID =scsan.nextLine();
        Client client1=client.get(clientID);
        if (client1 ==null){
            System.out.println("Client was not found");
            return;
        }
        System.out.println("Please enter pin code");
        String pincode =scsan.nextLine();
        if(!client1.authenticate(pincode)){
            System.out.println("You entered wrong pin code");
            return;
        }
        System.out.println(client1.getFull_name()+" welcome to Mbank");
         while (true){
             System.out.println("1.Посмотреть счета");
             System.out.println("2.Перевести между счетами");
             System.out.println("3.Показать чек");
             System.out.println("0.Выход из системы");

             String choice =scsan.nextLine();
             switch (choice){
                 case "1":
                     for (BankAccount bankAccount :client1.getAccounts()){
                         System.out.printf("%s | %s | Баланс: %.2f %s\n",
                                 bankAccount.getClass().getSimpleName(),
                                 bankAccount.getAccount_number(),
                                 bankAccount.getBalance(), bankAccount.getCurrency());
                     }
                     break;
                 case "2":
                     System.out.println("Введите номер счета отправителя");
                     String fromID =scsan.nextLine();
                     System.out.println("Введите номер счете получателя");
                     String toId =scsan.nextLine();
                     System.out.println("Сумма: ");
                     double amount =Double.parseDouble(scsan.nextLine());
                     BankAccount from =findAccount(fromID);
                     BankAccount to =findAccount(toId);
                     if (from !=null && to !=null) {
                        boolean result = BankService.transfer(from,to,amount);
                         System.out.println(result ? "Операция прошла успешно!" : "Ошибка перевода");
                     } else {
                         System.out.println("Счета не найдены");
                     }
                     break;
                 case "3":
                     for (BankAccount bankAccount: client1.getAccounts()){
                         System.out.println("\n == чек по счету "+bankAccount.getAccount_number());
                         for (Transaction transaction : bankAccount.getTransactions()){
                             System.out.println(transaction);
                         }
                     }
                     break;
                 case "0":
                     System.out.println("Выход ...");
                     return;
                 default:
                     System.out.println("Не верный выбор");
             }

         }


    }
    private static  BankAccount findAccount(String  accountNumber ){
        for (Client client1:client.values()){
            for (BankAccount bankAccount : client1.getAccounts()){
                if (bankAccount.getAccount_number().equals(accountNumber)){
                    return bankAccount;
                }
            }
        }
        return null;
    }
}
