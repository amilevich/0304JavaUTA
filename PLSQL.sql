/*
    PL/SQL - Procedural Language/Structured Query Language
    It is an extension of Oracle
    -- function, stored procedures, sequences, and triggers
    -- exception handling
    -- in other words, it provides a means to write actual code in SQL
*/

-- SEQUENCE
-- an object that will maintain a counter for you

CREATE SEQUENCE emp_seq
    START WITH 150
    INCREMENT BY 1;
    -- This sequence can be used to handle the id field for employees.
    -- In order to actually utilize it, we will need to build something
    -- that reacts to situations where an employee is inserted.
    -- trigger
/

-- TRIGGERS
-- An object that we can create that waits for actions to occur
-- based on a specific table the trigger was made for.

CREATE OR REPLACE TRIGGER emp_seq_trigger -- IF ALREADY CREATED,
                                                                                                    -- OR REPLACE WILL REPLACE THE TRIGGER
BEFORE INSERT ON employees -- 'BEFORE' OR 'AFTER'
FOR EACH ROW
BEGIN -- signigifies a block for a transaction
    IF :new.e_id IS NULL THEN
    SELECT emp_seq.nextval INTO :new.e_id FROM dual;
    END IF;
END;
/

-- STORED PROCEDURES
/*
    A named transaction that can be invoked when called (method in Java).
*/

CREATE OR REPLACE PROCEDURE hello_world_procedure
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello World');
END;
/

BEGIN
    hello_world_procedure();
END;
/

/*
IN parameters - whatever is passed as input during the procedure call
OUT parameters - whatever is returned from the procedure
IN OUT parameters - a variable that is used as input then transformed as output

--syntax
varname IN/OUT/IN OUT DATATYPE
*/


/*
    CURSORS!
    - A cursor is essentially like a pointer to a table or view.
    - We can use them to iterate through entire queries from the database.
    -When we want to pass entire tables or queries, we need to use cursors.
    
    NOTE: PL/SQL offers CURSOR and SYS_REFCURSOR
    The SYS_REFCURSOR is a stronger cursor that is allowed
    to be passed outside of the scope of the procedure it is in.
    A normal CURSOR must be created and die within the scope
    of the procedure where it was created in.
*/

--USER DEFINED FUNCTIONS
/*
    (method like in java)
    return something ONE and ONLY ONE resource.
    A function can only use IN parameters
    A function can only utilize DQL (stored procedure can use both DML and DQL)
*/

CREATE OR REPLACE FUNCTION get_max_id 
RETURN NUMBER
IS
    max_id NUMBER(6); --number size is not required
BEGIN
    SELECT MAX(e_id) INTO max_id FROM employees;
    RETURN max_id;
END;
/

DECLARE
            max_id NUMBER;
BEGIN
    max_id := get_max_id();
    DBMS_OUTPUT.PUT_LINE('Max employee id: ' || max_id);
END;
/
    