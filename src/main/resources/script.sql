create database jsp_servlet;

use jsp_servlet;

create table roles(
	id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(20),
    name VARCHAR(20)
);


create table users(
	id int primary key auto_increment,
    username nvarchar(50),
	password char(50),
    full_name nvarchar(50),
    phone char(10),
    email varchar(50),
    address nvarchar(255)
);

create table roles_users(
	role_id int references roles(id),
    user_id int references users(id),
    primary key(role_id, user_id)
);

create table categories(
	id INT primary key auto_increment,
    name nvarchar(50),
    code varchar(50)
);

create table products(
	id INT PRIMARY KEY auto_increment,
    product_name NVARCHAR(50),
    sale_price double,
    cost_price double,
    quantity int,
    desciption TEXT,
    category_id INT references categories(id)
);
