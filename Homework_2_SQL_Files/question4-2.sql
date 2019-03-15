--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE updateProcedure
AS
BEGIN
    UPDATE Employee
    SET LastName = 'Targaryen'
    WHERE LastName = 'Adams';
END;
/

--EXEC updateProcedure;
--SELECT*FROM Employee;

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE updateProcedure2
AS
managerCursor SYS_REFCURSOR;
BEGIN
    OPEN managerCursor FOR
    SELECT ReportsTo, FirstName
    FROM Employee;
    --WHERE ReportsTo = EmployeeId;
    
    DBMS_SQL.RETURN_RESULT(managerCursor);
END;
/

EXEC updateProcedure2;