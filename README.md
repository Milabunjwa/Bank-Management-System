# Bank Management System

A Java console application that simulates a simple banking system.

This project demonstrates object-oriented programming principles including encapsulation, composition, collections, file persistence, and unit testing.

---

## Features

### Customer Management

- Create customers
- Search customers by ID
- Store customer information

### Account Management

- Create bank accounts
- Link accounts to customers
- Search accounts

### Banking Operations

- Deposit money
- Withdraw money
- Transfer money between accounts

### Transaction History

Each account records:

- Deposits
- Withdrawals

### Data Persistence

Customer and account information is saved to JSON files and automatically loaded when the application starts.

### Validation

The system prevents:

- Duplicate customer IDs
- Duplicate account numbers
- Empty names
- Empty account numbers
- Invalid deposits
- Invalid withdrawals
- Invalid transfers
- Withdrawals exceeding available balance

### Unit Testing

JUnit tests verify:

- Customer creation
- Account creation
- Deposits
- Withdrawals
- Transfers
- Validation
- Transaction history
- Data persistence

---

# Technologies

- Java
- IntelliJ IDEA
- JUnit 5
- JSON (manual serialization)
- Git
- GitHub

---

# Project Structure

```
Bank-Management-System
│
├── src
│   ├── models
│   │     Account.java
│   │     Customer.java
│   │     Transaction.java
│   │
│   ├── services
│   │     BankService.java
│   │     FileManager.java
│   │
│   └── Main.java
│
├── tests
│      BankServiceTest.java
│
├── data
│      customers.json
│      accounts.json
│
└── README.md
```

---

# Running the Project

1. Clone the repository

```
git clone https://github.com/YourUsername/Bank-Management-System.git
```

2. Open the project in IntelliJ IDEA.

3. Run:

```
Main.java
```

---

# Running Tests

Run:

```
BankServiceTest.java
```

using IntelliJ's JUnit runner.

---

# Example Output

```
Customers

C001 - Mila
C002 - John

Accounts

A001 | Mila | Balance: R450.0

Deposit : R1000.0
Withdrawal : R250.0
Withdrawal : R300.0

A002 | John | Balance: R300.0

Deposit : R300.0
```

---

# Future Improvements

- Interest calculations
- Multiple account types
- User login system
- PIN authentication
- Monthly bank statements
- Better JSON handling using Jackson or Gson
- Database integration (MySQL or PostgreSQL)
- JavaFX graphical interface

---

# Concepts Demonstrated

- Classes
- Objects
- Encapsulation
- Composition
- ArrayLists
- Searching
- Validation
- File handling
- JSON persistence
- Unit testing
- Clean code
- Object-oriented programming

---

## Author

**Mila Bunjwa**

Software Development Student at WeThinkCode

Aspiring Java Backend Developer