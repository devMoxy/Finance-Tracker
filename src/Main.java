import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler();
        TransactionManager manager = new TransactionManager();
        double amount;
        String category;
        String description;
        String date;

        // load existing data on startup
        manager.loadTransactions(fileHandler.load());

        while(true){
            System.out.println("\n--- Finance Tracker ---");
            System.out.println("1. Add income");
            System.out.println("2. Add expense");
            System.out.println("3. View all transactions");
            System.out.println("4. View balance");
            System.out.println("5. Filter by category");
            System.out.println("6. Delete transaction");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch(choice){
                case "1":
                    System.out.println("Transaction type is Income!");
                    System.out.print("Enter amount: ");

                    amount = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter category: ");

                    category = scanner.nextLine();
                    System.out.print("Enter description: ");

                    description = scanner.nextLine();
                    System.out.print("Enter date(like DD-MM-YYYY): ");

                    date  = scanner.nextLine();
                    Transaction incomeTransaction = new Transaction(amount, "INCOME",category,description,date);
                    manager.addTransaction(incomeTransaction);
                    break;
                case "2":
                    System.out.println("Transaction type is Income!");
                    System.out.print("Enter amount: ");
                    amount = Double.parseDouble(scanner.nextLine());

                    System.out.print("Enter category: ");
                    category = scanner.nextLine();

                    System.out.print("Enter description: ");
                    description = scanner.nextLine();

                    System.out.print("Enter date(like DD-MM-YYYY): ");
                    date  = scanner.nextLine();
                    Transaction expenseTransaction = new Transaction(amount, "EXPENSE",category,description,date);
                    manager.addTransaction(expenseTransaction);
                    break;
                case "3":
                    manager.viewAll();
                    break;
                case "4":
                    System.out.println("Balance: £" + manager.getBalance());
                    break;
                case "5":
                    System.out.print("Enter the transaction category to be filtered: ");
                    String categoryInput = scanner.nextLine().trim().toUpperCase();
                    manager.filterByCategory(categoryInput);
                    break;
                case "6":
                    System.out.print("Enter the index of transaction you want to delete: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    manager.deleteTransaction(index);
                    break;
                case "7":
                    fileHandler.save(manager.getTransactions());
                    System.out.println("Saved. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}