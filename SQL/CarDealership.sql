/**********************************************************************************
CREATE USER cardealer
IDENTIFIED BY Qu1etH0ur
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to cardealer;
GRANT resource to cardealer;
GRANT create session TO cardealer;
GRANT create table TO cardealer;
GRANT create view TO cardealer;



conn cardealer/Qu1etH0ur
************************************************************************************/
--CREATE SCHEMA IF NOT EXISTS `CarDealership` ;

--CREATE USER IF NOT EXISTS 'car_dealership_user'@'%' identified by 'admin';
--GRANT ALL  ON CarDealership.* TO 'car_dealership_user'@'%';
--
--USE CarDealership;



CREATE TABLE car_dealership.`customer` (
  `customer_id` int NOT NULL,
  `username` varchar2(255) DEFAULT NULL,
  `firstname` varchar2(255) DEFAULT NULL,
  `lastname` varchar2(255) DEFAULT NULL,
   `email` varchar2(255) DEFAULT NULL,
   `address` varchar2(255) DEFAULT NULL,
  `city` varchar2(255) DEFAULT NULL,
  `state` varchar2(255) DEFAULT NULL,
  `postal_code` varchar2(255) DEFAULT NULL,
  `phone_number` varchar2(255) DEFAULT NULL,
  `credit_score` double DEFAULT NULL,
  `cash_on_hand` double DEFAULT NULL,
  `password` varchar2(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE car_dealership.`employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar2(255) DEFAULT NULL,
  `firstname` varchar2(255) DEFAULT NULL,
  `lastname` varchar2(255) DEFAULT NULL,
  `password` varchar2(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `car_dealership`.`car` (
    `car_id` int NOT NULL AUTO_INCREMENT,
    `vin_number` VARCHAR2(255) DEFAULT NULL,
    `make` VARCHAR2(255) DEFAULT NULL,
    `model` VARCHAR2(255) DEFAULT NULL,
	`mileage` INT DEFAULT NULL,
	`year` INT DEFAULT NULL,
    `price` double DEFAULT NULL,
    `rate` double DEFAULT NULL,
	`monthly_payment` double DEFAULT NULL,
    `current_status` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (`car_id`)
);


CREATE TABLE `car_dealership`.`customer_bid` (
    `bid_id` int NOT NULL AUTO_INCREMENT,
	`car_id` int NOT NULL,
	`customer_id` int NOT NULL,
    `months` int NOT NULL,
    `offer_made` double NOT NULL,
    FOREIGN KEY (car_id) REFERENCES car(car_id),
	FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    PRIMARY KEY (`bid_id`)
);


CREATE TABLE `car_dealership`.`customer_owned_cars` (
    `customer_id` int NOT NULL,
	`car_id` int NOT NULL,
    `amount` double NOT NULL,
    `is_payment_made` boolean NOT NULL,
	FOREIGN KEY (car_id) REFERENCES car(car_id),
    PRIMARY KEY (`customer_id`,`car_id`)
);

CREATE TABLE `car_dealership`.`dealer_payments` (
    `payment_id` int NOT NULL AUTO_INCREMENT,
    `bid_id` int NOT NULL,
	`customer_id` int NOT NULL,
    `amount` double NOT NULL,
    `payment_date` date NOT NULL,
	FOREIGN KEY (bid_id) REFERENCES bid(bid_id),
	FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    PRIMARY KEY (`payment_id`)
);


select * from `car_dealership`.`customer`;

select * from `car_dealership`.`car`;
select * from `car_dealership`.`customer_bid`;


INSERT INTO car(vin_number, make, model, mileage, year, price, rate, monthly_payment, current_status) 
VALUES ('vin-1', 'X-5', 'BMW', 60, 2020, 200000, 100, 10, 'IN_LOT');

INSERT INTO car(vin_number, make, model, mileage, year, price, rate, monthly_payment, current_status) 
VALUES ('vin-2', 'X-5', 'BMW', 60, 2020, 200000, 100, 10, 'NOT_IN_LOT');


INSERT INTO car(vin_number, make, model, mileage, year, price, rate, monthly_payment, current_status) 
VALUES ('vin-3', 'X-5', 'BMW', 60, 2020, 200000, 100, 10, 'TAKEN');
