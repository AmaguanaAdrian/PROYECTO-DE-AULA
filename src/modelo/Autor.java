/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USER
 */
public class Autor extends Usuario {
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

    
    
    
    
    
    
}
