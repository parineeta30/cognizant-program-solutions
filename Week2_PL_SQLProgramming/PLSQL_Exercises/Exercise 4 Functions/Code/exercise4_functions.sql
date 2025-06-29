SET SERVEROUTPUT ON;
-- Scenario 1: CalculateAge
CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob IN DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/
--Test Call for Scenario 1
SELECT Name, CalculateAge(DOB) AS Age
FROM Customers;

--Scenario 2: CalculateMonthlyInstallment
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount IN NUMBER,
    p_annual_rate IN NUMBER,
    p_duration_years IN NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_months NUMBER;
    v_emi NUMBER;
BEGIN
    v_monthly_rate := p_annual_rate / 12 / 100;
    v_months := p_duration_years * 12;

    v_emi := (p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months)) /
             (POWER(1 + v_monthly_rate, v_months) - 1);

    RETURN ROUND(v_emi, 2);
END;
/

--Test Call for Scenario 2
SELECT CalculateMonthlyInstallment(500000, 7.5, 5) AS Monthly_Installment FROM dual;

-- Scenario 3: HasSufficientBalance
CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN NUMBER,
    p_amount IN NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
    WHEN OTHERS THEN
        RETURN FALSE;
END;
/

--Test Call for Scenario 3
DECLARE
    v_result BOOLEAN;
BEGIN
    v_result := HasSufficientBalance(1, 1000);
    IF v_result THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient balance.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
    END IF;
END;
/


