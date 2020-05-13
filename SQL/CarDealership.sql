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
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR2(255) DEFAULT NULL,
  `firstname` VARCHAR2(255) DEFAULT NULL,
  `lastname` VARCHAR2(255) DEFAULT NULL,
   `email` VARCHAR2(255) DEFAULT NULL,
   `address` VARCHAR2(255) DEFAULT NULL,
  `city` VARCHAR2(255) DEFAULT NULL,
  `state` VARCHAR2(255) DEFAULT NULL,
  `postal_code` VARCHAR2(255) DEFAULT NULL,
  `phone_number` VARCHAR2(255) DEFAULT NULL,
  `credit_score` DOUBLE DEFAULT NULL,
  `cash_on_hand` DOUBLE DEFAULT NULL,
  `password` VARCHAR2(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE car_dealership.`employee` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR2(255) DEFAULT NULL,
  `firstname` VARCHAR2(255) DEFAULT NULL,
  `lastname` VARCHAR2(255) DEFAULT NULL,
  `password` VARCHAR2(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `car_dealership`.`car` (
    `car_id` INT NOT NULL AUTO_INCREMENT,
    `vin_number` VARCHAR(255) DEFAULT NULL,
    `make` VARCHAR2(255) DEFAULT NULL,
    `model` VARCHAR2(255) DEFAULT NULL,
	`mileage` INT DEFAULT NULL,
	`year` INT DEFAULT NULL,
    `price` DOUBLE DEFAULT NULL,
    `rate` DOUBLE DEFAULT NULL,
	`monthly_payment` DOUBLE DEFAULT NULL,
    `current_status` VARCHAR2(255) DEFAULT NULL,
    PRIMARY KEY (`car_id`)
);


CREATE TABLE `car_dealership`.`customer_bids` (
    `bid_id` INT NOT NULL AUTO_INCREMENT,
	`car_id` INT NOT NULL,
    `months` INT NOT NULL,
    `customer_id` int NOT NULL,
    `offer_made` double NOT NULL,
    FOREIGN KEY (car_id) REFERENCES car(car_id),
	FOREIGN KEY (customer_id) REFERENCES car(customer_id),
    PRIMARY KEY (`bid_id`)
);


CREATE TABLE `car_dealership`.`customer_owned_cars` (
    `customer_id` INT NOT NULL,
	`car_id` INT NOT NULL,
    `amount` DOUBLE NOT NULL,
    `is_payment_made` boolean NOT NULL,
	FOREIGN KEY (car_id) REFERENCES car(car_id),
    PRIMARY KEY (`customer_id`,`car_id`)
);

CREATE TABLE `car_dealership`.`dealer_payments` (
    `payment_id` INT NOT NULL AUTO_INCREMENT,
    `bid_id` INT NOT NULL,
	`customer_id` int NOT NULL,
    `amount` DOUBLE NOT NULL,
    `payment_date` DATE NOT NULL,
	FOREIGN KEY (bid_id) REFERENCES bid(bid_id),
	FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    PRIMARY KEY (`payment_id`)
);


SELECT * FROM `car_dealership`.`customer`;