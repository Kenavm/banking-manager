import banking.Account;
import banking.Deposition;
import banking.Transaction;
import banking.Withdrawal;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Account account = new Account("AT732060436165399561", 500.0);

        Transaction transaction = getTransactionInformation(account);
        transaction.processTransaction(account, transaction);

        System.out.println(transaction);
        System.out.println("balance: " + account.getBalance());
    }

    public static Transaction getTransactionInformation(Account account) {
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

    public static String getDescription() {
        Scanner s = new Scanner(System.in);
        System.out.println("what for?");
        String description = s.nextLine();
        return description;
    }

    public static double getAmount(String answer, Account account) {
        Scanner s = new Scanner(System.in);
        System.out.println("how much do you wanna " + answer + "?");
        double amount = s.nextDouble();
        if (answer.equals("withdraw")) {
            do {
                System.out.println("not enough funds, please put in different amount");
                amount = s.nextDouble();
            } while (!isValidAmount(account.getBalance(), amount));
        } else {
            return amount;
        }
        return amount;
    }

    public static boolean isValidAmount(double balance, double amount) {
        if (amount > balance) return false;
        return true;
    }

    public static Transaction createTransaction(String answer, double amount, String iban, String description) {
        Transaction transaction;
        long id = (int) Math.floor(Math.random() * 1000000000);
        if (answer.equals("withdraw")) {
            transaction = new Withdrawal(id, amount, iban, description);
        } else {
            transaction = new Deposition(id, amount, iban, description);
        }

        return transaction;
    }

    public static String withdrawOrDeposit() {
        Scanner s = new Scanner(System.in);
        System.out.println("do you want to make a withdrawal or a deposition?");
        return s.nextLine();
    }


}
