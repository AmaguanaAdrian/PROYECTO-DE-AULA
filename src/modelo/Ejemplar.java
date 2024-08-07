package modelo;

/**
 *
 * @author
 */
public class Ejemplar extends Libros {

    private int idEjemplar;
    private String codigoEjemplar;
    private boolean estado;
    private int numEjemplares;

    public Ejemplar() {
    }

    public Ejemplar(String codigoEjemplar, boolean estado, int numEjemplares, int idLibro, String titulo, String fechaPublicado, String isbn) {
        super(titulo, fechaPublicado, isbn);
        this.codigoEjemplar = codigoEjemplar;
        this.estado = estado;
        this.numEjemplares = numEjemplares;
    }
    

    // Constructor completo para crear un Ejemplar con todos los datos
    public Ejemplar(int idEjemplar, String codigoEjemplar, boolean estado, int numEjemplares) {
        this.idEjemplar = idEjemplar;
        this.codigoEjemplar = codigoEjemplar;
        this.estado = estado;
        this.numEjemplares = numEjemplares;
    }

    // Constructor para crear un Ejemplar con información de libro
    public Ejemplar(int idEjemplar, String codigoEjemplar, boolean estado, int numEjemplares, int idLibro, String titulo, String fechaPublicado, String isbn) {
        super(titulo, fechaPublicado, isbn);
        this.idEjemplar = idEjemplar;
        this.codigoEjemplar = codigoEjemplar;
        this.estado = estado;
        this.numEjemplares = numEjemplares;
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

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

//    @Override
//    public String imprimir() {
//        return super.imprimir() + "\n"
//                + "ID Ejemplar: " + getIdEjemplar() + "\n"
//                + "Código Ejemplar: " + getCodigoEjemplar() + "\n"
//                + "ID Libro: " + getIdLibro() + "\n"
//                + "Estado: " + (isEstado() ? "Disponible" : "No Disponible"
//                + "Número de ejemplares disponibles;: "+ getNumEjemplares());
//    }
}
