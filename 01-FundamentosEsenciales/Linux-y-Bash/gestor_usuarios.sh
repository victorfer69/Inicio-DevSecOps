#!/bin/bash

# Variables utilizadas
seleccion="0"

# Creación del archivo y carpeta de usuarios
ruta_fichero="./recursos/lista_usuarios.txt"
mkdir -p ./recursos
touch "$ruta_fichero"

# Funciones para realizar las tareas
crea_usuario() {
    if [ -z "$1" ]; then
        echo "Dame el nombre del usuario a crear:"
        read nombre
    else
        nombre="$1"
    fi

    if grep -q "^$nombre$" "$ruta_fichero"; then
        echo "El usuario '$nombre' ya existe."
    else
        echo "$nombre" >> "$ruta_fichero"
        echo "Usuario '$nombre' creado correctamente."
    fi
}

elimina_usuario() {
    echo "Dame el nombre del usuario a eliminar:"
    read nombre

    if grep -q "^$nombre$" "$ruta_fichero"; then
        sed -i "/^$nombre$/d" "$ruta_fichero"
        echo "Usuario '$nombre' eliminado correctamente."
    else
        echo "$nombre no existe. ¿Desea crearlo? (S/N):"
        read decision
        if [ "$decision" == "S" ]; then
            crea_usuario "$nombre"
        fi
    fi
}

lista_usuarios() {
    if [ ! -s "$ruta_fichero" ]; then
        echo "No hay usuarios registrados."
    else
        echo "Lista de usuarios:"
        cat "$ruta_fichero"
    fi
}

# Inicio del programa
echo "Bienvenido al gestor de usuarios"

while [ "$seleccion" != "4" ]; do
    echo
    echo "1 - Crear usuario"
    echo "2 - Eliminar usuario"
    echo "3 - Listar usuarios"
    echo "4 - Salir"
    echo -n "Seleccione una opción: "
    read seleccion

    case $seleccion in
        1) crea_usuario ;;
        2) elimina_usuario ;;
        3) lista_usuarios ;;
        4)
            echo "Saliendo del gestor de usuarios..."
            exit 0
            ;;
        *)
            echo "Opción no válida. Por favor, seleccione una opción del 1 al 4."
            ;;
    esac
done