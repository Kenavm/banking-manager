package banking;

public class Account {
    private String iban;
    private double balance;

    public Account(String iban, double balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public double checkBalance() {
        return this.getBalance();
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
