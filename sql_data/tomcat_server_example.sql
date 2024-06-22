-- Crear la base de datos (si aún no existe)
CREATE DATABASE IF NOT EXISTS tomcat_server_example;

-- Usar la base de datos creada
USE tomcat_server_example;

-- Crear la tabla de productos
CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL
);

-- Insertar ejemplos de productos
INSERT INTO productos (nombre, precio) VALUES ('Camiseta', 19.99);
INSERT INTO productos (nombre, precio) VALUES ('Pantalón', 39.95);
INSERT INTO productos (nombre, precio) VALUES ('Zapatos deportivos', 59.99);
INSERT INTO productos (nombre, precio) VALUES ('Reloj', 129.00);
INSERT INTO productos (nombre, precio) VALUES ('Mochila', 49.50);