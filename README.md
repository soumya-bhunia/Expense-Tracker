# Expense Tracker 

**Description**:
The Expense Tracker is a Java-based console application designed to help users manage their
personal finances by tracking expenses. The application allows users to add, remove, view, and
total their expenses. It saves the data to a file for persistent storage, ensuring that all expenses
are retained between sessions.
<br>

**Key Features**:
- Add Expense: Users can record a new expense by entering the date, description, and amount.
- Remove Expense: Allows users to delete an existing expense by specifying its index.
- View Expenses: Displays a list of all recorded expenses in a formatted manner.
- Total Expenses: Calculates and shows the sum of all expenses.
- Persistent Storage: Expenses are stored in a text file (`expenses.txt`), allowing the data to
persist across multiple runs of the application.
**Technologies Used**:
- Java: Core programming language used to build the application.
- File I/O: Utilized for reading from and writing to a file to persist expense data.
- `File`, `FileReader`, `FileWriter`, `BufferedReader`, `PrintWriter` for handling file operations.
- Collections Framework: `ArrayList` used to manage the list of expenses.
- Scanner: Used to capture user input from the console.
- String Formatting: Employed for formatting output, especially currency values.
**Skills Demonstrated**:
- Object-Oriented Programming: Created a nested `Expense` class within `ExpenseTracker` to
encapsulate expense details.
- Data Persistence: Implemented persistent storage using file I/O to maintain data consistency
across sessions.
- User Interaction: Developed a user-friendly console interface that interacts with users through
a menu-driven system.
- Error Handling: Added basic error checking for invalid inputs, ensuring robustness and user
reliability.
