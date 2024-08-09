package modelo;

/**
 *
 * @author
 */
public class Ejemplar extends Libro {

    private int idEjemplar;
    private String codigoEjemplar;
    private boolean estado;

    public Ejemplar() {
    }

    public Ejemplar(int idEjemplar, String codigoEjemplar, boolean estado) {
        this.idEjemplar = idEjemplar;
        this.codigoEjemplar = codigoEjemplar;
        this.estado = estado;
    }

    public Ejemplar(int idEjemplar, String codigoEjemplar, boolean estado, String titulo, String fechaPublicado, String isbn, int idLibro, String autor, String genero) {
        super(titulo, fechaPublicado, isbn, idLibro, autor, genero);
        this.idEjemplar = idEjemplar;
        this.codigoEjemplar = codigoEjemplar;
        this.estado = estado;
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

    public String imprimir() {
        return imprimir() + "\n"
                + "ID Ejemplar: " + getIdEjemplar() + "\n"
                + "Código Ejemplar: " + getCodigoEjemplar() + "\n"
                + "ID Libro: " + getIdLibro() + "\n"
                + "Estado: " + (isEstado() ? "Disponible" : "No Disponible");
    }
}
