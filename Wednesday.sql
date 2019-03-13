CREATE TABLE TA(
    nums NUMBER(6),
    chars VARCHAR2(10)
);

CREATE TABLE TB(
    nums NUMBER(6),
    otherchars VARCHAR2(10)
);

INSERT INTO TA VALUES (1, 'a');
INSERT INTO TA VALUES (2, 'b');
INSERT INTO TA VALUES (3, 'c');
INSERT INTO TA VALUES (4, 'd');

INSERT INTO TB VALUES(3, 'C');
INSERT INTO TB VALUES(4, 'D');
INSERT INTO TB VALUES(5, 'E');
INSERT INTO TB VALUES(6, 'F');
INSERT INTO TB VALUES(7, 'G');

SELECT * FROM TA;
SELECT * FROM TB;

SELECT * FROM TA
INNER JOIN TB
ON TA.nums = TB.nums;
-- inner join yields what both tables have in common based on a set condition
-- we had 2 records, nums 3,4 were a match
SELECT * FROM TA
LEFT JOIN TB
ON TA.nums = TB.nums
ORDER BY TA.nums;

SELECT * FROM TA
RIGHT JOIN TB
ON TA.nums = TB.nums
ORDER BY TA.nums;

SELECT * FROM TA
FULL OUTER JOIN TB
ON TA.nums = TB.nums
ORDER BY TA.nums;

SELECT * FROM TA
CROSS JOIN TB
 ORDER BY TA.nums;

-- self join
CREATE TABLE emps(
    emp_id NUMBER(6) PRIMARY KEY,
    e_name VARCHAR2(100),
    super_id NUMBER(6),
    CONSTRAINT some_fk FOREIGN KEY (super_id) REFERENCES emps(emp_id)
);

INSERT INTO emps VALUES (1, 'Henry', null);
INSERT INTO emps VALUES (2, 'John', 1);
INSERT INTO emps VALUES (3, 'Jacob', 2);
INSERT INTO emps VALUES (4, 'Yousef', 2);
INSERT INTO emps VALUES (5, 'Jingle', 2);
SELECT * FROM emps;

SELECT a.e_name, COUNT(a.emp_id) FROM emps a
INNER JOIN emps b
ON a.emp_id = b.super_id
GROUP BY a.e_name;

-- self join?
SELECT * FROM emps a, emps b
WHERE a.super_id = b.emp_id;

-- SET OPERATORS
-- UNION
-- UNION ALL
-- INTERSECT
-- MINUS

SELECT nums, chars FROM TA
UNION
SELECT nums, LOWER(otherchars) FROM TB;

SELECT nums, chars FROM TA
UNION ALL
SELECT nums, LOWER(otherchars) FROM TB; -- ALLOWS FOR DUPLICATES

SELECT nums, chars FROM TA
INTERSECT 
SELECT nums, LOWER(otherchars) FROM TB
ORDER BY nums;

SELECT nums, chars FROM TA
MINUS
SELECT nums, LOWER(otherchars) FROM TB
ORDER BY nums;

/*
    Views - virtual tables that can be created to ease the complexity of queries.
    You can query a databse and save the query + result in a viarual table that can
    be referenced or even used in other queries.
*/
