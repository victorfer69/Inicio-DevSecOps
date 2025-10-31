-- ==============================================
-- EJERCICIO 2: Modificación de datos
-- ==============================================

-- 1. Insertar nuevos empleados 
INSERT INTO empleados (nombre, salario, fecha_ingreso, id_departamento) VALUES
('Pepe Martin', 2700.00, '2023-02-15', 1),
('Jorge Frutos', 2200.00, '2023-02-15', 2),
('Ana Trace', 2700.00, '2023-02-15', 3);

SELECT * FROM empleados;


-- 2. Actualizar salario (aumentar un 10% a empleados de "Ventas")
UPDATE empleados
SET salario = salario * 1.10
WHERE id_departamento = (
    SELECT id_departamento FROM departamentos WHERE nombre = 'Ventas'
);

SELECT * FROM empleados
WHERE id_departamento = (
    SELECT id_departamento FROM departamentos WHERE nombre = 'Ventas'
);


-- 3. Eliminar el empleado con el salario más bajo
DELETE FROM empleados
WHERE salario = (SELECT MIN(salario) FROM empleados);

SELECT * FROM empleados ORDER BY salario ASC;
