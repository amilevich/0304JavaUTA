/*

Tomas Leriche

SQL Homework Week 2

*/

-- 2.1 SELECT
SELECT * FROM EMPLOYEE;

SELECT * FROM Employee WHERE LASTNAME = 'King';

SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;


-- 2.2 ORDER BY
SELECT * FROM ALBUM ORDER BY TITLE DESC;

-- included city in select because othewise we can't confirm that it is sorted by city.
SELECT FIRSTNAME, CITY FROM CUSTOMER ORDER BY CITY ASC;

-- 2.3 INSERT INTO
INSERT INTO GENRE(genreid, name) values ((SELECT MAX(GENREID) FROM GENRE) + 1, 'Vapor Wave');
INSERT INTO GENRE(genreid, name) values ((SELECT MAX(GENREID) FROM GENRE) + 1, 'Vaporer Wave');

INSERT INTO EMPLOYEE(employeeid, lastname, firstname, title, reportsto) values ((SELECT MAX(employeeid) FROM EMPLOYEE) + 1,'pob', 'blob', 'manager', null);
INSERT INTO EMPLOYEE(employeeid, lastname, firstname, title, reportsto) values ((SELECT MAX(employeeid) FROM EMPLOYEE) + 1, 'jobb', 'glob', 'employee', null);

INSERT INTO CUSTOMER(Customerid, firstname, lastname, company, address, email) values((SELECT MAX(customerid) FROM CUSTOMER) + 1,'bobby','Brown','revature','1 loop drive','rev@gmail.com');
INSERT INTO CUSTOMER(Customerid, firstname, lastname, company, address, email) values((SELECT MAX(customerid) FROM CUSTOMER) + 1,'bobby','Brown','revature','1 loop drive','rev@gmail.com');

-- 2.4 UPDATE

UPDATE CUSTOMER SET Firstname = 'Robert', lastname = 'Walter'
WHERE Firstname = 'Aaron' AND Lastname = 'Mitchell';

UPDATE ARTIST SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

-- 2.5 LIKE

SELECT * FROM INVOICE WHERE billingaddress LIKE 'T%';

-- 2.6 BETWEEN

SELECT * FROM INVOICE WHERE total BETWEEN 15 AND 50;

SELECT * FROM Employee WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7 DELETE
ALTER TABLE INVOICE DROP CONSTRAINT fk_invoicecustomerid;
DELETE FROM CUSTOMER WHERE firstname = 'Robert' AND lastname = 'Walter';

insert into customer (customerid, firstname, lastname, email) values (111, 'Rober', 'Walter', 'none');
Delete from Invoice where customerid = (select customerid from Customer where firstname = 'Robert' AND lastname = 'Walter');


-- 3.1 System Defined Functions

/
CREATE OR REPLACE FUNCTION get_time
RETURN VARCHAR2
is this_time VARCHAR2(50);
begin
    select TO_CHAR (sysdate, 'HH24:MI:SS')  into this_time from dual;
    return this_time;
end;
/
select get_time FROM DUAL;


-- SECOND PART
CREATE OR REPLACE FUNCTION ret_length
RETURN INT
is this_int INT(3);
begin
    select length(NAME) into this_int from mediatype 
    where rownum = 1;
    return this_int;
end;

select ret_length from DUAL;



-- 3.2 System Defined Aggregate Functions

CREATE OR REPLACE FUNCTION avg_total
RETURN NUMBER
is this_num NUMBER(5,2);
begin
    select AVG(TOTAL) into this_num from invoice;
    return this_num;
end;
    
select avg_total FROM DUAL;

-- SECOND PART

CREATE OR REPLACE FUNCTION exp_trak
RETURN NUMBER
is this_num NUMBER(3,2);
begin
    select MAX(UNITPRICE) into this_num from TRACK;
    return this_num;
end;

select exp_trak from DUAL;

-- 3.3 USER DEFINED SCALAR FUNCTIONS

CREATE OR REPLACE FUNCTION avg_price
RETURN NUMBER
IS this_num NUMBER(5,3);
begin
    select AVG(UNITPRICE) into this_num FROM INVOICELINE;
    return this_num;
end;

select avg_price from DUAL;

-- 3.4 USER DEFINED TABLE VALUED FUNCTIONS

CREATE OR REPLACE FUNCTION cnt_emps
RETURN SYS_REFCURSOR
IS this_return SYS_REFCURSOR;
begin
    open this_return FOR
    select FIRSTNAME, LASTNAME FROM EMPLOYEE
    WHERE BIRTHDATE > '31-DEC-68';
    return this_return;
end;

select cnt_emps from Dual;


--4.0

-- 4.1 BASIC STORED PROCEDURE
CREATE OR REPLACE PROCEDURE proc_2
AS
    var1 SYS_REFCURSOR;
BEGIN
    OPEN var1 FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
    DBMS_SQL.RETURN_RESULT(var1);
END;

execute proc_2;

-- 4.2 STORED PROCEDURE INPUT PARAMETERS

-- Task – Create a stored procedure that updates the personal information of an employee.

CREATE OR REPLACE PROCEDURE proc_K 
(
var1 VARCHAR2, var2 VARCHAR2, var3 VARCHAR2, var4 VARCHAR2, var5 VARCHAR2
)
IS
BEGIN
    UPDATE EMPLOYEE SET FIRSTNAME = var1,
    EMAIL = var2, 
    PHONE = var3, 
    COUNTRY = var4  
    WHERE FIRSTNAME = var5;
END;
 -- updates several personal attributes of the entered name (var5)
execute proc_K('Toomi','hord@mail.COO','5056996027', 'USA', 'Tommy');

-- SECOND PART

CREATE OR REPLACE PROCEDURE proc_L 
(
var2 varchar2, var3 varchar2
)
AS
    var1 SYS_REFCURSOR;
BEGIN
    OPEN var1 FOR
    select FirstName, lastname from EMployee 
    where employeeid = (select reportsto from employee 
                                        where firstname = var2 AND lastname = var3);
    DBMS_SQL.RETURN_RESULT(var1);
END;

execute proc_L('Toomi', 'Edwards');

-- 4.3 STORED PROCEDURE OUTPUT PARAMETERS

-- Task – Create a stored procedure that returns the name and company of a customer.

CREATE OR REPLACE PROCEDURE P_GET_DET (
    P_EMP_NAME varchar2,
    P_FNAME OUT varchar2,
    P_LNAME OUT varchar2,
    P_COMPANY OUT  varchar2)
IS
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY
    INTO P_FNAME, P_LNAME, P_COMPANY
    FROM CUSTOMER
    WHERE FIRSTNAME = P_EMP_NAME;
END;

set serveroutput ON;

DECLARE 
    EMP_NAME customer.firstname%type;
    FNAME customer.firstname%type;
    LNAME customer.lastname%type;
    COMPANY_NAME CUSTOMER.COMPANY%TYPE;
BEGIN
    EMP_NAME := 'Jimmbo';
    P_GET_DET(EMP_NAME, FNAME, LNAME, COMPANY_NAME);
    DBMS_OUTPUT.PUT_LINE('Customer name = ' || FNAME || ' ' || LNAME || ', of Company= ' || COMPANY_NAME);
END;

-- 5.0 TRANSACTIONS

-- 5.1
-- Task – Create a transaction that given a invoiceId will delete that invoice 
-- (There may be constraints that rely on this, find out how to resolve them).

CREATE OR REPLACE PROCEDURE transact
(
    var1 varchar2
)
IS
BEGIN
    DELETE FROM INVOICELINE WHERE INVOICEID = var1;
    DELETE FROM invoice WHERE invoiceid = var1;
END;
    
execute transact(124);

/
select * from invoiceline;
/

-- 5.2
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE inserts
IS
BEGIN
    INSERT INTO CUSTOMER (customerid, firstname, lastname, email) VALUES(69, 'John', 'Ford', 'JFord@email.com');
END;
EXEC inserts();
select * from customer;

-- 6.0 Triggers
-- 6.1 AFTER/For
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
-- you must commit for the triggers to work.
CREATE OR REPLACE TRIGGER after_trig 
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Trigger Warning!');
END;
set serveroutput ON;
INSERT INTO EMPLOYEE (employeeid, lastname, firstname, email) values (26, 'Jimmy', 'Johns','bob@mail.com');commit;



-- 6.1.2
-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER after_update
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Trigger Warning: Just UPDATED');
END;
UPDATE ALBUM SET title = 'Bigg bigggg' where ALBUMID = 2;commit;


-- 6.1.3
-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER after_delete
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Trigger Warning: Just DELETED from CUSTOMER TABLE');
END;
DELETE FROM CUSTOMER WHERE CUSTOMERID = 100;commit;

-- 7.1
-- JOINS
-- This problem is using a customer named Taron, which I added.
SELECT * FROM CUSTOMER C INNER JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID 
WHERE firstname = 'Taron' AND invoiceid BETWEEN 200 AND 220;
 
-- 7.2 INNER
SELECT c.customerid, firstname, lastname, invoiceid, total 
FROM CUSTOMER C FULL OUTER JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;
 
 -- 7.3 RIGHT JOIN
SELECT name, title FROM album
RIGHT JOIN artist ON album.artistid = artist.artistid;

-- 7.4 Cross Join
SELECT name, title
FROM album CROSS JOIN artist ORDER BY name ASC;

-- 7.5 - Self Join
SELECT
    ( m.firstname || ' ' || m.lastname ) manager, (e.firstname || ' ' || e.lastname) employee, e.title
FROM employee m 
INNER JOIN employee e 
ON m.employeeid = e.reportsto
ORDER BY manager;













