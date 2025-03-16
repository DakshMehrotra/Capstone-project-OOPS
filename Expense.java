class Expense extends Transaction {
    public Expense(String description, double amount, String date, String category) throws InvalidAmountException {
        super(description, amount, date, category);
    }

    @Override
    public void displayTransaction() {
        System.out.printf("ID: %s | Date: %s | Category: %-10s | Description: %-20s | Amount: -$%.2f\n",
                transactionId, date, category, description, amount);
    }
}
