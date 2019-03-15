-- SQL LAB 0304UTA HOMEWORK
-- GAEL MORALES CISNEROS


-- TASK 2.0 - SQL QUERIES
--2.1 SELECT 
-- 2.1.1
SELECT * FROM employee;

-- 2.1.2
SELECT * FROM employee
WHERE lastname LIKE 'King';

-- 2.1.3
SELECT * FROM employee
WHERE firstname LIKE 'Andrew'
AND reportsto IS NULL;


-- 2.2 ORDER BY
-- 2.2.1
SELECT * FROM album
ORDER BY title DESC;

-- 2.2.2
SELECT firstname FROM customer
ORDER BY city;


-- 2.3 INSERT INTO
--2.3.1
select * from genre;
INSERT INTO genre VALUES (26,'');
INSERT INTO genre VALUES (27,'');

-- 2.3.2
SELECT * FROM employee;
INSERT INTO employee VALUES (9,'Jeff','Burns','IT Staff',6,to_date('07-JUL-77', 'DD-MON-YY'),to_date('05-MAR-04','DD-MON-YY'),'123 F Ave','Lethbridge','AB','Canada',
    'T2B3T2','+1 (403) 125-3316','+1 (780) 262-8458','jeff@chinookcorp.com');
INSERT INTO employee VALUES (10,'Pam','Nichols','IT Staff',6,to_date('01-OCT-86','DD-MON-YY'),to_date('23-MAY-04','DD-MON-YY'),'456 Main St','Lethbridge','AB','Canada',
    'T1H2N6','+1 (403) 246 - 6856','+1 (403) 456 - 6971','pam@chinookcorp.com');

-- 2.3.3
select * from customer;
INSERT INTO customer VALUES (60,'Yousef','PizzaMan','Revature','123 Uta St','Dallas','TX','USA','76013','+1 (708) 564-6468',null,'yo.pizzaman@gmail.com',4);
INSERT INTO customer VALUES (61,'Jerry','Thespider','Revature','654 Uta Ave','Dallas','TX','USA','76013','+1 (708) 619-4824',null,'jerry.spider@yahoo.com',5);


-- 2.4 UPDATE
-- 2.4.1
UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname LIKE 'Aaron' AND lastname LIKE 'Mitchell';

--2.4.2
select * from artist;
UPDATE artist SET name = 'CCR' WHERE name LIKE 'Creedence Clearwater Revival';
SAVEPOINT;

-- 2.5 LIKE
-- 2.5.1
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';


-- 2.6 BETWEEN
--2.6.1
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

-- 2.6.2
SELECT * FROM employee WHERE hiredate BETWEEN to_date('01-JUN-03','DD-MON-YY') AND to_date('01-MAR-04','DD-MON-YY');


-- 2.7 DELETE
-- 2.7.1
ALTER TABLE invoice DROP  CONSTRAINT FK_InvoiceCustomerId;

ALTER TABLE invoice ADD CONSTRAINT FK_InvoiceCustomerId 
FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId) ON DELETE CASCADE ;

DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';


-- TASK 3.0 SQL FUNCTIONS
-- 3.1 System Defined Functions
-- 3.1.1
CREATE OR REPLACE FUNCTION get_current_time_function
RETURN TIMESTAMP
IS
    current_time_function TIMESTAMP;
BEGIN
    SELECT CURRENT_TIMESTAMP INTO current_time_function FROM dual;
    RETURN current_time_function;
END;

DECLARE
    current_time_function TIMESTAMP;
BEGIN
    current_time_function  := get_current_time_function();
    DBMS_OUTPUT.PUT_LINE('Current time: ' || current_time_function);
END;

-- 3.1.2
CREATE OR REPLACE FUNCTION get_mediatype_length
RETURN NUMBER
IS
    mediatype_length NUMBER;
BEGIN
    SELECT LENGTH(name) INTO mediatype_length FROM mediatype
    WHERE ROWNUM = 1;
    RETURN mediatype_length;
END;

DECLARE
    mediatype_length NUMBER;
BEGIN
    mediatype_length := get_mediatype_length();
    DBMS_OUTPUT.PUT_LINE('Length of mediatype name: ' || mediatype_length);
END;


-- 3.2 System Defined Aggregate Functions
-- 3.2.1
CREATE OR REPLACE FUNCTION get_avg_total
RETURN NUMBER
IS
    avg_total NUMBER;
BEGIN
    SELECT AVG(total) FROM invoice;
END;

DECLARE
    avg_total NUMBER;
BEGIN
    avg_total := get_avg_total();
    DBMS_OUTPUT.PUT_LINE('Average total of invoices: ' || avg_total);
END;

-- 3.2.2
CREATE OR REPLACE FUNCTION get_track_max_unitprice
RETURN VARCHAR2
IS
    track_max_unitprice VARCHAR2(100);
BEGIN
    SELECT name INTO track_max_unitprice FROM track
    WHERE ROWNUM = 1
    ORDER BY unitprice, name DESC;
    RETURN track_max_unitprice;
END;

DECLARE 
    track_max_unitprice VARCHAR2(100);
BEGIN
    track_max_unitprice := get_track_max_unitprice();
    DBMS_OUTPUT.PUT_LINE('Most expensive track: ' || track_max_unitprice);
END;


-- 3.3 User Defined Scalar Functions
-- 3.3.1
CREATE OR REPLACE FUNCTION get_avg_price
RETURN NUMBER
IS
    avg_price NUMBER;
BEGIN
    SELECT AVG(unitprice) INTO avg_price FROM invoiceline;
    RETURN avg_price;
END;
    
DECLARE
    avg_price NUMBER;
BEGIN
    avg_price := get_avg_price();
    DBMS_OUTPUT.PUT_LINE('Average invoiceline price: ' || avg_price);
END;


-- 3.4 User Defined Table Valued Functions
CREATE OR REPLACE FUNCTION get_emp_bornafter1968
RETURN SYS_REFCURSOR
IS
    temp SYS_REFCURSOR;
BEGIN
    OPEN temp FOR
    SELECT lastname, firstname FROM employee
    WHERE birthdate > to_date('31-DEC-68', 'DD-MON-YY');
    RETURN temp;
END;

SELECT get_emp_bornafter1968 FROM dual;


-- TASK 4.0 STORED PROCEDURES
-- 4.1 Basic Stored Procedure
-- 4.1.1
CREATE OR REPLACE PROCEDURE first_last_name_procedure
IS
    first_last_name SYS_REFCURSOR;
BEGIN
    OPEN first_last_name FOR SELECT lastname, firstname FROM employee;
    DBMS_SQL.RETURN_RESULT(first_last_name);
END;

BEGIN
    first_last_name_procedure();
END;


-- 4.2 Stored Procedure Input Parameters   --Add cursor for it to work
-- 4.2.1
CREATE OR REPLACE PROCEDURE update_personal_info_procedure
    (firstname_in VARCHAR2, address_in IN VARCHAR2, city_in IN VARCHAR2, state_in IN VARCHAR2, country_in IN VARCHAR2,
    postalcode_in IN VARCHAR2, phone_in IN VARCHAR2, fax_in IN VARCHAR2, email_in IN VARCHAR2)
IS
BEGIN
    UPDATE employee SET address = address_in, city = city_in, state = state_in,country = country_in, postalcode = postalcode_in, phone = phone_in, fax = fax_in, email = email_in
    WHERE firstname = firstname_in;
END;

BEGIN
    update_personal_info_procedure('Jeff','321 G St','Arlington','TX', 'USA','76013','+1 (780) 654-6482',null,'j.burns@gmail.com');
END;
ROLLBACK;

-- 4.2.2
CREATE OR REPLACE PROCEDURE manager_lookup_procedure
    (employeeid_in IN VARCHAR2)
IS 
    temp SYS_REFCURSOR;
BEGIN
    OPEN temp FOR SELECT b.firstname, b.lastname FROM employee a, employee b
    WHERE a.reportsto = b.employeeid AND a.employeeid = employeeid_in;
    DBMS_SQL.RETURN_RESULT(temp);
END;

BEGIN
    manager_lookup_procedure(3);
END;


-- 4.3 Stored Procedure Output Parameters
-- 4.3.1
CREATE OR REPLACE PROCEDURE get_name_company_procedure
    (customerid_in IN NUMBER, firstname_out OUT VARCHAR2, company_out OUT VARCHAR2)
IS
BEGIN
     SELECT firstname, company INTO firstname_out, company_out FROM customer
     WHERE customerid = customerid_in;
END;

DECLARE
cust_name VARCHAR2(20);
cust_comp VARCHAR2(20);
BEGIN
    get_name_company_procedure(5, cust_name, cust_comp);
    DBMS_OUTPUT.PUT_LINE('The customer : '|| cust_name || ' has company : ' || cust_comp );
END;


--TASK 5.0 TRANSACTIONS
-- 5.1
CREATE OR REPLACE PROCEDURE delete_invoice_by_id_procedure
(invoiceid_in IN NUMBER)
IS
BEGIN
    DELETE FROM invoiceline WHERE invoiceid = invoiceid_in;
    DELETE FROM invoice WHERE invoiceid = invoiceid_in;
END;


BEGIN
    delete_invoice_by_id_procedure(216);
    DBMS_OUTPUT.PUT_LINE('INVOICE DELETED');
END;
ROLLBACK;

-- 5.2
CREATE OR REPLACE PROCEDURE insert_customer_procedure
IS
BEGIN
    INSERT INTO customer VALUES (65,'Jingle','Heimer',null, null,null, null, null, null, null, null, 'j.h@gmail.com', null);
END;

BEGIN
    insert_customer_procedure();
    DBMS_OUTPUT.PUT_LINE('Customer inserted');
END;
ROLLBACK;

-- TASK 6.0 TRIGGERS
-- 6.1 AFTER/FOR
-- 6.1.1
CREATE OR REPLACE TRIGGER new_employee_record_trigger
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('New record in employee table');
END;

INSERT INTO employee VALUES (11,'Pam','Nichols','IT Staff',6,to_date('01-OCT-86','DD-MON-YY'),to_date('23-MAY-04','DD-MON-YY'),'456 Main St','Lethbridge','AB','Canada',
    'T1H2N6','+1 (403) 246 - 6856','+1 (403) 456 - 6971','pam@chinookcorp.com');
ROLLBACK;


-- 6.1.2
CREATE OR REPLACE TRIGGER new_album_row_trigger
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('new row in album table');
END;

UPDATE album SET title = 'Balls to the Wall'  WHERE title = 'Balls to the Wall';
ROLLBACK;

-- 6.1.3
CREATE OR REPLACE TRIGGER delete_customer_row_trigger
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Row in customer table deleted');
END;

DELETE FROM invoice WHERE customerid = 59;
DELETE FROM customer WHERE customerid = 59;
ROLLBACK;


-- TASK 7.0 JOINS
-- 7.1 INNER
-- 7.1.1
SELECT c.firstname, c.lastname, i.invoiceid FROM customer c
INNER JOIN invoice i
ON c.customerid = i.customerid;


-- 7.2 OUTER
-- 7.2.1
SELECT c.customerid, firstname, lastname, invoiceid, total FROM customer c
FULL OUTER JOIN invoice i
ON c.customerid = i.customerid
ORDER BY c.customerid;


-- 7.3 RIGHT
SELECT name, title FROM album al
RIGHT JOIN artist ar
ON ar.artistid = al.artistid
ORDER BY name;


-- 7.4 CROSS
SELECT * FROM album
CROSS JOIN artist
ORDER BY name;


-- 7.5 SELF
SELECT * FROM employee a, employee b
WHERE a.employeeid = b.reportsto;

commit;


