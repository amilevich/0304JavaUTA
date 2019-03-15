--2.1

SELECT * FROM Employee;

SELECT * FROM Employee
WHERE LastName = 'King';

SELECT * FROM Employee
WHERE LastName = 'King' 
AND ReportsTo = null;

--2.2
SELECT * FROM Album
ORDER BY TITLE DESC;

SELECT * FROM Customer
ORDER BY City DESC;

--2.3
INSERT INTO GENRE VALUES(26,'Korean Pop');
INSERT INTO GENRE VALUES(27,'Japanese Pop');


INSERT INTO Employee VALUES (10, 'Sung', 'Kevin', 'Operations Analyst', 2, TO_DATE('1994-7-6 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
TO_DATE('2016-5-27 00:00:00','yyyy-mm-dd hh24:mi:ss'),'464 Cent Pkwy', 'Tracy', 'CA', 'United States', 
'95391', '1 (408) 594-8704', '1 (780) 822-9453', 'kevin@chinookcorp.com');
INSERT INTO Employee VALUES (11, 'Lee', 'Daniel', 'Marketing', 2, TO_DATE('1991-4-20 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
TO_DATE('2012-4-12 00:00:00','yyyy-mm-dd hh24:mi:ss'), '4566 Lane', 'Fremont', 'CA', 'United States', 
'95391', '1 (408) 222-8334', '1 (780) 822-9453', 'daniel@chinookcorp.com');



--2.4
UPDATE Customer SET FirstName= 'Robert' ,
LastName='Walter' WHERE FirstName='Aaron' AND  LastName =  'Mitchell' ;

select * from Artist;

UPDATE Artist SET Name= 'CCR' 
WHERE Name='Creedence Clearwater Revival';

--2.5
SELECT * FROM Invoice WHERE BillingAddress LIKE 'T%';

--2.6
SELECT * FROM Invoice WHERE Total BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HireDate BETWEEN '1-JUN-03' AND '1-MAR-04'; 


--2.7

ALTER TABLE Invoice DROP CONSTRAINT FK_InvoiceCustomerId;
ALTER TABLE Invoice ADD CONSTRAINT FK_InvoiceCustomerId
FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId)
ON DELETE CASCADE;

ALTER TABLE InvoiceLine DROP CONSTRAINT FK_InvoiceLineTrackId;
ALTER TABLE InvoiceLine ADD CONSTRAINT FK_InvoiceLineTrackId
FOREIGN KEY (TrackId) REFERENCES Track (TrackId)
ON DELETE CASCADE;


DELETE FROM Customer WHERE FirstName= 'Robert' AND LastName= 'Walter';

--3.1.1

CREATE OR REPLACE FUNCTION get_current_time
RETURN VARCHAR2
IS 
my_current_time VARCHAR2(50);
BEGIN
    SELECT to_char (SYSDATE, 'MM-DD-YYYY HH24:MI:SS') INTO my_current_time FROM DUAL;
    RETURN my_current_time;
END;


--TEST

--3.1.2
CREATE or REPLACE FUNCTION get_media_length
RETURN NUMBER
IS
media_length NUMBER(30);
BEGIN 
SELECT LENGTH(Name)
INTO media_length
FROM MediaType
Where MediaTypeID=1;

Return media_length;
End;

--3.2.1
CREATE OR REPLACE FUNCTION get_average_total
RETURN NUMBER
IS
average_total NUMBER(50);
BEGIN
SELECT AVG(Total) INTO average_total FROM Invoice;
RETURN average_total;
END;


SELECT get_average_total FROM dual; --test

--

--3.2.2
CREATE OR REPLACE FUNCTION get_max_track
RETURN NUMBER
IS
max_track NUMBER(30);
BEGIN
SELECT MAX(UnitPrice) INTO max_track FROM Track;
RETURN max_track;
END;

SELECT get_max_track FROM DUAL; --test

--3.3
CREATE OR REPLACE FUNCTION get_avg_price_invoiceline
RETURN NUMBER
IS
avg_price NUMBER(30);
BEGIN
SELECT AVG(UnitPrice) INTO avg_price FROM INVOICELINE;
RETURN avg_price;
END;

SELECT GET_AVG_PRICE_INVOICELINE FROM Dual; -- test


--3.4
CREATE OR REPLACE FUNCTION employees_after_date
RETURN SYS_REFCURSOR
IS date_c SYS_REFCURSOR;
BEGIN
OPEN date_c FOR
SELECT *
FROM EMPLOYEE
WHERE BIRTHDATE > '31-DEC-68'; 
RETURN date_c;
END;


--4.1
CREATE OR REPLACE PROCEDURE return_a_cur
( p_cur OUT sys_refcur) 
IS
BEGIN
  OPEN p_cur
  FOR 
    SELECT * 
    FROM employee;
END return_a_cur;

--4.2.1
CREATE OR REPLACE PROCEDURE update_employee
( 
  id IN NUMBER,
  address_in IN  VARCHAR,
  city_in IN VARCHAR,
  state_in IN VARCHAR,
  country_in IN VARCHAR
) 
IS
BEGIN
  UPDATE EMPLOYEE
  
  SET
  
  ADDRESS = address_in,
  CITY = city_in,
  STATE = state_in,
  COUNTRY = country_in
  
  WHERE EMPLOYEEID = id;
END;


--5.0.1
CREATE OR REPLACE PROCEDURE remove_inv
(
    invoice_id IN NUMBER
)
IS
BEGIN
    DELETE FROM INVOICELINE WHERE INVOICEID = invoice_id;
    DELETE FROM INVOICE WHERE INVOICEID = invoice_id;    
END;

--5.0.2
CREATE OR REPLACE PROCEDURE add_stuff
(
    name_in IN CUSTOMER.FIRSTNAME%TYPE,
    last_in IN CUSTOMER.LASTNAME%TYPE,
    email_IN IN CUSTOMER.EMAIL%TYPE
)
AS
BEGIN
    DECLARE VARIL NUMBER;
    BEGIN
        SELECT COUNT(CUSTOMER.CUSTOMERID)+1 INTO VARIL FROM CUSTOMER;
        INSERT INTO CUSTOMER VALUES (VARIL,name_in,last_in,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,email_in,NULL);
    END;
END;


--6.1
CREATE TRIGGER insert_employee
AFTER INSERT ON EMPLOYEE
BEGIN
    dbms_output.put_line('Updated Employee!');
END;

--6.2
CREATE TRIGGER update_album
AFTER UPDATE ON ALBUM
BEGIN
    dbms_output.put_line('Updated Album!');
END;

--6.3
CREATE TRIGGER delete_cust
AFTER DELETE ON CUSTOMER
BEGIN
    dbms_output.put_line('Deleted!');
END;


--7.1
SELECT INVOICE.INVOICEID, CUSTOMER.FIRSTNAME FROM CUSTOMER 
INNER JOIN INVOICE 
ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID 
ORDER BY CUSTOMER.CUSTOMERID;


--7.2
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, CUSTOMER.CUSTOMERID, INVOICE.INVOICEID, INVOICE.TOTAL 
FROM CUSTOMER 
LEFT OUTER JOIN INVOICE
ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;


--7.3
SELECT ALBUM.TITLE, ARTIST.NAME
FROM ARTIST RIGHT OUTER JOIN ALBUM
ON ALBUM.ARTISTID = ARTIST.ARTISTID;

--7.4
SELECT * FROM ALBUM 
CROSS JOIN ARTIST;


--7.5
SELECT A.FIRSTNAME, B.FIRSTNAME FROM EMPLOYEE A , 
EMPLOYEE B WHERE A.REPORTSTO = B.EMPLOYEEID;

commit;