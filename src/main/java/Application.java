import banking.Account;
import gui.Menu;

public class Application {

    public static void main(String[] args) {
        Account account = new Account("Manuel Vanek", "AT732060436165399561", 500.0);
        Menu menu = new Menu();
        menu.showMenu(account);
        /*
        Transaction transaction = account.getTransactionInformation(account);
        transaction.processTransaction(account, transaction);

        System.out.println(transaction);
        System.out.println("balance: " + account.getBalance());

         */
    }


}
