--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM Customer
WHERE FirstName='Robert' AND Lastname='Walter';