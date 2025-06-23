
-- Exercise 1: Control Structures

-- Schema to be Created

CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);


-- Example Scripts for Sample Data Insertion

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

-- Scenario 1 – Senior Loan Discount

DECLARE
    CURSOR cur_customer IS
        SELECT customerid, EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM dob) AS age
        FROM customers;
    v_id customers.customerid%TYPE;
    v_age NUMBER;
BEGIN
    FOR cust IN cur_customer LOOP
        v_id := cust.customerid;
        v_age := cust.age;
        IF v_age > 60 THEN
            UPDATE loans
            SET interestrate = interestrate - 1
            WHERE customerid = v_id;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_id || ' | Age: ' || v_age || ' | No discount');
        END IF;
    END LOOP;
    COMMIT;
END;
/


-- Scenario 2 – Mark VIP Customers

ALTER TABLE customers ADD isvip VARCHAR2(10);

DECLARE
    CURSOR cur_vip IS
        SELECT customerid, balance FROM customers;
    v_id customers.customerid%TYPE;
    v_bal customers.balance%TYPE;
BEGIN
    FOR user IN cur_vip LOOP
        v_id := user.customerid;
        v_bal := user.balance;
        IF v_bal > 10000 THEN
            UPDATE customers SET isvip = 'TRUE' WHERE customerid = v_id;
            DBMS_OUTPUT.PUT_LINE('Marked Customer ' || v_id || ' as VIP. Balance is Rs. ' || v_bal);
        ELSE
            UPDATE customers SET isvip = 'FALSE' WHERE customerid = v_id;
            DBMS_OUTPUT.PUT_LINE('Customer ' || v_id || ' not eligible for VIP. Current balance: Rs. ' || v_bal);
        END IF;
    END LOOP;
    COMMIT;
END;
/


-- Scenario 3 – Loan Due Reminders

DECLARE
    CURSOR cur_loans IS
        SELECT l.loanid, l.customerid, c.name, l.enddate
        FROM loans l
        JOIN customers c ON c.customerid = l.customerid
        WHERE l.enddate BETWEEN SYSDATE AND SYSDATE + 30;
    v_loanid loans.loanid%TYPE;
    v_custid loans.customerid%TYPE;
    v_name customers.name%TYPE;
    v_due loans.enddate%TYPE;
    found BOOLEAN := FALSE;
BEGIN
    OPEN cur_loans;
    LOOP
        FETCH cur_loans INTO v_loanid, v_custid, v_name, v_due;
        EXIT WHEN cur_loans%NOTFOUND;
        found := TRUE;
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || v_loanid || ' for ' || v_name || ' (ID: ' || v_custid || ') is due on ' || TO_CHAR(v_due, 'DD-Mon-YYYY'));
    END LOOP;
    CLOSE cur_loans;
    IF NOT found THEN
        DBMS_OUTPUT.PUT_LINE('No loans are nearing due date in next 30 days.');
    END IF;
END;
/