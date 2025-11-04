package com.example.demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        int seleccion = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== GESTOR DE BIBLIOTECA =====");
        System.out.println("1. Añadir libro");
        System.out.println("2. Mostrar todos los libros");
        System.out.println("3. Buscar libro por ISBN");
        System.out.println("4. Actualizar libro");
        System.out.println("5. Eliminar libro");
        System.out.println("6. Marcar libro como prestado/devuelto");
        System.out.println("7. Salir");

        while (seleccion != 7){
            System.out.print("Seleccione una opción: ");
            seleccion = scanner.nextInt();

            switch (seleccion){
                case 1:
                    System.out.print("Ingrese el título: ");
                    String titulo = scanner.next();
                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.next();
                    System.out.print("Ingrese el año: ");
                    int ano = scanner.nextInt();
                    System.out.print("Ingrese el ISBN: ");
                    String isbn = scanner.next();

                    try {
                        Libro libro = new Libro(titulo, autor, ano, isbn, true);
                        biblioteca.agregarLibro(libro);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    biblioteca.mostrarLibros();
                    break;
                case 3:
                    //buscarLibroISBN();
                    break;
                case 4:
                    //actualizarLibro();
                    break;
                case 5:
                    //eliminarLibro();
                    break;
                case 6:
                    //marcarLibroPresDev();
                    break;
                default:
                    System.out.println("Introduce un numero del 1 al 7");
                    break;
            }
        }
        System.out.println("Hasta la vista!!!");
    }
}
