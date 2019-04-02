--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer
SET FirstName='Robert'
WHERE FirstName='Aaron';

UPDATE Customer
SET LastName='Walter'
WHERE LastName='Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist
SET Name='CCR'
WHERE Name='Creedence Clearwater Revival';