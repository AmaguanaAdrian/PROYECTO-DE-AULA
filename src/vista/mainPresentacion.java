package vista;
import java.util.Scanner;
/**
 *
 * @author
 */
public class mainPresentacion {
    public static void main(String[] args) {
        // Imprime un mensaje de bienvenida con un marco perfectamente alineado
        menus.introduccion();
        

        // Espera a que el usuario presione Enter
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();  

        // Llama al siguiente main
        main.main(null);
    }
}
