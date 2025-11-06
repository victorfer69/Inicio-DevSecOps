package com.example.demo;

/**
 * Clase que representa un libro dentro de una biblioteca
 * Contiene informacion sobre su titulo, autor, publicacion, isbn y disponibilidad
 * @author victorfer69
 * @version 1.0
 */
public class Libro {

    //Atributos privados
    private String titulo;
    private String autor;
    private int anoPublicacion;
    private String isbn;
    private boolean disponible;

    /**
     * Crea una nueva instancia de Libro con los datos especializados
     * @param titulo Titulo del libro.
     * @param autor Autor del libro.
     * @param anoPublicacion Cuando se publico el libro.
     * @param isbn ISBN del libro.
     * @param disponible Indica si el libro esta disponible o no
     */
    public Libro(String titulo, String autor, int anoPublicacion, String isbn, boolean disponible){
        setTitulo(titulo);
        setAutor(autor);
        setAnoPublicacion(anoPublicacion);
        setIsbn(isbn);
        setDisponible(disponible);
    }

    /**
     * Metodo que devuelve el titulo del libro
     * @return Titulo del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo que actualiza el titulo del libro
     * @param titulo del libro
     * @throws NullPointerException si el titulo es nulo
     */
    public void setTitulo(String titulo) {
        if(titulo == null){
            throw new NullPointerException("El titulo no puede ser nulo.");
        }
        this.titulo = titulo;
    }

    /**
     * Metodo que devuelve el nombre del autor del libro
     * @return Nombre del autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Metodo que actualiza el nombre del autor del libro
     * @param autor del libro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Metodo que devuelve cuando se publico el libro
     * @return cuando se publico el libro
     */
    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    /**
     * Metodo que actualiza cuando se publico el libro
     * @param anoPublicacion
     * @throws IllegalArgumentException si la fecha es negativa
     */
    public void setAnoPublicacion(int anoPublicacion) {
        if (anoPublicacion < 0){
            throw new IllegalArgumentException("El ano debe de ser mayor a cero");
        }
        this.anoPublicacion = anoPublicacion;
    }

    /**
     * Metodo que devuelve el ISBN dellibro
     * @return el ISBN del libro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Metodo que actualiza el ISBN del libro
     * @param isbn del libro
     * @throws NullPointerException si el ISBN es nulo
     */
    public void setIsbn(String isbn) {
        if (isbn == null){
            throw new NullPointerException("El ISBN no puede ser nulo");
        }
        this.isbn = isbn;
    }

    /**
     * Metodo que indica si el libro esta disponible o prestado
     * @return true si esta disponible, sino false
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Metodo que actualiza el estado del libro
     * @param disponible
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Metodo que muestra la informacion del libro
     * @return informacion del libro
     */
    public String muestraInfo(){
        return "ISBN: " + getIsbn() + "| Titulo: " + getTitulo() +"| Autor: " + getAutor() +
                "| Año: " + getAnoPublicacion();
    }
}
