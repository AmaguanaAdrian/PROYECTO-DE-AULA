package modelo;

/**
 *
 * @author
 */
public class DetalleReserva  {
    private Libros[] listaLibros = new Libros[4];
    private int idDetReserva;

    public DetalleReserva() {
    }

    public DetalleReserva(int idDetReserva) {
        this.idDetReserva = idDetReserva;
    }

    public Libros[] getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(Libros[] listaLibros) {
        this.listaLibros = listaLibros;
    }
    
    
    
    
    
}
