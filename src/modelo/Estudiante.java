package modelo;
/**
 *
 * @author david
 */
public class Estudiante extends Usuario{
    private int idEstudiante;
    private String carreraCursando;
    private String numMatricula;
    private int nivelCursando;
    

    public Estudiante() {
    }

    public Estudiante(int idEstudiante, String carreraCursando, String numMatricula, int nivelCursando, int idPersona, String nombres, String apellidos, String contraseña, String cedula, String direccion, int telefono, String correoInstitucional) {
        super(idPersona, nombres, apellidos, contraseña, cedula, direccion, telefono, correoInstitucional);
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
                + "CORREO INSTITUCIONAL: "+getCorreoInstitucional()+"\n"
                + "NÚMERO DE MATRICULA: "+getNumMatricula()+"\n"
                + "CARRERA CURSANDO: "+getCarreraCursando()+"\n"
                + "NIVEL ACTUAL: "+getNivelCursando()+"\n";
    }
    
    public void crearCuenta(){
        System.out.println("INGRESE LOS DATOS PARA CREAR LA CUENTA\n"
                + "Nombbres: ";
    
    };
   
    
}
