package modelo;
/**
 *
 * @author david
 */
public class Usuario {
    private int idPersona;
    private String nombres;
    private String apellidos;
    private String contraseña;
    private String cedula;
    private String direccion;
    private int telefono;
    private String correoInstitucional;

    public Usuario() {
    }

    public Usuario(int idPersona, String nombres, String apellidos, String contraseña, String cedula, String direccion, int telefono, String correoInstitucional) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contraseña = contraseña;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoInstitucional = correoInstitucional;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

   
    
    
    public String imprimir(){
        return"--------DATOS PERSONA--------\n"
                + "NOMBRE: "+getNombres()+"\n"
                + "APELLIDOS: "+getApellidos()+"\n"
                + "TELEFONO: "+getTelefono()+"\n"
                + "DIRECCIÓN: "+getDireccion()+"\n"
                + "CORREO INSTITUCIONAL: "+getCorreoInstitucional();
    }
    
}
