#!/bin/bash

# Variables
decision="0"
puntos=0

# Creación del archivo que almacena el récord (si no existe lo crea)
ruta_record="./recursos/record.txt"
mkdir -p ./recursos
if [ ! -f "$ruta_record" ]; then
    echo 0 > "$ruta_record"
fi

# Funciones utilizadas
iniciar_juego(){
    puntos=0

    echo ""
    echo "-------------------------------------------------"
    echo "Pregunta 1"
    echo "¿Cuál es el planeta más grande del sistema solar?"
    echo "a) Marte"
    echo "b) Júpiter"
    echo "c) Saturno"
    echo "d) Neptuno"
    echo "Respuesta: "
    read respuesta

    if [ "$respuesta" == "b" ]; then
        ((puntos+=1))
        echo "¡Correcto! Júpiter es el planeta más grande."
    else
        echo "¡Error! La respuesta correcta es Júpiter."
    fi
    echo "Puntaje actual: $puntos"
    echo ""

    echo "-------------------------------------------------"
    echo "Pregunta 2"
    echo "¿Quién pintó “La última cena”?"
    echo "a) Vincent van Gogh"
    echo "b) Pablo Picasso"
    echo "c) Leonardo da Vinci"
    echo "d) Miguel Ángel"
    echo "Respuesta: "
    read respuesta

    if [ "$respuesta" == "c" ]; then
        ((puntos+=1))
        echo "¡Correcto! Bien hecho."
    else
        echo "¡Error! Fue Leonardo da Vinci."
    fi
    echo "Puntaje actual: $puntos"
    echo ""

    echo "-------------------------------------------------"
    echo "Pregunta 3"
    echo "¿En qué año llegó el hombre a la Luna?"
    echo "a) 1965"
    echo "b) 1969"
    echo "c) 1971"
    echo "d) 1975"
    echo "Respuesta: "
    read respuesta

    if [ "$respuesta" == "b" ]; then
        ((puntos+=1))
        echo "¡Correcto! ¡Muy bien!"
    else
        echo "¡Error! Fue en 1969."
    fi
    echo "Puntaje actual: $puntos"
    echo ""

    record=$(cat "$ruta_record")

    if [ "$puntos" -gt "$record" ]; then #>
        echo "--------------"
        echo "¡Nuevo récord! ¡FELICIDADES!"
        echo "$puntos" > "$ruta_record"
    elif [ "$puntos" -eq "$record" ]; then #==
        echo "--------------"
        echo "Has igualado el récord, ¡bien hecho!"
    else
        echo "--------------"
        echo "No has superado el récord."
    fi
    echo "--------------"
    echo "Tu puntuación final es: $puntos / 3"
    echo ""
}

mostrar_instrucciones(){
    echo "-------------------------------------------------"
    echo "Instrucciones:"
    echo "Deberás responder las preguntas escribiendo la letra"
    echo "que consideres correcta (a, b, c o d)."
    echo "Cada respuesta correcta suma 1 punto."
    echo "-------------------------------------------------"
}

mostrar_record(){
    record=$(cat "$ruta_record")
    echo "----------------------------"
    echo "El récord actual es: $record"
    echo "----------------------------"
}

borrar_record(){
    echo 0 > $ruta_record
    echo "-------------------------------------"
    echo "Se ha borrado correctamente el récord"
    echo "-------------------------------------"
}

# Mensaje de bienvenida
echo "-----------------------------"
echo "Bienvenido al juego de trivia"
echo "-----------------------------"

while [ "$decision" != "4" ]; do
    echo ""
    echo "Seleccione una opción de juego:"
    echo "1 - Iniciar juego"
    echo "2 - Ver instrucciones"
    echo "3 - Mostrar récord"
    echo "4 - Borrar récord"
    echo "5 - Salir"
    echo "Opción: "
    read decision

    case $decision in 
        1) iniciar_juego ;;
        2) mostrar_instrucciones ;;
        3) mostrar_record ;;
        4) borrar_record ;;
        5) 
            echo "---------------------"
            echo "¡Fin del juego!"
            echo "Puntaje final: $puntos / 3"
            echo "---------------------"
            exit 0
            ;;
        *)
            echo "Opción no válida, intenta de nuevo."
            ;;
    esac
done
