/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USER
 */
public class Autor {
    private int idAutor;
    private String premiosReconocimientos;

    public Autor(int idAutor, String premiosReconocimientos) {
        this.idAutor = idAutor;
        this.premiosReconocimientos = premiosReconocimientos;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getPremiosReconocimientos() {
        return premiosReconocimientos;
    }

    public void setPremiosReconocimientos(String premiosReconocimientos) {
        this.premiosReconocimientos = premiosReconocimientos;
    }

    public void mostrarInfo() {
        System.out.println("Autor ID: " + idAutor + ", Premios y Reconocimientos: " + premiosReconocimientos);
    }
}
