/*
SQLHomework
*/


-----2.1 SELECT-------------------------------------------------------------------------------------------
--2.1.1
select * from Employee;
--2.1.2
select * from employee where lastname='King';
--2.1.3
select * from employee where firstname='Andrew' and reportsto is null;

-----2.2 Order By----------------------------------------------------------------------------------------
--2.2.1
SELECT * FROM ALBUM ORDER BY title DESC;
--2.2.2
SELECT firstname FROM CUSTOMER ORDER BY city ASC;

-----2.3 Insert into------------------------------------------------------------------------------------
--2.3.1
--select * from GENRE;
INSERT INTO GENRE (GENREID, NAME) VALUES(26, 'Techno');
INSERT INTO GENRE (GENREID, NAME) VALUES(27, 'Spanish');
--select * from genre;
--2.3.2
--select * from employee;
INSERT INTO EMPLOYEE(EMAIL, FAX, PHONE, POSTALCODE, COUNTRY, STATE, CITY, ADDRESS, HIREDATE, BIRTHDATE, REPORTSTO, TITLE, FIRSTNAME, LASTNAME, EMPLOYEEID) VALUES('	test@gmail.com', '123-456-7891', '987-456-7689', '78669', 'USA', 'Texas', 'Arlington', '123 blvd', NULL, NULL, 2, 'Developer', 'Ubba', 'Lothbrok', 9);
INSERT INTO EMPLOYEE(EMAIL, FAX, PHONE, POSTALCODE, COUNTRY, STATE, CITY, ADDRESS, HIREDATE, BIRTHDATE, REPORTSTO, TITLE, FIRSTNAME, LASTNAME, EMPLOYEEID) VALUES('	test1@gmail.com', '123-456-7891', '677-986-7689', '78345', 'USA', 'Texas', 'Dallas', '123 blvd', NULL, NULL, 2, 'DEV', 'Ragnar', 'Lothbrok', 10);
--select * from employee;
--2.3.3
--select * from customer;
INSERT INTO CUSTOMER(SUPPORTREPID, EMAIL, FAX, PHONE, POSTALCODE, COUNTRY, STATE, CITY, ADDRESS, COMPANY, LASTNAME, FIRSTNAME, CUSTOMERID) VALUES(3, 'test@gmail.com', '123-456-7898', '121-456-9807', '56448', 'USA', 'Texas', 'Austin', '123 blvd', 'Revature', 'Lothbrok', 'Sigurd', 60);
INSERT INTO CUSTOMER(SUPPORTREPID, EMAIL, FAX, PHONE, POSTALCODE, COUNTRY, STATE, CITY, ADDRESS, COMPANY, LASTNAME, FIRSTNAME, CUSTOMERID) VALUES(4, 'test1@gmail.com', '453-766-7898', '981-456-9987', '57848', 'USA', 'Texas', 'Tyler', '123 W street', 'REV', 'Lothbrok', 'Lagertha', 61);
--select * from customer;

-----2.4 Update--------------------------------------------------------------------------------------------------------------------
--2.4.1
--select * from CUSTOMER;
UPDATE CUSTOMER SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
--select * from customer;
--2.4.2
--select * from artist;
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';
--select * from artist;

-----2.5 Like-----------------------------------------------------------------------------------------------
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

-----2.6 Between-----------------------------------------------------------------------------------------------
--2.6.1
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
--2.6.2
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-2003' AND '01-MAR-2004';

--2.7 Delete
--select * from customer where firstname = 'Robert';
ALTER TABLE INVOICE DROP CONSTRAINT fk_invoicecustomerid;
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'ROBERT' AND LASTNAME = 'WALTER'; 
--select * from customer where firstname = 'Robert';

--3.1 System Define Function--------------------------------------------------------------------------
--3.1.1
CREATE OR REPLACE FUNCTION get_time
RETURN VARCHAR2 IS
    temp VARCHAR2(20);
BEGIN
    SELECT TO_CHAR(CURRENT_TIMESTAMP, 'MM-DD-YYY HH24:MI:SS')
    INTO temp
    FROM dual;
    
    RETURN temp;
END;
/
SELECT get_time() FROM dual;
--3.1.2
CREATE OR REPLACE FUNCTION get_length
RETURN NUMBER IS
    temp NUMBER;
BEGIN
SELECT LENGTH(name) into temp from mediatype
WHERE ROWNUM=1;
RETURN temp;
END;

SELECT get_length from dual;
--3.2.1
CREATE OR REPLACE FUNCTION average_total
RETURN NUMBER IS
    temp NUMBER;
BEGIN
    SELECT AVG(total) into temp from invoice;
    RETURN temp;
END;
select average_total from dual;
--3.2.2
CREATE OR REPLACE FUNCTION most_expensive
RETURN NUMBER IS
    temp NUMBER;
BEGIN
    SELECT MAX(unitprice) into temp from track;
    RETURN temp;
END;
select most_expensive from dual;
--3.3
CREATE OR REPLACE FUNCTION average_price
RETURN NUMBER IS
    temp NUMBER;
BEGIN
    SELECT AVG(unitprice) into temp from invoiceline;
    RETURN temp;
END;
select average_price from dual;
--3.4
CREATE OR REPLACE FUNCTION born
RETURN SYS_REFCURSOR IS
    temp SYS_REFCURSOR;
BEGIN
    OPEN temp FOR
    SELECT FIRSTNAME FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-68';
    RETURN temp;
END;
select born from dual;

--4.0 Stored Procedures------------------------------------------------------------------------------------
--4.1 Basic stored procedure
CREATE OR REPLACE PROCEDURE print_employee_procedure
AS
  temp SYS_REFCURSOR;
BEGIN
  OPEN temp FOR
  SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
  DBMS_SQL.RETURN_RESULT(temp);
END;
execute print_employee_procedure;

--4.2 Stored Procedure Input Parameters--------------------------------------------------------------------
--4.2.1
CREATE OR REPLACE PROCEDURE update_procedure(x in VARCHAR2, y in VARCHAR2)
IS
BEGIN
    UPDATE EMPLOYEE SET FIRSTNAME = 'Bob', LASTNAME = 'The Builder' WHERE FIRSTNAME=x AND LASTNAME=y ;
END;
execute update_procedure('Steve', 'Johnson');
--select * from employee;

--4.2.2
CREATE OR REPLACE PROCEDURE print_manager(x IN VARCHAR2, y VARCHAR2)
AS
  manager SYS_REFCURSOR;
BEGIN
  OPEN manager FOR
  SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE EMPLOYEEID = (SELECT reportsto from employee
                                                                where firstname=x and lastname=y);
  DBMS_SQL.RETURN_RESULT(manager);
END;
execute print_manager('Steve', 'Johnson');
--select * from employee;

--4.3 Stored Procedure Output Parameters--------------------------------------------------------------------------------------
/*CREATE OR REPLACE PROCEDURE print_name_com(x IN INTEGER)
AS
  manager SYS_REFCURSOR;
BEGIN
  OPEN manager FOR
  SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER WHERE CUSTOMERID = x;
  DBMS_SQL.RETURN_RESULT(manager);
END;
execute print_name_com(5);
select * from customer;*/

CREATE OR REPLACE PROCEDURE output_par (
   emp_name varchar2,
   fname OUT varchar2,
   lname OUT varchar2,
   p_company OUT  varchar2)
IS
BEGIN
   SELECT FIRSTNAME, LASTNAME, COMPANY
   INTO fname, lname, p_company
   FROM CUSTOMER
   WHERE FIRSTNAME = emp_name;
END;

set serveroutput ON;
select * from customer;

DECLARE
e_name customer.firstname%type;
f_name customer.firstname%type;
l_name customer.lastname%type;
c_name CUSTOMER.COMPANY%TYPE;
BEGIN
e_name := 'Daan';
output_par(e_name, f_name, l_name, c_name);
DBMS_OUTPUT.PUT_LINE('Customer name = ' || f_name || ' ' || l_name || ', of Company= ' || c_name);
END;

--5.0 Transactions-----------------------------------------------------------------------------------------------
--5.1
CREATE OR REPLACE PROCEDURE delete_invoice(invoice_id NUMBER)
IS
BEGIN
   DELETE FROM invoiceline
   WHERE invoiceid = invoice_id;
   DELETE FROM invoice
   WHERE invoiceid = invoice_id;
END;
/
SELECT * FROM invoice;
EXEC delete_invoice(5);

--5.2
CREATE OR REPLACE PROCEDURE inserts
IS
BEGIN
    INSERT INTO CUSTOMER VALUES(67, 'Please', 'Work', null, null, null, null, null, null, null, null, 'test1@email', null);
END;
EXEC inserts();
select * from customer;

--6.0 Triggers--------------------------------------------------------------------------------------
--6.1.1
CREATE OR REPLACE TRIGGER after_insert AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('after_insert Employee succesfully fired');
END;
ALTER TRIGGER after_insert ENABLE;
select * from employee;
insert into employee VAlUES(12, 'This', 'That', null, null, null, null, null, null, null, null, null, null, null, null);

--6.1.2
CREATE OR REPLACE TRIGGER after_update
AFTER UPDATE
   ON ALBUM
   FOR EACH ROW
BEGIN
    DBSM_OUTPUT.PUT_LINE('after_update tirgger fired');
END;
/
select * from album;
UPDATE album set title = 'Big Ones 2' Where title = 'Big Ones';

--6.1.3
CREATE OR REPLACE TRIGGER DELETE_TRIGGER 
AFTER DELETE ON CUSTOMER 
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('delete_after Customer succesfully fired');
END;
DELETE FROM INVOICE WHERE CUSTOMERID = 22;
DELETE FROM CUSTOMER WHERE CUSTOMERID = 22;

--7.0 Joins------------------------------------------------------------------------------------------
--7.1 Inner Join
--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT *
FROM CUSTOMER INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.2 Outter Join
--Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT customer.customerid, firstname, lastname, invoiceid, total
FROM CUSTOMER FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3 Right Join
--Create a right join that joins album and artist specifying artist name and title.
SELECT NAME, title 
FROM album
RIGHT JOIN artist
ON album.artistid = artist.artistid;

--7.4 Cross Join
--Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT artist.name
FROM album CROSS JOIN artist;

--7.5 Self Join
--Perform a self-join on the employee table, joining on the reportsto column.
SELECT
    ( m.firstname|| '  '|| m.lastname ) manager,( e.firstname|| '  '|| e.lastname ) employee, e.title
FROM
    employee m
    INNER JOIN employee e ON m.employeeid = e.reportsto
ORDER BY
    manager;


