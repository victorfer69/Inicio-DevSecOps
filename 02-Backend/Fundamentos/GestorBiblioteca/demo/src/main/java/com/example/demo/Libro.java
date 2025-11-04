package com.example.demo;

public class Libro {

    private String titulo;
    private String autor;
    private int anoPublicacion;
    private String isbn;
    private boolean disponible;

    public Libro(String titulo, String autor, int anoPublicacion, String isbn, boolean disponible){
        setTitulo(titulo);
        setAutor(autor);
        setAnoPublicacion(anoPublicacion);
        setIsbn(isbn);
        setDisponible(disponible);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if(titulo == null){
            throw new NullPointerException("El titulo no puede ser nulo.");
        }
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        if (anoPublicacion < 0){
            throw new IllegalArgumentException("El ano debe de ser mayor a cero");
        }
        this.anoPublicacion = anoPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String muestraInfo(){
        return "ISBN: " + getIsbn() + "| Titulo: " + getTitulo() +"| Autor: " + getAutor() +
                "| Año: " + getAnoPublicacion();
    }
}
