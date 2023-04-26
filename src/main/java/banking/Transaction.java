package banking;

public abstract class Transaction {

    private double id;
    private String iban;
    private double amount;
    private String description;

    public Transaction(double id, double amount, String iban, String description) {
        this.id = id;
        this.amount = amount;
        this.iban = iban;
        this.description = description;
    }

    public void processTransaction(Account account, Transaction transaction) {
        if (transaction instanceof Withdrawal) {
            account.setBalance(account.getBalance() - transaction.getAmount());
        } else {
            account.setBalance(account.getBalance() + transaction.getAmount());
        }

    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "id: " + this.getId() + "\niban: " + this.getIban() + "\namount: " + this.getAmount() + "\ndescription: " + this.getDescription();
    }
}
