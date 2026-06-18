import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private final String fileName = "transactions.txt";

    public void save(ArrayList<Transaction> transactions){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (Transaction transaction : transactions) {
                writer.write(transaction.toSaveFormat());
                writer.newLine();
            }
            writer.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Transaction> load(){
        ArrayList<Transaction> transactions = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split("\\|");
                Transaction transaction = new Transaction(Double.parseDouble(parts[0]), parts[1], parts[2], parts[3], parts[4]);
                transactions.add(transaction);
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return transactions;
    }
}