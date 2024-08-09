package modelo;

/**
 *
 * @author
 */
public class Autor extends Usuario  {
    private int idAutor;
    private String fechaNace;
    

    public Autor() {
    }

    public Autor(int idAutor, String fechaNace, int idUsuario, String nombres, String apellidos, String clave, String cedula, String direccion, String telefono, String correoInstitucional, int rol) {
        super(idUsuario, nombres, apellidos, clave, cedula, direccion, telefono, correoInstitucional, rol);
        this.idAutor = idAutor;
        this.fechaNace = fechaNace;
    }
    

    
    public Autor(String fechaNace, String nombres, String apellidos) {
        super(nombres, apellidos);
        this.fechaNace = fechaNace;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
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
