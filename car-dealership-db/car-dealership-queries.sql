USE car_dealership;

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
SELECT dealership_id, dealership_name, address FROM dealerships 
JOIN inventory  ON dealership_id = inventory.dealership_id
JOIN vehicles v ON inventory.VIN = VIN
WHERE make = 'Nissan' AND model = 'Altima' AND color = 'Gray';

-- 06

SELECT * FROM sales_contract
JOIN inventory ON vin = inventory.vin
WHERE  contract_date BETWEEN '2024-07-10' AND '2024-08-15';

