CREATE TABLE CUSTOMER(
    CUSTOMER_ID VARCHAR(36) PRIMARY KEY,
    FIRST_NAME VARCHAR(50),
    LAST_NAME VARCHAR(50),
    EMAIL VARCHAR(125)
);

CREATE TABLE ORDER_INFO(
    ORDER_ID VARCHAR(36) PRIMARY KEY,
    CUSTOMER_ID VARCHAR(36) ,
    ORDER_VALUE VARCHAR(10),
    ORDER_DATE DATE
);

ALTER TABLE ORDER_INFO ADD FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID);