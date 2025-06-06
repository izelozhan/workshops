-- Car Dealership Database -- 

DROP DATABASE IF EXISTS car_dealership;
CREATE DATABASE car_dealership;

USE car_dealership;

CREATE TABLE dealerships (
	dealership_id INT auto_increment NOT NULL,
	dealership_name varchar(50),
    address varchar(50),
    phone varchar(12),
    PRIMARY KEY (dealership_id)
);

CREATE table vehicles(
    vin int NOT NULL,
    year_made int,
    make varchar(40),
    model varchar(40),
    color varchar(40),
    vehicle_type varchar(50),
    odometer int,
    price float,
    sold boolean,
    PRIMARY KEY (vin)
);
    
CREATE table inventory(
	dealership_id int NOT NULL,
    vin int NOT NULL,
    PRIMARY KEY(vin)
);

CREATE table sales_contract(
    vin int NOT NULL,
    contract_date varchar(50) NOT NULL,
    customer_name varchar(50) NOT NULL,
    total_price float,
    PRIMARY KEY(vin)
);
    
CREATE table lease_contract(
    vin int NOT NULL,
    contract_date varchar(50) NOT NULL,
    customer_name varchar(50) NOT NULL,
    monthly_payment float,
    total_price float,
    PRIMARY KEY(vin)
);

-- add dealership

INSERT INTO dealerships (dealership_name, address, phone)
VALUES ("Dealer1", "4400 SomeAddress", "123-123-1212");
INSERT INTO dealerships (dealership_name, address, phone)
VALUES ("Dealer2", "4400 SomeAddress", "123-123-1212");
INSERT INTO dealerships (dealership_name, address, phone)
VALUES ("Dealer3", "4400 SomeAddress", "123-123-1212");

-- add vehicle

INSERT INTO vehicles (vin, year_made, make, model, color, vehicle_type, odometer, price, sold)
VALUES (10118, 2012, "Nissan", "Altima", "Gray", "Sedan", 103000, 7900.0, false);
INSERT INTO vehicles (vin, year_made, make, model, color, vehicle_type, odometer, price, sold)
VALUES (10119, 2016, "BMW", "X5", "Black", "SUV", 64000, 25999.0, true);
INSERT INTO vehicles (vin, year_made, make, model, color, vehicle_type, odometer, price, sold)
VALUES (10120, 2021, "Hyundai", "Elantra", "Blue", "Sedan", 21000, 18800.0, false);

-- add inventory

INSERT INTO inventory (dealership_id, vin)
VALUES (2, 10118);
INSERT INTO inventory (dealership_id, vin)
VALUES (1, 10119);
INSERT INTO inventory (dealership_id, vin)
VALUES (1, 10120);

-- add sales contract
INSERT INTO sales_contract (vin, contract_date, customer_name, total_price) 
VALUES 
(10118, "2024-08-15", "Alice Johnson", 10800.0),
(10119, "2024-07-10", "Bob Smith", 12950.0);

-- Questions

-- 01
SELECT * from dealerships;

-- 02

SELECT * FROM vehicles RIGHT JOIN inventory 
ON inventory.dealership_id = dealership_id
WHERE dealership_id = (SELECT dealership_id FROM dealerships
	WHERE dealership_name LIKE "%1%");

-- 03
SELECT * FROM vehicles
WHERE vin = 10118;

-- 04 
SELECT * FROM dealerships LEFT JOIN inventory 
ON inventory.vin = vin
WHERE vin = 10118;

-- 05 
SELECT DISTINCT * FROM dealerships 
JOIN inventory  ON dealership_id = inventory.dealership_id
JOIN vehicles v ON inventory.VIN = VIN
WHERE make = 'Nissan' AND model = 'Altima' AND color = 'Gray';

-- 06




