public class Transaction {
    //Encapsulating variables using private declaration
    private double amount;
    private String type;
    private String category;
    private String description;
    private String date;

    public Transaction(double amount, String type, String category, String description, String date){
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public double getAmount(){
        return amount;
    }

    public String getType(){
        return type;
    }

    public String getCategory(){
        return category;
    }

    public String getDescription(){
        return description;
    }

    public String getDate(){
        return date;
    }

    public String toSaveFormat(){
        return amount + "|" + type + "|" + category + "|" + description + "|" + date;
    }

    @Override
    public String toString(){
        return "[" + type + "] " + category + " | £" + amount + " | " + description + " | " + date;
    }
}
