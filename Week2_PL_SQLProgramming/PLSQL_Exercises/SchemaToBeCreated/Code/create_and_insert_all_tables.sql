SET SERVEROUTPUT ON;

-- Drop tables if already exist
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Transactions CASCADE CONSTRAINTS';
    EXECUTE IMMEDIATE 'DROP TABLE Loans CASCADE CONSTRAINTS';
    EXECUTE IMMEDIATE 'DROP TABLE Accounts CASCADE CONSTRAINTS';
    EXECUTE IMMEDIATE 'DROP TABLE Customers CASCADE CONSTRAINTS';
    EXECUTE IMMEDIATE 'DROP TABLE Employees CASCADE CONSTRAINTS';
EXCEPTION
    WHEN OTHERS THEN
        NULL;
END;
/

SET DEFINE OFF;

-- Customers Table
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

-- Accounts Table
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Transactions Table
CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

-- Loans Table
CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Employees Table
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

-- Insert Customers
INSERT INTO Customers VALUES (1, 'Gabriel dOrsay', TO_DATE('1950-03-01', 'YYYY-MM-DD'), 15000, SYSDATE); -- >60, VIP
INSERT INTO Customers VALUES (2, 'Nina Vermeer', TO_DATE('1995-06-15', 'YYYY-MM-DD'), 8000, SYSDATE);
INSERT INTO Customers VALUES (3, 'Victor Aleph', TO_DATE('1970-08-20', 'YYYY-MM-DD'), 12000, SYSDATE); -- VIP
INSERT INTO Customers VALUES (4, 'Tessa Marlowe', TO_DATE('1985-11-10', 'YYYY-MM-DD'), 4000, SYSDATE);
INSERT INTO Customers VALUES (5, 'Elias Koster', TO_DATE('1948-01-25', 'YYYY-MM-DD'), 9500, SYSDATE); -- >60

-- Insert Accounts
INSERT INTO Accounts VALUES (1, 1, 'Savings', 15000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Checking', 8000, SYSDATE);
INSERT INTO Accounts VALUES (3, 3, 'Savings', 12000, SYSDATE);
INSERT INTO Accounts VALUES (4, 4, 'Checking', 4000, SYSDATE);
INSERT INTO Accounts VALUES (5, 5, 'Savings', 9500, SYSDATE);

-- Insert Transactions
INSERT INTO Transactions VALUES (1, 1, SYSDATE, 200, 'Deposit');
INSERT INTO Transactions VALUES (2, 2, SYSDATE, 300, 'Withdrawal');
INSERT INTO Transactions VALUES (3, 3, SYSDATE, 400, 'Deposit');
INSERT INTO Transactions VALUES (4, 4, SYSDATE, 150, 'Withdrawal');
INSERT INTO Transactions VALUES (5, 5, SYSDATE, 500, 'Deposit');

-- Insert Loans (ensuring at least one loan ends within next 30 days)
INSERT INTO Loans VALUES (1, 1, 5000, 5.0, SYSDATE, ADD_MONTHS(SYSDATE, 60)); -- long-term
INSERT INTO Loans VALUES (2, 2, 4000, 4.5, SYSDATE, SYSDATE + 15); -- ends in 15 days
INSERT INTO Loans VALUES (3, 3, 6000, 5.5, SYSDATE, ADD_MONTHS(SYSDATE, 36));
INSERT INTO Loans VALUES (4, 4, 3000, 4.0, SYSDATE, SYSDATE + 25); -- ends in 25 days
INSERT INTO Loans VALUES (5, 5, 7000, 6.0, SYSDATE, ADD_MONTHS(SYSDATE, 48));

-- Insert Employees
INSERT INTO Employees VALUES (1, 'Gabriel dOrsay', 'Manager', 80000, 'Finance', TO_DATE('2010-01-10', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Nina Vermeer', 'Developer', 60000, 'IT', TO_DATE('2018-07-20', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (3, 'Victor Aleph', 'Analyst', 55000, 'R&D', TO_DATE('2016-05-22', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (4, 'Tessa Marlowe', 'Tester', 50000, 'QA', TO_DATE('2019-02-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (5, 'Elias Koster', 'Architect', 90000, 'IT', TO_DATE('2005-11-01', 'YYYY-MM-DD'));

-- Commit everything
COMMIT;
