## 🚀 3.1 Fundamentos Sólidos de Java

Los fundamentos de **Java** se establecen sobre una base estrictamente estructurada, caracterizada por:

* **Tipado Fuerte y Estático:** Aporta seguridad y consistencia al código.
* **Modelo de Ejecución Seguro (JVM):** La **Java Virtual Machine** provee un entorno controlado.
* **Orientación Total al Paradigma de Objetos (POO):** Todo el desarrollo se centra en **Clases** y **Objetos**.

Estos principios hacen de Java un lenguaje **Portátil**, **Robusto** y **Mantenible**, ideal para el desarrollo **backend empresarial**.

---

### 💡 3.1.1. Sintaxis Básica, Tipos de Datos y Control de Flujo

#### Sintaxis Básica y Estructura General

Java posee las siguientes características fundamentales:

| Característica | Descripción |
| :--- | :--- |
| **Compilado e Interpretado** | El código fuente (`.java`) se compila a **bytecode** (`.class`), que luego es ejecutado por la **JVM**. Esto garantiza la **portabilidad** ("*Write once, run anywhere*"). |
| **Fuertemente Tipado** | Cada variable debe tener un **tipo de dato** definido explícitamente. |
| **Orientado a Objetos** | La lógica de la aplicación gira completamente en torno a **clases y objetos**. |
| **Basado en Bloques** | Utiliza llaves (`{}`) para definir el **alcance** (scope) de instrucciones, clases y métodos. |

#### Estructura Mínima de un Programa Java
```java
public class Main {
  public static void main ( String [] args ) {
    System . out . println ( " Hola , ␣ mundo " ) ;
  }
}
```
* `public class Main`: Define la **clase pública** principal, llamada `Main`. Es crucial que el nombre del archivo (`Main.java`) **coincida exactamente** con el nombre de esta clase.
* `public static void main(String[] args)`: Es el **punto de entrada** (entry point) donde comienza la ejecución del programa.
* `System.out.println(...)`: Instrucción para imprimir una línea de texto en la **consola**. Esta instrucción se descompone en:
    * `System`: Es una **clase estándar** que representa el sistema operativo.
    * `out`: Es un **flujo de salida** estándar (output stream).
    * `println`: Es el **método** que imprime el texto y, automáticamente, añade un salto de línea.
 
### 🏷️ Tipos de Datos y Variables

Una **variable** es un espacio en la memoria del programa identificado por un nombre que se utiliza para almacenar un valor.

En Java, toda variable **debe declararse** antes de su uso.

```java
int edad = 25;
String nombre = " V í ctor " ;
```
#### Tipos Primitivos y de Referencia

Java distingue claramente entre dos categorías de tipos de datos:

| Tipo | Almacenamiento | Características | Ejemplos |
| :--- | :--- | :--- | :--- |
| **Primitivos** | Se guardan directamente en la **memoria Stack**. Tienen un tamaño fijo y no son objetos. | **Enteros:** `byte`, `short`, `int`, `long`<br>**Reales:** `float`, `double`<br>**Lógico:** `boolean`<br>**Carácter:** `char` | `int edad = 30;` |
| **Referencia** | Almacenan una **referencia** (puntero) a un objeto que se encuentra en la **memoria Heap**. | Son instancias de clases; guardan la dirección de memoria, no el valor directo. | `String`, `Array`, `Class`, `List`, `Scanner`, etc. |

### 🔄 Clases Envolventes (Wrapper Classes)

Cada tipo primitivo en Java tiene una clase equivalente dentro del paquete `java.lang`, conocida como **Clase Envolvente** o **Wrapper**. Estas clases permiten:

1.  Convertir entre tipos de datos.
2.  Usar métodos específicos para el tipo (ej. `Integer.parseInt()`).
3.  Trabajar con **colecciones**, ya que las colecciones (como `ArrayList`) solo almacenan objetos, no tipos primitivos.

| Tipo Primitivo | Clase Envolvente (Wrapper) |
| :--- | :--- |
| `int` | `Integer` |
| `double` | `Double` |
| `boolean` | `Boolean` |
| `char` | `Character` |

### ➡️ Control de Flujo

El control de flujo determina el orden en que se ejecutan las instrucciones de un programa.

* **`if / else if / else` (Condicional)**:
    Permite ejecutar un bloque de código basado en una condición booleana.

    ```java
    int edad = 18;
    if (edad >= 18) {
        System.out.println("Mayor de edad");
    else {
        System.out.println("NO mayor de edad");
    }
    ```
  * **`switch` (Selección Múltiple)**:
  Evalúa una expresión frente a múltiples valores posibles (`case`).

    ```java
    String dia = "Lunes";
    switch (dia) {
        case "Lunes":
            System.out.println("Inicio de semana");
            break;
        case "Viernes":
            System.out.println("Fin de semana");
            break;
        default:
            System.out.println("Día normal");
    }
    ```

* **`for` (Bucle Determinado)**:
    Bucle con inicialización, condición de terminación y actualización (incremento/decremento).

    ```java
    for (int i = 0; i < 5; i++) {
        System.out.println("Iteración " + i);
    }
    ```

* **`while` (Bucle Condicional)**:
    Se ejecuta repetidamente mientras la condición booleana sea verdadera.

    ```java
    int i = 0;
    while (i < 5) {
        System.out.println(i);
        i++;
    }
    ```

* **`do-while` (Bucle Condicional con ejecución inicial)**:
    Garantiza que el bloque de código se ejecute **al menos una vez**, ya que la condición se evalúa al final.

    ```java
    int i = 0;
    do {
        System.out.println(i);
        i++;
    } while (i < 5);
    ```

* **`for-each` (Bucle para Colecciones)**:
    Simplifica la iteración sobre arrays y colecciones (implementaciones de `Iterable`).

    ```java
    String[] nombres = {"Ana", "Carlos", "Lucía"};
    for (String nombre : nombres) {
        System.out.println(nombre);
    }
    ```

#### Palabras Clave de Control

Estas palabras clave modifican el flujo normal de bucles y métodos:

* `break`: **Interrumpe** inmediatamente el bucle (`for`, `while`, `do-while`) o la estructura `switch` más cercana.
* `continue`: **Salta** a la siguiente iteración del bucle, omitiendo el código restante de la iteración actual.
* `return`: **Finaliza** la ejecución del método y, opcionalmente, devuelve un valor.

## 🧱 3.1.2. Clases, Objetos y Métodos

### 1. Clases

Una **Clase** es un **molde** o **plano** que define los atributos y comportamientos de un tipo de objeto.

**Componentes Principales de una Clase:**

* **Atributos:** Variables internas que describen el **estado** del objeto.
* **Constructores:** Métodos especiales para **inicializar** un nuevo objeto.
* **Métodos:** Acciones o **comportamientos** que el objeto puede ejecutar.
* **Modificadores de Acceso:** Controlan la **visibilidad** (`public`, `private`, `protected`, etc.) de los miembros.
* **Bloques Estáticos o de Inicialización:** Se ejecutan una sola vez al cargar la clase en la memoria.

### 2. Objetos

Un **Objeto** es una **instancia concreta** de una clase; es una entidad real que ocupa memoria y tiene su propio estado.

Para crear un objeto se utiliza la palabra reservada `new`.

```java
// Ejemplo de creación de objeto
Coche miCoche = new Coche("Toyota", 120);
```
### Proceso Interno al Crear un Objeto

Cuando se crea un objeto utilizando la palabra reservada `new`, internamente se ejecutan los siguientes pasos:

1.  La **JVM** (Java Virtual Machine) reserva espacio en la memoria **Heap** para el nuevo objeto.
2.  Se invoca al **constructor** correspondiente de la clase.
3.  Se devuelve una **referencia** (puntero) al objeto, la cual se almacena en la variable (ej: `miCoche`).

---

## 🏛️ 3.1.4. Pilares de la Programación Orientada a Objetos (POO)

Java se construye sobre los pilares fundamentales de la POO, lo que permite modelar entidades del mundo real como objetos que interactúan entre sí.

### Encapsulación 🔒

La **Encapsulación** es el mecanismo que **protege el estado interno** de un objeto y define claramente qué interacciones externas son permitidas. En Java, esto se logra:

* **Ocultando Atributos:** Declarando los atributos como **privados** (`private`), haciéndolos accesibles solo desde la propia clase.
* **Exponiendo Métodos de Acceso:** Utilizando **Getters** (para leer) y **Setters** (para modificar) públicos. Esto permite incluir **validaciones** dentro de los *setters* para garantizar la integridad y seguridad de los datos.

* #### Modificadores de Acceso en Java 🔒

Los modificadores de acceso controlan la **visibilidad** y el **alcance** de los miembros (atributos, métodos, clases) en Java:

| Modificador | Alcance de Acceso |
| :--- | :--- |
| `public` | Accesible desde la **misma clase**, **subclases**, **mismo paquete** y **otras clases** (acceso total). |
| `protected` | Accesible desde la **misma clase**, **subclases** y **mismo paquete**. |
| `default` (Sin modificador) | Accesible desde la **misma clase** y **mismo paquete** (acceso a nivel de paquete). |
| `private` | Accesible **solo** desde la **misma clase**. |

#### Ventajas de la Encapsulación

Las principales ventajas de aplicar el principio de Encapsulación son:

* **Protección de Datos:** Salvaguarda los datos de alteraciones indebidas o accesos no controlados.
* **Mejora la Mantenibilidad:** El código es más fácil de mantener y depurar.
* **Flexibilidad:** Permite cambiar la implementación interna sin afectar a otros módulos o al código cliente que consume el objeto.

---

### 2. Herencia 🧬

La **Herencia** es un mecanismo que permite crear una nueva clase (**subclase** o **hija**) basada en otra clase existente (**superclase** o **padre**), facilitando la **reutilización de código** y la extensión de funcionalidades.

#### Palabras Clave de la Herencia

* `extends`: Indica que una clase **hereda** de otra (establece la relación **subclase** $\rightarrow$ **superclase**).
* `super`: Se utiliza para **acceder a miembros** (métodos o atributos) de la clase padre o para **invocar al constructor del padre**.

#### Tipos de Herencia en Java

| Tipo | Estado | Descripción | Alternativa |
| :--- | :--- | :--- | :--- |
| **Simple** | Permitida | Una clase solo puede heredar directamente de **una única clase**. | N/A |
| **Múltiple** | No permitida | No se permite heredar de múltiples clases para evitar el "problema del diamante". | Se utilizan **Interfaces** para lograr una funcionalidad similar. |

#### Clases Abstractas

Una **clase abstracta** define un comportamiento común a una jerarquía de clases, pero **deja algunos métodos sin implementar**.

* Una clase abstracta puede contener métodos normales y métodos **abstractos**.
* No puede ser instanciada directamente. Las clases hijas deben implementar los métodos abstractos.

### 3. Polimorfismo 🎭

El **Polimorfismo** (del griego, *muchas formas*) permite que una misma acción se comporte de diferentes maneras dependiendo del objeto que la ejecute.

| Tipo de Polimorfismo | Mecanismo | Resolución |
| :--- | :--- | :--- |
| **Por Sobreescritura (*Overriding*)** | Una **subclase** redefine un método que ha heredado de su clase padre. | Se resuelve en **Tiempo de Ejecución**. Se utiliza la anotación `@Override` para mayor claridad y control de errores del compilador. |
| **Por Sobrecarga (*Overloading*)** | Se utiliza el **mismo nombre de método** dentro de una clase, pero con **distintos parámetros** (diferente número, tipo o secuencia de argumentos). | Se resuelve en **Tiempo de Compilación**. |

## 💾 3.1.5. Colecciones y Estructuras de Datos

Java proporciona el **Java Collections Framework (JCF)**, un conjunto de interfaces que facilitan la gestión de conjuntos de datos dinámicos.

### Arrays (Arreglos)

* Son estructuras con un **tamaño fijo** que almacenan elementos del mismo tipo.
* El acceso se realiza por **índices**, que van desde `0` hasta `length - 1`.
* Para colecciones dinámicas que necesitan cambiar de tamaño, se usan clases como `ArrayList`.

### Listas (`List`) 📝

Permiten almacenar **elementos ordenados**, con acceso por índices y **posibilidad de duplicados**.

* `LinkedList`: Más eficiente en operaciones de **inserción y eliminación**.
* `Vector`: Versión **sincronizada** (menos usada actualmente).

### Conjuntos (`Set`) 🧩

Los conjuntos almacenan **elementos únicos**, lo que significa que **no permiten duplicados**.

| Implementación | Característica Principal |
| :--- | :--- |
| `HashSet` | No garantiza ningún orden específico de los elementos. |
| `LinkedHashSet` | Mantiene el **orden de inserción** (el orden en que se añadieron los elementos). |
| `TreeSet` | Mantiene los elementos **ordenados** (alfabéticamente, numéricamente, o mediante un comparador). |

### Mapas (`Map`) 🗺️

Los Mapas representan una estructura de **clave-valor**. Cada **clave** debe ser **única**, pero los valores pueden estar duplicados.

| Implementación | Característica Principal |
| :--- | :--- |
| `HashMap` | Proporciona acceso rápido, pero no garantiza el orden. |
| `TreeMap` | Ordena las **claves** automáticamente (alfabéticamente, numéricamente, etc.). |
| `LinkedHashMap` | Conserva el **orden de inserción** (el orden en que se añadieron las entradas). |

### Iteración en Colecciones 🔁

Puedes recorrer los elementos de cualquier colección (Listas, Sets, etc.) utilizando:

* Un **bucle `for-each`** (la forma más común).
* Un **Iterador** (para control más fino, como eliminar elementos durante el recorrido).

### Generics (Genéricos) `<T>`

Los **Genéricos** permiten especificar el tipo de datos que contendrá una colección (o una clase), garantizando la **seguridad de tipos** en tiempo de **compilación**. Esto ayuda a prevenir errores de *runtime* (ejecución) y elimina la necesidad de realizar *casts* manuales.

## 🛑 3.1.6. Manejo de Excepciones y Clases Personalizadas

Las **excepciones** en Java son una parte esencial del manejo de errores y del flujo de control. Permiten responder ante situaciones anómalas (fallos, entradas inválidas, errores de conexión, etc.) sin que el programa se detenga abruptamente.

### Jerarquía de Excepciones

En Java, toda excepción hereda de la clase base `java.lang.Throwable`.

| Clase Base | Tipo | Descripción |
| :--- | :--- | :--- |
| `Throwable` | Raíz | Clase de la que heredan todos los errores y excepciones. |
| `Error` | No Manejable | Situaciones críticas del sistema que no deben manejarse a nivel de aplicación (ej. fallo de la JVM). |
| **`Exception`** | **Checked** (Revisada) | Errores **recuperables**. Son los que deben manejarse en las aplicaciones (ej. `IOException`, `SQLException`). |
| **`RuntimeException`** | **Unchecked** (No Revisada) | Errores lógicos que suelen ser consecuencia de fallos del programador (ej. `NullPointerException`, `ArithmeticException`). |

### Manejo de Excepciones

Se utiliza la estructura de bloques `try-catch-finally` para controlar el flujo:

* **`try`**: Encapsula el código que es **propenso a fallar**.
* **`catch`**: Maneja el error si una excepción del tipo especificado es lanzada en el bloque `try`.
* **`finally`**: Ejecuta código que debe correr **siempre**, independientemente de si se produjo o no una excepción (ideal para cerrar conexiones o liberar recursos).

```java
try {
    // Código que puede fallar (ej. división por cero)
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    // Manejo del error
    System.out.println("Error: no se puede dividir entre cero.");
} finally {
    // Código que siempre se ejecuta
    System.out.println("Fin del proceso.");
}
```

## 📦 3.1.7. Maven, Estructura Modular y Convenciones de Backend

**Maven** es la herramienta estándar en Java para gestionar proyectos y dependencias, compilar código, ejecutar pruebas y generar empaquetados finales (`.jar` o `.war`).

### Arquitectura por Capas (MVC)

Para el desarrollo de un backend moderno en Java, se sigue típicamente una arquitectura de **4 capas** para asegurar la separación de responsabilidades:

| Capa | Responsabilidad Principal |
| :--- | :--- |
| **Controller** | Maneja las **peticiones HTTP** entrantes y prepara las respuestas al cliente. |
| **Service** | Contiene toda la **lógica de negocio** y las reglas de la aplicación. |
| **Repository** | Interactúa directamente con la **base de datos** (operaciones CRUD). |
| **Model / Entity** | Representa la estructura de los datos (tablas) del negocio. |

### Convenciones de Desarrollo

Seguir estas convenciones asegura la mantenibilidad y claridad del proyecto:

1.  **Paquete por Funcionalidad:** Agrupa los componentes relacionados (controladores, servicios, repositorios) por módulo lógico.
2.  **Nombres Claros:** Las clases y métodos deben indicar claramente su rol y función (ej. `UserService`, `ProductController`).
3.  **Validaciones:** Valida siempre los datos de entrada para prevenir errores y asegurar la integridad.
4.  **Uso de Logs:** Implementa un sistema de logging eficiente para el seguimiento de la ejecución y la depuración.
5.  **Test Unitarios:** Incluye una carpeta dedicada a las pruebas unitarias (ej. con JUnit) para garantizar la calidad del código.

---

## 📄 3.1.8. Javadoc: Documentación Profesional en Java

**Javadoc** es una herramienta oficial incluida en el JDK diseñada para generar **documentación HTML profesional** directamente a partir de los comentarios del código fuente. Permite describir el propósito, comportamiento y uso de clases y métodos de forma clara y estandarizada.

### Propósito y Utilidad

Javadoc actúa como un medio de comunicación esencial entre desarrolladores, especialmente en proyectos colaborativos, facilitando la comprensión del código.

* **Explicar el propósito del código:** Detalla qué hace, por qué existe y cómo debe usarse un componente.
* **Facilitar la colaboración:** Sirve como un manual de referencia rápido y estandarizado.
* **Documentación Oficial:** Es el estándar de facto usado por frameworks como Spring, JUnit y JPA.
* **Integración en IDEs:** Editores como VS Code o IntelliJ IDEA muestran automáticamente esta documentación al interactuar con el código.

### Estructura y Sintaxis del Javadoc

Los comentarios de Javadoc comienzan con `/**` y terminan con `*/`. Utilizan **etiquetas especiales (tags)** para estructurar la información.

#### Etiquetas más Comunes en Javadoc

| Etiqueta | Aplicación | Propósito |
| :--- | :--- | :--- |
| `@author` | Clase | Indica el autor del código. |
| `@version` | Clase | Indica la versión de la clase o módulo. |
| `@param` | Método | Describe un parámetro del método. |
| `@return` | Método | Explica qué valor devuelve el método. |
| `@throws` o `@exception` | Método | Describe una excepción que puede ser lanzada. |
| `@see` | Clase/Método | Referencia a otra clase o método relacionado. |
| `@since` | Clase/Método | Indica desde qué versión existe el elemento. |
| `@deprecated` | Clase/Método | Indica que el método o clase está obsoleto. |

### Buenas Prácticas de Documentación

1.  Documentar **lo esencial**, evitando describir lo obvio.
2.  Usar un tono **descriptivo** (ej. "Devuelve el nombre...") en lugar de imperativo.
3.  Mantener la **coherencia del formato** en todo el proyecto.
4.  **Actualizar** el Javadoc al refactorizar o modificar el código.
5.  Complementar el Javadoc con **código autoexplicativo** (nombres claros).
