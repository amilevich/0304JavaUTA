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
