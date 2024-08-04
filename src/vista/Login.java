package vista;

import Controlador.ConexionBDD;
import com.mysql.jdbc.Connection;
import controlador.LoginControlador;
import java.util.Scanner;

public class Login {

    public static void login(String[] args) {
        int b = 0;

        do {
            // CONEXION 
            ConexionBDD conexion = new ConexionBDD();
            Connection connection = (Connection) conexion.conectar();

            Scanner es = new Scanner(System.in);
            boolean loginCorrecto = false;

            while (!loginCorrecto) {
                System.out.print("------------------Inicio de sesión------------------".indent(30));
                System.out.print("    Ingrese su usuario: ".indent(35));
                String usuario = es.nextLine();
                System.out.print("    Ingrese su contraseña: ".indent(35));
                String clave = es.nextLine();
                 

                int usu_rol = LoginControlador.login(usuario, clave, connection);
                if (usu_rol > 0) {
                    System.out.println("Bienvenido!");
                    loginCorrecto = true;
                    if (usu_rol == 1) {
                        // Acciones para usuarios con rol 1
                        System.out.println("Acceso como Estudiante");
                        b=1;

                    } else if (usu_rol == 2) {
                        // Acciones para usuarios con rol 2
                        System.out.println("Acceso como Bibliotecario");
                        MainBibliotecario.perfilBliotecario(args);
                        b=1;

                    }
                } else {
                    System.out.println("Usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.");
                }
            }

        } while (b==0);

    }
}
