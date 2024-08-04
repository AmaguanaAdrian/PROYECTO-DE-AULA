
package vista;

import Controlador.ConexionBDD;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class MainP {
    public static void main(String[] args) {
        //        CONEXION A BASE DE DATOS
        ConexionBDD cb = new ConexionBDD();
        cb.conectar();

        // Imprime un mensaje de bienvenida 
        menus.introduccion();
        Funciones.cls();

        // Espera a que el usuario presione Enter
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        
        Login.login(args);
    }
    
}
