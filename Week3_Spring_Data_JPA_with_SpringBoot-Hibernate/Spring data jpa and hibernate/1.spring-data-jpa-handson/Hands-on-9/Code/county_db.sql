create database country_db;
use country_db;

create table country(
co_code VARCHAR(5)  PRIMARY KEY ,
co_name VARCHAR(255) NOT NULL);

INSERT INTO country (co_code, co_name) VALUES 
('BV', 'Bouvet Island'),
('DJ', 'Djibouti'),
('GP', 'Guadeloupe'),
('GS', 'South Georgia and the South Sandwich Islands'),
('LU', 'Luxembourg'),
('SS', 'South Sudan'),
('TF', 'French Southern Territories'),
('UM', 'United States Minor Outlying Islands'),
('ZA', 'South Africa'),
('ZM', 'Zambia'),
('ZW', 'Zimbabwe');