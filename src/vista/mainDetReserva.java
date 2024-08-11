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
        Ejemplar[] listaEjemplares = new Ejemplar[4]; // Lista estática con 5 posiciones
        int indice = 0; // Índice para controlar la inserción en el array

        while (true) {
            System.out.print("Ingrese el título del libro (o 0 para salir): ");
            String inputUsuario = es.nextLine(); // Variable local para manejar la entrada del usuario

            // Verificar si el usuario desea salir
            if (inputUsuario.equals("0")) {
                break;
            }

            // Usar la variable local en lugar de "titulo"
            String titulo = inputUsuario; // Ahora 'titulo' tiene el valor que ingresó el usuario

            int idLibro = libC.idPorTitulo(titulo, "");
            if (idLibro == 0) {
                System.out.println("No se encontró el libro con título '" + titulo + "'");
                continue;
            }

            boolean hayEjemplaresDisponibles = libC.buscarEjemplaresDisponibles(idLibro);
            if (hayEjemplaresDisponibles) {
                System.out.println("Hay ejemplares disponibles para este libro.");
                System.out.print("¿Desea seleccionar este libro? (si/no): ");
                String respuesta = es.nextLine();

                if (respuesta.equalsIgnoreCase("si")) {
                    String libroInfo = libC.infoLibro1(idLibro);
                    System.out.println("Ejemplar seleccionado: " + libroInfo);
                    listaEjemplares[indice] = new Ejemplar(); // Agrega el ejemplar en la posición actual
                    indice++; // Incrementa el índice para la próxima inserción
                } else {
                    System.out.println("No se seleccionó el libro.");
                }

                System.out.print("¿Desea continuar seleccionando libros? (si/no): ");
                String continuar = es.nextLine();

                if (continuar.equalsIgnoreCase("no")) {
                    break;
                }

            } else {
                System.out.println("No hay ejemplares disponibles para este libro.");
                System.out.print("¿Desea continuar seleccionando libros? (si/no): ");
                String continuar = es.nextLine();

                if (continuar.equalsIgnoreCase("no")) {
                    break;
                }
            }
        }

        // Aquí puedes agregar otro método para buscar libro por ISBN si lo necesitas.
    }
//
//    public static void main(String[] args) {
//        LibroControlador libC = new LibroControlador();
//        EstudianteControlador estC = new EstudianteControlador();
//        Scanner es = new Scanner(System.in);
//        Ejemplar[] listaEjemplares = new Ejemplar[4]; // Lista estática con 5 posiciones
//        int indice = 0; // Índice para controlar la inserción en el array
//
//        while (true) {
//            if (indice >= listaEjemplares.length) { // Verificar si la lista está llena
//                System.out.println("Lista llena, solo puedes reservar maximo 5 libros.");
//                break;
//            }
//
//            System.out.print("Ingrese el título del libro "
//                    + "(o 0 para salir): ");
//            String titulo = es.nextLine();
//
//            if (titulo.equals("0")) {
//                break;
//            }
//
//            int idLibro = libC.idPorTitulo(titulo, "");
//            if (idLibro == 0) {
//                System.out.println("No se encontró el libro con título '" + titulo + "'");
//                continue;
//            }
//
//            boolean hayEjemplaresDisponibles = libC.buscarEjemplaresDisponibles(idLibro);
//            if (hayEjemplaresDisponibles) {
//                System.out.println("Hay ejemplares disponibles para este libro.");
//                System.out.print("¿Desea seleccionar este libro? (si/no): ");
//                String respuesta = es.nextLine();
//
//                if (respuesta.equalsIgnoreCase("si")) {
//                    String libroInfo = libC.infoLibro1(idLibro);
//                    System.out.println("Ejemplar seleccionado: " + libroInfo);
//                    listaEjemplares[indice] = new Ejemplar(); // Agrega el ejemplar en la posición actual
//                    indice++; // Incrementa el índice para la próxima inserción
//                } else {
//                    System.out.println("No se seleccionó el libro.");
//                }
//
//                System.out.print("¿Desea continuar seleccionando libros? (si/no): ");
//                String continuar = es.nextLine();
//
//                if (continuar.equalsIgnoreCase("no")) {
//                    break;
//                }
//
//            } else {
//                System.out.println("No hay ejemplares disponibles para este libro.");
//                System.out.print("¿Desea continuar seleccionando libros? (si/no): ");
//                String continuar = es.nextLine();
//
//                if (continuar.equalsIgnoreCase("no")) {
//                    break;
//                }
//            }
//        }
//
//        // Aquí puedes agregar otro método para buscar libro por ISBN si lo necesitas.
//    }
    //    public static void main(String[] args) {
//        LibroControlador libC = new LibroControlador();
//        EstudianteControlador estC = new EstudianteControlador();
//        Scanner es = new Scanner(System.in);
////        Lista[] listaEjempalere==new Ejemplar[];
//        ArrayList<Ejemplar> listaEjemplares = new ArrayList<>();
//
//        while (true) {
//            System.out.print("Ingrese el título del libro (o 0 para salir): ");
//            String titulo = es.nextLine();
//
//            if (titulo.equals("0")) {
//                break;
//            }
//
//            int idLibro = libC.idPorTitulo(titulo, "");
//            if (idLibro == 0) {
//                System.out.println("No se encontró el libro con título '" + titulo + "'");
//                continue;
//            }
//
//            boolean hayEjemplaresDisponibles = libC.buscarEjemplaresDisponibles(idLibro);
//            if (hayEjemplaresDisponibles) {
//                System.out.println("Hay ejemplares disponibles para este libro.");
//                System.out.print("¿Desea seleccionar este libro? (si/no): ");
//                String respuesta = es.nextLine();
//                if (respuesta.equalsIgnoreCase("si")) {
//                    String libroInfo = libC.infoLibro1(idLibro);
//                    System.out.println("Ejemplar seleccionado: " + libroInfo);
//                    Ejemplar ejem = new Ejemplar(); // Inicializar con parámetros adicionales
//                    listaEjemplares.add(ejem);
//                    System.out.print("¿Desea continuar seleccionando libros? (si/no)1: ");
//                    String continuar = es.nextLine();
//                    if (continuar.equalsIgnoreCase("no")) {
//                        break;
//                    }
//                } else {
//                    System.out.println("No se seleccionó el libro.");
//                    System.out.print("¿Desea continuar seleccionando libros? (si/no)2: ");
//                    String continuar = es.nextLine();
//                    if (continuar.equalsIgnoreCase("no")) {
//                        break;
//                    }
//                }
//            } else {
//                System.out.println("No hay ejemplares disponibles para este libro.");
//                System.out.print("¿Desea continuar seleccionando libros? (s/n): ");
//                String continuar = es.nextLine();
//                if (continuar.equalsIgnoreCase("n")) {
//                    break;
//                }
//            }
//        }
//
//        //AQUI LE HACES OTRO MAIN QUE SEA PARA BUSCAR LIBRO POR ISBN
//    }
}
