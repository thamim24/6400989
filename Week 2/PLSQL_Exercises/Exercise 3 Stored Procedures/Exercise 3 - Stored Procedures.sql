-- Exercise 3: Stored Procedures

-- Schema to be Created

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
); 


-- Example Scripts for Sample Data Insertion

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, SYSDATE);


INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

-- Scenario 1 – Monthly Interest for Savings

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE accounts
    SET balance = balance * 1.01,
        lastmodified = SYSDATE
    WHERE accounttype = 'Savings';
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('1% interest added to savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Something went wrong: ' || SQLERRM);
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/


-- Scenario 2 – Bonus for Employees

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_dept IN employees.department%TYPE,
    p_bonus_percent IN NUMBER
) IS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * p_bonus_percent / 100),
        hiredate = SYSDATE
    WHERE department = p_dept;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus applied for department: ' || p_dept);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error applying bonus: ' || SQLERRM);
END;
/

BEGIN
    UpdateEmployeeBonus('HR', 15);
END;
/


-- Scenario 3 – Funds Transfer Between Accounts

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from IN accounts.accountid%TYPE,
    p_to IN accounts.accountid%TYPE,
    p_amount IN NUMBER
) IS
    v_balance_from accounts.balance%TYPE;
BEGIN
    SELECT balance INTO v_balance_from
    FROM accounts
    WHERE accountid = p_from
    FOR UPDATE;
    IF v_balance_from < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Not enough balance.');
    END IF;
    UPDATE accounts
    SET balance = balance - p_amount,
        lastmodified = SYSDATE
    WHERE accountid = p_from;
    UPDATE accounts
    SET balance = balance + p_amount,
        lastmodified = SYSDATE
    WHERE accountid = p_to;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transferred Rs. ' || p_amount || ' from A/C ' || p_from || ' to A/C ' || p_to);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/
