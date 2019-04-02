--Task – Insert two new records into Genre table
INSERT INTO Genre (GenreId, Name) VALUES (26, 'Gregorian Chants');
INSERT INTO Genre (GenreId, Name) VALUES (27, 'Anthems');

--Task – Insert two new records into Employee table
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Snow', 'Jon', 'Lord Commander', 1, TO_DATE('1996-8-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2019-3-11 00:00:00','yyyy-mm-dd hh24:mi:ss'), '998 Castle Black', 'Dallas', 'TX', 'USA', 'T5K 2N1', '+1 (780) 428-9482', '+1 (780) 428-3457', 'jon@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Lannister', 'Tyrion', 'Hand of the King', 2, TO_DATE('1996-8-2 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2019-3-11 00:00:00','yyyy-mm-dd hh24:mi:ss'), '123 Casterly Rock', 'Los Angeles', 'CA', 'USA', 'T5K 2N1', '+1 (780) 428-9482', '+1 (780) 428-3457', 'tyrion@chinookcorp.com');

--Task – Insert two new records into Customer table
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (60, 'Daenerys', 'Targaryen', 'Golden Co.', '123 Pyramid St', 'Dallas', 'TX', 'USA', '14700', '+420 2 4172 5555', '+420 2 4172 5555', 'dany@golden.com', 4);
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (61, 'Eddard', 'Stark', 'Microsoft', '456 Burned Tower St', 'Los Angeles', 'CA', 'USA', '14700', '+420 2 4172 5555', '+420 2 4172 5555', 'ned@microsoft.com', 4);
