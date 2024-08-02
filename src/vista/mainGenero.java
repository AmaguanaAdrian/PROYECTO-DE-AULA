/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author USER
 */
import Controlador.GeneroControlador;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Genero;

public class mainGenero {

    public static void main(String[] args) {
        Scanner es = new Scanner(System.in);
        GeneroControlador generoControlador = new GeneroControlador();
        int op1;

        do {
            System.out.println("""
                            |   GESTIÓN DE GÉNEROS     |
                            |-------------------------|
                            |   OPCIONES:             |
                            |   1. Insertar género     |
                            |   2. Listar géneros      |
                            |   3. Actualizar género   |
                            |   4. Eliminar género     |
                            |   0. Salir              |
                            
                            """);

            op1 = es.nextInt();
            es.nextLine(); // Consumir el salto de línea

            if (op1 == 1) {
                // Insertar género
                System.out.println("Ingrese el nombre del nuevo género:");
                String nombreGenero = es.nextLine();
                Genero nuevoGenero = new Genero(nombreGenero);
                generoControlador.crearGenero(nuevoGenero);
                
            } else if (op1 == 2) {
                // Mostrar lista de géneros
                ArrayList<Genero> listaGeneros = generoControlador.listarGeneros();
                System.out.println("Lista de géneros:");
                for (Genero g : listaGeneros) {
                    System.out.println(g.getNombreGenero());
                }

            } else if (op1 == 3) {
                // Actualizar información de un género
                System.out.println("Ingrese el nombre actual del género que desea actualizar:");
                String nombreActual = es.nextLine();
                int idGenero = generoControlador.buscarIdGenero(nombreActual);
                if (idGenero > 0) {
                    System.out.println("Ingrese el nuevo nombre del género:");
                    String nuevoNombre = es.nextLine();
                    Genero generoActualizado = new Genero(nuevoNombre);
                    generoControlador.actualizarGenero(generoActualizado, idGenero);
                } else {
                    System.out.println("Género no encontrado.");
                }

            } else if (op1 == 4) {
                // Eliminar género
                System.out.println("Ingrese el nombre del género que desea eliminar:");
                String nombreEliminar = es.nextLine();
                generoControlador.eliminarGenero(nombreEliminar);

            } else if (op1 == 0) {
                System.out.println("Saliendo...");

            } else {
                System.out.println("Opción no válida, por favor elija una opción entre 0 y 4.");
            }
        } while (op1 != 0);

        es.close();
    }
}
