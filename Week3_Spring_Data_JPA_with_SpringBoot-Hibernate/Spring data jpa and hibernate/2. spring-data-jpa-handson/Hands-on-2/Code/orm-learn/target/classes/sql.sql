CREATE DATABASE IF NOT EXISTS ormlearn;
USE ormlearn;

CREATE TABLE IF NOT EXISTS stock (
  st_id INT NOT NULL AUTO_INCREMENT,
  st_code VARCHAR(10), 
  st_date DATE,
  st_open NUMERIC(10,2),
  st_close NUMERIC(10,2), 
  st_volume NUMERIC,
  PRIMARY KEY (st_id)
);
SELECT * FROM stock LIMIT 10;
