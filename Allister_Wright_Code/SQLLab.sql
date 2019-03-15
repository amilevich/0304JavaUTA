conn chinook/p4ssw0rd

-- 2.1
-- 2.1.1
SELECT * FROM EMPLOYEE;
-- 2.1.2
SELECT * FROM EMPLOYEE WHERE lastname = 'King';
-- 2.1.3
SELECT * FROM EMPLOYEE WHERE firstname = 'Andrew' AND reportsto IS NULL;

-- 2.2.1
SELECT * FROM ALBUM
ORDER BY title DESC;
-- 2.2.2
SELECT firstname FROM CUSTOMER
ORDER BY address;

-- 2.3.1
INSERT INTO GENRE VALUES (26, 'Prog Rock');
INSERT INTO GENRE VALUES (27, 'Dubstep');

-- 2.3.2
INSERT INTO EMPLOYEE VALUES (9, 'Cook', 'Quinton', 'Associate', 6, '13-MAR-99', '04-MAR-2019', 
    '333 Pizza Cir', 'Bellvue', 'WA', 'United States', '77777', 
    '(403) 555-5555', '(403) 555-5556', 'quinton@chinookcorp.com');
INSERT INTO EMPLOYEE VALUES (10, 'Meme', 'Lopez', 'Associate', 6, '12-JAN-98', '04-MAR-2019', 
    '314 Pi Lane', 'Gonzales', 'TX', 'United States', '76543', 
    '(403) 666-6666', '(403) 666-6667', 'manuel@chinookcorp.com');
--SELECT * FROM EMPLOYEE;

-- 2.3.3
INSERT INTO CUSTOMER VALUES (60, 'Tomas', 'Leriche', 'Revature', 
    '2718 Euler Dr', 'Reston', 'VA', 'United States', '88888', 
    '(403) 777-7777', '(403) 777-7778', 'tleriche@revature.com', 4);
INSERT INTO CUSTOMER VALUES (61, 'Yousef', 'PizzaMan', 'Revature', 
    '666 Niro St', 'Reston', 'VA', 'United States', '87654',
    '(403) 888-8888', '(403) 888-8889', 'yousef@revature.com', 4);
--SELECT * FROM CUSTOMER;

-- 2.4.1
UPDATE CUSTOMER 
SET firstname = 'Robert',
    lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

-- 2.4.2
UPDATE ARTIST
SET name = 'CCR'
WHERE name = 'Credence Clearwater Revival';

-- 2.5.1
SELECT * FROM INVOICE WHERE billingaddress LIKE 'T%';

-- 2.6.1
SELECT * FROM INVOICE WHERE total BETWEEN 15 AND 50;

-- 2.6.2
SELECT * FROM EMPLOYEE
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7.1
-- UPDATE INVOICE CONSTRAINT TO DELETE ON CUSTOMER DELETION
ALTER TABLE INVOICE DROP CONSTRAINT FK_invoicecustomerid;
ALTER TABLE INVOICE 
ADD CONSTRAINT FK_customer FOREIGN KEY (customerid) REFERENCES CUSTOMER(customerid)
ON DELETE CASCADE;
-- UPDATE INVOICELINE TO DELETE ON INVOICE DELETION
ALTER TABLE INVOICELINE DROP CONSTRAINT FK_invoicelineinvoiceid;
ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_invoiceid FOREIGN KEY (invoiceid) REFERENCES INVOICE(invoiceid)
ON DELETE CASCADE;
-- DELETE RECORD OF Robert Walter
DELETE FROM CUSTOMER 
WHERE firstname = 'Robert' AND lastname = 'Walter';

-- CHECKS
-- SELECT * FROM CUSTOMER;

-- 3.1.1
CREATE OR REPLACE FUNCTION get_time
RETURN VARCHAR2
IS this_time VARCHAR2(50);
BEGIN
    SELECT TO_CHAR(LOCALTIMESTAMP, 'HH24:MI:SS') INTO this_time FROM dual;
    RETURN this_time;
END;
/
--SELECT get_time FROM dual;

-- 3.1.2
CREATE OR REPLACE FUNCTION get_media_type_length 
    (id_num IN NUMBER)
RETURN VARCHAR2
    IS media_type_length NUMBER(6);
BEGIN
    SELECT LENGTH(name) 
    INTO media_type_length 
    FROM MEDIATYPE 
    WHERE mediatypeid = id_num;
    RETURN media_type_length;
END;
/
--SELECT get_media_type_length(1) FROM dual;

-- 3.2.1
CREATE OR REPLACE FUNCTION get_average_invoice_total
RETURN NUMBER
    IS invoice_average NUMBER;
BEGIN
    SELECT ROUND(AVG(total), 2)
    INTO invoice_average
    FROM INVOICE;
    RETURN invoice_average;
END;
/
--SELECT get_average_invoice_total FROM dual;

-- 3.2.2
CREATE OR REPLACE FUNCTION get_highest_price_track
RETURN NUMBER
    IS track_price_max NUMBER;
BEGIN
    SELECT MAX(unitprice)
    INTO track_price_max
    FROM TRACK;
    RETURN track_price_max;
END;
/
--SELECT get_highest_price_track FROM dual;

-- 3.3.1
CREATE OR REPLACE FUNCTION get_average_invoice_price
RETURN NUMBER
    IS invoice_price_average NUMBER;
BEGIN
    SELECT ROUND(AVG(unitprice), 2)
    INTO invoice_price_average
    FROM INVOICELINE;
    RETURN invoice_price_average;
END;
/
--SELECT get_average_invoice_price FROM dual;

-- 3.4.1
CREATE OR REPLACE FUNCTION get_employees_bornafter_1968
RETURN SYS_REFCURSOR
    IS emp_list SYS_REFCURSOR;
BEGIN
    OPEN emp_list FOR
    SELECT *
    FROM EMPLOYEE 
    WHERE birthdate > '31-DEC-68';
    RETURN emp_list;
END;
/
SELECT get_employees_bornafter_1968 FROM dual;

-- 4.1.1
CREATE OR REPLACE PROCEDURE get_employee_names
( employee_names OUT SYS_REFCURSOR )
IS
BEGIN
    OPEN employee_names FOR
    SELECT firstname, lastname
    FROM EMPLOYEE;
END get_employee_names;
/
-- TESTING
--VARIABLE rc REFCURSOR;
--EXEC get_employee_names(:rc);
--PRINT rc;

-- 4.2.1
CREATE OR REPLACE PROCEDURE update_employee
( emp_id IN NUMBER, new_lastname IN VARCHAR2 )
IS
BEGIN
    UPDATE EMPLOYEE 
    SET lastname = new_lastname
    WHERE employeeid = emp_id;
END;
/
--EXEC update_employee(3, 'Wilson');
--SELECT * FROM EMPLOYEE;

-- 4.2.2
CREATE OR REPLACE PROCEDURE get_employee_manager
( emp_id IN NUMBER )
AS
    manager SYS_REFCURSOR;
BEGIN
    OPEN manager FOR
    SELECT * 
    FROM EMPLOYEE
    WHERE employeeid = (
        SELECT reportsto
        FROM EMPLOYEE
        WHERE employeeid = emp_id);
    DBMS_SQL.RETURN_RESULT(manager);
END get_employee_manager;
/
-- TESTING
--EXEC get_employee_manager(4);

-- 4.3.1
CREATE OR REPLACE PROCEDURE get_customer_profinfo
( cust_id IN NUMBER )
AS
    prof_info SYS_REFCURSOR;
BEGIN
    OPEN prof_info FOR
    SELECT firstname, lastname, company
    FROM CUSTOMER
    WHERE customerid = cust_id;
    DBMS_SQL.RETURN_RESULT(prof_info);
END get_customer_profinfo;
/
--EXEC get_customer_profinfo(6);

-- 5.0.1
-- DELETE INVOICE BY SPECIFIED ID
-- DELETES CASCADE CONSTRAINTS SHOULD BE PRESENT FROM 2.7.1
CREATE OR REPLACE PROCEDURE delete_invoice_by_id
( invoice_id IN NUMBER )
IS
BEGIN
    DELETE FROM INVOICE
    WHERE invoiceid = invoice_id;
END;
/
--EXEC delete_invoice_by_id(1);

-- 5.0.2
-- AUTO INCREMENT NEW CUSTOMER IDS
CREATE SEQUENCE cust_seq
    START WITH 150
    INCREMENT BY 1;
    
CREATE OR REPLACE TRIGGER cust_seq_trigger
BEFORE INSERT ON CUSTOMER
FOR EACH ROW
BEGIN
    IF :new.customerid IS NULL THEN
    SELECT cust_seq.nextval INTO :new.customerid FROM dual;
    END IF;
END;
/
-- INSERTION PROCDURE
CREATE OR REPLACE PROCEDURE insert_new_customer
(   first_name IN VARCHAR2, 
    last_name IN VARCHAR2 , 
    a_email IN VARCHAR2)
IS
BEGIN
    INSERT INTO CUSTOMER (firstname, lastname, email)
    VALUES (first_name, last_name, a_email);
END;
/
EXEC insert_new_customer('Vladimir', 'Lenin', 'VILENIN@RSFSR.ORG');

-- 6.1.1
CREATE OR REPLACE TRIGGER after_insert_employee
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    INSERT INTO EMPLOYEE (employeeid, lastname, firstname)
    VALUES (:new.employeeid, :new.lastname, 
    :new.firstname);
END;
/

