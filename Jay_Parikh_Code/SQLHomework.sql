--2.1-SELECT--------------------------------------------------------------------------------------------------------------------
SELECT * FROM Employee;

SELECT * FROM Employee
WHERE LASTNAME LIKE 'King';

SELECT * FROM Employee
WHERE FIRSTNAME LIKE 'Andrew'
AND REPORTSTO IS NULL;

--2.2-ORDER-BY------------------------------------------------------------------------------------------------------------------
SELECT * FROM album 
ORDER BY title DESC;

SELECT Firstname, City From Customer
ORDER BY City;

--2.3-INSERT-INTO---------------------------------------------------------------------------------------------------------------
INSERT INTO genre VALUES (26, 'Song of Legs');
INSERT INTO genre VALUES (27, 'Audiobooks');
SELECT * FROM genre;

INSERT INTO employee VALUES (9, 'Pizzaman', 'Yousef', 'Supreme Leader', 1, '01-JAN-00', '01-JAN-00', '0 CenterofWorld Way', 'Arlington', 'TX', 'MURICA', '00001', '911', 'FAX IS NOT A THING', 'pizza@gmail.com');
INSERT INTO employee VALUES (10, 'Guerra', 'Joseph', 'War Hero', 8, '30-JAN-99', '10-MAR-19', 'TheOnlyStreet Dr', 'Miami', 'FL', 'MURICA', '00000', '119', 'FAX IS NOT A THING', 'jg@gmail.com');
SELECT * FROM employee;

INSERT INTO customer VALUES (60, 'Pizzaman', 'Yousef', 1, '0 CenterofWorld Way', 'Arlington', 'TX', 'MURICA', '00001', '911', 'FAX IS NOT A THING', 'pizza@gmail.com', 1);
INSERT INTO customer VALUES (61, 'Guerra', 'Joseph', 8,  'TheOnlyStreet Dr', 'Miami', 'FL', 'MURICA', '00000', '119', 'FAX IS NOT A THING', 'jg@gmail.com', 1);
SELECT * FROM customer;

--2.4-UPDATE--------------------------------------------------------------------------------------------------------------------
 UPDATE customer SET firstname = 'Robert' WHERE firstname = 'Aaron';
 UPDATE customer SET lastname = 'Walter' WHERE lastname = 'Mitchell';
 SELECT * FROM customer;
 
 UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';
 SELECT * FROM artist;
 
--2.5-LIKE----------------------------------------------------------------------------------------------------------------------
SELECT * FROM invoice WHERE LOWER(billingaddress) LIKE 't%';

--2.6-BETWEEN-------------------------------------------------------------------------------------------------------------------
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7-DELETE--------------------------------------------------------------------------------------------------------------------
ALTER TABLE invoice DROP CONSTRAINT fk_invoicecustomerid;
--DELETE FROM invoiceline WHERE invoiceidid = invoiceline.invoiceid; -doesn't work this way apparently
--DELETE FROM invoice WHERE invoice.customerid = customer.customerid;
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';
SELECT * FROM customer;



--3.1-SYSTEM-DEFINED-FUNCTIONS--------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION get_time
RETURN VARCHAR2
IS timer VARCHAR2(20);
BEGIN    
    SELECT TO_CHAR (CURRENT_TIMESTAMP, 'MM-DD-YYYY HH24:MI:SS') INTO timer FROM dual;
    RETURN timer;
END;
/
SELECT get_time() FROM dual;

/
CREATE OR REPLACE FUNCTION get_length
RETURN NUMBER
IS med_length NUMBER(10);
BEGIN
    SELECT LENGTH(name)INTO med_length FROM mediatype
    WHERE ROWNUM = 1;
    RETURN med_length;
END;
/
SELECT get_length FROM dual;
/


--3.2-SYSTEM-DEFINED-AGGREGATE-FUNCTIONS----------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION get_avg_invoices
RETURN NUMBER
IS avg_invoice NUMBER(5,3);
BEGIN
    SELECT AVG(total)INTO avg_invoice FROM invoice;
    RETURN avg_invoice;
END;
/
SELECT get_avg_invoices() FROM dual;
/

CREATE OR REPLACE FUNCTION get_expensive_track
RETURN NUMBER
IS exp_track NUMBER;
BEGIN
    SELECT MAX(unitprice) INTO exp_track FROM track;
    RETURN exp_track;
END;
/
SELECT get_expensive_track FROM dual;
/

--3.3-USER-DEFINED-SCALAR-FUNCTIONS---------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION get_avgprice
RETURN NUMBER 
IS average NUMBER;
BEGIN
    SELECT AVG(unitprice)INTO average FROM invoiceline;
    RETURN average;
END;
/
SELECT get_avgprice FROM dual;
/

--3.4-USER-DEFINED-TABLE-VALUED-FUNCTIONS---------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION get_employee
RETURN SYS_REFCURSOR
IS emp SYS_REFCURSOR;
BEGIN
    OPEN emp FOR SELECT firstname FROM employee
    WHERE birthdate > '31-DEC-68';
    RETURN emp;
END;
/
SELECT get_employee FROM dual;
/


--4.1-BASIC-STORED PROCEDURE----------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE pls_work
AS
   cur_sor SYS_REFCURSOR;
BEGIN
   OPEN cur_sor FOR
   SELECT firstname, lastname FROM employee;
   DBMS_SQL.RETURN_RESULT(cur_sor);
END;
/
EXECUTE pls_work;   
/


--4.2-STORED PROCEDURE-INPUT-PARAMETERS-----------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE pls_update (first_name VARCHAR2, replace_name VARCHAR2)
AS
BEGIN  
    UPDATE employee SET firstname = replace_name 
    WHERE firstname = first_name; 
END;
/
EXECUTE pls_update('Michael', 'Aberto'); 
/
Select * FROM employee;
/


CREATE OR REPLACE PROCEDURE pls_manage (emp_first_name VARCHAR2)
AS
   cur_sor SYS_REFCURSOR;
BEGIN
   OPEN cur_sor FOR
   SELECT firstname, lastname, employeeid FROM employee
   WHERE employeeid = 
   (SELECT reportsto FROM employee
   WHERE firstname = emp_first_name);
   DBMS_SQL.RETURN_RESULT(cur_sor);
END;
/
EXECUTE pls_manage('Joseph'); 
/

--4.3-STORED PROCEDURE-OUTPUT-PARAMETERS----------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE pls_customer (customer_id IN NUMBER, customer_name OUT VARCHAR2, customer_company OUT VARCHAR2)
IS
BEGIN
    SELECT firstname, company INTO customer_name, customer_company FROM customer
    WHERE customerid = customer_id;
END;
/
SET SERVEROUTPUT ON;
/
DECLARE
customer_id customer.customerid %TYPE;
customer_name customer.firstname %TYPE;
customer_company customer.company %TYPE;
BEGIN
    customer_id := 4;
    pls_customer(customer_id, customer_name, customer_company);
    DBMS_OUTPUT.PUT_LINE('Customer: ' || customer_name || ' from Company ' || customer_company);
END;
/

--5.0-TRANSACTIONS--------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE del_invoice(invoice_id NUMBER)
IS
BEGIN
    DELETE FROM invoiceline
    WHERE invoiceid = invoice_id;
    DELETE FROM invoice
    WHERE invoiceid = invoice_id;
END;
/
SELECT * FROM invoice;
EXEC del_invoice(5);
SELECT * FROM invoice;
/

CREATE OR REPLACE PROCEDURE new_customer(cust_fname IN VARCHAR2, cust_lname IN VARCHAR2, cust_company IN VARCHAR2 )
IS
BEGIN
    --DECLARE the_new_cust
    BEGIN
        INSERT INTO customer VALUES ((SELECT MAX(customerid)FROM customer)+1, cust_fname, cust_lname, cust_company, null, null, null, null, null, null, null, 'fakee@gmail.com', null);
    END;
END;
/
SELECT * FROM customer;
EXEC new_customer('Tomas', 'Escargot', 'Revature');
/
--6.1-AFTER/FOR-----------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE TRIGGER insert_after 
AFTER INSERT ON employee 
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('New Employee Inserted');
END;
/
SET SERVEROUTPUT ON;
/
ALTER TRIGGER insert_after ENABLE;
INSERT INTO EMPLOYEE VALUES(14, 'PizzaMan', 'Yousef', null, null, null, null, null, null, null, null, null, null, null, null);
SELECT * FROM employee;
ROLLBACK;
/

CREATE OR REPLACE TRIGGER after_update
AFTER UPDATE
ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('New Album Updated');
END;
/
SET SERVEROUTPUT ON;
/
UPDATE album SET title = 'something else?' WHERE albumid = 1;
ROLLBACK;
SELECT * from album;
/

CREATE OR REPLACE TRIGGER after_delete
AFTER DELETE
ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Customer Deleted');
END;
/
SET SERVEROUTPUT ON;
/
DELETE FROM invoice where customerid = (SELECT MAX(customerid)FROM customer)+1;
DELETE FROM customer where customerid = (SELECT MAX(customerid)FROM customer)+1;
/

--7.1-INNER-JOINS---------------------------------------------------------------------------------------------------------------
SELECT * FROM customer INNER JOIN invoice 
ON customer.customerid = invoice.customerid;
/
select * from customer;
/

--7.2-OUTER-JOINS---------------------------------------------------------------------------------------------------------------
SELECT customer.customerid, firstname, lastname, invoiceid, total 
FROM customer FULL OUTER JOIN invoice
on customer.customerid = invoice.customerid;
/

--7.3-RIGHT-JOINS---------------------------------------------------------------------------------------------------------------
SELECT name, title FROM album 
RIGHT JOIN artist 
ON album.artistid = artist.artistid;
/
--7.4-CROSS-JOINS---------------------------------------------------------------------------------------------------------------
SELECT artist.name
FROM album CROSS JOIN artist;
/

--7.5-SELF-JOINS----------------------------------------------------------------------------------------------------------------
--SELECT employee a, employee b FROM employee WHERE a.reportsto = b.employeeid;
SELECT
( m.firstname || '  '|| m.lastname ) manager,
( e.firstname || '  '|| e.lastname ) employee, e.title
FROM employee m INNER JOIN employee e ON m.employeeid = e.reportsto
ORDER BY manager;
/
