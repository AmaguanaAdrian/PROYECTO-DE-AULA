
package vista;

import Controlador.ConexionBDD;
import java.util.Scanner;

/**
 *
 * @author
 */
import java.util.Scanner;

//public class main {
//    public static void main(String[] args) {
//        // CONEXIÓN A BASE DE DATOS
//        ConexionBDD cb = new ConexionBDD();
//        cb.conectar();
//
//        // Imprime un mensaje de bienvenida
//        menus.introduccion();
//
//        // Espera a que el usuario presione Enter
//        System.out.println("Presiona Enter para continuar...");
//        try (Scanner es = new Scanner(System.in)) {
//            es.nextLine();
//        }
//
//        // Aquí decides qué hacer a continuación
//        // Por ejemplo, si quieres mostrar el menú principal
//        // menus.menu1();
//        
//        // O si quieres ejecutar el programa principal
//        MainP.main(args);
//    }
//}

public class main {
    public static void main(String[] args) {
        //        CONEXION A BASE DE DATOS
        ConexionBDD cb = new ConexionBDD();
        cb.conectar();

        // Imprime un mensaje de bienvenida 
        menus.introduccion();
        // Espera a que el usuario presione Enter
        Scanner es = new Scanner(System.in);
        es.nextLine();
        int b = 0;
//        menus.menu1();
        
        MainP.main(args);    
    }
    
}
