package com.example.demo;

import java.util.ArrayList;

/**
 * Clase que representa una biblioteca con libros
 * Contiene informacion sobre los libros que contiene
 * @author victorfer69
 * @version 1.0
 */
public class Biblioteca {

    //Atributo privado
    private ArrayList<Libro> libros;

    /**
     * Crea una nueva instancia de una biblioteca vacia
     */
    public Biblioteca(){
        this.libros = new ArrayList<Libro>();
    }

    /**
     * Metodo que devuelve el array de libros que tiene la biblioteca
     * @return array de libros en la biblioteca
     */
    public ArrayList<Libro> getLibros(){
        return libros;
    }

    /**
     * Metodo que agrega un libro en la biblioteca
     * El libro debe de ser distinto
     * @param libro nuevo
     */
    public void agregarLibro(Libro libro){
        ArrayList<Libro> libros = getLibros();
        if (comprobarIsbnUnico(libro)){
            libros.add(libro);
            System.out.println("Libro agregado correctamente.");
        }else {
            System.out.println("El ISBN no es unico.");
        }
    }

    /**
     * Metodo que muestra la informacion sobre los libros de la biblioteca
     */
    public void mostrarLibros() {
        ArrayList<Libro> libros = getLibros();
        if (!estaVacio()) {
            System.out.println("---- LISTA DE LIBROS ----");
            for (int i = 0; i < libros.size(); i++) {
                System.out.println(libros.get(i).muestraInfo());
            }
        } else {
            System.out.println("Esta vacio.");
        }
    }

    /**
     * Metodo que busca un libro segun su ISBN
     * @param isbn del libro
     * @return libro en caso de existir, sino null
     */
    public Libro buscarLibroISBN(String isbn){
        ArrayList<Libro> libros = getLibros();
        if(!estaVacio()) {
            for (int i = 0; i < libros.size(); i++){
                if(libros.get(i).getIsbn().equals(isbn)){
                    return libros.get(i);
                }
            }
        }
        return null;
    }

    /**
     * Metodo que actualiza el isbn del libro
     * El libro debe de existir y el ISBN nuevo ser unico
     * @param isbnViejo del libro que existe
     * @param isbnNuevo del libro
     */
    public void actualizarLibro(String isbnViejo, String isbnNuevo){
        Libro libro = buscarLibroISBN(isbnViejo);
        if(libro != null){
            try{
                libro.setIsbn(isbnNuevo);
                System.out.println("ISBN actualizado con exito");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("No se ha encontrado el libro con ISBN: " + isbnViejo + ".");
        }
    }

    /**
     * Metodo que elimina un libro de la biblioteca
     * El libro debe existir
     * @param isbn del libro
     */
    public void eliminarLibro(String isbn){
        Libro libro = buscarLibroISBN(isbn);
        if(libro != null){
            ArrayList<Libro> libros = getLibros();
            libros.remove(libro);
            System.out.println("Libro eliminado con exito.");
        }else{
            System.out.println("No se ha encontrado el libro con ISBN: " + isbn + ".");
        }
    }

    /**
     * Metodo para actualizar el estado del libro
     * Si esta disponible se pone prestado y viceversa
     * @param isbn del libro
     */
    public void marcarLibroPresDev(String isbn){
        Libro libro = buscarLibroISBN(isbn);
        if(libro != null){
            if(libro.isDisponible()){
                libro.setDisponible(false);
                System.out.println("El libro ahora esta prestado.");
            }else{
                libro.setDisponible(true);
                System.out.println("El libro ahora esta disponible.");
            }
        }else{
            System.out.println("No se ha encontrado el libro con ISBN: " + isbn + ".");
        }
    }

    /**
     * Metodo que comprueba si el ISBN del libro es unico
     * @param libro
     * @return true si es unico y false sino
     */
    public boolean comprobarIsbnUnico(Libro libro){

        ArrayList<Libro> libros = getLibros();
        for (int i = 0; i < libros.size(); i++){
            Libro libroCom = libros.get(i);
            if (libroCom.getIsbn().equals(libro.getIsbn())){
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo que indica si la biblioteca esta vacia o no
     * @return true si esta vacia y false si no
     */
    public boolean estaVacio(){
        return getLibros().isEmpty();
    }
}
