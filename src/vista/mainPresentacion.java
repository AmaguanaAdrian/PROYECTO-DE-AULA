package vista;
import java.util.Scanner;
/**
 *
 * @author
 */
public class mainPresentacion {
    public static void main(String[] args) {
        // Imprime un mensaje de bienvenida con un marco perfectamente alineado
        System.out.println("╔═══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                         ║");
        System.out.println("║      Bienvenido al Sistema de Reserva de Libros para    ║");
        System.out.println("║      Bibliotecas. Este sistema te permitirá gestionar   ║");
        System.out.println("║      reservas, préstamos y el genero de libros          ║");
        System.out.println("║                  Podrás realizar                        ║");
        System.out.println("║       todas tus gestiones con facilidad y rapidez.      ║");
        System.out.println("║                                                         ║");
        System.out.println("║  ¡¡Presiona Enter para comenzar y explorar el sistema.¡ ║");
        System.out.println("║                                                         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════╝");
        
        

        // Espera a que el usuario presione Enter
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();  

        // Llama al siguiente main
        main.main(null);
    }
}
