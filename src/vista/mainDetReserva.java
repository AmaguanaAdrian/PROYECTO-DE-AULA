package vista;

import Controlador.EstudianteControlador;
import Controlador.LibroControlador;
import Controlador.ReservaControlador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Ejemplar;
import modelo.Reserva;

/**
 *
 * @author david
 */
public class mainDetReserva {
// AQUI ESTA SOLO PARA QUE BUSQUE CON EL TITULO PERO NO ESTA COMPLETO

    public static void main(String[] args) {
        LibroControlador libC = new LibroControlador();
        EstudianteControlador estC = new EstudianteControlador();
        Scanner es = new Scanner(System.in);
        ArrayList<Ejemplar> listaEjemplares = new ArrayList<>();

        while (true) {
            System.out.print("Ingrese el título del libro (o 0 para salir): ");
            String titulo = es.nextLine();

            if (titulo.equals("0")) {
                break;
            }

            int idLibro = libC.idPorTitulo(titulo, "");
            if (idLibro == 0) {
                System.out.println("No se encontró el libro con título '" + titulo + "'");
                continue;
            }

            boolean hayEjemplaresDisponibles = libC.buscarEjemplaresDisponibles(idLibro);
            if (hayEjemplaresDisponibles) {
                System.out.println("Hay ejemplares disponibles para este libro.");
                System.out.print("¿Desea seleccionar este libro? (s/n): ");
                String respuesta = es.nextLine();
                if (respuesta.equalsIgnoreCase("s")) {
                    String libroInfo = libC.infoLibro1(idLibro);
                    System.out.println("Ejemplar seleccionado: " + libroInfo);
                    Ejemplar ejem = new Ejemplar(); // Inicializar con parámetros adicionales
                    listaEjemplares.add(ejem);
                    System.out.print("¿Desea continuar seleccionando libros? (s/n): ");
                    String continuar = es.nextLine();
                    if (continuar.equalsIgnoreCase("n")) {
                        break;
                    }
                } else {
                    System.out.println("No se seleccionó el libro.");
                    System.out.print("¿Desea continuar seleccionando libros? (s/n): ");
                    String continuar = es.nextLine();
                    if (continuar.equalsIgnoreCase("n")) {
                        break;
                    }
                }
            } else {
                System.out.println("No hay ejemplares disponibles para este libro.");
                System.out.print("¿Desea continuar seleccionando libros? (s/n): ");
                String continuar = es.nextLine();
                if (continuar.equalsIgnoreCase("n")) {
                    break;
                }
            }
        }

        //AQUI LE HACES OTRO MAIN QUE SEA PARA BUSCAR LIBRO POR ISBN
    }
}
