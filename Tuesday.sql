--THIS IS A SQL DEVELOPER COMMENT!
/*
THIS IS A SQL BLOCK COMMENT
*/

/*SUB LANGUAGES
DDL - DATA DEFINITION LANGUAGE
- CREATE
- ALTER
- DROP
- TRUNCATE

DML - DATA MANIPULATION LANGUAGE (CRUD OPERATIONS)
- INSERT  (CREATE)
- SELECT  (READ)
- UPDATE
- DELETE

DQL - DATA QUERY LANGUAGE
- SELECT

TCL - TRANSACTION CONTROL LANGUAGE
- COMMIT -> MUST PERFORM TO PERSIST DATA
- ROLLBACK -> ALLOWS U TO GO TO A PREVIOUS SAVEPOINT
- SAVEPOINT -> FLAGS, CAN GO BACK TO 

DCL - DATA CONTROL LANGUAGE
- GRANT
- REVOKE

TRANSACTIONS -> CHANGES MADE TO A DATABASE
TRANSACTIONS MUST BE ACID:
-ATOMIC -> ALL GOES OR NOTHING GOES AFTER COMMITING
-CONSISTENT -> DOES NOT VIOLATE REFERENTIAL INTEGRITY
-ISOLATED -> TRANSACTIONS SHOULD NOT INTERFERE WITH ONE ANOTHER
-DURABLE -> DATA PERSISTS, ONCE WRITTEN (COMMITTED), DATA WILL REMAIN IN THE DB

KEYS - ATTRIBUTE OR COLLECTION OF ATTRIBUTES THAT UNIQUELY IDENTIFY A RECORD
    - PRIMARY -> YOUR GO-TO TO UNIQUELY IDENTIFY A RECORD
    - FOREIGN -> PRIMARY KEY OF A DIFFERENT TABLE
    - COMPOSITE -> MORE THAN ONE ATTRIBUTE, SET OF ATTRIBUTES OR COLUMNS, THAT TOGETHER
                                    FORM A UNIQUE IDENTIFIER
                                    
REFERENTIAL INTEGRITY:
- THE ENFORCEMENT OF FOREIGN KEY RELATIONS. IT PREVENTS A USER FROM INSERTING
A RECORD INTO A TABLE WITH A FOREIGN KEY THAT POINTS TO A NON EXISTENT ELEMENT.
IT ALSO PREVENTS A USER FROM DELETING A RECORD THAT ANOTHER TABLE IS REFERENCING.
THIS IS ALL TO PREVENT ORPHAN RECORDS, IE. A RECORD WITHOUT A PARENT.

*/

CREATE TABLE animals (
    animal_id NUMBER(6) PRIMARY KEY,
    animal_name VARCHAR2(100),
    animal_leg_count NUMBER(3) CHECK (animal_leg_count > 1) NOT NULL
);

CREATE TABLE owners (
    owner_id NUMBER(6),
    owner_name VARCHAR2(100) NOT NULL,
    owner_address VARCHAR2(200),
    owner_height NUMBER(6),
    owner_age NUMBER(6),
    CONSTRAINT owner_id_pk PRIMARY KEY (owner_id)
);

SELECT * FROM animals;
SELECT * FROM owners;
SELECT * FROM pet_shop;
SELECT * FROM pets;

CREATE TABLE pet_shop(
    shop_id NUMBER(6),
    shop_name VARCHAR2(100) NOT NULL,
    shop_owner_id NUMBER(6),
    CONSTRAINT shop_id_pk PRIMARY KEY (shop_id),
    CONSTRAINT shop_owner_id_fk FOREIGN KEY (shop_owner_id) REFERENCES owners (owner_id) ON DELETE CASCADE
    );

CREATE TABLE pets (
    pet_id NUMBER(6),
    pet_name VARCHAR2(100),
    animal_id NUMBER(6),
    shop_id NUMBER(6),
    owner_id NUMBER(6),
    CONSTRAINT pet_id_pk PRIMARY KEY (pet_id),
    CONSTRAINT animal_id_fk FOREIGN KEY (animal_id) REFERENCES animals (animal_id) ON DELETE CASCADE,
    CONSTRAINT shop_id_fk FOREIGN KEY (shop_id) REFERENCES  pet_shop (shop_id) ON DELETE CASCADE,
    CONSTRAINT owner_id_fk FOREIGN KEY (owner_id) REFERENCES owners (owner_id) ON DELETE CASCADE
);

INSERT INTO animals (animal_id, animal_name, animal_leg_count) 
VALUES (1, 'Boris', 8);

--if you omit the column names, it will implicitly assume you are providing data for each column
-- in the order they appear in the table

INSERT INTO animals VALUES(2, 'Helga', 4);
INSERT INTO animals VALUES (3, 'Lilly', 6);
INSERT INTO animals VALUES(4, 'Joseph', 3);

SELECT * FROM animals;
--INSERT INTO animals(null, 'Joseph', 3); -- not valid due to PK constraint

--INSERT INTO animals (animal_id, animal_leg_count) VALUES (5,10);
-- ommiting a column name defaults the missing value to null

INSERT INTO owners VALUES(1, 'Bobbert', '1861 Bobbert St', 70, 81);
INSERT INTO owners VALUES(2, 'Yousef', '1234 Pizza Ave', 73, 18);
INSERT INTO owners VALUES(3, 'Ubbah', '8 Mountain Dr', 32, 6);
INSERT INTO owners VALUES(4, 'Tangerine', '12 Citrus Cir', 5, 13);
select * from owners;

INSERT INTO pet_shop VALUES(1, 'Yousef''s NOT pizza shop', 2);
INSERT INTO pet_shop VALUES(2, 'WallyWorld', 4);
select * from pet_shop;

INSERT INTO pets VALUES (1, 'ShoeDuck', 2,  2, 2);
INSERT INTO pets VALUES (2, 'Prince II', 4,  1, 3);
select * from pets;

-- WHERE CLAUSE
/*
 use a WHERE clause to apply any conditions to a CRUD operation
 */
 
 SELECT * FROM pets WHERE pet_id>1;
 DELETE FROM owners WHERE owner_id=3;
 
 -- UPDATE
 -- Used to change the data inside records
 
 UPDATE pets SET pet_name = 'Dogbert' WHERE LOWER(pet_name) = 'shoeduck';
 select * from pets;
 
 -- ALTER
 CREATE TABLE garbage(
 stuffs NUMBER(9)
 );
 
 INSERT INTO garbage VALUES(1);
 INSERT INTO garbage VALUES(2);
 INSERT INTO garbage VALUES(3);
 select * from garbage;
 
 ALTER TABLE garbage RENAME TO different_garbage;
 select * from different_garbage;
 
 ALTER TABLE different_garbage ADD CONSTRAINT check_con CHECK (stuffs>0);
 ALTER TABLE different_garbage DROP CONSTRAINT check_con;
 
 /*SQL DEVELOPER DOES NOT AUTO COMMIT DATA;
 YOU MUST USE COMMIT TO PERSIST DATA;
 */
 
 INSERT INTO animals VALUES (12, 'I won''t be around long...', 5);
 select * from animals;
 rollback;
 
 commit; --persist all data
 
 /* Difference between DELETE and TRUNCATE
 You can rollback a DELETE.
 You canNOT rollback a TRUNCATE.
 */
 
 DELETE FROM pets;
 rollback;
 select * from pets;
 
 TRUNCATE TABLE pets;
 rollback;
 
 CREATE TABLE garbageTwo (
 stuffsTwo NUMBER(8)
 );
 rollback;
 select * from garbageTwo;
 
 
 
 
 
 CREATE TABLE employees(
    e_id NUMBER(6) PRIMARY KEY,
    e_name VARCHAR2(100),
    e_salary NUMBER(9),
    e_title VARCHAR2(100)
);

INSERT INTO employees VALUES (1, 'Floki', 30000, 'Janitor');
INSERT INTO employees VALUES (2, 'Goku', 10000, 'Developer');
INSERT INTO employees VALUES (3, 'Joseph', 125000, 'Astronaut');
INSERT INTO employees VALUES (4, 'Yousef', 1000000 , 'PizzaMan');
INSERT INTO employees VALUES (5, 'John', 11000 , 'Developer');
INSERT INTO employees VALUES (6, 'Pam', 12000 , 'Developer');
INSERT INTO employees VALUES (7, 'Jacob', 30000, 'Janitor');

select * from employees;

/*
Aggregate functions
- is a function you apply to a column that will process all the data and return  a single value back. 
Example:
SUM()
AVG()
MAX()
MIN()
COUNT() <- used a lot
*/
SELECT COUNT(*) FROM employees;

-- Use AS to rename a column for a query
-- You MUST use quotation marks

SELECT COUNT(*) AS "Number of Employees" FROM employees;

-- In order to show multiple columns of data alongside an aggregate function, we need
-- to tell how we are going to group non matching data.
SELECT SUM(e_salary), e_title FROM employees 
GROUP BY e_title --> grouped the results by the title, no individual records
ORDER BY SUM(e_salary);  --> ascending by default; ORDER BY SUM(e_salary) DESC for descending order

/* 
    SCALAR FUNCTIONS
    - a function that applies to each cell of a column
    - e.g. Alters the value within each cell of a column
    LOWER() <-- makes a string lowercase
    UPPER()
    ABS() <-- absolute value
    ROUND() <-- rounds to the nearest whole number
    CONCAT()
    LENGTH()
    TRIM()
*/
SELECT UPPER(e_name), LOWER(e_title) FROM employees;

/*
    HAVING 
    - having is a conditional that can be applied to aggregate data
*/
SELECT SUM(e_salary), LOWER(e_title) FROM employees 
WHERE e_salary < 200000 
GROUP BY e_title
HAVING SUM(e_salary) > 15000
ORDER BY e_title;

SELECT e_title, e_salary FROM employees
ORDER BY e_title, e_salary DESC;

DROP TABLE employees;

/*
    LIKE
    - we use the LIKE clause to search for data that matches a sort of regular expression criteria.
    There are two wildcards that you can use:
    _ - ONE of any character
    % - zero-many of any character
    
*/
SELECT * FROM employees WHERE LOWER(e_name) LIKE 'p%';
-- all names that start with 'p', not case sensitive

SELECT * FROM employees WHERE LOWER(e_name) LIKE 'jo%e%p_';
-- all names that start with "jo", have a "e" appear before "p" and "p" will be the 2nd to last letter.

SELECT * FROM employees WHERE LOWER(e_name) LIKE '%a%';

 
