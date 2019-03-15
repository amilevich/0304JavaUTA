----2.1
--part 1
select*from Employee;

--part 2
select*from Employee 
WHERE LastName = 'King';

--part 3
select*from Employee 
WHERE FirstName = 'Andrew' 
AND ReportsTo IS Null;
--
----2.2
--part 1
select*from Album 
ORDER BY title DESC;

--part 2
select FirstName from customer 
ORDER BY City;

--2.3

--part 1
INSERT INTO Genre VALUES (26, 'Jopera');
INSERT INTO Genre VALUES (27, 'Korean Fuzz-dub');

--part 2
INSERT INTO Employee VALUES (9, 'Deane', 'Julius', 'Flatline', 3, TO_DATE('1978-10-31 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-4-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), '36 Tesser Ashpool Plaza', 'Chiba City', 'Chiba', 'Japan', '3MP-505', '921-345-6724', Null, 'Julius_Deane@gmail.com');
INSERT INTO Employee VALUES (10,'Case', 'Henry', 'Cowboy', 2, TO_DATE('1979-12-22 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-4-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), '111 Marcus Street', 'Florence', 'Tuscany', 'Italy', '244-5TY', '329-212-6734', Null, 'Henry_Case@gmail.com');

--part 3
INSERT INTO Customer VALUES(61, 'Porpoise', 'Mandalay', 'Mandalay Enterprises', '31 Avenue Pavenue', 'Japavenue', 'Tavenue', 'Bavanue', 'I7-IU5-098', '327-495-6857', '218-2118-2128', 'Porpoiseguy@gmail.com', 2);
INSERT INTO Customer VALUES(62, 'Terry', 'Bananaboy', 'Banana Boy Industries', '22 Gorgonzoli', 'Machu Picju', 'Tina', 'Regina', 'I7-IU5-098', '327-495-6857', '218-2118-2128', 'beenbanannaboyin@gmail.com', 2);

--2.4

--part 1
UPDATE Customer SET FirstName = 'Robert' WHERE CustomerId = 32;
UPDATE Customer SET LastName = 'Walter' WHERE CustomerId = 32;

--part 2
UPDATE Artist SET Name = 'CCR' WHERE ArtistId = 76;

--2.5

SELECT*FROM Invoice
WHERE BillingAddress
LIKE 'T%';

--2.6


SELECT*FROM invoice
WHERE Total 
BETWEEN 15 AND 50;

SELECT*FROM Employee
WHERE HireDate
BETWEEN '1-JUN-03' AND '1-MAR-04';


--2.7

DELETE FROM InvoiceLine WHERE InvoiceId IN(SELECT InvoiceId FROM Invoice WHERE CustomerId IN (SELECT CustomerId FROM Customer WHERE FirstName = 'Robert' AND LastName = 'Walter'));

DELETE FROM Invoice WHERE CustomerId IN
(SELECT CustomerId FROM Customer WHERE FirstName = 'Robert' AND LastName = 'Walter');

DELETE FROM Customer WHERE FirstName = 'Robert' AND LastName = 'Walter';


--3.1

CREATE OR REPLACE FUNCTION get_time
RETURN VARCHAR2
is this_time VARCHAR2(50);
begin
    select TO_CHAR (sysdate, 'MM-DD-YYYY HH24:MI:SS')  into this_time from dual;
    return this_time;
end;
/
select get_time FROM DUAL;
--
--
--
--
--
--3.1 part 2

CREATE OR REPLACE FUNCTION ret_length
RETURN INT
is this_int INT(3);
begin
    select length(NAME) into this_int from mediatype 
    where rownum = 1;
    return this_int;
end;
select ret_length from DUAL;

--3.2 part 1
CREATE OR REPLACE FUNCTION avg_invoices
RETURN NUMBER
is invoice_avg NUMBER(5,3);
begin 
    select avg(Total) into invoice_avg from Invoice;
    
    return invoice_avg;
    end;
    select avg_invoices from dual;
--3.2 part 2
CREATE OR REPLACE FUNCTION unit_max_func
RETURN NUMBER
is unit_max NUMBER(5,3);
begin 
    select max(UnitPrice) into unit_max from Track;
    
    return unit_max;
    end;
    select unit_max_func from dual;

--3.3
CREATE OR REPLACE FUNCTION invoiceline_fun
RETURN NUMBER
is invoice_line_temp NUMBER(5,3);
begin 
    select avg(UnitPrice) into invoice_line_temp from InvoiceLine;
    
    return invoice_line_temp;
    end;
    select invoiceline_fun from dual;
    
--3.4

CREATE OR REPLACE FUNCTION birth_date
Return SYS_REFCURSOR
AS tempdate SYS_REFCURSOR;
BEGIN
    OPEN tempdate FOR 
    SELECT FirstName, LastName FROM Employee WHERE Birthdate > ('1-JAN-68') ;
    RETURN tempdate; 
    END;
SELECT birth_date FROM Dual;
    


--4.1

CREATE OR REPLACE PROCEDURE firstandlast
AS 
var1 SYS_REFCURSOR;
Begin
Open var1 FOR
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
DBMS_SQL.RETURN_RESULT(var1);
END;
/
exec firstandlast;
/

--4.2 (part 1)
CREATE OR REPLACE PROCEDURE proc_K
(
var1 VARCHAR2, var2 VARCHAR2, var3 VARCHAR2, var4 VARCHAR2, var5 VARCHAR2
)
IS
BEGIN
   UPDATE EMPLOYEE SET FIRSTNAME = var1,
   EMAIL = var2,
   PHONE = var3,
   COUNTRY = var4
   WHERE FIRSTNAME = var5;
END;
/
exec proc_K('Timmy', 'tim@gmail.com', '8383838384', 'timmyland','Laura');
SELECT*FROM Employee;
/


END;

--4.2 (Part 2)
CREATE OR REPLACE PROCEDURE ManagerRet
(
x1 VARCHAR2, x2 VARCHAR2
)
AS
var1 SYS_REFCURSOR;
Begin
Open var1 FOR
SELECT FirstName, LastName FROM Employee
WHERE EmployeeId = (SELECT ReportsTo FROM Employee WHERE FirstName = x1 AND LastName = x2);
DBMS_SQL.RETURN_RESULT(var1);
END;
/
exec ManagerRet( 'Jane', 'Peacock');
/
END;




--4.3

CREATE OR REPLACE PROCEDURE namcompproc(
z1 NUMBER)
AS var21 SYS_REFCURSOR;
BEGIN
OPEN var21 FOR
SELECT FirstName, LastName, Company FROM customer
     WHERE customerid = (SELECT CustomerId FROM Customer WHERE CustomerId = z1);
     DBMS_SQL.RETURN_RESULT(var21);
END;
/
exec namcompproc(5);
/







--5.0

--Task 1

DELETE FROM InvoiceLine WHERE InvoiceId IN(SELECT InvoiceID FROM Invoice WHERE InvoiceId = 68);
SAVEPOINT yossavepoint;
RollBACK;


--TASK 2
CREATE OR REPLACE PROCEDURE Barry
IS
BEGIN
    INSERT INTO Customer VALUES(63, 'Barry', 'Tannanentooler', 'Mr Mustapheles', '21 windywinderseon', 'Intmepsistwo', 'Sheena', 'Bambina', 'I7-IU5-391', '327-595-6857', '218-2148-2128', 'beenbanannaboyingg@gmail.com', 2);
END;

/
BEGIN
    Barry();
END;
/
SELECT*FROM Customer;


--6.1 part 1

CREATE OR REPLACE TRIGGER triggeryos
AFTER INSERT ON Employee
FOR EACH ROW 
BEGIN
INSERT INTO Genre(GenreId, Name)VALUES(30, 'Garbo Rock');
END;

--INSERT INTO Employee (EmployeeId, FirstName, LastName)VALUES(45, 'Jackson', 'Johnsons'); Proof that the trigger works.


--6.1 part 2


CREATE OR REPLACE TRIGGER triggeryos2
AFTER UPDATE ON Album
FOR EACH ROW 
BEGIN
INSERT INTO Genre(GenreId, Name)VALUES(31, 'Pollo Folk');
END;

--6.1 part 3

CREATE OR REPLACE TRIGGER triggeryos2
AFTER DELETE ON Customer
FOR EACH ROW 
BEGIN
INSERT INTO Genre(GenreId, Name)VALUES(32, 'Poo Poo');
END;

--7.1

SELECT CUSTOMER.FIRSTNAME, invoiceId
From Customer
INNER JOIN Invoice
ON Customer.Customerid = Invoice.customerId;

--7.2

SELECT CUSTOMER.FIRSTNAME, invoiceId
From Customer
INNER JOIN Invoice
ON Customer.Customerid = Invoice.customerId;

--7.3
SELECT CUSTOMER.FirstName, Customer.LastName, Customer.CustomerId, Invoice.InvoiceId
FROM Customer 
FULL OUTER JOIN INVOICE
ON Customer.CustomerId = Invoice.InvoiceId
ORDER BY Customer.FirstName;

--7.4
SELECT Customer.CustomerId, Invoice.InvoiceId
FROM Customer
CROSS JOIN Invoice;

--7.5
SELECT*FROM Employee a, Employee b
WHERE a.ReportsTo = b.EmployeeId;




    








    
    


--
--
--
--
--
--
--
--
--
--
--
--
--
--
--
--
--
--
--
--
--
