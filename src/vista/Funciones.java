/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import Controlador.ConexionBDD;
import com.mysql.jdbc.Connection;
import controlador.LoginControlador;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

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

    public static void cls() {
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

    public static boolean isValidDate(String fecha) {
        String regex = "^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";
        return Pattern.matches(regex, fecha);
    }

    public static boolean isValidText(String texto) {
        String regex = "^[a-zA-Z]+( [a-zA-Z]+)*$";
        return texto.matches(regex);
    }

    public static boolean isValidTitle(String texto) {
        String regex = "^[a-zA-Z0-9]+( [a-zA-Z0-9-]+)*$";
        return Pattern.matches(regex, texto);
    }

    public static boolean isValidISBN(String texto) {
        String regex = "^[a-zA-Z0-9-]+$";
        return texto.matches(regex);
    }

    public static void login(String[] args) throws IOException {
        int b = 0;

        do {
            // CONEXION 
            ConexionBDD conexion = new ConexionBDD();
            Connection connection = (Connection) conexion.conectar();

            Scanner es = new Scanner(System.in);
            boolean loginCorrecto = false;

            while (!loginCorrecto) {
                System.out.println("------------------Inicio de sesión------------------");
                System.out.print("    Ingrese su usuario: ");
                String usuario = es.nextLine();
                System.out.print("    Ingrese su contraseña: ");
                String clave = es.nextLine();

                int usu_rol = LoginControlador.login(usuario, clave, connection);
                if (usu_rol > 0) {
                    System.out.println("----Bienvenido!----");
                    loginCorrecto = true;
                    if (usu_rol == 1) {
                        // Acciones para usuarios con rol 1
                        System.out.println("----Acceso como Estudiante----");
                        Main1.perfilEstudiante(args);
                        b = 1;

                    } else if (usu_rol == 2) {
                        // Acciones para usuarios con rol 2
                        System.out.println("----Acceso como Bibliotecario----");
                        Main1.perfilBliotecario(args);
                        b = 1;

                    } else if (usu_rol == 3) {
                        // Acciones para usuarios con rol 3
                        System.out.println("----Acceso como Admin----");
                        Main1.perfilAdmin(args);
                        b = 1;
                    }
                } else {
                    System.out.println("Usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.");
                    System.out.print("¿Desea intentar otra vez? (Si/No): ");
                    String respuesta = es.nextLine();
                    if (respuesta.equalsIgnoreCase("si")) {
                        // No hace falta hacer nada, el bucle while seguirá ejecutándose
                    } else if (respuesta.equalsIgnoreCase("no")) {
                        b = 1;
                        break;// Cambia el valor de b para salir del bucle do-while
                    } else {
                        System.out.println("Respuesta inválida. Por favor, ingrese Si o No.");
                    }
                }
            }

        } while (b == 0);

    }
}
