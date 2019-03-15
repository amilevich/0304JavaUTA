
--***SQL LAB***
--Christopher Collins

--2.0 SQL Queries*************************************************************************************************************
--2.1 SELECT
SELECT * FROM Employee;
SELECT * FROM Employee WHERE Lastname = 'King';
SELECT * FROM Employee WHERE Firstname = 'Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
SELECT * FROM Album 
    ORDER BY Title DESC;
SELECT Firstname FROM Customer 
    ORDER BY City;
    
--2.3 INSERT INTO
INSERT INTO Genre VALUES (348, 'High Seas');
INSERT INTO Genre VALUES (349, 'YO');
INSERT INTO Employee 
VALUES (10,'Cornelius','Yukon','Security',9,TO_DATE('1973-8-22 00:00:00','yyyy-mm-dd hh24:mi:ss'),TO_DATE('1996-5-19 00:00:00','yyyy-mm-dd hh24:mi:ss'),'534 Trucker cr','NYC','New York','United States','48973','423-783-3294','862-734-2368','THEMAN@yahoo.com');
INSERT INTO Employee 
VALUES (9,'Jones','Casey','Security Manager',null,TO_DATE('1990-4-13 00:00:00','yyyy-mm-dd hh24:mi:ss'),TO_DATE('2008-1-11 00:00:00','yyyy-mm-dd hh24:mi:ss'),'713 Lucky lane','NYC','New York','United States','48973','422-584-1313','421-344-0313','DragonBreaker@yahoo.com');
INSERT INTO Customer 
VALUES (778, 'Biff', 'Buzzler','Danger Racing', '777 rich lane', 'LA', 'California', 'United States', '73834', '777-892-6663', '777-892-6663', 'ThePerfectOne@yahoo.com', 4);
INSERT INTO Customer 
VALUES (999, 'Drago', 'Scaleright','Knights of the blood', '130 fairy dust cr', 'The ground', 'Lost Trench', 'Britania', '00063', '000-123-1313','000-123-1313', 'FlameBlade@yahoo.com', 5);

--2.4 UPDATE
UPDATE Customer SET FirstName ='Robert',LastName = 'Walter' WHERE FirstName = 'Aaron' AND LastName = 'Mitchell';
UPDATE Artist SET Name = 'CCR' Where Name = 'Creedence Clearwater Revival';

--2.5 LIKE
SELECT * FROM Invoice WHERE BillingAddress Like 'T%';

--2.6 BETWEEN
SELECT * FROM Invoice
WHERE Total BETWEEN 15 AND 50;

SELECT * FROM Employee
WHERE HireDate BETWEEN TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');

--2.7 DELETE -- Does not work
ALTER TABLE Customer DROP CONSTRAINT FK_CustomerSupportRepId;
ALTER TABLE Customer ADD CONSTRAINT FK_CustomerSupportRepId FOREIGN KEY (SupportRepId) REFERENCES Employee (EmployeeId) ON DELETE CASCADE;
ALTER TABLE Invoice DROP CONSTRAINT FK_InvoiceCustomerId;
ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceCustomerId FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId) ON DELETE CASCADE;
ALTER TABLE InvoiceLine DROP CONSTRAINT FK_InvoiceLineInvoiceId;
ALTER TABLE InvoiceLine ADD CONSTRAINT FK_InvoiceLineInvoiceId FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId) ON DELETE CASCADE;
DELETE FROM Customer 
WHERE FirstName = 'Robert' AND LastName = 'Walter';


--3.0 SQL Functions*************************************************************************************************************
--3.1 System defined functions
CREATE OR REPLACE FUNCTION Return_Time
RETURN VARCHAR2
AS
BEGIN
    RETURN CURRENT_TIMESTAMP();
END;
BEGIN
    DBMS_OUTPUT.PUT_LINE(Return_Time);
END;

CREATE OR REPLACE FUNCTION Length_Medi
RETURN NUMBER
AS
    Medi NUMBER(6);
BEGIN
    SELECT LENGTH(Name) INTO Medi FROM MediaType Where MEDIATYPEID = '1';
    RETURN Medi;
END;
BEGIN
    DBMS_OUTPUT.PUT_LINE(Length_Medi);
END;

--3.2 System defined Aggregate functions
CREATE OR REPLACE FUNCTION Avg_Invoice
RETURN NUMBER
AS
    Average NUMBER;
BEGIN
    SELECT AVG(Total) INTO Average FROM Invoice;
    RETURN Average;
END;
BEGIN
    DBMS_OUTPUT.PUT_LINE(Avg_Invoice);
END;

CREATE OR REPLACE FUNCTION Most_Expensive
RETURN NUMBER
IS
 Exp_Price NUMBER(6);
BEGIN
 SELECT MAX(UnitPrice) INTO Exp_Price FROM Track;
 RETURN Exp_Price;
END;
DECLARE
 Price NUMBER;
BEGIN
 Price := Most_Expensive();
 DBMS_OUTPUT.PUT_LINE('Most expensive track is:' || Price);
END;


--3.3 User defined scalar functions
CREATE OR REPLACE FUNCTION Avg_Price(Alpha INTEGER)
RETURN NUMBER
AS
    Average NUMBER;
BEGIN
    SELECT AVG(UnitPrice) INTO Average FROM InvoiceLine WHERE InvoiceId = Alpha;
    RETURN Average;
END;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Average price is: ' || Avg_Price(4));
END;

--3.4 User defined table valued functiions -- not done
CREATE OR REPLACE FUNCTION Employ_After
RETURN TABLE
AS
    Employ TABLE;
BEGIN
    SELECT EmployeeId INTO Employ FROM Employee WHERE BirthDate > TO_DATE('1968-0-0 00:00:00','yyyy-mm-dd hh24:mi:ss') ;
    RETURN Employee;
END;


--4.0 Stored procedure**********************************************************************************************************
--4.1 Basic Stored Procedure
CREATE OR REPLACE PROCEDURE FLName_Sel
IS
    CURSE SYS_REFCURSOR;
BEGIN
    OPEN CURSE FOR
        SELECT FirstName, LastName FROM employee;
    DBMS_SQL.RETURN_RESULT(CURSE);
END;
BEGIN
    FLName_Sel;
END;


--4.2 Stored Procedure Intput Parameter
CREATE OR REPLACE PROCEDURE Up_Info( EmpID VARCHAR2, L_Name VARCHAR2, F_Name VARCHAR2, Titl VARCHAR2, Rep VARCHAR2, Addr VARCHAR2,
    Cit VARCHAR2, Stat VARCHAR2, Coun VARCHAR2, PostCo VARCHAR2, Pho VARCHAR2, Fa VARCHAR2, Ema VARCHAR2) 
IS
BEGIN
    UPDATE Employee SET LastName = L_Name, FirstName = F_Name, Title = Titl, ReportsTO = Rep, Address = Addr, City = Cit,
    State = Stat, Country = coun, PostalCode = PostCo, Phone = Pho, Fax = Fa, Email = Ema WHERE EmployeeId=EmpID; 
END;
BEGIN
    Up_Info(5, 'Jonhnson','Steve','Sales Manager',1,'12333 Jasper Ave SW','Calgary','AB','Canada','T2P 5R5','+1 (780) 836-9987','+1 (780) 836-9987','steve@chinookcorp.com');
END;



CREATE OR REPLACE PROCEDURE Find_Manag(Employ int)
IS
   CURSE SYS_REFCURSOR;  
   Temp Int;
BEGIN
    SELECT ReportsTo INTO Temp FROM Employee WHERE EmployeeId = Employ;
    OPEN CURSE FOR
        SELECT * FROM Employee WHERE EmployeeId = Temp;
    DBMS_SQL.RETURN_RESULT(CURSE);
END;
BEGIN
    Find_Manag(8);
END;

--4.3 Stored Procedure Output Parameter -- NOT DONE
CREATE OR REPLACE PROCEDURE Show_cust(CID int)
IS
 CURSE SYS_REFCURSOR;
BEGIN
    OPEN CURSE FOR
        SELECT FirstName, LastName, Company FROM employee WHERE CustomerId = CID;
    RETURN CURSE;
END;

--5.0 Transactions*************************************************************************************************************


--6.0 Triggers*****************************************************************************************************************
--6.1 After/FOR
CREATE TRIGGER New_Hire
AFTER INSERT ON Employee
FOR EACH ROW
WHEN (New.EmployeeId >0)
BEGIN
  DBMS_OUTPUT.PUT_LINE('NEW EMPLOYEE!!!');
END;

CREATE TRIGGER Fresh_Album
AFTER UPDATE ON Album
FOR EACH ROW
WHEN (New.AlbumId >0)
BEGIN
  DBMS_OUTPUT.PUT_LINE('');
END;

CREATE TRIGGER Lost_Customer
AFTER DELETE ON Customer
FOR EACH ROW
WHEN (New.CustomerId >0)
BEGIN
  DBMS_OUTPUT.PUT_LINE('We lost a customer!!!');
END;

--7.0 JOINS********************************************************************************************************************
--7.1 INNER
SELECT FirstName,LastName, InvoiceID From Customer
INNER JOIN Invoice ON Customer.CustomerId = Invoice.CustomerId;

--7.2 OUTER
SELECT Customer.CustomerId, FirstName,LastName, InvoiceID, Total From Customer
FULL OUTER JOIN Invoice ON Customer.CustomerId = Invoice.CustomerId;

--7.3 RIGHT
SELECT Name,Title FROM Album 
RIGHT JOIN Artist ON Album.artistId = Artist.artistId;

--7.4 CROSS
SELECT * FROM Album
CROSS JOIN Artist
ORDER BY Name;

--7.5 SELF
SELECT * FROM employee a
INNER JOIN employee b
ON a.ReportsTo = b.ReportsTo;

commit;