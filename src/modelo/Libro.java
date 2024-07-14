/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 *
 * @author USER
 */
public class Libro {
    private int idLibros;
    private String titulo;
    private Autor autor;
    private String isbn;
    private int anioPublicacion;
    private String estado;
    private int cantidadDisponible;
    private Genero genero;


    public Libro(int idLibros, String titulo, Autor autor, String isbn, int anioPublicacion, String estado, int cantidadDisponible, Genero genero) {
        this.idLibros = idLibros;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.estado = estado;
        this.cantidadDisponible = cantidadDisponible;
        this.genero = genero;

    }

    public int getIdLibros() {
        return idLibros;
    }

    public void setIdLibros(int idLibros) {
        this.idLibros = idLibros;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void mostrarInfoLibro() {
        System.out.println("Libro ID: " + idLibros + ", Título: " + titulo + ", Autor: " + autor.getPremiosReconocimientos() + ", ISBN: " + isbn + ", Año de Publicación: " + anioPublicacion + ", Estado: " + estado + ", Cantidad Disponible: " + cantidadDisponible + ", Género: " + genero.getNombGenero());
    }
}
