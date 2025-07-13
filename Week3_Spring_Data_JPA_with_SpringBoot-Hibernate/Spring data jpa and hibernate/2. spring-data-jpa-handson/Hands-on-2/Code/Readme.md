# Hands-on 2: Spring Data JPA - Query Methods on Stock Table

This project demonstrates the use of **Spring Data JPA Query Methods** for performing various queries on stock market data (Facebook, Google, Netflix) using a relational database.

##  Overview:

The exercise involves:
- Setting up a `stock` table in MySQL
- Populating stock data from a `.csv` file (October 2018 – October 2019)
- Implementing query methods using Spring Data JPA
- Executing methods to test different business scenarios

## Schema:

```
CREATE TABLE IF NOT EXISTS `ormlearn`.`stock` (
  `st_id` INT NOT NULL AUTO_INCREMENT,
  `st_code` VARCHAR(10), 
  `st_date` DATE,
  `st_open` NUMERIC(10,2),
  `st_close` NUMERIC(10,2), 
  `st_volume` NUMERIC,
  PRIMARY KEY (`st_id`)
);

```
# Note :
The platform mentioned a stock-data.csv file under spring-data-jpa-files folder. However, the file was not available.
Therefore, a sample CSV file was created manually for testing the implementation, containing partial data based on the given query result examples.

# Features Implemented:
| Query Description                                            | Method Implemented              |
| ------------------------------------------------------------ | ------------------------------- |
| Get all stock details of Facebook in September 2019          | `findByCodeAndDateBetween`      |
| Get all Google stock details where closing price > 1250      | `findByCodeAndCloseGreaterThan` |
| Get top 3 stocks with highest volume                         | `findTop3ByOrderByVolumeDesc`   |
| Get 3 dates when Netflix stocks had the lowest closing price | `findTop3ByCodeOrderByCloseAsc` |


# Output :
Results from each query method are printed in the console (e.g., Facebook stocks for Sep 2019, etc.).