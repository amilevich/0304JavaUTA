--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE nameCompanyProcedure
AS
someCursor SYS_REFCURSOR;
BEGIN
    OPEN someCursor FOR
    SELECT FirstName, LastName, Company
    FROM Customer;
    
    DBMS_SQL.RETURN_RESULT(someCursor);
END;
/

--EXEC nameCompanyProcedure;
--SELECT*FROM Customer;