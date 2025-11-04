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
    public void buscarLibroISBN(ArrayList<Libro> libros){}
    public void actualizarLibro(ArrayList<Libro> libros){}
    public void eliminarLibro(ArrayList<Libro> libros){}
    public void marcarLibroPresDev(ArrayList<Libro> libros){}
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
