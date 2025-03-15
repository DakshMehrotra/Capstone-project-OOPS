import java.util.UUID;

abstract class Transaction {
    protected String transactionId;
    protected String description;
    protected double amount;
    protected String date;
    protected String category;

    public Transaction(String description, double amount, String date, String category) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero!");
        }
        this.transactionId = UUID.randomUUID().toString();
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    // Abstract method to display transaction details
    public abstract void displayTransaction();

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }
}
