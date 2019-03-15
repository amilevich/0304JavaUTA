--SQL lab: Genevieve Wood

--2.1 SELECT
--Task 1
SELECT * FROM Employee;

--Task 2
SELECT * FROM Employee WHERE LastName =  'King'; 

--Task 3
SELECT * FROM Employee WHERE firstName =  'Andrew'  AND reportsto  IS NULL;

--2.2 ORDER BY
--Task 1
SELECT * FROM Album  ORDER BY Title DESC;

--Task 2
SELECT firstName FROM Customer ORDER BY City ASC;

--2.3 INSERT INTO
--Task 1
INSERT INTO Genre (GenreId, Name) VALUES (26, 'EDM');
INSERT INTO Genre (GenreId, Name) VALUES (27, 'R&B');

--Task 2
INSERT INTO Employee  VALUES (9, 'Radford', 'Timmy', 'IT Staff', 6, TO_DATE('1969-1-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-4-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 Fairy Lane', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 477-3351', '+1 (403) 477-8772', 'timmy@chinookcorp.com');
INSERT INTO Employee  VALUES (10, 'Bradford', 'Ashley', 'Sales Support Agent', 2, TO_DATE('1969-2-15 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-5-16 00:00:00','yyyy-mm-dd hh24:mi:ss'), '1041 Trample Lane', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 455-3351', '+1 (403) 455-8772', 'ashleyB@chinookcorp.com');

--Task 3
INSERT INTO Customer  VALUES (60, 'Hart', 'Hailey', '1041 Tree Lane', 'Fort Worth', 'USA', '76131', '+91 080 22279999', 'hailey_hart@yahoo.com', 4);
INSERT INTO Customer  VALUES (61, 'Tiny', 'Tina', '1043 Creek Lane', 'Fort Worth', 'USA', '76131', '+91 080 21279999', 'tiny_tina@yahoo.com', 3);

--2.4 UPDATE
--Task 1
UPDATE Customer SET firstName = 'Robert', lastName = 'Walter'
WHERE CustomerId = 32;

--Task 2
UPDATE Artist SET Name = 'CCR'
WHERE ArtistId = 76;

--2.5 LIKE
--Task 1
SELECT * FROM Invoice
WHERE BillingAddress LIKE 'T%';

--2.6 BETWEEN
--Task 1 
SELECT * FROM Invoice WHERE Total BETWEEN 15 AND 50;

--Task 2
SELECT * FROM Employee WHERE HireDate BETWEEN DATE '2003-06-01' AND Date '2004-03-01';

--2.7 DELETE
--Task 1
ALTER TABLE invoice DISABLE CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM Customer WHERE CustomerId = 32;

--3.0 SQL Functions
--3.1 System Defined Functions
--Task 1
CREATE OR REPLACE FUNCTION get_current_time
RETURN TIMESTAMP
IS
    current_time TIMESTAMP;
BEGIN
    SELECT LOCALTIMESTAMP
    INTO current_time
    FROM dual;
    RETURN current_time;
END;
/
DECLARE
 current_time TIMESTAMP;
BEGIN
    current_time := get_current_time();
    DBMS_OUTPUT.PUT_LINE('current time:' || current_time);
END; 
/

--Task 2
CREATE OR REPLACE FUNCTION get_length_mediatype(media_type_id IN NUMBER)
RETURN NUMBER
IS
    media_name VARCHAR2(100);
    length_mediatype NUMBER;
BEGIN
    SELECT name 
    INTO media_name
    FROM mediatype
    WHERE mediatypeid = media_type_id;
     
    length_mediatype := LENGTH(media_name);
    RETURN length_mediatype;
END;
/
DECLARE
 length_mediatype NUMBER;
BEGIN
    length_mediatype := get_length_mediatype();
    DBMS_OUTPUT.PUT_LINE('length of mediatype:' || length_mediatype);
END; 
/
--3.2 System Defined Aggregate Functions 
--Task 1
CREATE OR REPLACE FUNCTION get_avg_invoice
RETURN NUMBER
IS
    avg_invoice NUMBER;
BEGIN
    SELECT AVG(Total) 
    INTO avg_invoice 
    FROM invoice;
    RETURN avg_invoice;
END;
/
DECLARE
    avg_invoice NUMBER;
BEGIN
    avg_invoice := get_avg_invoice();
    DBMS_OUTPUT.PUT_LINE('avg invoice is: ' || avg_invoice);
END;
/

--Task 2
CREATE OR REPLACE FUNCTION get_most_expensive
RETURN NUMBER
IS
    most_expensive NUMBER;
BEGIN
    SELECT MAX(Unitprice) 
    INTO most_expensive
    FROM track;
    RETURN most_expensive;
END;
/
DECLARE
    most_expensive NUMBER;
BEGIN
    most_expensive := get_most_expensive();
    DBMS_OUTPUT.PUT_LINE('most expensive: ' || most_expensive);
END;
/

--3.3 User Defined Scalar Functions
--Task 1
CREATE OR REPLACE FUNCTION get_avg_invoice_price
RETURN NUMBER
IS
    avg_price NUMBER;
BEGIN
    SELECT AVG(Unitprice) 
    INTO avg_price 
    FROM invoiceline;
    RETURN avg_price;
END;
/
DECLARE
    avg_price NUMBER;
BEGIN
    avg_price := get_avg_invoice_price();
    DBMS_OUTPUT.PUT_LINE('avg invoice price is: ' || avg_price);
END;
/

--3.4 User Defined Table Valued Functions
--Task 1
CREATE OR REPLACE FUNCTION get_employee_bdayafter_1968
RETURN SYS_REFCURSOR
IS
    bdayafter_1968 SYS_REFCURSOR;
BEGIN
    OPEN bdayafter_1968 FOR
    SELECT firstname, lastname
    FROM employee 
    WHERE birthdate > '31-DEC-68';
    RETURN bdayafter_1968;
END;
/
SELECT get_employee_bdayafter_1968() FROM dual;
/

--4.0 Stored Procedures
--4.1 Basic Stored Procedure
--Task 1
CREATE OR REPLACE PROCEDURE select_name_procedure
AS
employee_name SYS_REFCURSOR;
BEGIN
    OPEN employee_name FOR
    SELECT firstname, lastname
    FROM employee;
    DBMS_SQL.RETURN_RESULT(employee_name);
END;
/ 
EXECUTE select_name_procedure;

--4.2 Stored procedure input parameters
--Task 1
CREATE OR REPLACE PROCEDURE update_info_procedure
(
    emp_id IN NUMBER,
    address_update IN VARCHAR2,
    city_update IN VARCHAR2,
    state_update IN VARCHAR2,
    country_update IN VARCHAR2
)
IS 
BEGIN
    UPDATE employee
    
    SET
    address = address_update,
    city = city_update,
    state = state_update,
    country = country_update
    WHERE employeeid = emp_id;
END;
/

--Task 2
CREATE OR REPLACE PROCEDURE employee_reportsto
(
    emp_id IN NUMBER,
    reports OUT NUMBER
)
IS 
BEGIN
    SELECT reportsTo 
    INTO reports
    FROM employee
    WHERE employeeId = emp_id;
END;
/

--4.3 Stored procedure output parameter
--Task 1
CREATE OR REPLACE PROCEDURE get_name_company
(
    cust_id IN NUMBER,
    cust_name OUT VARCHAR2,
    cust_company OUT VARCHAR2)
IS
BEGIN
   
    SELECT firstname, company
    INTO cust_name, cust_company
    FROM customer
    WHERE customerid = cust_id; 
    
END;
/

--5.0 Transactions
--Task 1
CREATE OR REPLACE PROCEDURE delete_invoice
(
    id_invoice IN NUMBER
)
IS
BEGIN
    DELETE FROM invoiceline WHERE invoiceid = id_invoice;
    DELETE FROM invoice WHERE invoiceid = id_invoice;
END;
/

--Task 2



--6.0 Triggers
--Task 1
CREATE TRIGGER new_record_trigger
AFTER INSERT ON employee
BEGIN
    DBMS_OUTPUT.PUT_LINE('inserted');
END;
/

--Task 2
CREATE TRIGGER update_record_trigger
AFTER UPDATE ON album
BEGIN
    DBMS_OUTPUT.PUT_LINE('updated');
END;
/

--Task 3
CREATE TRIGGER delete_record_trigger
AFTER DELETE ON customer
BEGIN
    DBMS_OUTPUT.PUT_LINE('deleted');
END;
/

--7.0 Joins
--7.1 Inner
--Task 1
SELECT Customer.firstname, Invoice.invoiceid FROM Customer
INNER JOIN Invoice
ON Customer.customerid = invoice.customerid;

--7.2 Outer
--Task 1
SELECT Customer.firstname, Customer.lastname, Invoice.invoiceid, Invoice.total
FROM Customer
FULL OUTER JOIN Invoice
ON Customer.customerid = invoice.customerid
ORDER BY Customer.customerid;

--7.3 Right
--Task 1
SELECT Artist.name, Album.title
FROM Artist
RIGHT JOIN Album
ON Artist.artistid = Album.artistid
ORDER BY Artist.artistid; 

--7.4 Cross 
--Task 1
SELECT * FROM Artist
CROSS JOIN Album
ORDER BY Artist.name ASC;

--7.5 Self
--Task 1
SELECT a.firstname, b.firstname FROM employee a, employee b
WHERE a.reportsto = b.employeeid;














