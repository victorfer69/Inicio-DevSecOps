package com.example.demo;

import java.util.Scanner;

/**
 * Clase que representa un ejemplo de uso de la biblioteca
 * Tiene distintas acciones dentro de la biblioteca
 * @author victorfer69
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        int seleccion = 0;

        Scanner scanner = new Scanner(System.in);

        while (seleccion != 7){
            System.out.println("===== GESTOR DE BIBLIOTECA =====");
            System.out.println("1. Añadir libro");
            System.out.println("2. Mostrar todos los libros");
            System.out.println("3. Buscar libro por ISBN");
            System.out.println("4. Actualizar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("6. Marcar libro como prestado/devuelto");
            System.out.println("7. Salir");
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
                    System.out.println("");
                    break;

                case 2:
                    biblioteca.mostrarLibros();
                    System.out.println("");
                    break;
                case 3:
                    System.out.print("Ingrese el ISBN del libro a buscar: ");
                    isbn = scanner.next();
                    Libro libro = biblioteca.buscarLibroISBN(isbn);
                    if (libro != null){
                        System.out.println(libro.muestraInfo());
                    }else{
                        System.out.println("No se ha encontrado el libro con ISBN: " + isbn + ".");
                    }
                    System.out.println("");
                    break;
                case 4:
                    System.out.print("Ingrese el ISBN del libro a buscar: ");
                    String isbnViejo = scanner.next();
                    System.out.print("Ingrese el ISBN nuevo del libro: ");
                    String isbnNuevo = scanner.next();
                    biblioteca.actualizarLibro(isbnViejo, isbnNuevo);
                    System.out.println("");
                    break;
                case 5:
                    System.out.print("Ingrese el ISBN del libro a buscar: ");
                    isbn = scanner.next();
                    biblioteca.eliminarLibro(isbn);
                    System.out.println("");
                    break;
                case 6:
                    System.out.print("Ingrese el ISBN del libro a buscar: ");
                    isbn = scanner.next();
                    biblioteca.marcarLibroPresDev(isbn);
                    System.out.println("");
                    break;
                case 7:
                    System.out.println("Hasta la vista!!!");
                    break;
                default:
                    System.out.println("Introduce un numero del 1 al 7");
                    System.out.println("");
                    break;
            }
        }

        scanner.close();
    }
}
