-- ==============================================
-- EJERCICIO 5: Subconsultas, Vistas y Transacciones
-- ==============================================

-- 1. Crea una vista que muestre el nombre del empleado, departamento, salario y días en la empresa
CREATE OR REPLACE VIEW vista_empleados_departamentos AS
SELECT 
    e.nombre AS empleado,
    d.nombre AS departamento,
    e.salario,
    (CURRENT_DATE - e.fecha_ingreso) AS dias_en_empresa
FROM empleados e
JOIN departamentos d ON e.id_departamento = d.id_departamento;

-- Comprobamos el contenido de la vista
SELECT * FROM vista_empleados_departamentos;


-- 2. Subconsulta: mostrar los empleados cuyo salario es superior al promedio
SELECT 
    nombre,
    salario
FROM empleados
WHERE salario > (SELECT AVG(salario) FROM empleados);


-- 3. Simula una transacción bancaria

-- Creamos la tabla de cuentas (si no existe)
DROP TABLE IF EXISTS cuentas;
CREATE TABLE cuentas (
    id_titular INT PRIMARY KEY,
    titular VARCHAR(50) NOT NULL,
    saldo NUMERIC(10,2) NOT NULL CHECK (saldo >= 0)
);

-- Insertamos los dos titulares
INSERT INTO cuentas (titular, saldo) VALUES
(1, 'Ana', 1000),
(2, 'Carlos', 500);

-- Mostramos el estado inicial
SELECT * FROM cuentas;

-- Iniciamos una transacción
BEGIN;

-- Restamos 200€ a Ana
UPDATE cuentas
SET saldo = saldo - 200
WHERE titular = 'Ana';

-- Sumamos 200€ a Carlos
UPDATE cuentas
SET saldo = saldo + 200
WHERE titular = 'Carlos';

-- Comprobamos los saldos dentro de la transacción (antes de confirmar)
SELECT * FROM cuentas;

-- Revertimos los cambios (rollback)
ROLLBACK;

-- Mostramos el estado tras el rollback (deberían volver los valores iniciales)
SELECT * FROM cuentas;

-- Repetimos la operación, esta vez confirmando (commit)
BEGIN;

UPDATE cuentas
SET saldo = saldo - 200
WHERE titular = 'Ana';

UPDATE cuentas
SET saldo = saldo + 200
WHERE titular = 'Carlos';

-- Confirmamos los cambios
COMMIT;

-- Mostramos el estado final (deben reflejar los cambios)
SELECT * FROM cuentas;