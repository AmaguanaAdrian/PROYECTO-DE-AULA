package vista;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 *
 * @author david
 */
public class Funciones {

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
        String regex = "^[a-zA-Z0-9ñ\\s]+$";
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
}
