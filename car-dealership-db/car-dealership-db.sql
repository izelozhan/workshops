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



