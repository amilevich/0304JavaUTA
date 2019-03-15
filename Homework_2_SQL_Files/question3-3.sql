CREATE OR REPLACE FUNCTION InvoiceLineAvgPriceFunction
RETURN NUMBER
IS avgPriceDummy NUMBER;
BEGIN
    SELECT AVG(UnitPrice)
    INTO avgPriceDummy
    FROM InvoiceLine;
    --WHERE InvoiceId=1;
    
    RETURN avgPriceDummy;
END;
/

SELECT InvoiceLineAvgPriceFunction FROM DUAL;
