package modelo;

/**
 *
 * @author
 */
public class Ejemplar extends Libros {
    private int idEjemplar;
    private String codigoEjemplar;
    private boolean estado;
    private int idLibro;

    public Ejemplar() {
        super();
    }

    // Constructor para crear un Ejemplar sin idEjemplar (cuando se está insertando)
    public Ejemplar(String codigoEjemplar, boolean estado, int idLibro) {
        this.codigoEjemplar = codigoEjemplar;
        this.estado = estado;
        this.idLibro = idLibro;
    }

    // Constructor completo para crear un Ejemplar con todos los datos
    public Ejemplar(int idEjemplar, String codigoEjemplar, boolean estado, int idLibro) {
        this.idEjemplar = idEjemplar;
        this.codigoEjemplar = codigoEjemplar;
        this.estado = estado;
        this.idLibro = idLibro;
    }

    // Constructor para crear un Ejemplar con información de libro
    public Ejemplar(int idEjemplar, String codigoEjemplar, boolean estado, int idLibro, String titulo, String fechaPublicado, String isbn) {
        super(idLibro, titulo, fechaPublicado, isbn);
        this.idEjemplar = idEjemplar;
        this.codigoEjemplar = codigoEjemplar;
        this.estado = estado;
        this.idLibro = idLibro;
    }

    public int getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public String getCodigoEjemplar() {
        return codigoEjemplar;
    }

    public void setCodigoEjemplar(String codigoEjemplar) {
        this.codigoEjemplar = codigoEjemplar;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + "\n"
                + "ID Ejemplar: " + getIdEjemplar() + "\n"
                + "Código Ejemplar: " + getCodigoEjemplar() + "\n"
                + "ID Libro: " + getIdLibro() + "\n"
                + "Estado: " + (isEstado() ? "Disponible" : "No Disponible");
    }
}
