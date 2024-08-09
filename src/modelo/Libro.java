package modelo;

/**
 *
 * @author
 */
public class Libro {

    private int idLibro;
    private String titulo;
    private String fechaPublicado;
    private String isbn;
    private int numEjemplares;

    public Libro() {
    }

    public Libro(String titulo, String fechaPublicado, String isbn, int idLibro) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.fechaPublicado = fechaPublicado;
        this.isbn = isbn;
        this.numEjemplares = numEjemplares;
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

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    @Override
    public String toString() {
        return 
                "idLibro= " + getIdLibro() +'\''
                + ", titulo= '" + getTitulo() + '\''
                + ", fechaPublicado= '" + getFechaPublicado() + '\''
                + ", isbn= '" + getIsbn() + '\'';
    }

}
