## 🐧 2.2 Fundamentos de Linux

### 2.2.1. Introducción y Navegación Básica

#### Estructura del sistema de archivos Linux

El sistema de archivos en Linux tiene una **estructura jerárquica** en forma de árbol, donde todo parte del **directorio raíz /**.

A diferencia de Windows, donde cada disco tiene una letra (C:, D:), en Linux todos los dispositivos y particiones se "**montan**" dentro de esta estructura, lo que **unifica la vista del sistema**.

Saber qué guarda cada directorio es **esencial** cuando se trabaja con servidores o contenedores Docker, ya que la estructura del sistema se mantiene igual.

---

#### Directorios más importantes y su propósito

Los directorios clave son:

* **/**: **Raíz** del sistema de archivos. Todo parte de aquí.
* **/bin**: Comandos **esenciales** disponibles para **todos** los usuarios (**cp, ls, mv**).
* **/boot**: Archivos críticos para el **arranque** del sistema, como el kernel y GRUB.
* **/dev**: Representa **dispositivos** físicos y virtuales como archivos (**`/dev/sda1`**, **`/dev/tty`**).
* **/etc**: Archivos de **configuración global** del sistema y de servicios.
* **/home**: Directorios **personales** de los usuarios comunes.
* **/lib**, **/lib64**: **Bibliotecas compartidas** necesarias para ejecutar programas de `/bin` y `/sbin`.
* **/media**: Puntos de montaje para dispositivos **extraíbles** (USB, DVD).
* **/mnt**: Usado **temporalmente** para montar particiones manualmente.
* **/opt**: Software **adicional** o de **terceros** (VSCode, JetBrains).
* **/proc**: Sistema de archivos **virtual** con información sobre procesos y kernel.
* **/root**: Directorio personal del usuario **root** (administrador).
* **/run**: Almacena información **temporal** sobre procesos y sesiones desde el arranque.
* **/sbin**: Binarios del sistema, usados principalmente por el **administrador**.
* **/srv**: Datos de **servicios** ofrecidos por el sistema (web, FTP, etc.).

### 🚀 Comandos de navegación básicos

Estos comandos son esenciales para moverte y ver el contenido dentro del sistema de archivos:

* **`pwd`**: Muestra la **ruta actual** (Print Working Directory).
* **`ls`**: **Lista** el contenido del directorio.
    * `-l`: Modo **detallado** (permisos, propietario, tamaño, fecha).
    * `-a`: Muestra archivos **ocultos** (los que empiezan con un punto).
    * `-h`: Muestra tamaños **legibles** (KB, MB, GB).
    * `-t`: Ordena por **fecha** (más reciente primero).
    * `-r`: **Invierte** el orden de la lista.
* **`cd`**: **Cambia de directorio** (Change Directory).
    * `cd ..`: Sube **un nivel** en la jerarquía.
    * `cd -`: Vuelve al **directorio anterior**.
    * `cd`: Va al directorio **`home`** (`/home/usuario`).
    * `cd /`: Va al directorio **raíz**.
* **`tree`**: Muestra la estructura **jerárquica** de directorios y archivos (requiere instalación).

#### Rutas absolutas y relativas

* **Absoluta**: Empieza siempre desde la raíz **`/`**.
    * *Ejemplo*: `/home/victor/documentos/nota.txt`
* **Relativa**: Se interpreta **desde el directorio actual** donde te encuentras.
    * *Ejemplo*: `../imagenes/foto.png`

---

## 🛠️ 2.2.2. Gestión de Archivos y Permisos

### Manipulación de archivos y directorios

Estos comandos permiten crear, modificar, mover y eliminar archivos y carpetas:

* **`touch`**: Crea un archivo **vacío** o actualiza su *timestamp* (hora de última modificación).
* **`mkdir`**: Crea **directorios** (carpetas).
* **`rmdir`**: **Elimina** un directorio **vacío**.
* **`rm`**: **Elimina** archivos o directorios (usar con precaución).
* **`cp`**: **Copia** archivos o directorios (Copy).
* **`mv`**: **Mueve** o **renombra** archivos (Move).
* **`cat`**: Muestra el **contenido completo** de archivos (Concatenate).
* **`head`/`tail`**: Muestra las **primeras** o **últimas** líneas de un archivo.
* **`grep`**: **Filtra** líneas que coinciden con un patrón dentro de un archivo.
* **`find`**: **Busca** archivos según criterios (nombre, tamaño, fecha, etc.).

> Sobre estos comandos se pueden utilizar **pipes (`|`)** y **redirecciones (`<`, `>`)** para combinar su funcionalidad.

### 🔗 Pipes y Redirecciones

Los **pipes** (`|`) y las **redirecciones** (`>`, `>>`) permiten conectar la salida de un comando con la entrada de otro o dirigir la salida a un archivo.

* **`ls /etc | grep ssh`**: **Filtra** la lista de `/etc` para mostrar solo las líneas que contengan `"ssh"`.
* **`cat notas.txt > copia.txt`**: **Sobrescribe** el contenido de `copia.txt` con el de `notas.txt`.
* **`echo "Nueva línea" >> notas.txt`**: **Añade** texto al final de `notas.txt` sin borrar el contenido existente.

---

### 🔐 Permisos y Propietarios

Cada archivo o directorio tiene tres tipos de permisos (**rwx**) y tres niveles de usuario.

#### Tipos de Permisos

| Permiso | Letra | Significado | Aplica a Archivos | Aplica a Directorios |
| :---: | :---: | :--- | :--- | :--- |
| **Lectura** | `r` | `4` | Ver contenido del archivo. | **Listar** el contenido del directorio (`ls`). |
| **Escritura** | `w` | `2` | **Modificar** el contenido del archivo. | **Crear/Eliminar** archivos dentro del directorio. |
| **Ejecución** | `x` | `1` | **Ejecutar** el script o binario. | **Entrar** al directorio (`cd`). |

#### Niveles de Usuario

* **`u`**: **Usuario** (*owner* o dueño del archivo).
* **`g`**: **Grupo** (usuarios que pertenecen al grupo).
* **`o`**: **Otros** (cualquier otro usuario del sistema).
* **`a`**: **Todos** (`u`, `g`, y `o`).

#### Comando `chmod` (Cambiar Permisos)

Se utiliza para modificar los permisos de un archivo o directorio:

* **Simbólico**: `chmod u+x script.sh` &rarr; Da permisos de **ejecución** (`x`) solo al **usuario** (`u`).
* **Numérico**: `chmod 754 archivo` &rarr; Establece los permisos como `rwxr-xr--` (7=rwx, 5=r-x, 4=r--).

#### Comando `chown` (Cambiar Propietario)

Se utiliza para cambiar el **propietario** o el **grupo** de un archivo. Es crucial para servicios que usan usuarios específicos (web, bases de datos).

* *Ejemplo*: `sudo chown victor:devs archivo.txt` &rarr; Cambia el propietario a `victor` y el grupo a `devs`.

#### Otros comandos de usuario

* **`groups`**: Muestra los grupos a los que pertenece el usuario actual.
* **`sudo`**: Permite ejecutar comandos como **superusuario (root)**, manteniendo el historial personal.

---

## 👥 2.2.3. Gestión de Usuario y Grupos

### Crear y eliminar usuarios

* **`sudo useradd -m -s /bin/bash alumno1`**: Crea el usuario `alumno1` con una carpeta **personal** (`-m`) y le asigna el *shell* **bash** (`-s`).
* **`sudo passwd alumno1`**: Asigna una **contraseña** al nuevo usuario.
* **`sudo userdel -r alumno1`**: **Elimina** el usuario y también su **directorio personal** (`-r`).

### Gestión de contraseñas

* **`passwd`**: Cambia tu **propia** contraseña.
* **`sudo passwd usuario`**: Cambia la contraseña de **otro** usuario (requiere permisos de *root*).

> **Seguridad**: Las contraseñas se almacenan **cifradas** en el archivo **/etc/shadow**. Por motivos de seguridad, solo el usuario **root** puede leer este archivo.

### 👥 Grupos y pertenencias

Los grupos son **clave** para la gestión de **permisos compartidos** y el acceso a recursos del sistema.

* **`sudo groupadd devops`**: Crea el nuevo grupo llamado `devops`.
* **`sudo usermod -aG devops victor`**: **Añade** el usuario `victor` al grupo `devops` (`-aG` para añadir a un grupo suplementario sin eliminar los demás).
* **`groups victor`**: Muestra a qué **grupos** pertenece el usuario `victor`.
* **`sudo gpasswd -d alumno1 devops`**: **Elimina** al usuario `alumno1` del grupo `devops`.
* **`id`**: Muestra el **UID** (User ID), **GID** (Group ID) y todos los grupos del usuario actual.

#### Archivos de configuración relacionados

Estos archivos contienen información sensible sobre usuarios y grupos:

* **/etc/passwd**: Lista de usuarios y su información básica (UID, *shell* asignado, directorio *home*).
* **/etc/group**: Grupos y sus miembros.
* **/etc/shadow**: Contraseñas **cifradas** y datos de expiración (solo legible por *root*).

---

## ✏️ 2.2.4. Edición de Archivos y Redirecciones

### Creación, Eliminación y Manipulación de Archivos

Además de los comandos básicos, estas opciones son cruciales para la administración:

* **`cp -r`**: **Copia directorios** de forma **recursiva** (incluyendo todo su contenido).
* **`mv`**: **Mueve** o **renombra** archivos/directorios.
* **`rm -rf`**: **Elimina forzosamente** un directorio y su contenido (usar con **extremo cuidado**).
* **`cp -i`**: Solicita **confirmación** antes de sobrescribir un archivo existente.
* **`ln -s`**: Crea un **enlace simbólico** (atajo).

> 💡 Los **enlaces simbólicos** son útiles para apuntar a configuraciones, logs o scripts sin duplicar archivos. Son muy usados en directorios como `/etc` o `/usr/local/bin`.

### Editores de texto

Para trabajar en la línea de comandos, es necesario dominar un editor de texto:

* **Nano**:
    * **Sencillo**, **rápido** y preinstalado en la mayoría de distribuciones.
    * Ideal para modificar configuraciones o *scripts* cortos.
* **Vi/Vim**:
    * Editor más **avanzado**, ideal para servidores **sin entorno gráfico**.
    * Tiene tres modos principales de edición:
        * **Comando** (por defecto): Ejecutar acciones (ej: buscar, guardar, salir).
        * **Inserción**: Permite **escribir** y editar texto.
        * **Visual**: Permite **seleccionar** bloques de texto.

### 🔎 Visualización de archivos

Comandos clave para ver y analizar el contenido de los archivos sin abrirlos en un editor:

* **`cat`**: Muestra el **contenido completo** de un archivo de una sola vez.
* **`less`**: Permite **ver archivos grandes con paginación** (navegar hacia adelante y hacia atrás).
* **`head -n 20`**: Muestra las **primeras 20 líneas** del archivo.
* **`tail -f`**: **Monitoriza** el archivo en **tiempo real** (ideal para ver **logs** mientras se escriben).
* **`wc -l`**: **Cuenta las líneas** del archivo (útil para logs).
* **`cut -d":" -f1`**: **Corta campos** específicos usando delimitadores (aquí, `: ` como delimitador, y `-f1` para el primer campo).
* **`sort`, `uniq`**: **Ordena** el contenido y **elimina duplicados**, respectivamente.

---

### ➡️ Redirección de Entradas y Salidas

En Linux, la comunicación se maneja a través de flujos de datos:

#### Flujos de Datos Estándar

| Flujo | Descriptor | Nombre | Descripción |
| :---: | :---: | :---: | :--- |
| **STDIN** | `0` | Entrada Estándar | Suele ser la entrada del teclado o el contenido de un archivo. |
| **STDOUT** | `1` | Salida Estándar | Salida normal del comando (generalmente la pantalla). |
| **STDERR** | `2` | Salida de Errores | Salida de mensajes de error. |

#### Operadores de Redirección

| Operador | Acción | Ejemplo |
| :---: | :--- | :--- |
| **`>`** | **Sobrescribe** el archivo con el STDOUT. | `comando > archivo.txt` |
| **`>>`** | **Añade** (append) la salida al final del archivo. | `comando >> archivo.txt` |
| **`<`** | Usa el archivo como **entrada** (STDIN) para el comando. | `comando < archivo.txt` |
| **`2>`** | Redirige la **Salida de Errores** (STDERR) a un archivo. | `comando 2> errores.log` |
| **`&>`** | Redirige la **Salida** y los **Errores juntos**. | `comando &> logs.txt` |

> 📌 **Pipes (`|`)**: Se encargan de **encadenar comandos**, conectando el STDOUT del primero al STDIN del segundo.
>
> *Ejemplo*: `cat /var/log/syslog | grep "error" | wc -l` (Busca errores en el log y cuenta cuántos hay).

---

## 📦 2.2.5. Gestión de Paquetes y Software

### Sistemas de paquetes

Cada distribución Linux utiliza su propio gestor para instalar, actualizar o eliminar software, resolviendo automáticamente las **dependencias** (otros programas que necesita el software).

#### APT (Advanced Package Tool)

Utilizado por **Debian, Ubuntu, Kali, Mint**, y sus derivados.

* **`sudo apt update`**: **Actualiza los índices** de paquetes disponibles en los repositorios remotos.
* **`sudo apt upgrade`**: **Actualiza** el software que ya está instalado en el sistema.
* **`sudo apt install paquete`**: **Instala** un programa.
* **`sudo apt remove paquete`**: **Elimina** el programa, **sin borrar los archivos de configuración**.
* **`sudo apt purge paquete`**: **Elimina** el programa y **borra** la configuración.
* **`sudo apt purge paquete`**: **Elimina** el programa y su **configuración**.
* **`sudo apt autoremove`**: **Limpia** las dependencias no usadas.
* **`sudo apt search nombre`**: **Busca** un paquete.
* **`apt show paquete`**: Muestra **información detallada** sobre el programa.

#### DNF/YUM (Fedora, RHEL, CentOS)

* **`sudo dnf install paquete`**: Instala el programa.
* **`sudo dnf update`**: Actualiza el sistema.
* **`sudo dnf remove paquete`**: Elimina el programa.
* **`sudo dnf list installed`**: Muestra la lista de paquetes instalados.

#### Otras utilidades útiles

* **`dpkg -l`**: Muestra **todos** los paquetes instalados.
* **`which comando`**: Muestra la **ruta de instalación** de un programa.
* **`apt-mark hold paquete`**: **Bloquea** actualizaciones de un paquete concreto.
* **`history | grep install`**: Muestra el **historial de instalaciones** ejecutadas.

---

### 💻 Información del sistema

Comandos para obtener métricas y datos clave del sistema operativo:

* **`uname -a`**: Muestra la información del **kernel**.
* **`lsb_release -a`**: Muestra la **versión de la distribución** Linux.
* **`df -h`**: Muestra el **espacio en disco** disponible (`-h` para formato legible).
* **`free -h`**: Muestra la **memoria** disponible (RAM y Swap).
* **`htop`**: Muestra los **procesos** y el consumo de recursos de forma interactiva.
* **`screenfetch`**: Muestra la información **visual** del sistema (ASCII art).

---

## 🌐 2.2.6. Red y Conectividad

### Fundamentos de Red

Linux trata la red como un conjunto de **interfaces** configurables:

* **`lo`**: Interfaz **local** (*localhost*, loopback).
* **`eth0`, `ens33`, `enp0s3`**: Interfaces **Ethernet** (cableadas).
* **`wlan0`**: Interfaces **Wi-Fi**.

### Comandos básicos de red

* **`ip a`**: Muestra **interfaces y direcciones IP**.
* **`hostname`**: Muestra o cambia el **nombre del host**.
* **`ping`**: Comprueba la **conectividad** con otro host de la red.
* **`traceroute`**: Muestra la **ruta** que siguen los paquetes (los *saltos*).
* **`nslookup`**: Realiza una **consulta DNS** para resolver nombres a IPs y viceversa.
* **`ss -tuln`**: Muestra los **puertos abiertos** y las **conexiones** activas (`-t` TCP, `-u` UDP, `-l` listening, `-n` numérico).
* **`curl`**: Herramienta potente para hacer **peticiones HTTP o API**.
* **`wget`**: **Descarga** archivos de internet.

---

### 📡 Configuración y acceso remoto

#### SSH (Secure Shell)

Es el protocolo **seguro** estándar para **acceso remoto** y administración de servidores Linux.

* **Conexión de ejemplo**: `ssh usuario@192.168.1.10`
* **Puerto por defecto**: `22`.
* **Archivos de configuración**: `/etc/ssh/ssh_config` (cliente) o `/etc/ssh/sshd_config` (servidor).

##### Autenticación por Claves

Método de acceso más seguro que las contraseñas:

* **Generar clave**: `ssh-keygen -t rsa -b 4096` (Crea una clave pública y una privada).
* **Copiar al servidor**: `ssh-copy-id usuario@ip` (Copia la clave pública al servidor).

#### Transferencia de Archivos

* **`SCP`** (Secure Copy) y **`SFTP`** (Secure File Transfer Protocol) son herramientas que utilizan el protocolo **SSH** para transferir archivos de forma segura entre equipos.

### Entornos virtualizados (Networking)

Configuraciones comunes para máquinas virtuales (VMs):

* **Bridge**: Permite a la VM tener una **IP propia y visible** en la red local del host (actúa como un dispositivo más).
* **NAT**: La VM **usa la IP del host** (no es accesible directamente desde fuera de la máquina host).
* **Host-only**: Comunicación **solo entre el host y las VMs**.

---

### 🩺 Diagnóstico y monitoreo de red

* **`ifconfig`**: Comando clásico (sustituido por **`ip a`**) que muestra información de la red.
* **`netstat -tulnp`**: Muestra **conexiones y puertos activos** (`-t` TCP, `-u` UDP, `-l` listening, `-n` numérico, `-p` proceso).
* **`journalctl -u network.service`**: Muestra los **logs** del servicio de red (en sistemas con *systemd*).
* **`systemctl status ssh`**: Muestra el **estado** del servicio **SSH**.

## ⚙️ 2.2.7. Procesos y Gestión del Sistema

### Conceptos Fundamentales

Un **proceso** en Linux representa una instancia en **ejecución** de un programa.

* Cada proceso tiene su propio **PID** (Process ID).
* Los procesos pueden generar **procesos hijos** con su propio **PPID** (Parent PID).
* El *kernel* gestiona los procesos, asignando recursos como memoria, CPU y acceso a disco.

#### Tipos de procesos

| Tipo | Descripción |
| :--- | :--- |
| **Interactivo** | Iniciado manualmente por el usuario en la terminal (primer plano). |
| **Demonio (*daemon*)** | Se ejecuta de forma persistente en **segundo plano** al iniciar el sistema (servicios). |
| **Zombi (*zombie*)** | Proceso **finalizado** que sigue en la tabla de procesos esperando la confirmación de su padre. |
| **Huérfano (*orphan*)** | Proceso cuyo padre ha terminado y ha sido **adoptado** por el proceso `init` o `systemd`. |

---

### Visualización y Monitoreo

Comandos para inspeccionar el estado y los recursos consumidos por los procesos:

* **`ps aux`**: Lista **todos** los procesos activos con información detallada (**usuario, CPU, memoria, estado**).
* **`ps -ef`**: Muestra procesos con **jerarquía padre-hijo**.
* **`top`**: Monitoreo de procesos **en tiempo real**. Permite ordenar por uso de CPU o memoria.
* **`htop`**: Versión **mejorada** de `top` con una interfaz más **interactiva** y visual.
* **`pidof nombre`**: Devuelve el **PID** de un proceso buscando por su **nombre**.
* **`pgrep/pkill nombre`**: Busca procesos por nombre (`pgrep`) o los termina (`pkill`).
* **`nice/renice`**: Ajusta la **prioridad** de ejecución de un proceso.

---

### Control de Procesos

Comandos para manipular el estado de los trabajos desde la *shell* actual:

| Comando | Acción | Ejemplo |
| :--- | :--- | :--- |
| **`&`** | Ejecutar un comando en **segundo plano**. | `sleep 600 &` |
| **`jobs`** | **Listar** los trabajos activos lanzados desde la sesión actual. | |
| **`fg %n`** | **Traer al primer plano** (*foreground*) el trabajo número `n`. | `fg %1` |
| **`bg %n`** | **Reanudar** un proceso detenido y enviarlo al **segundo plano** (*background*). | `bg %2` |
| **`kill -9 PID`** | **Fuerza la finalización** inmediata del proceso por su PID. | `kill -9 1234` |
| **`killall nombre`** | **Termina todos los procesos** que tienen un nombre específico. | `killall apache2` |

### 📈 Supervisión del Sistema

Comandos esenciales para monitorear el rendimiento y el estado de los recursos:

* **`uptime`**: Muestra el **tiempo encendido** y la **carga media** del sistema.
* **`free -h`**: Muestra el **uso de memoria** RAM y *swap* (`-h` para formato legible).
* **`df -h`**: Muestra el **espacio en disco** por partición.
* **`du -sh *`**: Muestra el **tamaño de archivos/directorios** del directorio actual.
* **`vmstat 2`**: Estadísticas de **memoria, CPU y E/S** cada 2 segundos.
* **`iotop`**: Monitorea procesos que realizan más **E/S en disco**.
* **`systemctl status servicio`**: Muestra el estado de un servicio gestionado por *systemd*.

---

### 👤 Administración de Usuarios y Permisos (Resumen)

* **`sudo useradd usuario`**: Crea un **nuevo usuario**.
* **`sudo passwd usuario`**: Define la **contraseña** del usuario.
* **`sudo usermod -aG grupo usuario`**: **Añade** al usuario a un grupo existente.
* **`sudo deluser usuario`**: **Elimina** al usuario.
* **`id usuario`**: Muestra el **UID, GID** y **grupos** del usuario.

---

### 📝 Gestión de Logs

Los *logs* del sistema son fundamentales para auditar, depurar y monitorear el comportamiento del sistema. Se almacenan generalmente en **/var/log/**.

* **`tail -f archivo.log`**: **Sigue** la salida del archivo en **tiempo real**.
* **`grep "error" archivo.log`**: **Filtra** el archivo por palabra clave.
* **`journalctl -u servicio`**: Muestra *logs* de un **servicio de *systemd*** específico.
* **`logrotate`**: Herramienta que **rota, comprime y limpia *logs*** antiguos automáticamente para ahorrar espacio.

---

## 💻 2.2.8. Automatización con Bash

### Introducción a Bash

**Bash** (*Bourne-Again Shell*) es el intérprete de comandos más utilizado en sistemas Linux y Unix.

* Además de permitir la ejecución directa de comandos en la terminal, Bash puede **automatizar tareas repetitivas** mediante *scripts*, mejorando la eficiencia en la administración de sistemas, despliegues y tareas.
* Los *scripts* Bash son **secuencias de comandos** que el sistema ejecuta línea a línea.
* Permiten **encadenar operaciones**, aplicar **lógica condicional**, manipular archivos, procesar texto o interactuar con el usuario.

> 🌟 **Bash** es una herramienta esencial para la **automatización**, la administración de servidores y la orquestación de tareas del sistema.
>
> ### Estructura y Ejecución de un Script

Un script Bash es un archivo de texto plano con una lista de comandos. Para crearlo y ejecutarlo:

1.  **Crear el archivo**: `nano script.sh`
2.  **Indicar el intérprete** (*Shebang*) dentro del archivo: `#!/bin/bash`
3.  **Dar permisos de ejecución**: `chmod +x script.sh`
4.  **Ejecutar el script**: `./script.sh`

---

### Variables y Sustitución de Comandos

Las **variables** son espacios en memoria que almacenan valores temporales (texto, números o resultados de comandos).

| Tipo de Asignación | Ejemplo | Descripción |
| :--- | :--- | :--- |
| **Cadena/Número** | `nombre="Víctor"` | Asignación directa de un valor. **No se usan espacios** alrededor del `=`. |
| **Sustitución de Comando** | `usuario=$(whoami)` | Asigna el **resultado** de un comando. También se usa la sintaxis `` `comando` ``. |

*Ejemplo de uso de variables:*

```bash
nombre="Víctor"
usuario=$(whoami)
fecha=$(date)
numero=6
echo "Hola, $nombre"
echo "El usuario $usuario ejecutó el script el $fecha, y su número favorito es el $numero."
```
### Entrada y Salida de Datos
* Entrada de usuario: read -p Ïntroduce tu nombre: "nombre
* Parámetros de entrada: echo "Primer parámetro: $1, total de parámetros $#"

```bash
if [ condici ó n ]; then
  comandos
elif [ otra_condici ó n ]; then
  otros_comandos
else
  comandos_alternativos
fi
```

Los operadores comunes para realizar comparaciones son:
* Numéricos: -eq, -ne, -lt, -le, -gt, -ge.
* Cadenas: =, !=, -z (vacía),-n (no vacía).
* Archivos: -f (archivo), -d (directorio), -r (lectura), -x (ejecución).

### Bucles
Los bucles permiten repetir acciones de forma controlada.

```bash
# Bucle for
for archivo in *. txt ; do
  echo " Procesando ␣ $archivo "
done
# Contar numeros
for i in {1..5}; do
  echo " Iteraci ó n ␣ $i "
done
# Bucle while
contador =1
while [ $contador - le 5 ]; do
  echo " Contador : ␣ $contador "
  (( contador ++) )
done
# Leer archivo linea a linea
while read -r linea ; do
  echo " L í nea : ␣ $linea "
done < documento . txt
```

### Funciones
Las funciones permiten estructurar mejor los scripts dividiéndolos en bloques razonables. Pueden declararse en cualquier parte del script y luego ser llamada múltiples veces. Además, pueden devlver valores mediante return o usando echo junto al comando.

```bash
mi_funcion () {
  echo " Esta ␣ es ␣ una ␣ funci ó n . "
}
```

### Operadores Lógicos y Comparaciones Avanzadas
Bash permite combinar condiciones con operadores lógicos:
* &&: AND lógico.
* ||: OR lógico.
* !: negación.

### Redirecciones Pipes
```bash
# Redirecci ó n de salida
echo " Texto " > salida . txt # Sobrescribe
echo " L í nea ␣ adicional " >> salida . txt # A ñ ade
# Redirecci ó n de entrada
sort < lista . txt
# Redirecció n de errores
comando 2 > errores . log
# Pipes ( tuber í as )
cat / var / log / syslog | grep " error " | wc -l
```

### ⚙️ Herramientas de Automatización y Productividad

Además de los *scripts*, existen utilidades para mejorar la eficiencia en la terminal:

* **`alias`**: Define **atajos** para comandos frecuentes (ej: `alias ll='ls -alF'`).
* **`history`**: Muestra el **historial de comandos** ejecutados por el usuario.
* **`watch`**: **Ejecuta un comando de forma periódica** y muestra su resultado en la terminal (ej: `watch -n 1 'ps aux | head -n 5'`).
* **`cron`**: Sistema utilizado para **programar tareas automáticas** (trabajos recurrentes) en momentos específicos (ej: copias de seguridad nocturnas).

---

### ✅ Buenas Prácticas en Scripting

Seguir estas prácticas ayuda a crear *scripts* robustos, legibles y seguros:

* **Shebang**: Siempre incluir el *shebang* (`#!/bin/bash`) en la primera línea para indicar el intérprete.
* **Comentarios**: Añadir **comentarios descriptivos** (`#`) en cada función o bloque de lógica para explicar su propósito.
* **Detección de Errores**: Probar *scripts* con `bash -n script.sh` para detectar **errores de sintaxis** antes de ejecutar.
* **Modo de Falla Rápida**: Usar **`set -e`** al principio del *script* para que se **detenga inmediatamente** ante cualquier error, evitando consecuencias no deseadas.
* **Validación**: **Validar los parámetros** recibidos antes de usarlos (ej: verificar que `$1` existe o que una ruta es válida).
* **Rutas**: Evitar rutas **absolutas** cuando sea posible; usar rutas relativas o variables de entorno.
* **Documentación**: **Documentar la salida** del *script* (qué hace, qué devuelve).
* **Seguridad**: Mantener los **permisos correctos** (`chmod 700`) y restringir el acceso a *scripts* críticos.
