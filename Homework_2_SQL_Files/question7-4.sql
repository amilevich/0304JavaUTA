--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT Name
FROM Album --Album table
CROSS JOIN Artist --Artist table
ORDER BY Album.AlbumId ASC;