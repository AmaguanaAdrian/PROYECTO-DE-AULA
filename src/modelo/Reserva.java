package modelo;

/**
 *
 * @author
 */
public class Reserva {

    private int idReserva;
    private int idEstudiante;
    private String fechaRetiro;
    private String fechaReserva;
    private String fechaDevolucion;

    public Reserva() {
    }

    public Reserva(int idReserva, int idEstudiante, String fechaRetiro, String fechaReserva, String fechaDevolucion) {
        this.idReserva = idReserva;
        this.idEstudiante = idEstudiante;
        this.fechaRetiro = fechaRetiro;
        this.fechaReserva = fechaReserva;
        this.fechaDevolucion = fechaDevolucion;
    }

    // Getters y setters
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(String fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return ("idLibro=" + getIdReserva() + "\n"
                + ", titulo='" + getFechaRetiro() + "\n"
                + ", fechaPublicado='" + getFechaDevolucion() + "\n");
    }
}
