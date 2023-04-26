import banking.Account;
import banking.Deposition;
import banking.Transaction;
import banking.Withdrawal;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Account account = new Account("AT732060436165399561", 500.0);
        String accountIban = account.getIban();
        Transaction transaction = getTransactionInformation(accountIban);
        transaction.processTransaction(account, transaction);
        System.out.println(transaction);

        System.out.println("balance: "+account.checkBalance());
    }

    public static Transaction getTransactionInformation(String iban) {
        Scanner s = new Scanner(System.in);
        double amount;
        String description;
        Transaction transaction;
        String answer = withdrawOrDeposit();

        System.out.println("how much do you wanna " + answer + "?");
        amount = s.nextDouble();
        s.nextLine();
        System.out.println("what for?");
        description = s.nextLine();
        transaction = createTransaction(answer, amount, iban, description);
        return transaction;

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
