/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USER
 */
public class Bibliotecario extends Usuario{
    private int idBibliotecario;
    private String puesto;
    private double horario;

    public Bibliotecario() {
    }

    public Bibliotecario(int idBibliotecario, String puesto, double horario) {
        this.idBibliotecario = idBibliotecario;
        this.puesto = puesto;
        this.horario = horario;
    }

    public Bibliotecario(int idBibliotecario, String puesto, double horario, String nombres, String apellidos, String usuario, String contraseña, String cedula, String fechaNace, String direccion, Double telefono, String correoInstitucional, String sexo) {
        super(nombres, apellidos, usuario, contraseña, cedula, fechaNace, direccion, telefono, correoInstitucional, sexo);
        this.idBibliotecario = idBibliotecario;
        this.puesto = puesto;
        this.horario = horario;
    }

    public int getIdBibliotecario() {
        return idBibliotecario;
    }

    public void setIdBibliotecario(int idBibliotecario) {
        this.idBibliotecario = idBibliotecario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getHorario() {
        return horario;
    }

    public void setHorario(double horario) {
        this.horario = horario;
    }
    

    public String imprimir(){
        return"--------DATOS PERSONABICLIOTECARIO--------\n"
                + "NOMBRE: "+getNombres()+"\n"
                + "APELLIDOS: "+getApellidos()+"\n"
                + "TELEFONO: "+getTelefono()+"\n"
                + "DIRECCIÓN: "+getDireccion()+"\n"
                + "FECHA DE NACIMIENTO: "+getFechaNace()+"\n"
                + "CORREO INSTITUCIONAL: "+getCorreoInstitucional()+"\n"+
                 "-------DATOS ESTUDIANTE-----------\n"
                + "idBibliotecario:"+getIdBibliotecario()+"\n"
                + "Puesto: "+getPuesto()+"\n"
                + "Horario: "+getHorario()+"\n";
    }
}
