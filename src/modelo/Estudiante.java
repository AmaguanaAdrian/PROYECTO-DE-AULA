package modelo;
/**
 *
 * @author david
 */
public class Estudiante extends Persona{
    private int idEstudiante;
    private String carreraCursando;
    private String numMatricula;
    private int nivelCursando;

    public Estudiante() {
    }

    public Estudiante(int idEstudiante, String carreraCursando, String numMatricula, int nivelCursando, String nombres, String apellidos, String usuario, String contraseña, String cedula, String fechaNace, String direccion, Double telefono, String correoInstitucional, String sexo) {
        super(nombres, apellidos, usuario, contraseña, cedula, fechaNace, direccion, telefono, correoInstitucional, sexo);
        this.idEstudiante = idEstudiante;
        this.carreraCursando = carreraCursando;
        this.numMatricula = numMatricula;
        this.nivelCursando = nivelCursando;
    }

    

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    
    public String getCarreraCursando() {
        return carreraCursando;
    }

    public void setCarreraCursando(String carreraCursando) {
        this.carreraCursando = carreraCursando;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    public int getNivelCursando() {
        return nivelCursando;
    }

    public void setNivelCursando(int nivelCursando) {
        this.nivelCursando = nivelCursando;
    }
    
    @Override
    public String imprimir(){
        return"--------DATOS PERSONA--------\n"
                + "NOMBRE: "+getNombres()+"\n"
                + "APELLIDOS: "+getApellidos()+"\n"
                + "TELEFONO: "+getTelefono()+"\n"
                + "DIRECCIÓN: "+getDireccion()+"\n"
                + "FECHA DE NACIMIENTO: "+getFechaNace()+"\n"
                + "CORREO INSTITUCIONAL: "+getCorreoInstitucional()+"\n"
                + "SEXO: "+getSexo()+"\n"
                + "NÚMERO DE MATRICULA: "+getNumMatricula()+"\n"
                + "CARRERA CURSANDO: "+getCarreraCursando()+"\n"
                + "NIVEL ACTUAL: "+getNivelCursando()+"\n";
    }
   
    
}
