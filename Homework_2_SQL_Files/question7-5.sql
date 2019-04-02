--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.FirstName, b.FirstName
FROM Employee a, Employee b
WHERE a.ReportsTo = b.EmployeeId;
