
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USER
 */
public class Estudiante extends Usuario{


    private int idEstudiante;
    private String carreraCursando;
    private String numMatricula;
    private int nivelCursando;

    public Estudiante() {
    }

    public Estudiante(int idEstudiante, String carreraCursando, String numMatricula, int nivelCursando, int idUsuario, String nombres, String apellidos, String clave, String cedula, String direccion, String telefono, String correoInstitucional, int rol) {
        super(idUsuario, nombres, apellidos, clave, cedula, direccion, telefono, correoInstitucional, rol);
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


  
    
}

   
    


