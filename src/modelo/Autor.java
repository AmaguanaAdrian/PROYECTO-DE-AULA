package modelo;

/**
 *
 * @author
 */
public class Autor extends Usuario  {
    private String fechaNace;

    public Autor() {
    }

    public Autor(String fechaNace, String nombres, String apellidos) {
        super(nombres, apellidos);
        this.fechaNace = fechaNace;
    }

    
    public String getFechaNace() {
        return fechaNace;
    }

    public void setFechaNace(String fechaNace) {
        this.fechaNace = fechaNace;
    }

    public String imprimir() {
        return "-------DATOS DEL AUTOR-----------\n"
                + "Nombre:" + getNombres()+ "\n"
                + "Apellido:" + getApellidos()+ "\n"
                + "Fecha de Nacimiento:" + getFechaNace();
    }

}
