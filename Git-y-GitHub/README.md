# 🧩 2.1 Git y GitHub

## 📘 2.1.1 ¿Qué es Git?

**Git** es un **sistema de control de versiones distribuido (VCS)**.  
Su función principal es registrar los cambios en el código fuente a lo largo del tiempo y coordinar el trabajo entre varios desarrolladores que colaboran en un mismo proyecto.

Fue creado por **Linus Torvalds** (creador de Linux) en **2005**, para gestionar de forma eficiente y segura miles de cambios en el kernel de Linux.

Linus buscaba tres cosas fundamentales:

- ⚡ **Velocidad:** guardar y consultar cambios de forma rápida.  
- 🧩 **Integridad:** garantizar que el historial de código no se corrompa ni se modifique sin detectar.  
- 🌐 **Trabajo distribuido:** cada desarrollador tiene una copia completa del proyecto sin depender de un servidor central.

Con Git puedes guardar el progreso mediante **commits** y volver a cualquier punto anterior sin duplicar carpetas ni archivos.

Cada commit guarda:
- Qué cambió.
- Cuándo cambió.
- Quién lo cambió (`user.name` y `user.email`).
- Por qué lo cambió (mensaje del commit).

### 🧱 Niveles de trabajo en Git

1. **Working Directory:** tu carpeta de trabajo (donde editas los archivos).  
2. **Staging Area (index):** zona intermedia donde preparas los archivos a guardar.  
3. **Repository (.git):** historial de versiones donde se almacenan los commits.

### 🪄 Ejemplo de flujo de trabajo

```bash
git add archivo.txt
git commit -m "Agrega nueva función"
git push origin main
```

# ☁️ 2.1.2 ¿Qué es GitHub?

**GitHub** es una plataforma en la nube que permite **alojar repositorios Git**, compartirlos y colaborar con otras personas.

En otras palabras:

- **Git** = herramienta que usas en tu PC.  
- **Hub** = lugar donde guardas y sincronizas tus repositorios.

---

## 🔧 Funcionalidades principales

1. 🏗️ **Alojamiento remoto de repositorios:** accede a tu código desde cualquier lugar.  
2. 👥 **Colaboración:** otros usuarios pueden clonar, modificar y proponer cambios.  
3. 🔄 **Pull Requests (PRs):** sistema para proponer y revisar cambios antes de integrarlos.  
4. 🐛 **Issues:** registro de errores, tareas o mejoras pendientes.  
5. 📖 **Wiki y documentación:** para documentar el proyecto.  
6. ⚙️ **GitHub Actions:** automatización de pruebas, despliegues y compilaciones (CI/CD).  
7. 📋 **Proyectos:** organización de tareas estilo Kanban (ideal para Scrum).

---

# 🧠 2.1.3 Conceptos esenciales

| Concepto | Descripción | Comando o ejemplo |
|-----------|--------------|-------------------|
| **Repositorio (repo)** | Carpeta del proyecto con su historial de cambios. | `git init`, `git clone` |
| **Commit** | Punto de guardado con una descripción. | `git commit -m "mensaje"` |
| **Branch (rama)** | Línea de trabajo independiente. | `git checkout -b nueva-funcion` |
| **Merge** | Combina los cambios de una rama a otra. | `git merge` |
| **Remote** | Repositorio remoto en GitHub. | `git remote add origin ...` |
| **Push / Pull** | Enviar o traer cambios del remoto. | `git push`, `git pull` |
| **Clone** | Descargar un repositorio existente. | `git clone URL` |
| **.gitignore** | Archivos excluidos del control de versiones. | `.env`, `node_modules/` |

---

# 🚀 2.1.4 Por qué Git y GitHub son imprescindibles

- 🤝 **Trabajo en equipo:** varios desarrolladores pueden trabajar en paralelo sin pisarse el código.  
- 🕓 **Historial completo:** puedes ver quién cambió qué y cuándo.  
- 🔐 **Seguridad:** Git usa hashes **SHA-1** para asegurar la integridad del contenido.  
- ⚡ **Automatización:** CI/CD, despliegues automáticos, revisiones.  
- 💼 **Portafolio profesional:** tu perfil de GitHub es como un *LinkedIn técnico*.

---

# 🧩 2.1.5 Ejemplo de flujo de trabajo

```bash
# 1. Crear un nuevo repositorio
git init

# 2. Crear un archivo
echo "Hola mundo" > hola.txt

# 3. Agregarlo al área de preparación
git add hola.txt

# 4. Hacer commit
git commit -m "Primer commit"

# 5. Enlazar con GitHub
git remote add origin https://github.com/usuario/mi_repo.git

# 6. Subir los cambios
git push -u origin main
```
# ⚙️ 2.1.6 Comandos Git y GitHub

Esta sección contiene los comandos más utilizados de **Git** y **GitHub**, organizados por categoría.

---

## 🧭 Comandos de configuración

```bash
git config --global user.name "nombre"         
# Configura el nombre del usuario que realizará los commits

git config user.name                          
# Muestra el nombre de usuario asignado al sistema

git config --global user.email "correo@example.com"
# Configura el correo electrónico que realizará los commits

git config user.email                         
# Muestra el correo electrónico asignado al sistema

git config --global init.defaultBranch main    
# Configura el nombre por defecto de la rama inicial de los nuevos repositorios
```

## 🗂️ Comandos de Repositorio y Seguimiento de Cambios

```bash
git init
# Inicializa un repositorio de Git en la carpeta actual, convirtiéndola en un repositorio de Git.

git status
# Permite verificar el estado del repositorio (si hay cambios listos para el próximo commit).

git add <archivo> / .
# Agrega o añade los cambios al área de preparación (staging area).

git rm --cached <archivo>
# Remueve un archivo del área de preparación sin borrarlo del sistema de archivos.

git commit -m "mensaje"
# Crea un commit con el mensaje, llevando los cambios al repositorio de Git.

git commit --amend
# Modifica el mensaje del último commit realizado.

git log
# Muestra el historial de commits realizados en la rama actual.

git log --oneline
# Muestra el historial de commits en una sola línea (modo resumido).

git log -p
# Muestra el historial de commits junto con las diferencias realizadas en cada uno.

git reset --soft HEAD~1
# Deshace el último commit, pero mantiene los cambios en el directorio de trabajo.
```

## 🌿 Comandos de Ramas (Branch) y de Fusión (Merge)

```bash
git branch <nombre>
# Crea una nueva rama en el repositorio.

git branch
# Muestra la lista de ramas existentes en el repositorio local.

git branch -m <actual> <nuevo>
# Cambia el nombre de una rama existente.

git branch -d <rama>
# Elimina una rama local.

git checkout <rama>
# Cambia a una rama específica.

git checkout -b <rama>
# Crea una nueva rama y cambia a ella directamente.

git merge <rama>
# Fusiona los cambios de una rama específica a la rama actual.

git merge --continue
# Continúa el proceso de fusión una vez que se han resuelto los conflictos.
```

## 🌍 Comandos para Operaciones Remotas

```bash
git clone <url>
# Clona un repositorio remoto, creando una copia local del mismo.

git remote
# Muestra los nombres de los repositorios remotos configurados.

git remote add origin <url>
# Agrega un repositorio remoto llamado 'origin' y especifica su URL.

git push origin -d <rama>
# Elimina una rama remota en el servidor.

git pull <origen> <rama>
# Descarga el contenido del repositorio remoto y actualiza el local.

git fetch <origen>
# Verifica y descarga los cambios del repositorio remoto sin fusionarlos automáticamente.

git branch -a
# Muestra las ramas locales y también las remotas existentes.
```
