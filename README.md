# Bank Management System

A console-based Bank Management System built in Java that allows users to manage customers, bank accounts, transactions, and account operations. The project demonstrates object-oriented programming principles, clean code practices, and incremental feature development.

---

## Features

### Current Features
- Create new customers
- Create bank accounts
- View customer accounts
- Deposit money
- Withdraw money
- Transfer funds between accounts
- Record transaction history
- Search customers and accounts
- Input validation
- Unit testing

### Planned Features
- JSON data persistence
- Load saved banking data
- Account statements
- Savings and Current account types
- Custom exceptions
- Reporting
- Improved documentation

---

## Project Structure

```
Bank-Management-System/
│
├── src/
│   ├── Main.java
│   ├── models/
│   │   ├── Account.java
│   │   ├── Customer.java
│   │   ├── SavingsAccount.java
│   │   ├── CurrentAccount.java
│   │   └── Transaction.java
│   │
│   ├── services/
│   │   └── BankService.java
│   │
│   ├── exceptions/
│   │   └── InsufficientFundsException.java
│   │
│   └── utils/
│       └── InputValidator.java
│
├── test/
│   └── BankServiceTest.java
│
└── README.md
```

---

## Technologies

- Java
- Object-Oriented Programming (OOP)
- Collections Framework
- Exception Handling
- JUnit
- IntelliJ IDEA
- Git & GitHub

---

## Concepts Demonstrated

- Encapsulation
- Inheritance
- Polymorphism
- Composition
- Object Relationships
- Collections (ArrayList, HashMap)
- File Handling
- Unit Testing
- Input Validation
- Exception Handling

---

## Getting Started

### Clone the repository

```bash
git clone git@github.com:Milabunjwa/Bank-Management-System.git
```

### Navigate to the project

```bash
cd Bank-Management-System
```

### Compile

```bash
javac src/**/*.java
```

### Run

```bash
java Main
```

---

## Development Roadmap

- [x] Customer management
- [x] Account creation
- [ ] Deposits
- [ ] Withdrawals
- [ ] Fund transfers
- [ ] Transaction history
- [ ] Account search
- [ ] JSON persistence
- [ ] Data loading
- [ ] Monthly statements
- [ ] Custom exceptions
- [ ] Reporting

---

## Testing

Unit tests are written using **JUnit** to verify the correctness of the banking operations, customer management, validation, and transaction handling.

---

## Future Improvements

- Graphical User Interface (JavaFX)
- Database integration (MySQL/PostgreSQL)
- Authentication and login
- Interest calculation
- Scheduled payments
- Transaction filtering
- REST API

---

## Author

**Mila Bunjwa**

GitHub: https://github.com/Milabunjwa