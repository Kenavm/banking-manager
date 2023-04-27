package gui;

import banking.Account;
import transactions.Transaction;

import java.util.Scanner;

public class Menu {

    public void showMenu(Account account) {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + account.getAccountOwner());
        System.out.println("Your Iban:" + account.getIban());
        System.out.println("\n");
        System.out.println("a) Check Balance");
        System.out.println("b) Deposit Amount");
        System.out.println("c) Withdraw Amount");
        System.out.println("d) Previous Transaction");
        System.out.println("e) Exit");

        do {
            System.out.println("********************************************");
            System.out.println("Choose an option");
            option = sc.next().charAt(0);
            System.out.println("\n");
            Transaction transaction;
            switch (option) {
                case 'a':
                    System.out.println("......................");
                    System.out.println("Balance = " + account.getBalance());
                    System.out.println("......................");
                    System.out.println("\n");
                    break;
                case 'b':
                    System.out.println("......................");
                    System.out.println("Enter a amount to deposit :");
                    System.out.println("......................");
                    transaction = account.getTransactionInformation(account, option);
                    transaction.processTransaction(account, transaction);
                    System.out.println("......................");
                    System.out.println(transaction);
                    System.out.println("Current balance: " + account.getBalance());
                    System.out.println("\n");
                    break;
                case 'c':
                    System.out.println("......................");
                    System.out.println("Enter a amount to Withdraw :");
                    System.out.println("......................");
                    transaction = account.getTransactionInformation(account, option);
                    transaction.processTransaction(account, transaction);
                    System.out.println("......................");
                    System.out.println(transaction);
                    System.out.println("Current balance: " + account.getBalance());
                    System.out.println("\n");
                    break;
                case 'd':
                    System.out.println("......................");
                    break;
                default:
                    System.out.println("Choose a correct option to proceed");
                    break;
            }

        } while (option != 'd');

        System.out.println("Thank you for using our banking services");
    }
}
