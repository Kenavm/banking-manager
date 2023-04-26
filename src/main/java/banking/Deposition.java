package banking;

public class Deposition extends Transaction{

    public Deposition(double id, double amount, String recipient, String description) {
        super(id, amount, recipient, description);
    }
}
