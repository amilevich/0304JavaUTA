--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION employees1968Function
RETURN SYS_REFCURSOR
IS employeeCursor SYS_REFCURSOR;
BEGIN
    OPEN employeeCursor FOR
    SELECT *
    FROM Employee
    WHERE BirthDate > '31/12/1968';
    
    RETURN employeeCursor;
END;
/

SELECT*FROM Employee



CREATE OR REPLACE PROCEDURE listEmployees1968Procedure IS
    e SYS_REFCURSOR;
    r Employee%rowtype;
BEGIN
    e := employees1968Function;
    LOOP
        FETCH e INTO r;
        EXIT WHEN e%notfound;
        DBMS_OUTPUT.PUT_LINE(r.firstname||','||r.birthdate);
    END LOOP;
    CLOSE E;
END;
/

EXEC listEmployees1968Procedure;
/
