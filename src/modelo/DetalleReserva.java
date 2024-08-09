package modelo;

/**
 *
 * @author
 */
public class DetalleReserva  {
    private Libro[] listaLibros = new Libro[4];
    private int idDetReserva;

    public DetalleReserva() {
    }

    public DetalleReserva(int idDetReserva) {
        this.idDetReserva = idDetReserva;
    }

    public Libro[] getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(Libro[] listaLibros) {
        this.listaLibros = listaLibros;
    }
    
    
    
    
    
}
