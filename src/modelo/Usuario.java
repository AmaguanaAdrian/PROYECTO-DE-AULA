/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USER
 */
public class Usuario {
    private String nombres;
    private String apellidos;
    private String usuario;
    private String clave;
    private String cedula;
    private String fechaNace;
    private String direccion;
    private Double telefono;
    private String correoInstitucional;
    private String sexo;

    public Usuario() {
    }

    public Usuario(String nombres, String apellidos, String usuario, String clave, String cedula, String fechaNace, String direccion, Double telefono, String correoInstitucional, String sexo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
        this.cedula = cedula;
        this.fechaNace = fechaNace;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoInstitucional = correoInstitucional;
        this.sexo = sexo;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getFechaNace() {
        return fechaNace;
    }

    public void setFechaNace(String fechaNace) {
        this.fechaNace = fechaNace;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getTelefono() {
        return telefono;
    }

    public void setTelefono(Double telefono) {
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    public String imprimir(){
        return"--------DATOS PERSONA--------\n"
                + "NOMBRE: "+getNombres()+"\n"
                + "APELLIDOS: "+getApellidos()+"\n"
                + "TELEFONO: "+getTelefono()+"\n"
                + "DIRECCIÓN: "+getDireccion()+"\n"
                + "FECHA DE NACIMIENTO: "+getFechaNace()+"\n"
                + "CORREO INSTITUCIONAL: "+getCorreoInstitucional()+"\n";
    }
    
}