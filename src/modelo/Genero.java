/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USER
 */
public class Genero {
    private int idGenero;
    private String nombGenero;

    public Genero(int idGenero, String nombGenero) {
        this.idGenero = idGenero;
        this.nombGenero = nombGenero;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombGenero() {
        return nombGenero;
    }

    public void setNombGenero(String nombGenero) {
        this.nombGenero = nombGenero;
    }
}
