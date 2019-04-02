--Task – Select all invoices with a billing address like “T%”
SELECT*FROM Invoice
WHERE BillingAddress LIKE 'T%';
