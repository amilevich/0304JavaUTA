/*
CREATE TABLE CustomerPet(
name VARCHAR2(50),
type VARCHAR2(50)
);
/
SELECT*FROM CustomerPet;
*/

CREATE TABLE CustomerTable( --This table contains APPROVED customers only
customerIndex NUMBER,
customerUsername VARCHAR(70), --Replaces blue "name"
customerPassword VARCHAR(70) --Replaces blue "type"
);
/
SELECT*FROM CustomerTable;
/
DROP TABLE CustomerTable;
/

CREATE TABLE MoneyTable(
customerIndex NUMBER,
customerUsername VARCHAR(70), --Replaces blue "name"
customerMoney NUMBER --Replaces blue "type"
);
/
SELECT*FROM MoneyTable;
/
DROP TABLE MoneyTable;
/

CREATE TABLE EmployeeTable( --This table contains APPROVED customers only
employeeIndex NUMBER,
employeeUsername VARCHAR(70), --Replaces blue "name"
employeePassword VARCHAR(70) --Replaces blue "type"
);
/
SELECT*FROM EmployeeTable;
/
DROP TABLE EmployeeTable;
/

CREATE TABLE AdminTable( --This table contains APPROVED customers only
adminIndex NUMBER,
adminUsername VARCHAR(70), --Replaces blue "name"
adminPassword VARCHAR(70) --Replaces blue "type"
);
/
SELECT*FROM AdminTable;
/
DROP TABLE AdminTable;
/