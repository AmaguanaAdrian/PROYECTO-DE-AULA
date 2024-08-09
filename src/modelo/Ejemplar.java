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

    // Constructor para crear un Ejemplar con información de libro   
    public Ejemplar(String codigoEjemplar, boolean estado, int idLibro, String titulo, String fechaPublicado, String isbn, int numEjemplares) {
        super(titulo, fechaPublicado, isbn, idLibro);
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
