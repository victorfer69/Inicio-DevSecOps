package com.example.demo;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> libros;

    public Biblioteca(){
        this.libros = new ArrayList<Libro>();
    }

    public ArrayList<Libro> getLibros(){
        return libros;
    }
    public void agregarLibro(Libro libro){
        ArrayList<Libro> libros = getLibros();
        if (comprobarIsbnUnico(libro)){
            libros.add(libro);
            System.out.println("Libro agregado correctamente.");
        }else {
            System.out.println("El ISBN no es unico.");
        }
    }

    public void mostrarLibros(){
        ArrayList<Libro> libros = getLibros();
        if(!estaVacio()) {
            System.out.println("---- LISTA DE LIBROS ----");
            for (int i = 0; i < libros.size(); i++){
                System.out.println(libros.get(i).muestraInfo());
            }
        }else{
            System.out.println("Esta vacio.");
        }
    }
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
    public boolean estaVacio(){
        return getLibros().isEmpty();
    }
}
