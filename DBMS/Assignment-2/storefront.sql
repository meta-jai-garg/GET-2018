/*
Creating Database
*/
CREATE DATABASE STOREFRONT;

use storefront;
/*
Creating user table
*/

CREATE TABLE user(
    user_id INT AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    user_type CHAR(1) NOT NULL DEFAULT 'S',
    registration_date DATE NOT NULL,
    PRIMARY KEY (user_id)
);

/*
creating address table
*/

CREATE TABLE address(
    address_id INT AUTO_INCREMENT,
    user_id INT,
    phone VARCHAR(10) NOT NULL,
    house_no VARCHAR(10) NOT NULL,
    street VARCHAR(20),
    city VARCHAR(50) NOT NULL,
    state VARCHAR(20) NOT NULL,
    country VARCHAR(50) NOT NULL,
    zipcode INT(6) NOT NULL,
    PRIMARY KEY (address_id),
    FOREIGN KEY (user_id)
        REFERENCES user (user_id)
);

/*
creating product table
*/
CREATE TABLE product(
    product_id INT AUTO_INCREMENT,
    product_name VARCHAR(50) NOT NULL,
    product_price FLOAT NOT NULL,
    stock INT,
    added_date DATE NOT NULL,
    modify_date DATE,
    PRIMARY KEY (product_id)
);

/*
creating category table
*/

CREATE TABLE category(
    category_id INT AUTO_INCREMENT,
    category_name varchar(30) NOT NULL,
    parent_categopry varchar(30),
    PRIMARY KEY (category_id)
);

/*
creating category relation
*/
CREATE TABLE category_relation(
    category_id INT,
    product_id INT,
    PRIMARY KEY (category_id,product_id),
    FOREIGN KEY (category_id)
        REFERENCES category (category_id),
    FOREIGN KEY (product_id)
        REFERENCES product (product_id)
);
/*
creating table for product image
*/

CREATE TABLE product_image(
    img_id INT AUTO_INCREMENT,
    img_url varchar(300) NOT NULL,
    img_name varchar(50) NOT NULL,
    product_id INT,
    PRIMARY KEY (img_id),
    FOREIGN KEY (product_id)
        REFERENCES product (product_id)
);

/*
creating table for product order
*/
CREATE TABLE product_order(
    order_id INT AUTO_INCREMENT,
    address_id INT,
    PRIMARY KEY (order_id),
    FOREIGN KEY (address_id)
        REFERENCES address (address_id)
);

/*
creating table for order detail
*/
CREATE TABLE order_detail(
    detail_id INT AUTO_INCREMENT,
    order_id INT REFERENCES product_order (order_id),
    amount double NOT NULL,
    status ENUM('SHIPPED', 'CANCELLED', 'RETURNED'),
    last_update TIMESTAMP NOT NULL,
    PRIMARY KEY (detail_id)
);

/*command to display all the table names present in StoreFront*/
show tables;

/*command to remove Product table of the StoreFront database*/
SET FOREIGN_KEY_CHECKS = 0;
drop table product;
SET FOREIGN_KEY_CHECKS = 1;

/*command to display all the table names present in StoreFront*/
show tables;

/*Again creation of product table*/
CREATE TABLE product(
    product_id INT AUTO_INCREMENT,
    product_name VARCHAR(50) NOT NULL,
    product_price FLOAT NOT NULL,
    stock INT,
    added_date DATE NOT NULL,
    modify_date DATE,
    PRIMARY KEY (product_id)
);