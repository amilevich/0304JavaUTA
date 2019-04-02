--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT Name, Title
FROM Album
RIGHT JOIN Artist
ON Album.ArtistId = Artist.ArtistId
ORDER BY Album.ArtistId;
--right join