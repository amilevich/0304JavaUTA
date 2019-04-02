--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE deleteProcedure(myInvoiceId IN NUMBER)
IS
BEGIN
    DELETE FROM InvoiceLine WHERE InvoiceId = myInvoiceId;
    DELETE FROM Invoice WHERE InvoiceId = myInvoiceId;
END;
/
EXEC deleteProcedure(2);
SELECT*FROM InvoiceLine;
SELECT*FROM Invoice;


--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insertProcedure(myCustomerId IN NUMBER, myFirstName IN VARCHAR2, myLastName IN VARCHAR2, myCompany IN VARCHAR2, myAddress IN VARCHAR2, myCity IN VARCHAR2, myState IN VARCHAR2, myCountry IN VARCHAR2, myPostalCode IN VARCHAR2, myPhone IN VARCHAR2, myFax IN VARCHAR2, myEmail IN VARCHAR2, mySupportRepId IN NUMBER)
IS
BEGIN
    INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (myCustomerId, myFirstName, myLastName, myCompany, myAddress, myCity, myState, myCountry, myPostalCode, myPhone, myFax, myEmail, mySupportRepId);
END;
/
EXEC insertProcedure(60, 'Luís', 'Gonçalves', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);
