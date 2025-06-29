SET SERVEROUTPUT ON;
--Scenario 1: CustomerManagement Package
--Package Specification
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER);
    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

--Package body
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Customer already exists.');
    END;

    PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name, Balance = p_balance
        WHERE CustomerID = p_id;
        DBMS_OUTPUT.PUT_LINE('Customer updated: ' || p_name);
    END;

    FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance
        FROM Customers
        WHERE CustomerID = p_id;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN -1;
    END;

END CustomerManagement;
/

--Test call for scenario 1
BEGIN
    CustomerManagement.AddCustomer(7, 'Anya Sorel', TO_DATE('1994-04-10','YYYY-MM-DD'), 7000);
    CustomerManagement.UpdateCustomer(7, 'Anya Sorel', 7500);
    DBMS_OUTPUT.PUT_LINE('Balance: ' || CustomerManagement.GetCustomerBalance(7));
END;
/

-- Scenario 2: EmployeeManagement Package
-- Package Specification
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_dept VARCHAR2, p_hiredate DATE);
    PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER);
    FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_dept VARCHAR2, p_hiredate DATE) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_id, p_name, p_position, p_salary, p_dept, p_hiredate);
        DBMS_OUTPUT.PUT_LINE('Employee hired: ' || p_name);
    END;

    PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER) IS
    BEGIN
        UPDATE Employees
        SET Salary = p_salary
        WHERE EmployeeID = p_id;
        DBMS_OUTPUT.PUT_LINE('Employee salary updated.');
    END;

    FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_id;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN -1;
    END;

END EmployeeManagement;
/

--Test call for scenario 2
BEGIN
    EmployeeManagement.HireEmployee(6, 'Darian Vahl', 'Tester', 45000, 'QA', TO_DATE('2022-01-15', 'YYYY-MM-DD'));
    EmployeeManagement.UpdateEmployee(6, 47000);
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || EmployeeManagement.GetAnnualSalary(6));
END;
/

-- Scenario 3: AccountOperations Package
--Package Specification
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(p_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER);
    PROCEDURE CloseAccount(p_id NUMBER);
    FUNCTION GetCustomerTotalBalance(p_cust_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(p_id NUMBER, p_cust_id NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_id, p_cust_id, p_type, p_balance, SYSDATE);
        DBMS_OUTPUT.PUT_LINE('Account opened: ' || p_id);
    END;

    PROCEDURE CloseAccount(p_id NUMBER) IS
    BEGIN
        DELETE FROM Accounts WHERE AccountID = p_id;
        DBMS_OUTPUT.PUT_LINE('Account closed: ' || p_id);
    END;

    FUNCTION GetCustomerTotalBalance(p_cust_id NUMBER) RETURN NUMBER IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance) INTO v_total
        FROM Accounts
        WHERE CustomerID = p_cust_id;

        RETURN NVL(v_total, 0);
    END;

END AccountOperations;
/

--Test call for scenario 3
BEGIN
    AccountOperations.OpenAccount(6, 7, 'Savings', 5000);
    DBMS_OUTPUT.PUT_LINE('Total Balance: ' || AccountOperations.GetCustomerTotalBalance(7));
    AccountOperations.CloseAccount(6);
END;
/

