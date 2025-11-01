-- ==============================================
-- EJERCICIO 4: Relaciones y Joins
-- ==============================================

-- 1. Muestra el nombre del empleado junto con el nombre del departamento
SELECT 
    e.nombre AS empleado,
    d.nombre AS departamento
FROM empleados e
JOIN departamentos d 
    ON e.id_departamento = d.id_departamento;

-- 2. Muestra todos los departamentos aunque no tengan empleados
SELECT 
    d.nombre AS departamento,
    e.nombre AS empleado
FROM departamentos d
JOIN empleados e 
    ON d.id_departamento = e.id_departamento;

-- 3. Crea una tabla proyectos
CREATE TABLE proyectos (
    id_proyecto INT PRIMARY KEY,
    nombre_proyecto VARCHAR(50) NOT NULL,
    id_empleado INT,
    CONSTRAINT fk_id_empleado
        FOREIGN KEY (id_empleado)
        REFERENCES empleados (id_empleado)
        ON DELETE SET NULL
);

-- 4. Inserta algunos valores en la tabla proyectos
INSERT INTO proyectos (nombre_proyecto, id_empleado) VALUES
('Proyecto Alfa', 1),
('Proyecto Beta', 2),
('Proyecto Gamma', 3),
('Proyecto Delta', NULL),  -- Proyecto sin empleado asignado
('Proyecto Omega', 4);

SELECT * FROM proyectos;

-- 5. Muestra los empleados que trabajan en cada proyecto
SELECT 
    p.nombre_proyecto AS proyecto,
    e.nombre AS empleado,
    d.nombre AS departamento
FROM proyectos p
LEFT JOIN empleados e ON p.id_empleado = e.id_empleado
LEFT JOIN departamentos d ON e.id_departamento = d.id_departamento
ORDER BY proyecto;

-- 6. Muestra los proyectos sin empleados asignados
SELECT 
    nombre_proyecto AS proyecto
FROM proyectos
WHERE id_empleado IS NULL;