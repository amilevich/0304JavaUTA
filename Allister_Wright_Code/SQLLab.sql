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
SELECT get_time FROM dual;

-- 3.1.2
CREATE OR REPLACE 
FUNCTION get_media_type_length 
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
SELECT get_media_type_length(1) FROM dual;

-- 3.2.1
