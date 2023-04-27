package account;

import transactions.Deposition;
import transactions.Transaction;
import transactions.Withdrawal;

import java.util.Scanner;

import static validation.InputValidator.validateDoubleInput;

public class Account {
    private String accountOwner;
    private String iban;
    private double balance;
    private static final int MAX_ID = 1000000000;
    public Account(String accountOwner, String iban, double balance) {
        this.accountOwner = accountOwner;
        this.iban = iban;
        this.balance = balance;
    }

    public Transaction getTransactionInformation(Account account, char answer) {
        double amount;
        String description;
        Transaction transaction;
        amount = getAmount(answer, account);
        description = getDescription();
        transaction = createTransaction(answer, amount, account.getIban(), description);
        return transaction;
    }


    public String getDescription() {
        Scanner s = new Scanner(System.in);
        System.out.println("what for?");
        String description = s.nextLine();
        return description;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public double getAmount(char answer, Account account) {
        Scanner s = new Scanner(System.in);
        double amount = validateDoubleInput(s.nextLine());
        while (answer == 'c' && !isValidAmount(account.getBalance(), amount)) {
            System.out.println("not enough funds, please enter a different amount");
            amount = validateDoubleInput(s.nextLine());
        }
        return amount;
    }


    public boolean isValidAmount(double balance, double amount) {
        if (amount > balance) return false;
        return true;
    }

    public Transaction createTransaction(char answer, double amount, String iban, String description) {
        Transaction transaction;
        final long  ID = (int) Math.floor(Math.random() * MAX_ID);

        if (answer == 'c') {
            transaction = new Withdrawal(ID, amount, iban, description);
        } else {
            transaction = new Deposition(ID, amount, iban, description);
        }

        return transaction;
    }



    public double getBalance() {
        return balance;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }
}
