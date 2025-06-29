SET SERVEROUTPUT ON;

--Scenario 1: Generate Monthly Statements

DECLARE
    CURSOR monthly_transactions IS
        SELECT t.TransactionID, t.AccountID, c.Name, t.Amount, t.TransactionType, t.TransactionDate
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE TO_CHAR(t.TransactionDate, 'MM-YYYY') = TO_CHAR(SYSDATE, 'MM-YYYY')
        ORDER BY c.CustomerID;

BEGIN
    FOR rec IN monthly_transactions LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name ||
                             ' | Account ID: ' || rec.AccountID ||
                             ' | Type: ' || rec.TransactionType ||
                             ' | Amount: ' || rec.Amount ||
                             ' | Date: ' || TO_CHAR(rec.TransactionDate, 'DD-Mon-YYYY'));
    END LOOP;
END;
/

--Code for TestOutput for scenario1
SELECT 
    t.TransactionID, 
    c.CustomerID, 
    c.Name AS CustomerName, 
    a.AccountID, 
    t.TransactionType, 
    t.Amount, 
    TO_CHAR(t.TransactionDate, 'DD-Mon-YYYY') AS TransactionDate
FROM 
    Transactions t
JOIN Accounts a ON t.AccountID = a.AccountID
JOIN Customers c ON a.CustomerID = c.CustomerID
WHERE 
    TO_CHAR(t.TransactionDate, 'MM-YYYY') = TO_CHAR(SYSDATE, 'MM-YYYY')
ORDER BY 
    c.CustomerID;


--Scenario 2: Apply Annual Fee
DECLARE
    CURSOR all_accounts IS
        SELECT AccountID, Balance FROM Accounts;

    v_fee CONSTANT NUMBER := 500;
BEGIN
    FOR rec IN all_accounts LOOP
        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE AccountID = rec.AccountID;

        DBMS_OUTPUT.PUT_LINE('Annual fee of ₹' || v_fee || ' deducted from Account ID: ' || rec.AccountID);
    END LOOP;

    COMMIT;
END;
/

--Code for TestOutput of scenario2
SELECT AccountID, Balance FROM Accounts ORDER BY AccountID;

-- Scenario 3: Update Loan Interest Rates
DECLARE
    CURSOR all_loans IS
        SELECT LoanID, InterestRate FROM Loans;

    v_new_rate NUMBER;
BEGIN
    FOR rec IN all_loans LOOP
        v_new_rate := rec.InterestRate - 0.5;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE LoanID = rec.LoanID;

        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || rec.LoanID || ' | New Interest Rate: ' || v_new_rate || '%');
    END LOOP;

    COMMIT;
END;
/

--Code for TestOutput of scenario3
SELECT LoanID, InterestRate FROM Loans ORDER BY LoanID;





