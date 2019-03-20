CREATE TABLE bank_Employees(
Username VARCHAR2(100) PRIMARY KEY,
Password NUMBER NOT NULL,
Admin_Access VARCHAR2(100) NOT NULL
);





CREATE TABLE bank_Customers(
Username VARCHAR2(100) PRIMARY KEY,
Password NUMBER NOT NULL,
account_State NUMBER,--DROPPED
credit_Score NUMBER,
account_Tracker NUMBER
);




CREATE TABLE Accounts(
account_Number NUMBER PRIMARY KEY,
account_Name VARCHAR2(20),
customer_Username VARCHAR2(20),
customer_Username2 VARCHAR2(20),
account_Type VARCHAR2(20),
account_Balance NUMBER,
--account_State NUMBER Added

CONSTRAINT account_Count_fk FOREIGN KEY (customer_Username)REFERENCES bank_Customers(Username) ON DELETE CASCADE,
CONSTRAINT account_Count2_fk FOREIGN KEY (customer_Username2)REFERENCES bank_Customers(Username)ON DELETE CASCADE
);




CREATE SEQUENCE accounts_seq
MINVALUE 1000
START WITH 1000
INCREMENT BY 10
NOCACHE;





CREATE OR REPLACE TRIGGER accounts_trigger
BEFORE INSERT
    ON Accounts
    FOR EACH ROW    
DECLARE
    accounts_seq_var NUMBER;
BEGIN
    SELECT accounts_seq.nextval INTO accounts_seq_var FROM dual;
    :new.account_Number :=accounts_seq_var;
END;





CREATE OR REPLACE PROCEDURE Approve_Deny(CreditScore IN NUMBER,UN IN VARCHAR, message OUT VARCHAR)
AS 
BEGIN
    IF CreditScore < 540 THEN
    UPDATE Accounts SET account_State = -1  WHERE customer_Username = UN;
    message := 'Denied automatically';
    ELSE IF CreditScore > 740 THEN
    UPDATE Accounts SET account_State = 1  WHERE customer_Username = UN;
    message := 'Approved Automatically';
    END IF;
    END IF;
END;




CREATE OR REPLACE PROCEDURE WITHDRAW(withdraw_Req IN NUMBER, UN IN VARCHAR, AN IN NUMBER, message OUT VARCHAR, TEMP_VAR OUT NUMBER)
AS
BEGIN
    SELECT account_Balance INTO TEMP_VAR FROM Accounts WHERE account_Number = AN;
    TEMP_VAR := TEMP_VAR - withdraw_Req;
    IF TEMP_VAR > 0 THEN
    UPDATE Accounts SET account_balance = TEMP_VAR WHERE customer_Username = UN AND account_Number = AN;
    message := 'WITHDRAW COMPLETED';
    ELSE IF TEMP_VAR < 0 THEN
    TEMP_VAR:= TEMP_VAR + withdraw_Req;
    message := 'WITHDRAW FAILED';
    END IF;
    END IF;
END;







CREATE OR REPLACE PROCEDURE DEPOSIT( amount IN NUMBER, UN IN VARCHAR, AN IN NUMBER, message OUT VARCHAR, TEMP_VAR OUT NUMBER)
AS
BEGIN
    SELECT account_balance INTO TEMP_VAR FROM Accounts WHERE account_Number = AN;
    TEMP_VAR := TEMP_VAR + amount;
    UPDATE Accounts SET account_Balance = TEMP_VAR WHERE customer_Username = UN AND account_Number = AN;
    message := 'Deposit Went through';
END;









CREATE OR REPLACE PROCEDURE TRANSFER( amount IN NUMBER, AN IN NUMBER, AN2 IN NUMBER, message OUT VARCHAR, TEMP_VAR OUT NUMBER, TEMP_VAR2 OUT NUMBER)
AS
BEGIN
    SELECT account_Balance INTO TEMP_VAR FROM Accounts WHERE account_Number = AN;
    TEMP_VAR := TEMP_VAR - amount;
    
    SELECT account_Balance INTO TEMP_VAR2 FROM Accounts WHERE account_Number = AN2;
    TEMP_VAR2 := TEMP_VAR2 + amount;
    
    IF TEMP_VAR > 0 THEN
    UPDATE Accounts SET account_balance = TEMP_VAR WHERE account_Number = AN;
    UPDATE Accounts SET account_balance = TEMP_VAR2 WHERE account_Number = AN2;
    message := 'Transfer COMPLETED';
    
    
    ELSE IF TEMP_VAR < 0 THEN
    TEMP_VAR:= TEMP_VAR + amount;
    TEMP_VAR2 := TEMP_VAR2 - amount;
    message := 'Transfer FAILED';
    END IF;
    END IF;
END;





--TRUNCATE TABLE bank_Customers;
SELECT * FROM bank_Customers;

--TRUNCATE TABLE Accounts;

--DELETE FROM bank_Customers WHERE Username LIKE 'J%';
--DELETE FROM bank_Customers WHERE Username LIKE 'j%';


SELECT * FROM bank_Employees;


TRUNCATE TABLE bank_Employees;

SELECT * FROM bank_Employees WHERE Username = 'Dad';

--UPDATE Accounts SET account_State = 1 WHERE account_Number = 31;
SELECT * FROM Accounts;


--DROP PROCEDURE DEPOSIT;

--DROP PROCEDURE WITHDRAW;

--DROP PROCEDURE Approve_Deny;

--DROP TRIGGER accounts_trigger; --i messed up

--ALTER TABLE bank_Customers DROP COLUMN account_State;

--ALTER TABLE Accounts ADD account_State NUMBER;
--ALTER TABLE Accounts MODIFY customer_Username VARCHAR2(20) NOT NULL;
--SELECT * FROM Accounts;

--Kemmel
--Falon
--Hendrix
--Nuetron
--Dean
/*
CREATE SEQUENCE bankEmp_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1
NOCACHE;


CREATE SEQUENCE customer_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1
NOCACHE;


CREATE OR REPLACE TRIGGER bank_Employee_trigger
BEFORE INSERT
    ON bank_Employees
    FOR EACH ROW    
BEGIN
    SELECT bankEmp_seq.nextval INTO :new.employee_Number FROM dual;
END;



CREATE OR REPLACE TRIGGER customer_seq_trigger
BEFORE INSERT
    ON bank_Customers
    FOR EACH ROW
BEGIN
    SELECT customer_seq.nextval INTO :new.customer_Number FROM dual;
END;

*/