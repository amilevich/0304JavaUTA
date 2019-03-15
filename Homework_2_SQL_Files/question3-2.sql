--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION InvoiceAvgTotalFunction
RETURN NUMBER
IS avgDummy NUMBER;
BEGIN
    SELECT AVG(Total)
    INTO avgDummy
    FROM Invoice;
    --WHERE InvoiceId=1;
    
    RETURN avgDummy;
END;
/

SELECT InvoiceAvgTotalFunction FROM DUAL;


--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION mostExpensiveTrackFunction
RETURN VARCHAR
IS expensiveDummy VARCHAR(100);
BEGIN
    SELECT MAX(UnitPrice)
    INTO expensiveDummy
    FROM Track;
    --WHERE MediaTypeId=1;
    
    RETURN expensiveDummy;
END;
/

SELECT mostExpensiveTrackFunction FROM DUAL;


