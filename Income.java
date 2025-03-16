class Income extends Transaction {
    public Income(String description, double amount, String date) throws InvalidAmountException {
        super(description, amount, date, "Income");
    }

    @Override
    public void displayTransaction() {
        System.out.printf("ID: %s | Date: %s | Description: %-20s | Amount: +$%.2f\n",
                transactionId, date, description, amount);
    }
}
