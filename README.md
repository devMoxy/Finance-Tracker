💰 Finance Tracker

A console-based personal finance tracking application built in Java. Add income and expenses, view your balance, filter by category, and persist your data between sessions using file I/O.


Features


Add income and expense transactions
View all transactions with a clean formatted output
Check your current balance instantly
Filter transactions by category (Food, Rent, Salary, etc.)
Delete transactions by index
Data persists between sessions via file storage — close and reopen, your data is still there


Tech Stack

Language: Java
Concepts: Object-Oriented Programming, File I/O, Collections (ArrayList), Encapsulation, Constructor Injection
Tools: IntelliJ IDEA, Git, GitHub



Project Structure

src/
├── Main.java               — Entry point, menu loop, user input handling
├── Transaction.java        — Data model representing a single transaction
├── TransactionManager.java — Business logic, manages ArrayList of transactions
└── FileHandler.java        — Reads and writes transaction data to a .txt file


How It Works

Transaction.java

Represents a single financial transaction. All fields are private and accessed via getters, following proper encapsulation principles. Fields marked as final cannot be changed after the object is created.

javaprivate final double amount;
private final String type;       // "INCOME" or "EXPENSE"
private final String category;
private final String description;
private final String date;

TransactionManager.java

Handles all business logic. Stores transactions in an ArrayList<Transaction> and exposes methods for adding, deleting, viewing, filtering, and calculating balance.

javapublic void addTransaction(Transaction t)
public void deleteTransaction(int index)
public void viewAll()
public double getBalance()
public void filterByCategory(String category)
public ArrayList<Transaction> getTransactions()
public void loadTransactions(ArrayList<Transaction> loaded)
public void clearTransactions()

FileHandler.java

Handles data persistence. Saves transactions to transactions.txt in a pipe-separated format and reads them back on startup, reconstructing Transaction objects line by line.

Save format:

1500.0|INCOME|Salary|Monthly pay|16-06-2024
50.0|EXPENSE|Food|Weekly groceries|16-06-2024

Main.java

Coordinates everything. Loads existing data on startup, presents a menu loop, collects user input via Scanner, and saves data on exit.


Menu Options

--- Finance Tracker ---
1. Add income
2. Add expense
3. View all transactions
4. View balance
5. Filter by category
6. Delete transaction
7. Exit


How To Run

Clone the repository

bashgit clone https://github.com/devMoxy/Finance-Tracker.git


Open in IntelliJ IDEA
Run Main.java
Follow the console menu


No external dependencies. Pure Java. No setup required beyond a JDK.


What I Learned

This project was built as a Java deepening exercise, focusing on:


OOP principles — every class has a single responsibility. Transaction holds data, TransactionManager handles logic, FileHandler handles persistence, Main coordinates everything
Encapsulation — private fields with public getters, no direct field access from outside a class
File I/O — BufferedWriter and BufferedReader for reading and writing persistent data
Collections — real-world use of ArrayList with filtering, searching, and iteration
Constructor injection — dependencies passed in rather than grabbed globally



Planned Improvements

 Input validation — handle non-numeric input gracefully
 SQLite database instead of flat file storage
 Monthly spending summaries
 Connect to UK Open Banking API (TrueLayer) for real bank data
 Spring Boot REST API version
 Simple frontend UI



👤 Author

Built by Enoch Adelowo — self-taught Java developer.

Part of a structured 7-month roadmap toward a software engineering internship in the UK fintech space.

"The best way to learn is to build something real."
