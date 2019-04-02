--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT FirstName, LastName, InvoiceId
FROM Customer
INNER JOIN Invoice
ON Customer.CustomerId = Invoice.CustomerId;
/*
SELECT FirstName
FROM Customer
WHERE Customer.CustomerId=Invoice.CustomerId;
DBMS_OUTPUT.PUT_LINE(Customer.CustomerId);
*/
