-- Daniel Serna
-- 03/15/19
-- SQL Homework 

-- 2.1.1
SELECT * FROM EMPLOYEE; 

-- 2.1.2
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';

-- 2.1.3
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO IS NULL;

-- 2.2
SELECT * FROM ALBUM ORDER BY TITLE DESC;
SELECT * FROM CUSTOMER ORDER BY CITY ASC;

--2.3.1
INSERT INTO GENRE VALUES(26,'Classical'); 
INSERT INTO GENRE VALUES(27, 'Alternative'); 

SELECT * FROM GENRE;

--2.3.2
INSERT INTO EMPLOYEE VALUES(9,'Arnold','Hey','Sanitation Engineer',1,'15-OCT-83','15-OCT-03','1818 Ash Ave','Edinburg','AR','America','99054','+1 (555) 555-4545','+1 (555) 555-1234','arnold@chinookcorp.com');
INSERT INTO EMPLOYEE VALUES(10,'Ed','Little','Sanitation Engineer',1,'08-AUG-70','15-OCT-03','741 Jesus Ln','Flordaida','TX','America','85712','+1 (555) 555-4555','+1 (555) 555-1111','ed@chinookcorp.com');

SELECT * FROM EMPLOYEE;

--2.3.3
INSERT INTO CUSTOMER VALUES(60,'Tomas','Leriche','Architect Corp','332 Sunflower Dr','Sante Fe','New Mexico','America','99023','+1 (665) 123-4567',null,'tomas@gmail.com',3); 
INSERT INTO CUSTOMER VALUES(61,'Fry','Philip','Space Corp','999 Venus Ln','Alpha 7','Nowhere','Mars','11111','+88 (888) 888-8888',null,'fry@gmail.com',3); 

SELECT * FROM CUSTOMER;

-- 2.4.1
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMERID = 32; 

-- 2.4.2
UPDATE ARTIST
SET NAME = 'CCR'
WHERE ARTISTID = 76; 

SELECT * FROM ARTIST

-- 2.5
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6.1
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50; 

-- 2.6.2
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '31-MAR-04';

-- 2.7
ALTER TABLE Invoice DROP CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

-- 3.1.1
CREATE OR REPLACE FUNCTION return_current_time     
RETURN VARCHAR 
IS 
 my_time VARCHAR(100);
BEGIN
 SELECT TO_CHAR (CURRENT_DATE, 'HH:MI:SS') INTO my_time FROM DUAL; 
 RETURN return_current_time;
END;
/

-- I feel like this is the correct but every time I run this it doesn't run

SELECT return_current_time FROM DUAL; 

-- 3.1.2
CREATE OR REPLACE FUNCTION return_length
RETURN INT
IS my_int INT(3);
BEGIN
 SELECT LENGTH(NAME) INTO my_int FROM MEDIATYPE -- (NAME) -> is the name of column
 WHERE rownum = 1;
 RETURN my_int;
END;
/
SELECT return_length from DUAL;

--3.2.1
CREATE OR REPLACE FUNCTION average_of_invoices
RETURN NUMBER
IS my_average NUMBER;
BEGIN
 SELECT AVG(TOTAL) INTO my_average FROM INVOICE;
 RETURN my_average;
END;
/

SELECT average_of_invoices FROM DUAL;

--3.2.2  
CREATE OR REPLACE FUNCTION most_expensive_track
RETURN NUMBER
IS the_track NUMBER(3,2);
BEGIN
 SELECT MAX(UNITPRICE) INTO the_track FROM TRACK;
 RETURN the_track;
END; 
/

SELECT most_expensive_track FROM DUAL;

-- 3.3
CREATE OR REPLACE FUNCTION average_of_invoiceline
RETURN NUMBER
IS the_average NUMBER(3,2);
BEGIN
 SELECT AVG(UNITPRICE) INTO the_average FROM INVOICELINE;
 RETURN the_average;
END; 
/

SELECT average_of_invoiceline FROM DUAL;

-- 3.4
CREATE OR REPLACE FUNCTION find_employees
RETURN SYS_REFCURSOR
IS the_employees SYS_REFCURSOR; 
BEGIN
 OPEN the_employees FOR
 SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE
 WHERE BIRTHDATE > '31-DEC-68';
 RETURN the_employees;
END;
/

SELECT find_employees FROM DUAL;

-- 4.1
CREATE OR REPLACE PROCEDURE emp_find(
    emp_names IN OUT SYS_REFCURSOR)
    IS -- used when you IN OUT
BEGIN
    OPEN emp_names FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END; 
/

var cur REFCURSOR;
EXECUTE emp_find(:cur); 
PRINT cur;

-- 4.2.1
CREATE OR REPLACE PROCEDURE emp_info(
    emp_id NUMBER, emp_phone VARCHAR2)
    AS
BEGIN
    UPDATE EMPLOYEE 
    SET PHONE = emp_phone
    WHERE EMPLOYEEID = emp_id;
END;

execute emp_info(5,'+1 (999)123-1234');


select * from employee; 

-- 4.2.2
CREATE OR REPLACE PROCEDURE emp_report (
emp_id NUMBER, emp_name OUT SYS_REFCOURSOR)
    IS
BEGIN
    OPEN emp_name FOR
        SELECT m.FIRSTNAME, m.LASTNAME
        FROM EMPLOYEE m
        INNER JOIN EMPLOYEE e ON m.EMPLOYEEID = e.REPORTSTO
        WHERE e.EMPLOYEEID = emp_id
END; 


var curr refcursor;
EXECUTE emp_report(5,:curr);
print curr; 

-- 4.3
CREATE OR REPLACE PROCEDURE ret_custo_comp(
cus_id NUMBER, comp_name OUT SYS_REFCURSOR)
 IS
BEGIN
    OPEN comp_name FOR
        SELECT c.FIRSTNAME, c.LASTNAME, c.COMPANY FROM CUSTOMER c
        WHERE c.CUSTOMERID = cus_id; 
END; 

var cur refcursor;
execute(11,:cur);
print cur; 

-- 5.0.1
CREATE OR REPLACE delete_invoice (invoice_id NUMBER)
IS
BEGIN
    DELETE FROM INVOICELINE WHERE INVOICEID = invoice_id;
    DELETE FROM INVOICE WHERE INVOICEID = invoice_id;
END;

execute delete_invoice(4); 
rollback; 

-- 5.0.2
CREATE OR REPLACE insert_into_customer(customer_id NUMBER, first_name VARCHAR2, last_name VARCHAR2, p_hone VARCHAR2, e_mail VARCHAR2)
IS
BEGIN
    INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, PHONE, EMAIL) VALUES (customer_id, first_name, last_name, p_hone, e_mail)
END; 

EXECUTE insert_into_customer(61, 'Filthy', 'Frank', '+1 (999) 555-5001', 'frank@gmail.com');
rollback;


-- 6.1
SELECT * FROM EMPLOYEES;

CREATE OR REPLACE TRIGGER after_record_insert
BEFORE INSERT
ON EMPLOYEE
FOR EACH ROW
BEGIN
 INSERT INTO EMPLOYEES (E_ID, E_NAME, E_SALARY, E_TITLE) VALUES (:new.employee_id, :new.employee_name, :new.employee_salary, :new.employee_title)
END; 

INSERT INTO EMPLOYEES (employee_id, employee_name, employee_salary, employee_title) VALUES (1, 'Filthy Frank', 10, 'Content Creator');


-- 6.2
CREATE OR REPLACE TRIGGER after_update
AFTER UPDATE
ON ALBUM
FOR EACH ROW
BEGIN
    DBMS_OUPUT.PUT_LINE('Triggered: Updating');
END; 
UPDATE ALBUM SET TITLE = 'Sondre Lerche' WHERE ALBUMID = 10;


-- 6.3
CREATE OR REPLACE TRIGGER delete
AFTER DELETE
ON CUSTOMER
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LIKE('Triggered: Deleting');
END; 
DELETE FROM CUSTOMER WHERE CUSTOMERID = 100;


-- 7.1
SELECT c.FIRSTNAME, c.LASTNAME, i.INVOICEID
FROM CUSTOMER c
INNER JOIN INVOICE i
ON c.CUSTOMERID = i.CUSTOMERID;


-- 7.2
SELECT c.CUSTOMERID, c.FIRSTNAME, c.LASTNAME, i.INVOICEID, i.TOTAL
FROM CUSTOMER c
RIGHT OUTER JOIN INVOICE i
ON c.CUSTOMERID = i.CUSTOMERID;


-- 7.3
SELECT a.NAME, l.TITLE
FROM ARTIST a
RIGHT JOIN ALBUM l
on a.ARTISTID = l.ARTISTID;


-- 7.4
SELECT a.NAME 
FROM ARTIST a
CROSS JOIN ALBUM
ORDER BY a.NAME;


-- 7.5
SELECT m.FIRSTNAME, m.LASTNAME, e.FIRSTNAME, e.LASTNAME
FROM EMPLOYEE m
INNER JOIN EMPLOYEE e ON m.EMPLOYEEID = e.REPORTSTO;