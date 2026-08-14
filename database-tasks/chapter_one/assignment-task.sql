CREATE DATABASE e_commerce_db;

CREATE TABLE users (
	id INT AUTO_INCREMENT PRIMARY KEY, -- NOT NULL
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
    phone_number VARCHAR(20)
);

CREATE TABLE products (
	products_id INT AUTO_INCREMENT PRIMARY KEY,
    price DECIMAL(50),
    quantity_in_store INT(50),
    quantity_sold INT(50)
);

CREATE TABLE orders (
	order_id INT AUTO_INCREMENT PRIMARY KEY,
    price DECIMAL(50),
    quantity_sold INT(50)
);

SHOW TABLES;
