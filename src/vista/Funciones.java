/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.io.IOException;

/**
 *
 * @author david
 */
public class Funciones {
    
    public static void cls2() {
        for (int i = 0; i < 30; i++) {
            System.out.println("");
        }
    }
    
    public static void cls(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Comando para limpiar pantalla en Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comando para limpiar pantalla en Unix/Linux/MacOS
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al intentar limpiar la pantalla: " + ex.getMessage());
        }
    }
}
