--------------------------------------------------------------------------------------------------------
--2.1 SELECT 
--------------------------------------------------------------------------------------------------------
--  Task - Select all records from the Employee table
SELECT      * 
FROM        EMPLOYEE; 

--  Task - Select all records from the Employee table where last name is King.
SELECT      * 
FROM        EMPLOYEE
WHERE       LASTNAME = 'King';

--  Task - Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT      *
FROM        EMPLOYEE
WHERE       FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;


--------------------------------------------------------------------------------------------------------
--2.2 ORDER BY
--------------------------------------------------------------------------------------------------------
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT      *
FROM        ALBUM
ORDER BY    TITLE   DESC;

-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT      FIRSTNAME
FROM        CUSTOMER
ORDER BY    CITY    ASC;

--------------------------------------------------------------------------------------------------------
-- 2.3 INSERT INTO
--------------------------------------------------------------------------------------------------------
-- Task – Insert two new records into Genre table
INSERT INTO GENRE (GENREID, NAME) VALUES(26, 'Folk Metal');
INSERT INTO GENRE (GENREID, NAME) VALUES(27, 'Adult Contemporary');

-- Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE VALUES (9,'Peklar', 'Andrew', 'Head Chef', 7, '07-DEC-93','08-JUL-05', 'PLACERVILLE', 'PLACERVILLE','CA', 'Россия', '9999', '4444444444', '4444444444','email@gmail.com');
INSERT INTO EMPLOYEE VALUES (10, 'NAME', 'NAMER', 'A NAME', 3, '03-JUL-03', '08-JUL-05', 'NAMED', 'NAMEY','MC', 'NAME FACE','99999','99999','999999','NAME@NAMEY.MCNAMEFACE');

--------------------------------------------------------------------------------------------------------
-- 2.4 UPDATE
--------------------------------------------------------------------------------------------------------
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE      CUSTOMER
SET         FIRSTNAME = 'Robert' ,   LASTNAME = 'Walter'
WHERE       FIRSTNAME = 'Aaron'  AND LASTNAME = 'Mitchell';

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE      ARTIST
SET         NAME = 'CCR'
WHERE       NAME = 'Creedence Clearwater Revival';

--------------------------------------------------------------------------------------------------------
-- 2.5 LIKE
--------------------------------------------------------------------------------------------------------
-- Task – Select all invoices with a billing address like “T%”
SELECT      *
FROM        INVOICE
WHERE       BILLINGADDRESS LIKE 'T%';

--------------------------------------------------------------------------------------------------------
-- 2.6 BETWEEN
--------------------------------------------------------------------------------------------------------
-- Task – Select all invoices that have a total between 15 and 50
SELECT      *
FROM        INVOICE
WHERE       TOTAL       BETWEEN '15' AND '50'; 

-- Task – Select all employees hired between 1 st of June 2003 and 1 st of March 2004
SELECT      *
FROM        EMPLOYEE
WHERE       HIREDATE    BETWEEN '01-JUN-03' AND '01-MAR-04';   

--------------------------------------------------------------------------------------------------------
-- 2.7 DELETE
--------------------------------------------------------------------------------------------------------
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints 
--        that rely on this, find out how to resolve them).
DELETE FROM CUSTOMER 
WHERE       FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
-- Note:  Change the contraint to ON DELETE CASCADE in CHInook.          
--------------------------------------------------------------------------------------------------------
-- 3.1 SYSTEM DEFINED FUNCTIONS
--------------------------------------------------------------------------------------------------------

--  Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION GET_TIME 
RETURN VARCHAR IS my_time VARCHAR(50);
    BEGIN
        my_time := TO_CHAR(CURRENT_TIMESTAMP, 'HH24:MI:SS');
        RETURN my_time;
    END;
/
--test
SELECT GET_TIME FROM DUAL;
/


--  Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION MEDIA_LENGTH (inpp IN NUMBER) 
    RETURN NUMBER 
    IS media_length VARCHAR2(160);
    BEGIN
        SELECT NAME 
        INTO media_length
        FROM MEDIATYPE 
        WHERE MEDIATYPEID = inpp;
        return length(media_length);
    END;
/
--test
SELECT MEDIA_LENGTH(3) from dual;
/

--------------------------------------------------------------------------------------------------------
-- 3.2 System Defined Aggregate Functions
--------------------------------------------------------------------------------------------------------
-- Task:    Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION AVG_INVOICE
    RETURN NUMBER IS  TMP NUMBER;
BEGIN
    SELECT  AVG(total) 
    INTO    TMP
    FROM    INVOICE;
    RETURN  TMP;
END;
/
--test
SELECT AVG_INVOICE FROM DUAL;
/

-- Task:    Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION HIGHEST_PRICE
    RETURN NUMBER IS  TMP NUMBER;
BEGIN
    SELECT  MAX(UNITPRICE) 
    INTO    TMP
    FROM    TRACK;
    RETURN  TMP;
END;
/
--test
SELECT HIGHEST_PRICE FROM DUAL;
/
SELECT  *   FROM  TRACK;
/


--------------------------------------------------------------------------------------------------------
--  3.3 User Defined Scalar Functions
--------------------------------------------------------------------------------------------------------
-- Task:    Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_INVOICE_PRICE
    RETURN NUMBER IS  TMP NUMBER;
BEGIN
    SELECT  AVG(UNITPRICE) 
    INTO    TMP
    FROM    INVOICELINE;
    RETURN  TMP;
END;
/
--test
SELECT AVG_INVOICE_PRICE FROM dual;
/
--------------------------------------------------------------------------------------------------------
--  3.4 User Defined Table Valued Functions
--------------------------------------------------------------------------------------------------------
-- Task:    Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION AFTER_1968
    RETURN SYS_REFCURSOR IS TMP SYS_REFCURSOR;
BEGIN
    OPEN TMP FOR
    SELECT * 
    FROM EMPLOYEE 
    WHERE BIRTHDATE > '31-DEC-68';
    RETURN TMP;
END;
/
--test
SELECT AFTER_1968 FROM DUAL;
/

--------------------------------------------------------------------------------------------------------
--  4.1 Basic Stored Procedure
--------------------------------------------------------------------------------------------------------
-- Task:    Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE EMPLOYEE_NAMES
    AS var1 SYS_REFCURSOR;
BEGIN
    OPEN var1 FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
    DBMS_SQL.RETURN_RESULT(var1);
END;
/
--test
EXEC EMPLOYEE_NAMES;
/

--------------------------------------------------------------------------------------------------------
--  4.2 Stored Procedure Input Parameters
--------------------------------------------------------------------------------------------------------
-- Task:    Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE (EID IN NUMBER, FNAME IN VARCHAR2, LNAME IN VARCHAR2) IS
BEGIN
    UPDATE      EMPLOYEE 
    SET         FIRSTNAME = FNAME 
    WHERE       EMPLOYEEID = EID; 
    ---
    UPDATE      EMPLOYEE 
    SET         LASTNAME = LNAME 
    WHERE       EMPLOYEEID = EID;
    ---
    DBMS_OUTPUT.PUT_LINE('Personal information update for employee with ID: '||EID);
    COMMIT;
END;
/
--test
EXEC UPDATE_EMPLOYEE (2, 'Johanny', 'Appleseed');
SELECT * FROM EMPLOYEE;
ROLLBACK;
/

-- Task:    Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE GET_MANAGER (FN IN VARCHAR2, LN VARCHAR2)    
    AS  MANAGER SYS_REFCURSOR;
BEGIN
    OPEN MANAGER FOR
    ---
    SELECT      FIRSTNAME, LASTNAME 
    FROM        EMPLOYEE 
    WHERE       EMPLOYEEID = (
                                SELECT  REPORTSTO 
                                FROM    EMPLOYEE 
                                WHERE   FIRSTNAME = FN AND LASTNAME = LN);
    DBMS_SQL.RETURN_RESULT(manager);
END;
/
--test
EXEC GET_MANAGER('Robert', 'King');
/

--------------------------------------------------------------------------------------------------------
--  4.3 Stored Procedure Output Parameters
--------------------------------------------------------------------------------------------------------
-- Task:    Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE CUSTOMER_INFO(CUST_ID IN NUMBER)
AS
  manager SYS_REFCURSOR;
BEGIN
  OPEN manager FOR
  SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER WHERE CUSTOMERID = CUST_ID;
  DBMS_SQL.RETURN_RESULT(manager);
END;
/
--test
EXEC CUSTOMER_INFO(5);
/

--------------------------------------------------------------------------------------------------------
--  5.0 TRANSACTIONS
--------------------------------------------------------------------------------------------------------
-- Task:    Create a transaction that given a invoiceId will delete that invoice (There may be constraints 
--          that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INVOICE_ID NUMBER) IS
BEGIN
   DELETE FROM      INVOICELINE
   WHERE            INVOICEID = INVOICE_ID;
   ---
   DELETE FROM      INVOICE
   WHERE            INVOICEID = INVOICE_ID;
END;
/
--test
EXEC DELETE_INVOICE(5);
/

-- Task:    Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE NEW_TRANS(ID IN NUMBER, FRSTNAME IN VARCHAR2, LSTNAME IN VARCHAR2) IS
BEGIN
    INSERT INTO CUSTOMER VALUES(ID, FRSTNAME, LSTNAME, null, null, null, null, null, null, null, null, 
                                                            'xXtotallyrealemailXx@angelfire.com', null);
END;
/
--test
EXEC NEW_TRANS(69, 'TWO', 'CHAINZZZ');
/

--------------------------------------------------------------------------------------------------------
-- 6.1 AFTER/FOR
--------------------------------------------------------------------------------------------------------
-- Task:    Create an after insert trigger on the employee table fired after a new record is inserted into 
--          the table.
CREATE OR REPLACE TRIGGER INSERT_TRIG 
    AFTER INSERT    ON EMPLOYEE
    FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Employee succesfully hired!');
END;
/
--test
--ALTER TRIGGER INSERT_TRIG ENABLE;
--/
--SELECT * FROM EMPLOYEE;
--/
--insert into employee VAlUES(24, 'INPUT', 'TEXT', null, null, null, null, null, null, null, null, null, null, null, null);
--/

-- Task:    Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER UPDATE_TRIG
    AFTER UPDATE    ON ALBUM
    FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('UPDATE_TRIG: ALBUM TABLE UPDATED');
END;
/

-- Task:    Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER DELETE_TRIG
    AFTER DELETE ON CUSTOMER 
    FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('DELETE_TRIG:  Customer succesfully fired');
END;
/

--------------------------------------------------------------------------------------------------------
-- 7.1 INNER
--------------------------------------------------------------------------------------------------------
-- Task:    Create an inner join that joins customers and orders and specifies the name of the customer 
--          and the invoiceId.
SELECT  *
FROM    CUSTOMER INNER JOIN INVOICE
ON      CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--------------------------------------------------------------------------------------------------------
-- 7.2 OUTER
--------------------------------------------------------------------------------------------------------
-- Task:    Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--          firstname, lastname, invoiceId, and total.
SELECT  CUSTOMER.CUSTOMERID, FIRSTNAME, LASTNAME, INVOICE, TOTAL
FROM    CUSTOMER FULL OUTER JOIN INVOICE
ON      CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--------------------------------------------------------------------------------------------------------
-- 7.3 RIGHT
--------------------------------------------------------------------------------------------------------
-- Task:    Create a right join that joins album and artist specifying artist name and title.
SELECT    NAME, TITLE 
FROM      ALBUM RIGHT JOIN ARTIST
ON        ALBUM.ARTISTID = ARTIST.ARTISTID;

--------------------------------------------------------------------------------------------------------
-- 7.4 CROSS
--------------------------------------------------------------------------------------------------------
-- Task:    Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT      ARTIST.ARTISTID, ALBUM.ALBUMID,ARTIST.NAME, TITLE
FROM        ARTIST CROSS JOIN ALBUM 
WHERE       ARTIST.ARTISTID = ALBUM.ARTISTID
ORDER BY    decode(sign(ascii(substr(lpad(NAME, 2), 2))-64), 1, lpad(NAME, 3, chr(58)), lpad(NAME, 2)); 
-- I TRIED, BUT AC/DC WILL ALWAYS BE ON TOP \m/
-- REST IS SORTED APPROPRIETLY
/
--------------------------------------------------------------------------------------------------------
-- 7.5 SELF
--------------------------------------------------------------------------------------------------------
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
/
SELECT
    ( m.firstname || '  '|| m.lastname ) manager,
    ( e.firstname || '  '|| e.lastname ) employee, e.title
FROM
    employee m
    INNER JOIN employee e ON m.employeeid = e.reportsto
ORDER BY
    manager;
/
