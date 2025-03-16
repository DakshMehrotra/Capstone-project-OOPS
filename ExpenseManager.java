import java.util.Scanner;

public class ExpenseManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseTracker tracker = new ExpenseTracker();

        System.out.println("Welcome to the Smart Expense Manager!");

        while (true) {
            try {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Set Budget");
                System.out.println("2. Add Income");
                System.out.println("3. Add Expense");
                System.out.println("4. Show Transactions");
                System.out.println("5. Show Balance");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter budget: $");
                        double budget = scanner.nextDouble();
                        tracker.setBudget(budget);
                        break;

                    case 2:
                        System.out.print("Enter income description: ");
                        String incomeDesc = scanner.nextLine();
                        System.out.print("Enter amount: $");
                        double incomeAmount = scanner.nextDouble();
                        System.out.print("Enter date (MM-DD-YYYY): ");
                        String incomeDate = scanner.next();
                        tracker.addIncome(new Income(incomeDesc, incomeAmount, incomeDate));
                        break;

                    case 3:
                        System.out.print("Enter expense description: ");
                        String expDesc = scanner.nextLine();
                        System.out.print("Enter amount: $");
                        double expAmount = scanner.nextDouble();
                        System.out.print("Enter date (MM-DD-YYYY): ");
                        String expDate = scanner.next();
                        System.out.print("Enter category: ");
                        String expCategory = scanner.next();
                        tracker.addExpense(new Expense(expDesc, expAmount, expDate, expCategory));
                        break;

                    case 4:
                        tracker.displayAllTransactions();
                        break;

                    case 5:
                        System.out.printf("Remaining Balance: $%.2f\n", tracker.getBalance());
                        break;

                    case 6:
                        System.out.println("Exiting Smart Expense Manager... Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Please select a valid option.");
                }
            } catch (InvalidAmountException | BudgetExceededException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter the correct values.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
}
