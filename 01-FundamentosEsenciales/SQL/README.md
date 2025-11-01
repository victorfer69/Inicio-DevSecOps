## 💾 2.3 Fundamentos de SQL (MySQL y PostgreSQL)

### 2.3.1. Introducción a las Bases de Datos

#### ¿Qué es una Base de Datos?

Una base de datos (DB) es un **sistema organizado** que permite **almacenar, gestionar y recuperar información** de forma eficiente.

Una base de datos reemplaza el almacenamiento de datos en ficheros planos o dispersos, aportando **estructura, seguridad y consistencia**.

El objetivo principal de una base de datos es ofrecer una forma **eficiente y segura** de manejar grandes volúmenes de información, garantizando que los datos sean **accesibles, actualizables y consistentes**.

---

#### Ejemplos de Bases de Datos en la Vida Cotidiana

* **Registro de usuarios** en una aplicación web.
* **Historial de compras** de una tienda online.
* **Datos médicos** de un hospital.

#### 🗣️ Lenguaje SQL (Structured Query Language)

El **SQL** (*Structure Query Language*) es un lenguaje **declarativo y estándar** diseñado específicamente para interactuar con **bases de datos relacionales** (RDBMS).

Su objetivo es permitir al usuario **definir, manipular y consultar datos**, así como controlar los **permisos** y la **estructura** de la base de datos.

SQL se considera un **lenguaje universal**, adoptado por los principales gestores:

* **PostgreSQL**: (*Open source*, muy robusto y con soporte de estándares avanzados).
* **MySQL**: (Muy extendido, especialmente en entornos web).
* **Oracle Database**, **Microsoft SQL Server**, y **SQLite**.

---

##### Historia y Estandarización

* El modelo de bases de datos relacionales fue propuesto por **Edgar F. Codd** en 1970.
* A partir de sus ideas, IBM desarrolló el prototipo **System R**, que utilizó por primera vez el lenguaje **SEQUEL**, el cual evolucionó hasta el actual SQL.
* Desde 1986, SQL está regulado por el estándar **ANSI** y desde 1987 también por **ISO**, lo que garantiza que sus principios fundamentales sean los mismos en todos los sistemas.
* No obstante, cada motor de base de datos puede añadir **extensiones propias**.

---

#### 🖥️ Sistemas Gestores de Bases de Datos Relacionales (RDBMS)

Un **RDBMS** (*Relational DataBase Management System*) es el **software** que implementa el modelo relacional y gestiona las operaciones realizadas con SQL.

Además de almacenar datos, un RDBMS garantiza **seguridad, integridad, concurrencia** y **recuperación ante fallos**.

**Características clave de un RDBMS:**

* Gestión estructurada mediante **tablas**.
* Cumplimiento de las propiedades **ACID** (**A**tomicidad, **C**onsistencia, **A**islamiento [Isolation], **D**urabilidad).
* Soporte para múltiples **usuarios concurrentes**.
* Mecanismos de copia de seguridad, permisos y auditorías.

---

## 🏗️ 2.3.2. Conceptos Fundamentales de SQL

### Estructura Lógica de una Base de Datos

Los gestores de bases de datos almacenan la información en una **jerarquía de elementos lógicos**:

1.  **Base de Datos / Esquema**: Contenedor lógico principal de todas las tablas, vistas y relaciones.
2.  **Tabla**: Estructura principal que almacena los datos en formato de **filas y columnas**.
3.  **Columna (Campo o Atributo)**: Define una **característica o propiedad** de la entidad. Cada columna tiene un **tipo de dato** definido.
4.  **Fila (Registro o Tupla)**: Representa un **elemento único** de la entidad. Cada fila contiene los valores específicos para todas las columnas.
5.  **Relación**: Enlace entre dos tablas que se establece mediante **claves primarias (PK)** y **claves foráneas (FK)**. Permite mantener la **integridad referencial**.

---

#### 🧱 Tipos de Datos y Restricciones

Definir correctamente los tipos de datos y las restricciones es crucial para la **integridad** y la **eficiencia** de la base de datos.

##### Tipos de Datos Comunes

| Tipo de Dato | Ejemplo | Descripción |
| :--- | :--- | :--- |
| **INT, SERIAL** | `1, 23, 456` | Números enteros, con o sin **autoincremento** (SERIAL). |
| **VARCHAR(n)** | `'Madrid'` | Texto de **longitud variable**, hasta un máximo de *n* caracteres. |
| **CHAR(n)** | `'YES'` | Texto de **longitud fija** de *n* caracteres. |
| **DATE, TIMESTAMP** | `'2025-10-27'` | Fechas y marcas de tiempo (incluye hora). |
| **BOOLEAN** | `TRUE/FALSE` | Valor lógico (verdadero o falso). |
| **NUMERIC(p,s)** | `123.45` | Números con **precisión** (*p* dígitos) y **escala** (*s* decimales) específicas. |

##### Restricciones Principales

| Restricción | Propósito |
| :--- | :--- |
| **PRIMARY KEY (PK)** | Identifica de forma **única** cada registro. **No puede ser nula ni duplicada**. |
| **FOREIGN KEY (FK)** | Referencia una **PK de otra tabla**, estableciendo **relaciones** y manteniendo la integridad. |
| **NOT NULL** | Impide que un campo quede **vacío** al insertar o actualizar un registro. |
| **UNIQUE** | Garantiza que **no existan valores duplicados** en esa columna, aunque sí puede ser nulo (excepto si también es PK). |
| **CHECK** | Define una **condición lógica** que deben cumplir los datos al ser insertados. |
| **DEFAULT** | Asigna un **valor por defecto** cuando no se especifica uno al insertar el registro. |

---

#### 🤝 Relaciones entre Tablas (Cardinalidad)

Las relaciones permiten vincular datos entre distintas tablas, evitando duplicaciones innecesarias y asegurando coherencia.

| Relación | Símbolo | Descripción |
| :--- | :---: | :--- |
| **Uno a uno** | **1:1** | Un registro de una tabla se asocia con **exactamente uno** de otra tabla. |
| **Uno a muchos** | **1:N** | Un registro de una tabla puede estar relacionado con **varios** registros de otra tabla. |
| **Muchos a muchos** | **N:M** | Varios registros de una tabla pueden asociarse con **varios** registros de otra. **Se resuelve mediante una tabla intermedia.** |

### 📝 Sentencias Fundamentales (CRUD)

SQL se basa en cuatro operaciones básicas conocidas como **CRUD** (Create, Read, Update, Delete), que representan la gestión completa de datos:

| Operación | Sentencia SQL | Propósito | Ejemplo |
| :--- | :--- | :--- | :--- |
| **C**reate | **`INSERT INTO`** | Inserta un **nuevo registro** (fila) en una tabla. | `INSERT INTO empleados (nombre, salario) VALUES ('Ana', 2500);` |
| **R**ead | **`SELECT`** | **Muestra** o recupera los registros de una tabla. | `SELECT * FROM empleados;` |
| **U**pdate | **`UPDATE`** | **Modifica datos existentes** en uno o varios registros. | `UPDATE empleados SET salario = 3000 WHERE id = 2;` |
| **D**elete | **`DELETE FROM`** | **Elimina** registros de una tabla. | `DELETE FROM empleados WHERE id = 3;` |

---

## 🔑 2.3.3. Cláusulas Importantes

Estas cláusulas se utilizan principalmente junto con la sentencia `SELECT` para refinar y presentar los datos:

* **`WHERE`**: **Filtra** registros que cumplen una condición específica.
    * *Ejemplo*: `SELECT * FROM empleados WHERE salario > 2000;`
* **`ORDER BY`**: **Ordena** los resultados ascendente (`ASC`) o descendentemente (`DESC`).
    * *Ejemplo*: `SELECT * FROM empleados ORDER BY salario DESC;`
* **`DISTINCT`**: Evita mostrar **valores duplicados** en la columna especificada.
    * *Ejemplo*: `SELECT DISTINCT departamento FROM empleados;`
* **`LIMIT / OFFSET`**: Controla el **número de filas devueltas** (`LIMIT`) y dónde empezar a contarlas (`OFFSET`). Útil para paginación.
    * *Ejemplo*: `SELECT * FROM empleados LIMIT 10 OFFSET 20;` (Muestra 10 filas, saltándose las primeras 20).
* **`LIKE`**: Se utiliza en la cláusula `WHERE` para buscar **patrones en texto**. Usa comodines (`%`, `_`).
    * *Ejemplo*: `WHERE nombre LIKE 'A%';` (Busca nombres que empiecen por 'A').
* **`BETWEEN / IN`**:
    * **`BETWEEN`**: Evalúa **rangos** de valores. *Ejemplo*: `WHERE edad BETWEEN 20 AND 30;`
    * **`IN`**: Evalúa si un valor está dentro de un **conjunto** de valores. *Ejemplo*: `WHERE pais IN ('España', 'Francia');`

---

### 🗃️ DDL, DML, DCL y TCL

SQL se divide en sublenguajes según la función principal de sus comandos:

| Sublenguaje | Acrónimo | Función | Comandos Clave |
| :--- | :--- | :--- | :--- |
| **Data Definition Language** | **DDL** | Define la **estructura** de la base de datos (tablas, índices, etc.). | `CREATE, ALTER, DROP` |
| **Data Manipulation Language** | **DML** | **Manipula los datos** dentro de las estructuras existentes. | `SELECT, INSERT, UPDATE, DELETE` |
| **Data Control Language** | **DCL** | Controla los **permisos** y accesos de los usuarios. | `GRANT, REVOKE` |
| **Transaction Control Language** | **TCL** | Gestiona las **transacciones** y asegura la integridad ACID. | `COMMIT, ROLLBACK, SAVEPOINT` |

### 🔒 Integridad y Transacciones

Las **transacciones** son unidades lógicas de trabajo que agrupan una o más operaciones SQL. Son esenciales porque garantizan las **propiedades ACID**:

* **A**tomicidad: **Todo o nada**. Una transacción se completa en su totalidad o no se realiza ningún cambio.
* **C**onsistencia: Los datos mantienen su **validez**. La transacción lleva la DB de un estado válido a otro estado válido.
* **I**solamiento: Las transacciones **no interfieren entre sí** ni se ven afectadas por operaciones concurrentes.
* **D**urabilidad: Los cambios **confirmados** (`COMMIT`) se mantienen de forma permanente, incluso tras fallos del sistema.

---

## 🛠️ 2.3.4. Creación y Manipulación de Bases de Datos y Tablas (DDL)

*(Esta sección incluiría comandos como `CREATE DATABASE`, `CREATE TABLE`, `ALTER TABLE` y `DROP TABLE`)*

---

## 📝 2.3.5. Inserción, Actualización y Eliminación de Datos (DML)

Estas operaciones forman parte de las cuatro funciones básicas del modelo **CRUD** (*Create, Read, Update, Delete*), esenciales en la manipulación de datos de cualquier RDBMS.

### Inserción de Datos (`INSERT INTO`)

La inserción consiste en **añadir nuevos registros (filas)** a una tabla existente.

Esta operación **aumenta el conjunto de datos** disponibles y debe **respetar las restricciones definidas** (tipo de datos, claves primarias, foráneas, etc.).

```sql
INSERT INTO nombre_tabla ( columna1 , columna2 , ...)
VALUES ( valor1 , valor2 , ...) ;
INSERT INTO empleados ( nombre , salario , departamento )
VALUES
  ( ’ Ana ’ , 2500 , ’ Ventas ’) ,
  ( ’ Luis ’ , 3000 , ’ TI ’) ,
  ( ’ Marta ’ , 2800 , ’ RRHH ’) ;
```

### Actualización de Datos (UPDATE)
Permite modificar los valores existentes en una o más filas de una tabla. Es una operación crítica, ya que puede afectar a múltiples registros.

```sql
UPDATE nombre_tabla
SET columna1 = valor1 , columna2 = valor2 , ...
WHERE condici ó n ;
UPDATE empleados
SET salario = salario + 200
WHERE departamento = ’ Ventas ’;
```

### Eliminación de Datos (DELETE FROM)
Elimina uno o varios registros de una tabla. Debe usarse con cuidado, ya que los datos no pueden recuperarse fácilmente si no se ha realizado una copia de seguridad.

```sql
DELETE FROM nombre_tabla
WHERE condici ó n ;
DELETE FROM empleados
WHERE salario < 1200;
```

## 🔍 2.3.6. Consultas Básicas (Sentencias SELECT)

El comando **`SELECT`** es el más utilizado en SQL, ya que permite **consultar, filtrar y analizar datos** almacenados en tablas. Es la base de cualquier operación de lectura, desde informes simples hasta análisis de datos complejos.

### Estructura básica de consulta

La sintaxis completa y estándar de una sentencia `SELECT` sigue un orden lógico estricto (aunque no todas las cláusulas son obligatorias):

```sql
SELECT columnas
FROM nombre_tabla
[ WHERE condición ]
[ ORDER BY columna ]
[ LIMIT número ];
SELECT * FROM empleados ;
SELECT nombre , salario FROM empleados ;
```

### 🔎 Filtrado de Resultados (`WHERE`)

La cláusula **`WHERE`** restringe los registros devueltos, permitiendo filtrar por condiciones específicas.

| Operador | Descripción | Ejemplo |
| :--- | :--- | :--- |
| **Igualdad / Diferencia** | `=`, `!=`, o `<>` | `WHERE pais = 'España'` |
| **Comparación Numérica** | `>`, `<`, `>=`, `<=` | `WHERE salario >= 2500` |
| **Rangos** | `BETWEEN` | `WHERE edad BETWEEN 20 AND 30` |
| **Conjuntos** | `IN` | `WHERE departamento IN ('Ventas', 'TI', 'RRHH')` |
| **Texto Parcial** | `LIKE` | `WHERE nombre LIKE 'A%'` (Busca nombres que empiecen por A) |
| **Valores Nulos** | `IS NULL / IS NOT NULL` | `WHERE email IS NOT NULL` |
| **Condiciones Múltiples** | `AND`, `OR`, `NOT` | `WHERE salario > 3000 AND departamento = 'TI'` |

---

### 🗂️ Orden, Distinción y Limitación de Resultados

Estos modificadores afectan la presentación y el volumen de los datos extraídos:

* **`ORDER BY`**: **Ordena** los resultados de la consulta.
    * Por defecto es **Ascendente** (`ASC`).
    * Se puede especificar **Descendente** (`DESC`).
    * *Ejemplo*: `ORDER BY salario DESC, nombre ASC;`
* **`DISTINCT`**: Muestra solo **valores únicos** (elimina duplicados) de las columnas seleccionadas.
    * *Ejemplo*: `SELECT DISTINCT pais FROM clientes;`
* **`LIMIT / OFFSET`**: **Restringe** la cantidad de registros devueltos. `OFFSET` omite las primeras líneas y se usa para la paginación.
    * *Ejemplo*: `LIMIT 10 OFFSET 5;` (Muestra 10 filas, saltándose las primeras 5).

### 🔢 Funciones y Expresiones Básicas (Agregación)

Las funciones de agregación se utilizan para realizar cálculos sobre un conjunto de filas y devolver un único valor resumido.

| Función | Propósito | Ejemplo |
| :--- | :--- | :--- |
| **`COUNT()`** | **Cuenta** el número de registros (filas). | `SELECT COUNT(*) FROM empleados;` |
| **`SUM()`** | **Suma** los valores de una columna numérica. | `SELECT SUM(salario) FROM empleados;` |
| **`AVG()`** | Calcula la **media** (promedio) de una columna numérica. | `SELECT AVG(salario) FROM empleados;` |
| **`MIN()`/`MAX()`** | Devuelve el **valor mínimo** o el **máximo**. | `SELECT MAX(salario) FROM empleados;` |

> 💡 Se suelen utilizar los **alias (`AS`)** para dar un nombre legible al resultado de la función:
>
> `SELECT AVG(salario) AS salario_medio FROM empleados;`

---

### 🚀 Jerarquía de Ejecución de una Consulta `SELECT`

Aunque SQL se escribe de arriba abajo, el motor de la base de datos ejecuta internamente las consultas en un orden lógico estricto. Este orden es clave para comprender por qué algunas cláusulas no pueden usarse juntas (ej: no se puede usar un alias de `SELECT` en la cláusula `WHERE`).

1.  **`FROM`**: Selecciona la tabla origen (o realiza los `JOINs`).
2.  **`WHERE`**: **Filtra filas** individuales.
3.  **`GROUP BY`**: Agrupa los resultados.
4.  **`HAVING`**: **Filtra grupos** resultantes (se aplica después de `GROUP BY`).
5.  **`SELECT`**: Devuelve las columnas específicas (se ejecutan las funciones de agregación).
6.  **`ORDER BY`**: Ordena el resultado final.
7.  **`LIMIT/OFFSET`**: Limita las filas finales a mostrar.

---

## 🔗 2.3.7. Relaciones y Joins

El modelo relacional de bases de datos se basa en la idea de que los datos se distribuyen entre múltiples tablas **interconectadas** mediante relaciones.

Estas relaciones permiten representar el mundo real de forma estructurada y **evitar redundancia de datos**.

### Claves y Relaciones entre Tablas

* **Clave Primaria (Primary Key - PK)**: Identifica de forma **única** cada fila de una tabla. No puede contener valores nulos ni repetidos.
* **Clave Foránea (Foreign Key - FK)**: Campo que **referencia la PK de otra tabla**, estableciendo una relación entre ambas.

Estas restricciones aseguran la **integridad referencial** del sistema: no se pueden crear o eliminar registros que rompan la relación entre tablas.

### 🔄 Tipos de Relaciones (Cardinalidad)

Las relaciones describen cómo se vinculan los registros entre tablas, definiendo la **cardinalidad** de la asociación:

| Tipo | Símbolo | Descripción |
| :--- | :---: | :--- |
| **Uno a uno** | **1:1** | Un registro de una tabla se asocia con **solo un** registro de otra tabla. |
| **Uno a muchos** | **1:N** | Un registro de una tabla puede estar relacionado con **varios** registros en otra. |
| **Muchos a muchos** | **N:M** | Múltiples registros de una tabla se asocian con **múltiples** registros de otra. |
| **Autorreferencia** | | Una tabla se relaciona consigo misma (ej: la tabla `empleados` tiene un campo que apunta al ID de su jefe, que también es un empleado). |

---

### 🤝 El Comando JOIN (Unión de Tablas)

Un **`JOIN`** permite **combinar datos de dos o más tablas** en función de una **condición común**, que normalmente es la igualdad entre una **clave primaria (PK)** de una tabla y una **clave foránea (FK)** de otra.

```sql
SELECT columnas
FROM tabla1
JOIN tabla2
ON tabla1 . columna = tabla2 . columna ;
```

### 🧩 Tipos de JOIN

El tipo de `JOIN` determina qué filas se incluyen en el resultado, basándose en si existe o no una coincidencia en la tabla opuesta:

| Tipo de JOIN | Comportamiento | Descripción |
| :--- | :--- | :--- |
| **`INNER JOIN`** | **Intersección** | Devuelve solo las filas que tienen **coincidencias** en ambas tablas. |
| **`LEFT JOIN`** | **Tabla izquierda completa** | Devuelve **todas** las filas de la tabla izquierda, y las coincidencias de la derecha (si no hay, devuelve `NULL` en las columnas de la derecha). |
| **`RIGHT JOIN`** | **Tabla derecha completa** | Devuelve **todas** las filas de la tabla de la derecha, y las coincidencias de la izquierda (si no hay, devuelve `NULL` en las columnas de la izquierda). |
| **`FULL JOIN`** | **Unión completa** | Devuelve **todas** las filas con coincidencias o no en cualquiera de las tablas. |
| **`CROSS JOIN`** | **Producto Cartesiano** | Combina **cada fila de una tabla con todas las de la otra**. Genera `filas_A * filas_B` resultados. |
| **`SELF JOIN`** | **Unión interna a sí misma** | Una tabla se une **consigo misma** (necesita el uso de alias para diferenciar las referencias). |

---

## 🧐 2.3.8. Subconsultas y Vistas

### Subconsultas (Subqueries)

Una **subconsulta** es una instrucción **`SELECT` dentro de otra consulta** (puede ir en el `FROM`, `WHERE`, o `SELECT`). Se evalúa **primero** y su resultado es utilizado por la consulta externa.

```sql
SELECT columnas
FROM tabla
WHERE columna_operador ( SELECT ...) ;
```

### Tipos de Subconsultas según el Resultado

Las subconsultas se clasifican según el tipo de resultado que devuelven a la consulta principal:

* **Escalar**: Devuelve un **solo valor** (una sola fila y una sola columna).
* **De Fila**: Devuelve una **sola fila** con varias columnas.
* **De Conjunto**: Devuelve **varias filas** (actúa como una tabla temporal).
* **Correlacionada**: Se ejecuta **una vez por cada fila** de la consulta principal (es dependiente de la externa).

---

### Vistas (`VIEWS`)

Una vista es una **tabla virtual** que almacena una consulta `SELECT`.

Las vistas no contienen datos físicos en sí mismas, sino que muestran datos provenientes de otras tablas cada vez que se consultan. Permiten **simplificar consultas complejas**, mejorar la **legibilidad** del código y aplicar **restricciones de seguridad** (mostrando solo columnas específicas a ciertos usuarios).

```sql
CREATE VIEW nombre_vista AS
SELECT columnas FROM tabla WHERE condici ó n ;
CREATE VIEW vista_empleados_ti AS
SELECT nombre , salario FROM empleados WHERE departamento = ’ TI ’;
```

### ✅ Beneficios de usar Vistas

Las vistas son herramientas poderosas para la abstracción y el control en una base de datos:

* **Simplicidad**: Permiten **reutilizar consultas complejas** sin necesidad de reescribirlas constantemente.
* **Seguridad**: Se puede conceder acceso a la **vista** y **no a las tablas subyacentes**, restringiendo la visibilidad de datos sensibles.
* **Mantenimiento**: Si cambia la estructura interna de las tablas (ej., se añade una columna), las aplicaciones que consumen la vista **pueden seguir funcionando** sin cambios.
* **Consistencia**: Facilita mantener una capa de **abstracción** entre los datos físicos y el modelo lógico que las aplicaciones utilizan.

---

### ➕ `UNION` y `UNION ALL`

La cláusula `UNION` permite **combinar los resultados de varias consultas `SELECT`** en una sola salida, siempre y cuando las consultas tengan el **mismo número de columnas** y **tipos de datos compatibles** en el mismo orden.

* **`UNION`**: Combina los resultados **eliminando duplicados**.
* **`UNION ALL`**: Combina los resultados **manteniendo duplicados**.

---

## 🔒 2.3.9. Gestión de Usuarios y Permisos (DCL)

La gestión de **usuario y permisos** en SQL es esencial para mantener la **seguridad, integridad y control de acceso** en las bases de datos. Cada gestor permite definir **qué usuarios** pueden conectarse, leer, modificar o administrar datos y objetos del sistema.

### Conceptos clave 🗝️

La gestión de acceso se basa en la interacción de cuatro elementos fundamentales:

* **Usuario**: Representa una **identidad** que puede conectarse al servidor de base de datos y ejecutar operaciones.
* **Rol**: Agrupa un conjunto de **privilegios** y puede asignarse a uno o varios usuarios (facilitando la administración).
* **Privilegio**: **Derecho específico** para realizar una acción (consultar, insertar, eliminar, etc.) sobre un objeto (tabla, vista, función, etc.).
* **Esquema**: Espacio de **nombre lógico** dentro de una base de datos donde se agrupan objetos relacionados (tablas, vistas, funciones, etc.).

---

### Creación y Gestión de Usuarios / Roles

*(Esta sección contendría los comandos DCL como `CREATE USER`, `CREATE ROLE`, `GRANT` y `REVOKE`)*

```sql
CREATE ROLE nombre_usuario WITH LOGIN PASSWORD ’ contrase ñ a ’;
CREATE ROLE app_reader WITH LOGIN PASSWORD ’ segura123 ’;
GRANT CONNECT ON DATABASE empresa TO app_reader ;
```

### Asignación de Privilegios (Comando `GRANT`) 🔑

Los privilegios son los derechos que se asignan a un usuario o rol para interactuar con un objeto específico (tabla, vista, etc.):

| Privilegio | Acción Permitida |
| :--- | :--- |
| **`SELECT`** | Permite **leer** datos de una tabla o vista. |
| **`INSERT`** | Permite **insertar** nuevos registros (filas). |
| **`UPDATE`** | Permite **modificar** registros existentes. |
| **`DELETE`** | Permite **eliminar** registros. |
| **`ALL PRIVILEGES`** | Concede **todos** los permisos posibles sobre un objeto. |

---

### Roles y Herencia 👥

Un **Rol** simplifica la administración de permisos. En sistemas avanzados como **PostgreSQL**, se permite crear **roles jerárquicos** que **heredan privilegios** de otros roles.

**Ejemplo de Herencia**: Si el rol `gerente` hereda los permisos del rol `empleados`, cualquier usuario asignado a `gerente` obtendrá automáticamente todos los derechos de `empleados` más los específicos de `gerente`.

```sql
CREATE ROLE empleados ;
CREATE ROLE gerente INHERIT ;
GRANT empleados TO gerente ;
```

### ⚙️ 2.3.10. Transacciones y Control de Errores

Las **transacciones** son el mecanismo que garantiza la **consistencia** e **integridad** de los datos en una base de datos. Permiten agrupar un conjunto de operaciones SQL en un **bloque atómico**: o se ejecutan todas correctamente, o se deshacen todas.

#### Propiedades ACID

Las transacciones aseguran que la base de datos mantenga un estado fiable, garantizando las siguientes propiedades fundamentales:

* **A**tomicidad: **Todo o nada**. Todas las operaciones dentro de la transacción se ejecutan como una sola unidad.
* **C**onsistencia: La base de datos pasa de un estado válido a otro, manteniendo la **validez de los datos** y respetando todas las reglas y restricciones.
* **I**solamiento (Aislamiento): Las transacciones **concurrentes no interfieren entre sí**. Para el usuario, cada transacción parece ejecutarse de forma aislada.
* **D**urabilidad: Una vez **confirmada** (`COMMIT`), la transacción se guarda de forma **permanente** y se mantiene incluso ante fallos del sistema o reinicios.

---

## 🔁 2.3.11. Ciclo de Vida de una Transacción
```sql
BEGIN ; -- Inicia la transacci ó n
UPDATE cuentas SET saldo = saldo - 100 WHERE id = 1;
UPDATE cuentas SET saldo = saldo + 100 WHERE id = 2;
COMMIT ; o ROLLBACK ; -- Guarda los cambios ( é xito ) o --
Revierte todos los cambios
```

### Control de errores
```sql
BEGIN ;
  UPDATE cuentas SET saldo = saldo - 100 WHERE id = 1;
  UPDATE cuentas SET saldo = saldo + 100 WHERE id = 2;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK ;
    RAISE NOTICE ’ Error ␣ en ␣ la ␣ transacci ón , ␣ cambios ␣ revertidos . ’;
END ;
```

### 🔄 2.3.11. Ciclo de Vida de una Transacción

*(Esta sección contendría los comandos de control de transacciones como `BEGIN`, `COMMIT` y `ROLLBACK`)*

#### Control de Concurrencia

En entornos con múltiples usuarios, varias transacciones pueden intentar modificar los mismos datos simultáneamente. El sistema gestiona esta situación mediante **bloqueos** y **niveles de aislamiento**.

##### Tipos de Bloqueos (Locks)

* **Shared Lock** (Bloqueo Compartido): Permite **lectura concurrente**, pero bloquea las operaciones de escritura de otros.
* **Exclusive Lock** (Bloqueo Exclusivo): Impide tanto la lectura como la escritura a otros miembros mientras se modifica un dato.

##### Niveles de Aislamiento de Transacciones

Definen el grado en que una transacción debe estar aislada de las modificaciones realizadas por otras transacciones concurrentes.

| Nivel de Aislamiento | Comportamiento | Riesgos Evitados |
| :--- | :--- | :--- |
| **READ UNCOMMITED** | Permite leer datos **aún no confirmados** (sucios). | *Ninguno.* |
| **READ COMMITED** | Solo permite leer datos **ya confirmados** (`COMMIT`). | **Lectura Sucia** (*Dirty Reads*). |
| **REPEATABLE READ** | Garantiza que los datos leídos **no cambien** dentro de la transacción. | **Lectura No Repetible** (*Non-Repeatable Reads*). |
| **SERIALIZABLE** | Simula la **ejecución secuencial** de transacciones. | Evita **Todos** los problemas de concurrencia. |

#### Interbloqueos (Deadlocks)

Un *deadlock* ocurre cuando dos transacciones se **bloquean mutuamente** esperando que la otra libere un recurso que necesita. Los Sistemas Gestores de Bases de Datos (SGBD) suelen detectarlo automáticamente y **cancela una de las transacciones** involucradas para que la otra pueda avanzar.

---

## 💾 2.3.12. Exportación, Importación y Backups

El mantenimiento de una base de datos no solo consiste en almacenar y consultar datos, sino también en garantizar su **seguridad, disponibilidad y recuperación ante fallos**.

### Exportación de Datos (Backups)

La exportación o respaldo consiste en generar una copia que contenga la **estructura**, los **datos** o ambos.

* **`pg_dump`**: Crea una copia de seguridad de una **base de datos individual** (PostgreSQL).
* **`pg_dumpall`**: Permite respaldar **todas las bases de datos** del servidor, junto con roles y configuraciones globales (PostgreSQL).
* **`psql`**: Cliente interactivo que también se usa para ejecutar archivos `.sql` y **restaurar** datos.

### Importación y Restauración

La importación o restauración consiste en reconstruir la base de datos a partir de un archivo de respaldo.

* **Verificar privilegios** de los usuarios antes de importar.
* **Adaptar referencias** de usuario o esquemas si cambian entre entornos (producción, desarrollo).
* Al migrar entre distintos gestores (ej., MySQL a PostgreSQL), exportar los datos en formatos **CSV o JSON** para evitar incompatibilidades.

### Automatización de Backups

Para entornos productivos, los *backups* deben **automatizarse** mediante tareas programadas (`cron` en Linux) o herramientas de orquestación.

* Se suelen intercalar copias de seguridad **completas** con copias **incrementales** para optimizar el almacenamiento y la velocidad de restauración.
