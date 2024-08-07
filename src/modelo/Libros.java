package modelo;
/**
 *
 * @author
 */
public class Libros {
    private int idLibro;
    private String titulo;
    private String fechaPublicado;
    private String isbn;

    public Libros() {
    }

    public Libros(String titulo, String fechaPublicado, String isbn) {
        this.titulo = titulo;
        this.fechaPublicado = fechaPublicado;
        this.isbn = isbn;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaPublicado() {
        return fechaPublicado;
    }

    public void setFechaPublicado(String fechaPublicado) {
        this.fechaPublicado = fechaPublicado;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", fechaPublicado='" + fechaPublicado + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
