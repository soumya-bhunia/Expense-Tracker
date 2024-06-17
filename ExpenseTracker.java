import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseTracker {
    private List<Expense> expenses;
    private static final String FILE_NAME = "expenses.txt";

    public ExpenseTracker() {
        this.expenses = new ArrayList<>();
        loadExpenses();
    }

    private class Expense {
        private String date;
        private String description;
        private double amount;

        public Expense(String date, String description, double amount) {
            this.date = date;
            this.description = description;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Date: " + date + ", Description: " + description + ", Amount: $" + String.format("%.2f", amount);
        }

        public String toCSV() {
            return date + "," + description + "," + amount;
        }

        public double getAmount() {
            return amount;
        }
    }

    public void addExpense(String date, String description, double amount) {
        Expense expense = new Expense(date, description, amount);
        expenses.add(expense);
        saveExpenses();
        System.out.println("Expense added successfully.");
    }

    public void removeExpense(int index) {
        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
            saveExpenses();
            System.out.println("Expense removed successfully.");
        } else {
            System.out.println("Invalid expense index.");
        }
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
        } else {
            System.out.println("Expense List:");
            for (int i = 0; i < expenses.size(); i++) {
                System.out.println((i + 1) + ". " + expenses.get(i));
            }
        }
    }

    public void totalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        System.out.println("Total Expenses: $" + String.format("%.2f", total));
    }

    private void loadExpenses() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        String date = parts[0];
                        String description = parts[1];
                        double amount = Double.parseDouble(parts[2]);
                        expenses.add(new Expense(date, description, amount));
                    }
                }
                System.out.println("Expenses loaded successfully.");
            } catch (IOException e) {
                System.err.println("Failed to load expenses: " + e.getMessage());
            }
        }
    }

    private void saveExpenses() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Expense expense : expenses) {
                writer.println(expense.toCSV());
            }
            System.out.println("Expenses saved successfully.");
        } catch (IOException e) {
            System.err.println("Failed to save expenses: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nExpense Tracker Menu");
            System.out.println("1. Add Expense");
            System.out.println("2. Remove Expense");
            System.out.println("3. View Expenses");
            System.out.println("4. Total Expenses");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); 
                    tracker.addExpense(date, description, amount);
                    break;
                case "2":
                    System.out.print("Enter expense index to remove: ");
                    int index = scanner.nextInt() - 1;
                    scanner.nextLine(); 
                    tracker.removeExpense(index);
                    break;
                case "3":
                    tracker.viewExpenses();
                    break;
                case "4":
                    tracker.totalExpenses();
                    break;
                case "5":
                    System.out.println("Exiting the Expense Tracker.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}