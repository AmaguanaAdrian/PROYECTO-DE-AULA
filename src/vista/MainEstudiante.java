package vista;

import java.util.Scanner;

/**
 *
 * @author
 */
public class MainEstudiante {

    public static void perfilEstudiante(String[] args) {

        Scanner es = new Scanner(System.in);
        int i = 1;

        do {
            menus.menuEstudiante();
            int op = es.nextInt();
            //REALIZAR RESERVA
            if (op == 1) {
                //AQUI VA EL CODIGO DE HACER LA RESERVA

            } else if (op == 2) {
                menus.menuBusquedaLibros();
                int op1 = es.nextInt();
                if (op1 == 1) {

                } else if (op1 == 2) {

                } else if (op1 == 3) {

                } else if (op1 == 0) {

                    MainEstudiante.perfilEstudiante(args);
                    break;
                }
            } else if (op == 0) {
                return;
            }
        } while (true);

    }
}
