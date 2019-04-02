--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT FirstName, LastName, InvoiceId, Total
FROM Customer
FULL OUTER JOIN Invoice
ON Customer.CustomerId = Invoice.CustomerId;