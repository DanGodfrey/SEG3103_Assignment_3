CREATE TABLE item (
ID INT NOT NULL CONSTRAINT pk_item PRIMARY KEY,
name VARCHAR(30),
price DOUBLE PRECISION,
quantity INT
);

CREATE TABLE customer (
ID INT NOT NULL CONSTRAINT pk_customer PRIMARY KEY,
name VARCHAR(30)
);

CREATE TABLE employee (
ID INT NOT NULL CONSTRAINT pk_employee PRIMARY KEY,
name VARCHAR(30),
password VARCHAR(15)
);

CREATE TABLE trans (
ID INT NOT NULL CONSTRAINT pk_transaction PRIMARY KEY,
employee INT,
customer INT,
is_open INT
);

CREATE TABLE acquisition (
ID INT NOT NULL CONSTRAINT pk_acquisition PRIMARY KEY,
trans INT,
item INT,
quantity INT
);

