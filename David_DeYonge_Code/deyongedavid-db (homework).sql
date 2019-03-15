--2.1
-- Select all records from the Employee table
SELECT*FROM employee;
--Select all records from the Employee table where last name is King
SELECT*FROM employee WHERE lastname = 'King';
-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
SELECT*FROM employee WHERE firstname = 'Andrew' and reportsto is null;

--2.2
-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
SELECT*FROM album ORDER BY title DESC;

--Select first name from Customer and sort result set in ascending order by city
SELECT*FROM customer ORDER BY city;

--2.3
--Insert two new records into Genre table
INSERT INTO genre VALUES((SELECT MAX(GENREID)FROM genre)+1,'Genre');
INSERT INTO genre VALUES((SELECT MAX(GENREID)FROM genre)+1,'Genre2');

--Insert two new records into Employee table
INSERT INTO employee VALUES((SELECT MAX(EMPLOYEEID)FROM employee)+1,'Genre','Best','The',1,'12-May-69','21-May-07','69 Lulz Street','City#2','AL','!Canada',42069,'+1 (369) 258-0147','+1 (741) 852-9630','email@email.com');
INSERT INTO employee VALUES((SELECT MAX(EMPLOYEEID)FROM employee)+1,'Leroy','Jenkins','Paladin',null,'07-Oct-42','15-Nov-88','Leeeeerooy Jeeeeeeeenkiiiinss Ave','Staples','TX','Murica',69420,'+1 (135) 579-9753','+1 (555) 246-6810','!email@notemail.com');

--Insert two new records into Customer table
INSERT INTO customer VALUES((SELECT MAX(CUSTOMERID)FROM customer)+1,'That One Firstname','That One Lastname','That One Company','That One Address','That One City','TOS','That One Country',01011,1111111111,null,'ThatOneEmail@ThatOneSite.com',4);
INSERT INTO customer VALUES((SELECT MAX(CUSTOMERID)FROM customer)+1,'Big','Chungus','Chungus Inc.','1273 Rockefeller Street','Chungusville','BS','Chungus',10100,8675309,null,'BigChungus@Chungus.com',5);


--2.4
--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname = 'Robert',lastname = 'Walter'
WHERE firstname = 'Aaron' and lastname = 'Mitchell';

-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

--2.5
--Select all invoices with a billing address like “T%”
SELECT * FROM invoice 
WHERE billingaddress LIKE 'T%';

--2.6
--Select all invoices that have a total between 15 and 50
SELECT*FROM invoice
WHERE total > 15 and total < 50;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT*FROM employee
WHERE hiredate BETWEEN '01-Jun-03' and '01-Mar-04';

--2.7
-- Delete a record in Customer table where the name is Robert Walter
--(There may be constraints that rely on this, find out how to resolve them)
ALTER TABLE invoice 
DROP CONSTRAINT fk_invoicecustomerid;

ALTER TABLE invoice 
ADD CONSTRAINT fk_invoicecustomerid FOREIGN KEY(customerid) REFERENCES customer(customerid);
DELETE FROM customer WHERE firstname = 'Robert' and lastname = 'Walter';

--3.1
-- Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_time
RETURN VARCHAR2
IS 
curr_time VARCHAR2(100);
BEGIN
   SELECT TO_CHAR(LOCALTIMESTAMP, 'HH24:MI:SS') INTO curr_time FROM dual;
   RETURN curr_time;
END;
/
SELECT get_time FROM dual;


--create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_length
RETURN NUMBER
IS
ret_number NUMBER;
BEGIN
   SELECT LENGTH(name) INTO ret_number FROM mediatype
   WHERE ROWNUM = 1;
   RETURN ret_number;
END;
/

SELECT get_length FROM dual;

-- 3.2 
--Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION avg_total
RETURN NUMBER
IS 
average NUMBER;
BEGIN
   SELECT AVG(total) INTO average FROM invoice;
   RETURN average;
END;
/
Select avg_total FROM DUAL;

-- Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION get_max_price
RETURN NUMBER
IS
max_price NUMBER;
BEGIN
   SELECT MAX(unitprice) INTO max_price FROM track;
   RETURN max_price;
END;
/
Select get_max_price FROM dual;

-- 3.3 
-- Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_price
RETURN NUMBER
IS 
average NUMBER;
BEGIN
   SELECT AVG(unitprice) INTO average FROM invoiceline;
   RETURN average;
END;
/
SELECT avg_price FROM dual;

-- 3.4 
-- Create a function that returns all employees who are born after 1968
CREATE OR REPLACE FUNCTION get_employee
RETURN SYS_REFCURSOR
IS 
ret_employee SYS_REFCURSOR;
BEGIN
   OPEN ret_employee FOR
   SELECT firstname, lastname FROM employee
   WHERE birthdate > '31-DEC-68';
   RETURN ret_employee;
END;
/
SELECT get_employee FROM dual;


-- 4.1
--Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_name_procedure
AS
   names SYS_REFCURSOR;
BEGIN
   OPEN names FOR
   SELECT firstname, lastname FROM employee;
   DBMS_SQL.RETURN_RESULT(names);
END;
/
EXECUTE get_name_procedure;

-- 4.2 
--Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_info_procedure
(
user_id NUMBER,
n_firstname VARCHAR2, n_lastname VARCHAR2,
n_address VARCHAR2, n_city VARCHAR2, n_state VARCHAR2, n_country VARCHAR2,n_postalcode VARCHAR2,
n_phone VARCHAR2,n_email VARCHAR2
)
IS
BEGIN
   UPDATE employee SET 
   firstname = n_firstname,lastname =n_lastname,
   address = address,city = n_city,state = n_state,country = n_country,postalcode = n_postalcode,
   phone = n_phone,email = n_email
   WHERE employeeid = user_id;
END;
/
EXECUTE update_info_procedure(2,'Jimmy', 'Johns','Bread Street','Meatville','VG','Sandwich',32145,'+1 (531) 975-3579','emailBoi@stuffs.com');

--Create a stored procedure that returns the managers of an employee
CREATE OR REPLACE PROCEDURE get_manager (user_id varchar2)
AS
   managers SYS_REFCURSOR;
BEGIN
   OPEN managers FOR
   SELECT firstname, lastname from Employee
   WHERE employeeid = (SELECT reportsto FROM employee
                                       WHERE employeeid = user_id);
   DBMS_SQL.RETURN_RESULT(managers);
END;
/
EXECUTE get_manager(4);

--4.3
--Create a stored procedure that returns the name and company of a customer
CREATE OR REPLACE PROCEDURE get_customer_procedure
(
   user_id IN NUMBER,
   ret_firstname OUT VARCHAR2,
   ret_lastname OUT VARCHAR2,
   ret_company OUT  VARCHAR2)
IS
BEGIN
   SELECT firstname, lastname, company
   INTO ret_firstname, ret_lastname, ret_company
   FROM customer
   WHERE customerid = user_id;
END;
/
SET serveroutput ON;

DECLARE
user_id customer.customerid%TYPE;
n_firstname customer.firstname%TYPE;
n_lastname customer.lastname%TYPE;
company_name customer.company%TYPE;
BEGIN
user_id := 61;
get_customer_procedure(user_id, n_firstname, n_lastname, company_name);
DBMS_OUTPUT.PUT_LINE('Customer ' || n_firstname || ' ' || n_lastname || ' of ' || company_name);
END;
/

--5.0
-- Create a transaction that given a invoiceId will delete that invoice 
--(There may be constraints that rely on this, find out how to resolve them)
CREATE OR REPLACE PROCEDURE delete_invoice_procedure(invoice_id IN NUMBER)
IS
BEGIN
DELETE FROM invoiceline WHERE invoiceid = invoice_id;
DELETE FROM invoice WHERE invoiceid = invoice_id;
END;
/
EXECUTE delete_invoice_procedure(2);
Select *from invoice;

--Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insert_customer_procedure
(
n_firstname VARCHAR2, n_lastname VARCHAR2,n_company VARCHAR2,
n_address VARCHAR2, n_city VARCHAR2, n_state VARCHAR2, n_country VARCHAR2,n_postalcode VARCHAR2,
n_phone VARCHAR2,n_fax VARCHAR2,n_email VARCHAR2,n_supportrepid VARCHAR2
)
IS
BEGIN
INSERT INTO customer VALUES ((SELECT MAX(customerid)FROM customer)+1, n_firstname, n_lastname,n_company,
                                n_address,n_city,n_state,n_country,n_postalcode,
                               n_phone,n_fax,n_email,n_supportrepid);
END;
/
EXECUTE insert_customer_procedure('Larry','Lobster','KrustyKrab','133 Corral Street','Bikini Bottom','SB','Ocean','32198','+1 (789) 456-1234',null,'mail',2);
Select *from CUSTOMER;


--6.1
--Create an after insert trigger on the employee table fired after a new record is inserted into the table
CREATE OR REPLACE TRIGGER EMPLOYEE_AFTERINSERT_TRIGGER 
AFTER INSERT ON EMPLOYEE 
BEGIN

  DBMS_OUTPUT.PUT_LINE('Employee Added');
END;
/
set serveroutput on;
INSERT INTO employee VALUES(
((SELECT MAX(EMPLOYEEID)FROM employee)+1),--id
'Suzy',--fname
'Queue',--lname
'asdf',--title
2,--reportsto
null,--bday
null,--hireday
'asdf',--address
'asdf',--city
'as',--state
'asdf',--country
1324,--pcode
132465130,--phone
13216489,--fax
'email@asdfl.com'--email
);


--Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER ALBUM_AFTER_INSERT_TRIGGER 
AFTER UPDATE OR INSERT ON ALBUM 
BEGIN
  DBMS_OUTPUT.PUT_LINE('Album Updated');
END;
/
set serveroutput on;
UPDATE album
SET title = 'new title'
WHERE ALBUMID = 1;

--Create an after delete trigger on the customer table that fires after a row is deleted from the table
CREATE OR REPLACE TRIGGER AFTER_DELETE_CUSTOMER 
AFTER DELETE ON CUSTOMER 
BEGIN
  DBMS_OUTPUT.PUT_LINE('Customer Deleted...Permanantly');
END;
/
set serveroutput on;
ALTER TRIGGER enable;
DELETE FROM customer WHERE customerid = 8;
--7.1
-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId
SELECT customer.firstname,customer.lastname,invoice.invoiceid FROM customer
INNER JOIN invoice
ON  invoice.customerid=customer.customerid ;

--7.2
-- Create an outer join that joins the customer and invoice table, specifying the
--CustomerId, firstname, lastname, invoiceId, and total
SELECT customer.customerid,customer.firstname,customer.lastname,invoice.invoiceid,invoice.total FROM customer
FULL OUTER JOIN invoice
ON  invoice.customerid=customer.customerid;

--7.3
--Create a right join that joins album and artist specifying artist name and title
SELECT artist.name,album.title FROM album
RIGHT JOIN artist
ON artist.artistid = album.artistid;

--7.4
--Create a cross join that joins album and artist and sorts by artist name in ascending order
SELECT*FROM album
CROSS JOIN artist
ORDER BY artist.name;

--7.5
--Perform a self-join on the employee table, joining on the reportsto column
SELECT *FROM employee a
INNER JOIN employee b
ON a.reportsto = b.employeeid;

