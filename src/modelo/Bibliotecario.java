package modelo;

/**
 *
 * @author
 */
public class Bibliotecario extends Usuario{
    private int idBibliotecario;
    private String tituloRegistrado;
    
    

    public Bibliotecario() {
    }

    public Bibliotecario(int idBibliotecario, String tituloRegistrado, int idUsuario, String nombres, String apellidos, String clave, String cedula, String direccion, String telefono, String correoInstitucional, int rol) {
        super(idUsuario, nombres, apellidos, clave, cedula, direccion, telefono, correoInstitucional, rol);
        this.idBibliotecario = idBibliotecario;
        this.tituloRegistrado = tituloRegistrado;
    }

    
    

    public int getIdBibliotecario() {
        return idBibliotecario;
    }

    public void setIdBibliotecario(int idBibliotecario) {
        this.idBibliotecario = idBibliotecario;
    }

    public String getTituloRegistrado() {
        return tituloRegistrado;
    }

    public void setTituloRegistrado(String tituloRegistrado) {
        this.tituloRegistrado = tituloRegistrado;
    }

   
    

    public String imprimir(){
        return"--------DATOS PERSONABICLIOTECARIO--------\n"
                + "NOMBRE: "+getNombres()+"\n"
                + "APELLIDOS: "+getApellidos()+"\n"
                + "TELEFONO: "+getTelefono()+"\n"
                + "DIRECCIÓN: "+getDireccion()+"\n"
                + "CORREO INSTITUCIONAL: "+getCorreoInstitucional()+"\n"+
                 "-------DATOS ESTUDIANTE-----------\n"
                + "idBibliotecario:"+getIdBibliotecario()+"\n";
    }
}
