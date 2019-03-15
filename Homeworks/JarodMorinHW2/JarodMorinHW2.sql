---------------------------------------START OF SECTION 2---------------------------------------
---------------------------------------START OF SECTION 2---------------------------------------
---------------------------------------START OF SECTION 2---------------------------------------
-- Q2.1 T1
SELECT * FROM Employee;
-- Q2.1 T2
SELECT * FROM Employee WHERE lastname = 'King';
-- Q2.1 T3
SELECT * FROM Employee WHERE firstname = 'Andrew' AND REPORTSTO is NULL;
/
-- Q2.2 T1
SELECT * FROM Album
ORDER BY title DESC;
-- Q2.2 T2
SELECT FirstName FROM Customer
ORDER BY city;
/
-- Q2.3 T1
INSERT INTO Genre (GenreId, Name) VALUES (26, 'Dubstep');
INSERT INTO Genre (GenreId, Name) VALUES (27, 'Trance');
-- Q2.3 T2
INSERT INTO Employee (EmployeeId, LastName, FirstName) VALUES (9, 'Sue','Mary');
INSERT INTO Employee (EmployeeId, LastName, FirstName) VALUES (10, 'Stu','Gary');
-- Q2.3 T3
INSERT INTO Customer (CustomerId, LastName, FirstName, Email) VALUES (60, 'Sue','Mary','Mary.Sue@email.com');
INSERT INTO Customer (CustomerId, LastName, FirstName, Email) VALUES (61, 'Stu','Gary','Gary.Stu@email.com');
/
-- Q2.4 T1
UPDATE Customer
SET FirstName = 'Robert', LastName = 'Walter' 
WHERE FirstName = 'Aaron' AND LastName = 'Mitchell';
-- Q2.4 T2
UPDATE Artist
SET Name = 'CCR'
WHERE Name = 'Creedence Clearwater Revival';
/
-- Q2.5
SELECT * FROM invoice
WHERE billingAddress LIKE 'T%'; 
/
-- Q2.6 T1
SELECT * FROM invoice
WHERE   total BETWEEN 15 AND 50;
-- Q2.6 T2
SELECT * FROM Employee
WHERE HireDate BETWEEN TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') AND TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
/
-- Q2.7
DELETE FROM InvoiceLine -- Delete all invoicelines that correspond to any invoiceid that corresponds to any robert walter's customer id
WHERE InvoiceID IN
(SELECT InvoiceID FROM Invoice
WHERE CustomerId IN
(SELECT CustomerId FROM Customer
WHERE LastName = 'Walter' AND FirstName = 'Robert'
));

DELETE FROM Invoice -- Delete all invoices that corespond to any robert walter's customer id
WHERE CustomerId IN
(SELECT CustomerId FROM Customer
WHERE LastName = 'Walter' AND FirstName = 'Robert'
);

DELETE  -- Delete all Robert Walters from customer now that all children have been removed
FROM Customer
WHERE LastName = 'Walter' AND FirstName = 'Robert';
rollback;
/
---------------------------------------START OF SECTION 3---------------------------------------
---------------------------------------START OF SECTION 3---------------------------------------
---------------------------------------START OF SECTION 3---------------------------------------
-- Q3.1 T1
CREATE OR REPLACE FUNCTION get_time
RETURN VARCHAR2
IS time_result VARCHAR2(50);
BEGIN
    SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS') "NOW" INTO time_result
    FROM DUAL;
    RETURN time_result;
END;
/
SELECT get_time FROM DUAL;
/
-- Q3.1 T2
CREATE OR REPLACE FUNCTION get_media_type_length(media_id IN NUMBER)
RETURN NUMBER
IS length_result NUMBER(5);
BEGIN
    SELECT LENGTH(name) INTO length_result 
    FROM mediatype
    WHERE mediaTypeId = media_id;
    DBMS_OUTPUT.PUT_LINE('Length is: ' || length_result);
    RETURN length_result;
END;
/
DECLARE
    mediatype_length NUMBER;
BEGIN
    mediatype_length := get_media_type_length(2);
END;
/
-- Q3.2 T1
CREATE OR REPLACE FUNCTION get_invoice_total_avg
RETURN NUMBER
IS avg_result NUMBER(5);
BEGIN
    SELECT AVG(total) INTO avg_result 
    FROM invoice;
    DBMS_OUTPUT.PUT_LINE('Avg is: ' || avg_result);
    RETURN avg_result;
END;
/
DECLARE
    invoice_avg NUMBER(3); 
BEGIN
    invoice_avg := get_invoice_total_avg();
END;
/
-- Q3.2 T2
CREATE OR REPLACE FUNCTION get_priciest_track
RETURN NUMBER
IS max_result NUMBER(3,2);
BEGIN
    SELECT MAX(UnitPrice) INTO max_result 
    FROM Track;
    DBMS_OUTPUT.PUT_LINE('Max price is: ' || max_result);
    RETURN max_result;
END;
/
DECLARE
    track_numba NUMBER(5,2); 
BEGIN
    track_numba := get_priciest_track();
END;
/
-- Q3.3
CREATE OR REPLACE FUNCTION get_average_price
RETURN NUMBER
IS avg_result NUMBER(3,2); temp_var NUMBER(3,2);
BEGIN
    SELECT AVG(UnitPrice) INTO avg_result 
    FROM Track;
    DBMS_OUTPUT.PUT_LINE('Avg price is: ' || avg_result);
    RETURN avg_result;
END;
/
DECLARE
    avg_price NUMBER(5,2); 
BEGIN
    avg_price := get_average_price();
END;
/
-- Q3.4
CREATE OR REPLACE FUNCTION emp_born_after
RETURN SYS_REFCURSOR
IS cursor_result SYS_REFCURSOR;
BEGIN
   OPEN cursor_result FOR
   SELECT EmployeeId, LastName, FirstName FROM Employee
   WHERE BirthDate > '31-DEC-68';
   RETURN cursor_result;
END;
/
SELECT emp_born_after FROM DUAL;
/
---------------------------------------START OF SECTION 4---------------------------------------
---------------------------------------START OF SECTION 4---------------------------------------
---------------------------------------START OF SECTION 4---------------------------------------
-- Q4.1
CREATE OR REPLACE PROCEDURE first_and_last
AS temp_var SYS_REFCURSOR;
BEGIN
  OPEN temp_var FOR
  SELECT FirstName, LastName FROM Employee;
  DBMS_SQL.RETURN_RESULT(temp_var);
END;
/
BEGIN
  first_and_last();
END;
/
-- Q4.2 T1
savepoint save421;
CREATE OR REPLACE PROCEDURE update_personal_info(firstnamey VARCHAR2, lastnamey VARCHAR2)
AS
BEGIN
  UPDATE Employee
  SET FirstName='JOE', LastName='BOB'
  WHERE FirstName = firstnamey AND LastName = lastnamey;
END;
/
BEGIN
  update_personal_info('Andrew','Adams');
  first_and_last(); -- Displaying employee names after update_personal_info shows BOB JOE instead of Andrew Adams.
END;
rollback;
/

-- Q4.2 T2
CREATE OR REPLACE PROCEDURE get_boss(emp_id NUMBER)
AS temp_var SYS_REFCURSOR;
BEGIN
  OPEN temp_var FOR
  SELECT b.LastName, b.FirstName FROM Employee a, Employee b
  WHERE b.EmployeeId = a.ReportsTo AND a.EmployeeId = emp_id;
  DBMS_SQL.RETURN_RESULT(temp_var);
END;
/
BEGIN
  get_boss(6);  -- Gets first + last name of emplid whose id corresponds to the reportsto of the employee with the given ID, so #6 Michael Mitchell's boss is Andrew Adams, the result
END;
/

-- Q4.3
CREATE OR REPLACE PROCEDURE get_name_and_comp(cust_id NUMBER)
AS temp_var SYS_REFCURSOR;
BEGIN
  OPEN temp_var FOR
  SELECT Company, LastName, FirstName FROM Customer
  WHERE CustomerId = (SELECT CustomerId FROM Customer WHERE CustomerId = cust_id);
  DBMS_SQL.RETURN_RESULT(temp_var);
END;
/
BEGIN
  get_name_and_comp(5);
END;
/
SELECT * FROM Customer WHERE CustomerId = 5;

---------------------------------------START OF SECTION 5---------------------------------------
---------------------------------------START OF SECTION 5---------------------------------------
---------------------------------------START OF SECTION 5---------------------------------------
-- Q5.0 T1
savepoint save501;
CREATE OR REPLACE PROCEDURE invoice_delete (invoice_id NUMBER)
IS
BEGIN
    DELETE FROM InvoiceLine -- Delete all invoicelines that correspond to given invoiceid
    WHERE InvoiceId = invoice_id;

    DELETE FROM Invoice -- Delete invoice that corresponds to given invoiceid
    WHERE InvoiceId = invoice_id;
END;

/
BEGIN
    invoice_delete(5);
END;
/
rollback;
/

-- Q5.0 T2
CREATE OR REPLACE PROCEDURE cust_insert
IS
BEGIN
    INSERT INTO Customer (CustomerId, LastName, FirstName, Email) VALUES (81, 'Stu','Gary','Gary.Stu@email.com');
END;

/
BEGIN
    cust_insert();
END;
/
SELECT * FROM Customer WHERE CustomerId = 81;       -- It worked!
/
---------------------------------------START OF SECTION 6---------------------------------------
---------------------------------------START OF SECTION 6---------------------------------------
---------------------------------------START OF SECTION 6---------------------------------------
-- Q6.1 T1
-- I made this Flags table for use with triggers, its contents will only be altered through triggers
-- Any records present inside Flags indicate that a trigger has occurred
CREATE TABLE Flags(
Flag1 NUMBER(6),
Flag2 NUMBER(6)
);

CREATE OR REPLACE TRIGGER after_emp_insert_trigger
AFTER INSERT ON Employee
FOR EACH ROW
BEGIN
    INSERT INTO Flags (Flag1, Flag2) VALUES (1,2);
END;
/
/* Trigger above
Inserts new record in table Flags with values (1,2) whenever a record is inserted into employee
The following functions let me test insertions and clear the results of these insertions
*/
INSERT INTO Employee (EmployeeId, LastName, FirstName) VALUES (21, 'Stu','Gary'); 
SELECT * FROM Flags;
DELETE FROM FLAGS;
DELETE FROM Employee WHERE EmployeeId > 10;

-- Q6.1 T2
savepoint save612;
CREATE OR REPLACE TRIGGER after_album_update_trigger
AFTER UPDATE ON Album
FOR EACH ROW
BEGIN
    INSERT INTO Flags (Flag1, Flag2) VALUES (3,4);
END;
/

UPDATE Album
SET  title = 'Stu'
WHERE albumID = 1;
SELECT * FROM Flags;    -- Flag 3,4 appears in selection due to trigger after album update
DELETE FROM FLAGS;
rollback;

-- Q6.1 T3
savepoint save613;
CREATE OR REPLACE TRIGGER after_customer_delete_trigger
AFTER DELETE ON Customer
FOR EACH ROW
BEGIN
    INSERT INTO Flags (Flag1, Flag2) VALUES (5,6);
END;
/
INSERT INTO Customer (CustomerId,LastName,FirstName,email) VALUES(32,'Walter','Robert','wally@email.com');


DELETE  -- Adding Robert to delete him, trigger fires and inserts 5,6 into Flags
FROM Customer
WHERE LastName = 'Walter' AND FirstName = 'Robert';

SELECT * FROM Flags;    -- Flag 3,4 appears in selection due to trigger after album update
DELETE FROM FLAGS;
rollback;

---------------------------------------START OF SECTION 7---------------------------------------
---------------------------------------START OF SECTION 7---------------------------------------
---------------------------------------START OF SECTION 7---------------------------------------
-- Q7.1
SELECT Customer.FirstName, invoiceId 
FROM Customer
INNER JOIN Invoice
ON Customer.Customerid = Invoice.customerId;

-- Q7.2
SELECT Customer.CustomerId, Customer.FirstName, Customer.LastName, Invoice.InvoiceId, Invoice.Total
FROM Customer
FULL OUTER JOIN Invoice
ON Customer.CustomerId = Invoice.CustomerId;

-- Q7.3
SELECT Album.title, Artist.Name 
FROM Album
RIGHT JOIN Artist
ON Album.ArtistId = Artist.ArtistId;

-- Q7.4
SELECT Album.title, Artist.Name
FROM Album 
CROSS JOIN Artist
ORDER BY Artist.Name;

-- Q7.5
SELECT b.FirstName,b.LastName,b.ReportsTo,a.FirstName,a.LastName FROM Employee a, Employee b
WHERE a.EmployeeId = b.ReportsTo;
