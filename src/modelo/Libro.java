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
    private String autor; // Nuevo atributo
    private String genero; // Nuevo atributo

    public Libro() {
    }

    public Libro(String titulo, String fechaPublicado, String isbn, int idLibro, String autor, String genero) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.fechaPublicado = fechaPublicado;
        this.isbn = isbn;
        this.numEjemplares = numEjemplares;
        this.autor = autor; // Inicializar autor
        this.genero = genero; // Inicializar género
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void imprimirDetalles() {
        System.out.printf("| %-20s | %-15s | %-15s | %-30s | %-15s | %-10d |\n",
                          titulo, fechaPublicado, isbn, autor, genero, numEjemplares);
    }
//    @Override
//    public String toString() {
//        return "idLibro= " + idLibro +
//                ", titulo= '" + titulo + '\'' +
//                ", fechaPublicado= '" + fechaPublicado + '\'' +
//                ", isbn= '" + isbn + '\'' +
//                ", autor= '" + autor + '\'' + // Incluir autor
//                ", genero= '" + genero + '\''; // Incluir género
//    }
}
