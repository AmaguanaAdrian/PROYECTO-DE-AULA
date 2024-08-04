package modelo;

/**
 *
 * @author
 */
public class Usuario {

    private int idUsuario;
    private String nombres;
    private String apellidos;
    private String clave;
    private String cedula;
    private String direccion;
    private String telefono;
    private String correoInstitucional;
    private int rol;

    public Usuario() {
    }

    public Usuario(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Usuario(int idUsuario, String nombres, String apellidos, String clave, String cedula, String direccion, String telefono, String correoInstitucional, int rol) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.clave = clave;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoInstitucional = correoInstitucional;
        this.rol = rol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String imprimir() {
        return "--------DATOS PERSONA--------\n"
                + "NOMBRE: " + getNombres() + "\n"
                + "APELLIDOS: " + getApellidos() + "\n"
                + "TELEFONO: " + getTelefono() + "\n"
                + "DIRECCIÓN: " + getDireccion() + "\n"
                + "TELEFONO: " + getCedula() + "\n"
                + "DIRECCIÓN: " + getClave() + "\n"
                + "CORREO INSTITUCIONAL: " + getCorreoInstitucional() + "\n";
    }
    public boolean validarCedula(String c){
        if (c == null || c.length() != 10) {
            return false;
        }

        if (!c.matches("\\d{10}")) {
            return false;
        }

        int codigoProvincia = Integer.parseInt(c.substring(0, 2));
        int tercerDigito = Integer.parseInt(c.substring(2, 3));

        if (codigoProvincia < 1 || codigoProvincia > 24 || tercerDigito >= 6) {
            return false;
        }

        int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(c.charAt(i)) * coeficientes[i];
            sum += digito > 9 ? digito - 9 : digito;
        }

        int comprobadorDigito = (10 - (sum % 10)) % 10;

        return comprobadorDigito == Character.getNumericValue(c.charAt(9));
    }

}
