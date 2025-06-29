SET SERVEROUTPUT ON;

--Scenario 1: Trigger to Auto-Update LastModified on Customer Updates
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

--Test call for scenario 1
UPDATE Customers
SET Balance = Balance + 500
WHERE CustomerID = 1;

SELECT CustomerID, LastModified FROM Customers
WHERE CustomerID = 1;

--Scenario 2: Trigger to Log Transactions into an Audit Table
--(i)Create AuditLog table
CREATE TABLE AuditLog (
    AuditID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    TransactionID NUMBER,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    LogTimestamp DATE DEFAULT SYSDATE
);
--(ii)Create the trigger
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (:NEW.TransactionID, :NEW.AccountID, :NEW.TransactionDate, :NEW.Amount, :NEW.TransactionType);
END;
/

--Test call for scenario 2
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (6, 1, SYSDATE, 300, 'Deposit');

SELECT * FROM AuditLog;

--Scenario 3: Enforce Deposit/Withdrawal Rules Before Insert
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    IF :NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :NEW.AccountID;
        IF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20001, 'Withdrawal amount exceeds account balance.');
        END IF;
    ELSIF :NEW.TransactionType = 'Deposit' THEN
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be greater than zero.');
        END IF;
    END IF;
END;
/

--Test call for scenario 3
-- 1.Valid
-- Use TransactionID = 6 (or higher)
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (11, 2, SYSDATE, 100, 'Deposit');

SELECT TransactionID FROM Transactions ORDER BY TransactionID;


-- 2.Invalid (withdrawal more than balance)
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (8, 2, SYSDATE, 99999, 'Withdrawal');  -- Should raise error

-- 3.Invalid (negative deposit)
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (9, 3, SYSDATE, -500, 'Deposit');  -- Should raise error





