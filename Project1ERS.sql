DROP TABLE ERS_Users;
DROP TABLE ERS_Tickets;

CREATE TABLE ERS_Users(
user_username VARCHAR2(50) PRIMARY KEY,
user_password VARCHAR(64) NOT NULL,
user_type VARCHAR(50) NOT NULL
);

CREATE TABLE ERS_Tickets(
ticket_id NUMBER(12 PRIMARY KEY, 
ticket_amount NUMBER(12) NOT NULL,
ticket_type VARCHAR2(50) NOT NULL,
ticket_state VARCHAR(50) NOT NULL,
ticket_user VARCHAR2(50) NOT NULL, 
ticket_description VARCHAR2(400)
);
ALTER TABLE ERS_Tickets ADD CONSTRAINT fk_ticket_user FOREIGN KEY (ticket_user) REFERENCES ERS_Users (user_username);

SELECT*FROM ERS_Users;
SELECT*FROM ERS_Tickets;

