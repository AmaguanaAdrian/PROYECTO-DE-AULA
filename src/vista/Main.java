
package vista;

import Controlador.ConexionBDD;
import java.util.Scanner;

/**
 *
 * @author
 */
public class Main {
    public static void main(String[] args) {
        //        CONEXION A BASE DE DATOS
        ConexionBDD cb = new ConexionBDD();
        cb.conectar();

        // Imprime un mensaje de bienvenida 
        menus.introduccion();
        Funciones.cls();

        // Espera a que el usuario presione Enter
        Scanner es = new Scanner(System.in);
        es.nextLine();
        int b = 0;
//        menus.menu1();
        
        MainP.main(args);
        
        
    }
    
}
