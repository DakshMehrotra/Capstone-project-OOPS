import java.util.ArrayList;

class ExpenseTracker {
    private ArrayList<Transaction> transactions;
    private double budget;
    private double totalIncome;
    private double totalExpenses;

    public ExpenseTracker() {
        this.transactions = new ArrayList<>();
        this.budget = 0;
        this.totalIncome = 0;
        this.totalExpenses = 0;
    }

    // Set Budget
    public void setBudget(double budget) throws InvalidAmountException {
        if (budget <= 0) {
            throw new InvalidAmountException("Budget must be greater than zero!");
        }
        this.budget = budget;
        System.out.println("Budget set to: $" + budget);
    }

    // Add Income (Adds directly to the balance)
    public void addIncome(Income income) {
        transactions.add(income);
        totalIncome += income.getAmount();
        System.out.println("Income added successfully! Total Balance: $" + getBalance());
    }

    // Add Expense (Deducts from balance)
    public void addExpense(Expense expense) throws BudgetExceededException {
        double updatedExpenses = totalExpenses + expense.getAmount();
        if (budget > 0 && updatedExpenses > budget) {
            System.out.println("Warning: Expense exceeds budget!");
        }
        transactions.add(expense);
        totalExpenses += expense.getAmount();
        System.out.println("Expense added successfully! Remaining Balance: $" + getBalance());
    }

    // Display All Transactions
    public void displayAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions recorded yet.");
            return;
        }
        System.out.println("\n--- Transaction History ---");
        for (Transaction t : transactions) {
            t.displayTransaction();
        }
        System.out.println("-----------------------------");
        System.out.printf("Total Income: $%.2f | Total Expenses: $%.2f | Remaining Balance: $%.2f\n",
                totalIncome, totalExpenses, getBalance());
    }

    // Calculate Balance
    public double getBalance() {
        return totalIncome - totalExpenses;
    }
}
