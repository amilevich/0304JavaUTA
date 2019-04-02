--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE firstNameLastNameProcedure --(myVar IN VARCHAR2)
AS
myCursor SYS_REFCURSOR; --cursor can store a whole table
BEGIN
    OPEN myCursor FOR
    SELECT FirstName, LastName
    FROM Employee;
    
    DBMS_SQL.RETURN_RESULT(myCursor);
END;
/

EXEC firstNameLastNameProcedure;

/*
CREATE OR REPLACE PROCEDURE firstnameLastnameProcedure(
firstnameString OUT VARCHAR2(20),
lastnameString OUT VARCHAR2(20)
)
IS
BEGIN
    SELECT Firstname, Lastname
    FROM Employee
    INTO firstnameString, lastnameString
    WHERE EmployeeId=1;
END;
--EXEC SelectAllCustomers;

--FROM Employee;
    --FROM Employee
    --WHERE Total BETWEEN 15 AND 50;

/*
CREATE OR REPLACE PROCEDURE firstLastEmployeeProcedure
IS
BEGIN
    SELECT*FROM Employee
    --WHERE FirstName='Andrew';
    --FROM Employee
    --WHERE FirstName='Andrew';
END;
/

DROP PROCEDURE firstLastEmployeeProcedure

SELECT*FROM Employee
*/