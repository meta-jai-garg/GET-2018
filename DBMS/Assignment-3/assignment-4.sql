-- database creation
CREATE DATABASE zipcodelist;
USE zipcodelist;

-- creating state table
CREATE TABLE state (
    state_id INT AUTO_INCREMENT,
    state_name VARCHAR(40),
    PRIMARY KEY (state_id)
);

-- creating city table
CREATE TABLE city (
    city_id INT AUTO_INCREMENT,
    city_name VARCHAR(40),
    state_id INT REFERENCES state (state_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY (city_id)
);

-- creating table for zipcode
create table zip (
    zipcode INT,
    city_id INT REFERENCES city (city_id)
    ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY (zipcode)
);

-- insertion of data into state
INSERT INTO state(state_name) VALUES('Rajasthan'), ('UP'), ('Andhra');

-- insertion of data into city
INSERT INTO city(city_name,state_id) VALUES('Jaipur', 1), ('Ajmer', 1),('Lucknow', 2), ('Kanpur', 2),('Hyderabad', 3),('Vijaywada', 3);

-- insertion of data into zip
INSERT INTO zip(zipcode,city_id) VALUES(302001, 1), (302002, 1),(303001, 2), (303002, 2),(312001, 3),(312002, 3), (313001, 4),(313002, 4),(322001, 5),(322002, 5),(323001, 6),(323002, 6);
-- queries to see data contents in state, city and zip table
SELECT 
    *
FROM
    state;

SELECT 
    *
FROM
    city;

SELECT 
    *
FROM
    zip;


-- query to fetch a Resultset containing Zip Code, City Names and States ordered by State Name and City Name

SELECT 
    zip.zipcode AS 'Zip Code',
    city.city_name AS 'City',
    state.state_name AS 'State'
FROM
    state
        INNER JOIN
    city ON state.state_id = city.state_id
        INNER JOIN
    zip ON city.city_id = zip.city_id
ORDER BY state.state_name , city.city_name;