--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
/*
CREATE OR REPLACE SEQUENCE my_Trigger
START WITH 150
INCREMENT BY 1;
/
*/
CREATE OR REPLACE TRIGGER my_Trigger_seq -- IF ALREADY CREATED, -- OR REPLACE WILL REPLACE THE TRIGGER
AFTER INSERT ON Employee -- 'BEFORE' OR 'AFTER'
FOR EACH ROW
BEGIN -- signigifies a block for a transaction
    DBMS_OUTPUT.PUT_LINE('Fire trigger now: Employee has been inserted');
END;
/
--INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Doe', 'John', 'General Manager', TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 428-9482', '+1 (780) 428-3457', 'andrew@chinookcorp.com');
--ROLLBACK;

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER my_Trigger2_seq -- IF ALREADY CREATED, -- OR REPLACE WILL REPLACE THE TRIGGER
AFTER UPDATE ON Album -- 'BEFORE' OR 'AFTER'
FOR EACH ROW
BEGIN -- signigifies a block for a transaction
    DBMS_OUTPUT.PUT_LINE('Fire trigger now: Album has been updated');
END;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER my_Trigger3_seq -- IF ALREADY CREATED, -- OR REPLACE WILL REPLACE THE TRIGGER
AFTER DELETE ON Customer -- 'BEFORE' OR 'AFTER'
FOR EACH ROW
BEGIN -- signigifies a block for a transaction
    DBMS_OUTPUT.PUT_LINE('Fire trigger now: Customer row has been deleted');
END;
/