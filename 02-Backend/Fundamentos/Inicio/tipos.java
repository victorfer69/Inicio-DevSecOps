package Inicio;

public class tipos {
    public static void main(String[] args) {
        
        //if-else if-else
        int edad = 18;
        if (edad > 18){
            System.out.println("Mayor de edad");
        } else if (edad == 18){
            System.out.println("Justo mayor de edad");
        } else {
            System.out.println("Menor de edad");
        }

        //switch
        String dia = "Lunes";
        switch (dia) {
            case "Lunes":
                System.out.println("Es Lunes");
                break;
            case "Martes":
                System.out.println("Es Martes");
                break;
            default:
                System.out.println("No es ni Lunes ni Martes");
                break;
        }

        //for
        for (int i = 0; i < 5; i++) {
            System.out.println("Bucle for: " + i);
        }

        //while
        int i = 0;
        while (i < 5) {
            System.out.println("Bucle while: " + i);
            i++;
        }

        //do-while
        i = 0;
        do {
            System.out.println("Bucle do while: " + i);
            i++;
        } while (i < 5);

        //for-each
        String[] nombres = {"Pepe", "Juan", "Maria", "Ana"};
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

    }
}
