package modelo;

/**
 *
 * @author
 */
public class DetalleReserva {
    private String titulo;
    private String codigoEjemplar;
    private String autor;
    private String isbn;
    private String fechaReserva;
    private String estadoReserva;

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigoEjemplar() {
        return codigoEjemplar;
    }

    public void setCodigoEjemplar(String codigoEjemplar) {
        this.codigoEjemplar = codigoEjemplar;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
}
//public class DetalleReserva  {
//    private Libro[] listaLibros = new Libro[4];
//    private int idDetReserva;
//
//    public DetalleReserva() {
//    }
//
//    public DetalleReserva(int idDetReserva) {
//        this.idDetReserva = idDetReserva;
//    }
//
//    public Libro[] getListaLibros() {
//        return listaLibros;
//    }
//
//    public void setListaLibros(Libro[] listaLibros) {
//        this.listaLibros = listaLibros;
//    }  
//}
