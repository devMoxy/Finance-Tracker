import java.util.ArrayList;

public class TransactionManager {
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction t){
        transactions.add(t);
    }
    public void viewAll(){
        for(Transaction transaction : transactions){
            System.out.println(transaction);
        }
    }
    public void deleteTransaction(int index){
        transactions.remove(index);
    }
    public double getBalance(){
        double balance = 0;

        for(Transaction transaction : transactions){
            if (transaction.getType().equals("INCOME")) {
                balance += transaction.getAmount();
            }
            if (transaction.getType().equals("EXPENSE")) {
                balance -= transaction.getAmount();
            }
        }
        return balance;
    }
    public void filterByCategory(String category){
        for(Transaction transaction : transactions){
            if(transaction.getCategory().equals(category)){
                System.out.println(transaction);
            }
        }
    }

    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

    public void loadTransactions(ArrayList<Transaction> loaded){
        transactions = loaded;
    }
}