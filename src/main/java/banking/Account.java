package banking;

import java.util.InputMismatchException;
import java.util.Scanner;

import static validation.InputValidator.validateDoubleInput;

public class Account {
    private String iban;
    private double balance;
    private static final int MAX_ID = 1000000000;
    public Account(String iban, double balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public Transaction getTransactionInformation(Account account) {
        double amount;
        String description;
        Transaction transaction;
        String answer = withdrawOrDeposit();
        amount = getAmount(answer, account);
        description = getDescription();
        System.out.println(amount);
        transaction = createTransaction(answer, amount, account.getIban(), description);
        return transaction;
    }

    public String getDescription() {
        Scanner s = new Scanner(System.in);
        System.out.println("what for?");
        String description = s.nextLine();
        return description;
    }

    public double getAmount(String answer, Account account) {
        Scanner s = new Scanner(System.in);
        System.out.println("how much do you want to " + answer + "?");
        double amount = validateDoubleInput(s.nextLine());
        while (answer.equals("withdraw") && !isValidAmount(account.getBalance(), amount)) {
            System.out.println("not enough funds, please enter a different amount");
            amount = validateDoubleInput(s.nextLine());
        }
        return amount;
    }


    public boolean isValidAmount(double balance, double amount) {
        if (amount > balance) return false;
        return true;
    }

    public Transaction createTransaction(String answer, double amount, String iban, String description) {
        Transaction transaction;
        final long
        final long  ID = (int) Math.floor(Math.random() * MAX_ID);
        if (answer.equals("withdraw")) {
            transaction = new Withdrawal(ID, amount, iban, description);
        } else {
            transaction = new Deposition(ID, amount, iban, description);
        }

        return transaction;
    }

    public String withdrawOrDeposit() {
        Scanner s = new Scanner(System.in);
        System.out.println("do you want to make a withdrawal or a deposition?");
        return s.nextLine();
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
