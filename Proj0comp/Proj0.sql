-- Project 0 Banking AP
-- Christopher Collins

--*************************************************Accounts********************************************************************
-- Create Table For Customer Accounts
CREATE TABLE Account(
    Username VARCHAR(100),
    Password VARCHAR(100),
    Name VARCHAR(100),
    AccountId NUMBER(8),
    Status VARCHAR(1),
    Funds NUMBER(15),
    Cust_ID NUMBER(10)
    
);

-- Adding constraint
ALTER TABlE Account ADD(CONSTRAINT Cust_Con PRIMARY KEY(Cust_ID));

-- Start Sequence
CREATE SEQUENCE Seq_Acc
START WITH 1
INCREMENT BY 1;

-- Create Trigger
CREATE OR REPLACE TRIGGER Trig_Acc
BEFORE INSERT ON Account
FOR EACH ROW
BEGIN
    SELECT Seq_Acc.nextval
    INTO :new.Cust_ID
    FROM Dual;
END;

/*
CREATE OR REPLACE fUNCTION S_F_L( Alpha VARCHAR2, Beta VARCHAR2)
RETURN BOOLEAN
IS
    Epsilon SYS_REFCURSOR;
BEGIN
    OPEN Epsilon FOR SELECT Username FROM Account WHERE Username = Alpha and Password = Beta;
    If Alpha = Epsilon THEN
        SELECT Password INTO Epsilon FROM Account WHERE Username = Alpha and Password = Beta;
        IF Beta = Epsilon THEN
            RETURN True;
        END IF;
    Else
        RETURN False;
    END IF;
END;
BEGIN
     DBMS_OUTPUT.PUT_LINE(S_F_L('CC','Poke'));
END;
*/

--***********************************************Employee***********************************************************************
-- Create Table for Employee
CREATE TABLE Employee (
    EmployeeId VARCHAR(10) UNIQUE,
    Password VARCHAR(100),
    Name VARCHAR(100),
    Rank VARCHAR(1),
    E_ID NUMBER(8) PRIMARY KEY
);

--Insert Admins and Employees
INSERT INTO Employee VALUES('SL00476','Sensei','Splinter','A',1);
INSERT INTO Employee VALUES('LN10477','Katana','Leonardo','E',2);
INSERT INTO Employee VALUES('RP20477','Sai','Raphael','E',3);
INSERT INTO Employee VALUES('DO30477','Bo_Staff','Donatello','E',4);
INSERT INTO Employee VALUES('MC40477','Nuchucks','Michaelangelo','E',5);




--***********************************************Commands***********************************************************************

--SELECT
SELECT * FROM Account;
SELECT * FROM Account WHERE Username='CC' AND Password='Poke';
SELECT * FROM Employee;
SELECT * FROM Employee WHERE EmployeeID = 'LN10477' AND Password ='Katana';

--TRUNCATE - EMPTY TABLE
TRUNCATE TABLE Account;

--DROP
DROP TABLE Account;
DROP TABLE Employee;

--DELETE
DELETE FROM Account WHERE AccountId = 207337;

--Update
UPDATE Account SET STATUS = 'A' WHERE UserName='CC';

--INSERT INTO Account table
INSERT INTO Account VALUES('HeroOfRome', 'TheBEST', 'Marcus Antonius', 07844387, 'W', 0, 0);
INSERT INTO Account VALUES('TheBrave', 'Fearless', 'Drake', 66677712, 'W', 0, 1);
INSERT INTO Account VALUES('CC', 'Poke', 'Chris', 12341343, 'W', 500, 0);


--<><><><><><><><><><><><><><><><><><><><><><><><><><><><><END><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
Commit;
