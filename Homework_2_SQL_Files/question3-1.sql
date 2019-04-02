--Task – Create a function that returns the current time.
/
CREATE OR REPLACE FUNCTION currentTimeFunction
RETURN VARCHAR
IS dummyTime VARCHAR(20);
BEGIN
    SELECT TO_CHAR (SYSDATE, 'HH24:MI:SS')
    INTO dummyTime
    FROM DUAL;
    
    RETURN dummyTime;
END;
/

SELECT currentTimeFunction FROM DUAL;
/

--Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION mediaTypeLengthFunction
RETURN int
IS dummy int;
BEGIN
    SELECT LENGTH(Name)
    INTO dummy
    FROM MediaType
    WHERE MediaTypeId=1;
    
    RETURN dummy;
END;
/

SELECT mediaTypeLengthFunction FROM DUAL;

--DROP FUNCTION mediaTypeLengthFunction;
