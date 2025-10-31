-- ==============================================
-- EJERCICIO 1: Creación de base de datos y tablas
-- ==============================================

-- 1. Crear la base de datos
CREATE DATABASE empresa_db;

-- 2. Crear la tabla de departamentos
CREATE TABLE departamentos (
    id_departamento INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- 3. Crear la tabla de empleados
CREATE TABLE empleados (
    id_empleado INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    salario NUMERIC(10,2) CHECK (salario > 0),
    fecha_ingreso DATE NOT NULL,
    CONSTRAINT fk_departamento
        FOREIGN KEY (id_departamento)
        REFERENCES departamentos (id_departamento)
);

-- 4. Insertar datos de ejemplo

-- Insertamos 5 departamentos
INSERT INTO departamentos VALUES
(1,'Recursos Humanos'),
(2,'Ventas'),
(3,'Marketing'),
(4,'Tecnología'),
(5,'Finanzas');

-- Insertamos 15 empleados distribuidos por departamentos
INSERT INTO empleados (nombre, salario, fecha_ingreso, id_departamento) VALUES
('Ana López', 2500.00, '2020-03-15', 1),
('Carlos Ruiz', 2200.00, '2021-06-10', 1),
('María Gómez', 2700.00, '2019-11-05', 1),

('Juan Pérez', 3100.00, '2020-01-22', 2),
('Lucía Torres', 2950.00, '2021-04-19', 2),
('Sergio Morales', 2800.00, '2022-09-30', 2),

('Paula Navarro', 2400.00, '2018-07-14', 3),
('Raúl Fernández', 2600.00, '2020-09-12', 3),
('Isabel Ortega', 2550.00, '2023-02-17', 3),

('Miguel Castro', 3500.00, '2019-05-09', 4),
('Laura Sánchez', 3300.00, '2020-11-03', 4),
('Javier Martín', 3200.00, '2022-06-27', 4),

('Sofía Ramos', 2900.00, '2020-12-18', 5),
('Andrés Molina', 3100.00, '2021-09-07', 5),
('Beatriz Vega', 2750.00, '2019-04-02', 5);

-- 5. Comprobación de los datos insertados
SELECT * FROM departamentos;
SELECT * FROM empleados;