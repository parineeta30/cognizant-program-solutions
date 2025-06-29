SET SERVEROUTPUT ON;

--Scenario 1: Apply 1% Discount to Loan Interest Rates for Customers Over 60
DECLARE
    CURSOR senior_customers IS
        SELECT c.CustomerID, c.DOB, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID;

    v_age NUMBER;
BEGIN
    FOR rec IN senior_customers LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);

        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - (InterestRate * 0.01)
            WHERE LoanID = rec.LoanID;

            DBMS_OUTPUT.PUT_LINE('Applied 1% discount to LoanID ' || rec.LoanID || ' (CustomerID: ' || rec.CustomerID || ')');
        END IF;
    END LOOP;

    COMMIT;
END;
/

--Scenario 2: Promote Customers to VIP Based on Balance > $10,000
--Add column IsVIP
ALTER TABLE Customers ADD IsVIP VARCHAR2(5);

--PL/SQL block
BEGIN
    FOR rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Promoted to VIP: CustomerID ' || rec.CustomerID);
        END IF;
    END LOOP;

    COMMIT;
END;
/

--Scenario 3 : Send Reminders for Loans Due Within Next 30 Days

DECLARE
    CURSOR upcoming_loans IS
        SELECT l.LoanID, l.CustomerID, l.EndDate, c.Name
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate <= SYSDATE + 30;

BEGIN
    FOR rec IN upcoming_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || rec.LoanID || ' for customer ' || rec.Name || ' is due by ' || TO_CHAR(rec.EndDate, 'DD-Mon-YYYY'));
    END LOOP;
END;
/
--Final Table Output Commands
--1. Loans Table (to verify interest discount)
SELECT LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate
FROM Loans
ORDER BY LoanID;

--2.  Customers Table (to verify VIP status)
SELECT CustomerID, Name, DOB, Balance, IsVIP
FROM Customers
ORDER BY CustomerID;

--3. Loan Reminders (due within 30 days)
SELECT LoanID, CustomerID, EndDate
FROM Loans
WHERE EndDate <= SYSDATE + 30
ORDER BY EndDate;

