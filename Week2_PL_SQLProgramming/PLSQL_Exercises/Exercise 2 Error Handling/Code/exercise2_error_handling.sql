-- Scenario 1: SafeTransferFunds

CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    -- Check balance of the source account
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;

    -- Deduct from source
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account_id;

    -- Add to destination
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer successful from Account ' || p_from_account_id || ' to Account ' || p_to_account_id);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/

--TestCase for Scenario 1
BEGIN
    SafeTransferFunds(3, 4, 2000);
END;
/
BEGIN
    SafeTransferFunds(3,4,18000);
END;
/

-- Scenario 2: UpdateSalary
CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) AS
BEGIN
    -- Try to update salary
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percentage / 100)
    WHERE EmployeeID = p_employee_id;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Employee ID not found.');
    END IF;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated for Employee ID ' || p_employee_id);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating salary: ' || SQLERRM);
END;
/

--Test Case for Scenario 2
BEGIN
    UpdateSalary(2, 10);  -- Increase salary of Employee ID 2 by 10%
END;
/
SELECT EmployeeID, Name, Salary FROM Employees
WHERE EmployeeID = 2;

BEGIN
    UpdateSalary(999, 10);  -- Invalid ID
END;
/

--Scenario 3 : AddNewCustomers

CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
) AS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer added successfully: ' || p_name);
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_customer_id || ' already exists.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Unexpected error while adding customer: ' || SQLERRM);
END;
/

-- Test Case for Scenario 3
-- Scenario 3
BEGIN
    AddNewCustomer(6, 'Lyra Vonn', TO_DATE('1992-09-19', 'YYYY-MM-DD'), 5000);
END;
/

SELECT CustomerID, Name, DOB, Balance FROM Customers ORDER BY CustomerID;


