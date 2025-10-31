-- ==============================================
-- EJERCICIO 3: Consultas a tablas
-- ==============================================

-- 1. Muestra los nombres y salarios de los empleados que ganan más de 2000 €.
SELECT nombre, salario FROM empleados where salario > 2000;

-- 2. Ordena los resultados por salario descendente y muestra solo los 3 primeros.
SELECT nombre, salario FROM empleados where salario > 2000 ORDER BY salario DESC LIMIT 3;

-- 3. Muestra todos los nombres de departamentos sin duplicados.
SELECT DISTINCT nombre FROM departamentos;

-- 4. Calcula el salario medio, mínimo y máximo por departamento (GROUP BY).
SELECT 
    nombre, 
    AVG(salario) AS salario_medio, 
    MAX(salario) AS salario_max, 
    MIN(salario) AS salario_min
FROM empleados GROUP BY id_departamentos; 

-- 5. Filtra los resultados para mostrar solo los departamentos cuyo salario medio supere los 2500 € (HAVING).
SELECT 
    nombre, 
    AVG(salario) AS salario_medio, 
    MAX(salario) AS salario_max, 
    MIN(salario) AS salario_min
FROM empleados GROUP BY id_departamentos
HAVING AVG(salario) > 2500;