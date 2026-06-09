CREATE TABLE IF NOT EXISTS app_user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    rolId INT NOT NULL,
    name VARCHAR(20) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    price FLOAT NOT NULL,
    stock INT NOT NULL
);

CREATE TABLE IF NOT EXISTS wish (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userId INT NOT NULL,
    productId INT NOT NULL,
    FOREIGN KEY (productId) REFERENCES product(id),
    FOREIGN KEY (userId) REFERENCES app_user(id)
);

CREATE TABLE IF NOT EXISTS wish_history (
    id INT PRIMARY KEY,
    userId INT NOT NULL,
    productId INT NOT NULL
);

MERGE INTO app_user (id,rolId,name,password) VALUES (1,1,'admin','admin');
MERGE INTO app_user (id,rolId,name,password) VALUES (2,2,'user','user');
ALTER TABLE app_user ALTER COLUMN id RESTART WITH 2;

MERGE INTO product (id,name,price,stock) VALUES (1,'Teclado',25.99,100);
MERGE INTO product (id,name,price,stock) VALUES (2,'Mouse',15.50,200);
MERGE INTO product (id,name,price,stock) VALUES (3,'Monitor',150.00,50);
MERGE INTO product (id,name,price,stock) VALUES (4,'Auriculares',45.75,80);
MERGE INTO product (id,name,price,stock) VALUES (5,'Webcam',60.00,0);
ALTER TABLE product ALTER COLUMN id RESTART WITH 6;