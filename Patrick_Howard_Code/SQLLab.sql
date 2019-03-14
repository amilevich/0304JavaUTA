2.1.1
SELECT * FROM Employee;
2.1.2
SELECT * FROM Employee WHERE LASTNAME = 'King';
2.1.3
SELECT * FROM Employee WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
2.2.1
SELECT * FROM Album ORDER BY TITLE DESC;
2.2.2
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;
2.3.1
SELECT * FROM Genre;
INSERT INTO Genre (GENREID,NAME) VALUES (26, 'Dancing');
INSERT INTO Genre (GENREID,NAME) VALUES (27, 'Singing');
2.3.2
SELECT * FROM Employee;
INSERT INTO employee (employeeid,lastname,firstname) VALUES (9,'Howard','Patrick');
INSERT INTO employee (employeeid,lastname,firstname) VALUES (10,'Woodward','Barney');
2.3.3
SELECT * FROM Customer;
INSERT INTO Customer (customerid,lastname,firstname,email) VALUES (60,'Garfield','Jerry','garfieldj@chinook.com');
INSERT INTO Customer (customerid,lastname,firstname,email) VALUES (61,'Rudy','Karol','krudy@chinook.com');
2.4.1
UPDATE Customer SET FIRSTNAME = 'Robert',LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
2.4.2
UPDATE Artist SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';
2.5
SELECT * FROM Invoice WHERE BillingAddress LIKE 'T%';
2.6.1
SELECT * FROM Invoice WHERE Total BETWEEN 15 AND 50;
2.6.2
SELECT * FROM Employee WHERE HireDate BETWEEN TO_DATE('2003-06-01','YYYY-MM-DD') AND TO_DATE('2004-03-01','YYYY-MM-DD');
2.7
SELECT * FROM InvoiceLine WHERE InvoiceID IN (342,50,61,116,245,268,290);
SELECT * FROM Invoice WHERE CustomerID = 32;
DELETE FROM InvoiceLine WHERE InvoiceID IN (342,50,61,116,245,268,290);
DELETE FROM Invoice WHERE CustomerID = 32;
DELETE FROM Customer Where FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

3.1.1
CREATE OR REPLACE FUNCTION CURRENTTIME 
RETURN VARCHAR2
IS timeString VARCHAR2(10);
BEGIN
    SELECT TO_CHAR(CURRENT_DATE, 'HH:MI:SS') INTO timeString() FROM DUAL;
    RETURN (timeString);
END;
SELECT CURRENTTIME() FROM DUAL;


3.1.2
SELECT * FROM MediaType;
CREATE OR REPLACE FUNCTION MEDIALENGTH 
RETURN NUMBER
IS StringLength NUMBER(4);
BEGIN
    SELECT LENGTH(name) INTO StringLength FROM MediaType WHERE mediatypeid = 4;
  RETURN (StringLength);
END;
SELECT MEDIALENGTH() FROM DUAL;

3.2.1
CREATE OR REPLACE FUNCTION AVGINVOICE 
RETURN NUMBER
IS InvoiceAvg NUMBER(12,2);
BEGIN
    SELECT AVG(Total) INTO InvoiceAvg FROM Invoice;
  RETURN (InvoiceAvg);
END;
SELECT AVGINVOICE() FROM DUAL;
3.2.2
CREATE OR REPLACE FUNCTION MOSTEXP 
RETURN VARCHAR2
IS Expensive VARCHAR2(50);
BEGIN
    SELECT Name INTO Expensive FROM Track GROUP BY Name ORDER BY MAX(UnitPrice) DESC
    OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY;
  RETURN (Expensive);
END;

SELECT MOSTEXP() FROM DUAL;

3.3
SELECT AVG(UNITPRICE) FROM INVOICELINE WHERE INVOICEID=362;

CREATE OR REPLACE FUNCTION AVGINVOICELINE(invID IN NUMBER) 
RETURN NUMBER
IS InvoiceAvg NUMBER(12,2);
BEGIN
    SELECT AVG(UNITPRICE) INTO InvoiceAvg FROM INVOICELINE WHERE INVOICEID=invID;
  RETURN (InvoiceAvg);
END;

SELECT AVGINVOICELINE(362) FROM DUAL;


3.4
-- Create an employee object 
CREATE OR REPLACE TYPE typ_emp AS OBJECT (
    FIRSTNAME VARCHAR2(20),
    LASTNAME VARCHAR2(20),
    BIRTDATE DATE
);
-- Create a collection table to hold results
CREATE OR REPLACE FUNCTION getEmps1968
RETURN tab_emp PIPELINED
AS
BEGIN
    FOR x IN (SELECT FIRSTNAME,LASTNAME,BIRTHDATE
            FROM EMPLOYEE 
            WHERE to_Char(BIRTHDATE, 'YY') > '68')
    LOOP
        PIPE ROW (typ_emp(x.FIRSTNAME,x.LASTNAME,x.BIRTHDATE));
    END LOOP;
END;

SELECT * FROM TABLE(getEmps1968());

4.1
SELECT FIRSTNAME,LASTNAME FROM Employee;

CREATE OR REPLACE PROCEDURE employee_sel(
   emp_names IN OUT sys_refcursor)
   IS
   BEGIN
     OPEN emp_names for
      SELECT FIRSTNAME,LASTNAME FROM Employee;
END;

-- execute procedure
var cur REFCURSOR
EXECUTE employee_sel(:cur);
print cur;

4.2.1
SELECT * FROM Employee;

CREATE OR REPLACE PROCEDURE employee_upd(empID NUMBER, newPostalCode VARCHAR2)
   AS
   BEGIN
     UPDATE Employee SET POSTALCODE = newPostalCode WHERE EMPLOYEEID = empID; 
END;
--Changed employeeid 5 zipcode to 77546
EXECUTE employee_upd(5,'77546');



4.2.2
SELECT * FROM Employee;
CREATE OR REPLACE PROCEDURE employee_mgr (empid NUMBER, prc out sys_refcursor)
IS
BEGIN
    open prc for
        SELECT M.FIRSTNAME,M.LASTNAME FROM EMPLOYEE M
        INNER JOIN EMPLOYEE E ON M.EMPLOYEEID = E.REPORTSTO 
        WHERE E.EMPLOYEEID=empid;
END;
var rc refcursor;
EXECUTE employee_mgr(2,:rc);
print rc;

4.3
SELECT * FROM CUSTOMER;

CREATE OR REPLACE PROCEDURE customer_company (custID NUMBER, prc out sys_refcursor)
IS
BEGIN
    open prc for
        SELECT C.FIRSTNAME,C.LASTNAME,C.COMPANY FROM CUSTOMER C
        WHERE C.CUSTOMERID=custID;
END;
var rc refcursor;
EXECUTE customer_company(10,:rc);
print rc;

5.0.1
SELECT * FROM Invoice;
CREATE OR REPLACE PROCEDURE invoice_del(invID NUMBER)
AS
BEGIN
    SAVEPOINT sp_start;
    DELETE FROM InvoiceLine WHERE InvoiceID = invID;
    DELETE FROM Invoice WHERE InvoiceID = invID;  
    EXCEPTION
      WHEN OTHERS THEN
        ROLLBACK TO sp_start;
     COMMIT;
END;
--Deleted invoice 329 from Invoice table
EXECUTE invoice_del(329);

5.0.2
SELECT * FROM Customer;
CREATE OR REPLACE PROCEDURE customer_ins(customerid NUMBER,lastname VARCHAR2,firstname VARCHAR2,email VARCHAR2)
AS
BEGIN
    SAVEPOINT sp_start;
    INSERT INTO Customer (customerid,lastname,firstname,email) VALUES (customerid,lastname,firstname,email);
    EXCEPTION
      WHEN OTHERS THEN
        ROLLBACK TO sp_start;
     COMMIT;
END;

--added customer 62 David Johnson djohnson@chinook.com
EXECUTE customer_ins(62,'Johnson','David','djohnson@chinook.com');

6.1.1
SELECT * FROM employee;
SELECT * FROM employees;

CREATE OR REPLACE TRIGGER employee_after_insert
AFTER INSERT
  ON employee
  FOR EACH ROW
BEGIN
    INSERT INTO employees
  (e_id,e_name,e_salary,e_title)
  VALUES
  (:new.employeeid,:new.lastname,0,:new.title);
END;
--added Sarb 11 to employees(a new empty table)
INSERT INTO employee (employeeid,lastname,firstname) VALUES (11,'Sarb','Jilly');

6.1.2
SELECT * FROM album;
SELECT * FROM employees;
CREATE OR REPLACE TRIGGER albumafter
AFTER UPDATE
  ON Album
  FOR EACH ROW

BEGIN
    INSERT INTO employees
  ( e_id,e_salary)
  VALUES
  (:new.albumid,:new.artistid);
END;
--Changed album 5 to little ones
UPDATE Album SET TITLE = 'Little Ones' WHERE Albumid = 5;


SELECT * FROM customer;
SELECT * FROM employees;
CREATE OR REPLACE TRIGGER afterdelete
AFTER DELETE
  ON customer
  FOR EACH ROW
BEGIN
    INSERT INTO employees
  (e_id,e_name,e_salary,e_title)
  VALUES
  (:old.customerid,:old.lastname,0,:old.email
    );
END;
--Deleted customer number 60
DELETE FROM customer WHERE Customerid = 60;


7.1
SELECT c.Firstname,c.Lastname,i.invoiceid
FROM customer c
INNER JOIN invoice i
ON c.customerid = i.customerid;

7.2
SELECT c.customerid,c.Firstname,c.Lastname,i.invoiceid,i.total
FROM customer c
LEFT OUTER JOIN invoice i
ON c.customerid = i.customerid;

7.3
SELECT ar.name, al.title
FROM artist ar
RIGHT JOIN album al
ON ar.artistid = al.artistid;

7.4
SELECT ar.name
FROM artist ar
CROSS JOIN album al
ORDER BY ar.name;

7.5
SELECT m.firstname,m.lastname ,e.firstname,e.lastname
FROM employee m
INNER JOIN employee e ON m.employeeID = E.ReportsTo;
