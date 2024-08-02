package modelo;

/**
 *
 * @author
 */
public class Ejemplar extends Libros {

    private int ejemId;
    private String codigoEjemplar;
    private Boolean estadoEjempalr;

    public Ejemplar() {
    }

    public Ejemplar(int ejemId, String codigoEjemplar, Boolean estadoEjempalr, int idLibro, String titulo, String fechaPublicado, String isbn) {
        super(idLibro, titulo, fechaPublicado, isbn);
        this.ejemId = ejemId;
        this.codigoEjemplar = codigoEjemplar;
        this.estadoEjempalr = estadoEjempalr;
    }

    public int getEjemId() {
        return ejemId;
    }

    public void setEjemId(int ejemId) {
        this.ejemId = ejemId;
    }

    public String getCodigoEjemplar() {
        return codigoEjemplar;
    }

    public void setCodigoEjemplar(String codigoEjemplar) {
        this.codigoEjemplar = codigoEjemplar;
    }

    public Boolean getEstadoEjempalr() {
        return estadoEjempalr;
    }

    public void setEstadoEjempalr(Boolean estadoEjempalr) {
        this.estadoEjempalr = estadoEjempalr;
    }

}
