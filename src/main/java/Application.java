import banking.Account;
import banking.Transaction;

public class Application {

    public static void main(String[] args) {
        Account account = new Account("AT732060436165399561", 500.0);

        Transaction transaction = account.getTransactionInformation(account);
        transaction.processTransaction(account, transaction);

        System.out.println(transaction);
        System.out.println("balance: " + account.getBalance());
    }


}
