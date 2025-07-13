CREATE SCHEMA ormlearn;
USE ormlearn;

CREATE TABLE country (
    co_code VARCHAR(2) PRIMARY KEY,
    co_name VARCHAR(50)
);

INSERT INTO country VALUES ('IN', 'India');
INSERT INTO country VALUES ('US', 'United States of America');
insert into country values ("CL", "Chile");
insert into country values ("CN", "China");
insert into country values ("CX", "Christmas Island");
insert into country values ("CC", "Cocos (Keeling) Islands");
