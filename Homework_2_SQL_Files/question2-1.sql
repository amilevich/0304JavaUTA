--Task – Select all records from the Employee table.
SELECT*FROM Employee;

--Task – Select all records from the Employee table where last name is King.
SELECT*FROM Employee
WHERE LASTNAME='King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
SELECT*FROM Employee
WHERE FIRSTNAME='Andrew'
 AND REPORTSTO=NULL;