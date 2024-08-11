package vista;

import Controlador.EstudianteControlador;
import Controlador.LibroControlador;
import Controlador.ReservaControlador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Ejemplar;
import modelo.Libro;
import modelo.Reserva;

/**
 *
 * @author david
 */
import java.util.ArrayList;
import java.util.Scanner;

public class mainDetReserva {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Controladores
        LibroControlador libroControlador = new LibroControlador();
        EstudianteControlador estudianteControlador = new EstudianteControlador();
        ReservaControlador reservaControlador = new ReservaControlador();

        ArrayList<Ejemplar> listaEjemplares = new ArrayList<>();
        int idEstudiante = 0;

        // Paso 1: Selección de libros por parte del usuario
        System.out.println("Seleccione los libros que desea reservar:");

        // Listar libros disponibles
        ArrayList<Libro> listaLibros = libroControlador.listarLibros();
        if (listaLibros.isEmpty()) {
            System.out.println("No hay libros disponibles.");
            return; // Salir si no hay libros
        } else {
            // Imprimir encabezados de la tabla
            System.out.println("+----------------------+-----------------+-----------------+--------------------------------+-----------------+------------+");
            System.out.println("| Título               | Fecha Publicado | ISBN            | Autor                          | Género          | Ejemplares |");
            System.out.println("+----------------------+-----------------+-----------------+--------------------------------+-----------------+------------+");

            for (Libro libro : listaLibros) {
                libro.imprimirDetalles(); // Llama al método para imprimir detalles
            }
            System.out.println("+----------------------+-----------------+-----------------+--------------------------------+-----------------+------------+");
        }
        while (true) {
            System.out.print("Ingrese el título del libro o 0 (salir): ");
            String inputUsuario = scanner.nextLine().trim();
            if (inputUsuario.equals("0")) {
                break;
            }
            int idEjemplar = libroControlador.idPorTitulo(inputUsuario, "");
            if (idEjemplar == 0) {
                System.out.println("No se encontró el libro con título: " + inputUsuario);
                continue;
            }
            boolean hayEjemplaresDisponibles = libroControlador.buscarEjemplaresDisponibles(idEjemplar);
            if (hayEjemplaresDisponibles) {
                System.out.println("Ejemplares disponibles.");
                System.out.print("¿Desea seleccionar este libro? (si/no): ");
                String respuesta = scanner.nextLine().trim();
                if (respuesta.equalsIgnoreCase("si")) {
                    Ejemplar ejemplar = new Ejemplar(idEjemplar);
                    listaEjemplares.add(ejemplar); 
                    System.out.println("Libro seleccionado: " + inputUsuario);
                    
                    // Preguntar si desea continuar seleccionando libros
                    System.out.print("¿Desea seleccionar otro libro? (si/no): ");
                    String continuar = scanner.nextLine().trim();
                    if (continuar.equalsIgnoreCase("no")) {
                        break; 
                    }

                } else {
                    System.out.println("No se seleccionó el libro.");
                }

            } else {
                System.out.println("No hay ejemplares disponibles para este libro.");
            }
        }
        if (listaEjemplares.isEmpty()) {
            System.out.println("No seleccionaste ningún libro.");
            return;
        }
        System.out.print("Ingrese la cédula para registrar la reserva: ");
        String cedula = scanner.nextLine().trim();
        idEstudiante = estudianteControlador.buscarIdEstudiante(cedula);

        if (idEstudiante == 0) {
            System.out.println("No se encontró un estudiante con la cédula proporcionada.");
            return;
        }
        Reserva reserva = new Reserva();

        System.out.print("Ingrese la fecha de retiro (yyyy-MM-dd): ");
        reserva.setFechaRetiro(scanner.nextLine().trim());
        System.out.print("Ingrese la fecha de devolución (yyyy-MM-dd): ");
        reserva.setFechaDevolucion(scanner.nextLine().trim());
        reserva.setIdEstudiante(idEstudiante);

        // Mostrar detalles de la reserva
        System.out.println("\nDetalles de la reserva:");
        System.out.println("Cédula del estudiante: " + cedula);
        System.out.println("Fecha de retiro: " + reserva.getFechaRetiro());
        System.out.println("Fecha de devolución: " + reserva.getFechaDevolucion());
        System.out.println("Libros seleccionados:");
        for (Ejemplar ejemplar : listaEjemplares) {
            System.out.println(" - " + libroControlador.obtenerTituloPorId(ejemplar.getIdEjemplar())); // Asumiendo que hay un método para obtener el título
        }

        // Paso 4: Confirmación de la reserva
        System.out.print("¿Desea confirmar la reserva? (si/no): ");
        String confirmacion = scanner.nextLine().trim();

        if (confirmacion.equalsIgnoreCase("si")) {
            // Insertar la reserva en la base de datos
            reservaControlador.crearReserva(reserva, idEstudiante, listaEjemplares);
            System.out.println("Reserva creada exitosamente.");
        } else {
            System.out.println("La reserva ha sido cancelada. No se guardará ninguna información.");
        }

        scanner.close(); // Cerrar el scanner al final
    }
}
//        LibroControlador libC = new LibroControlador();
//        EstudianteControlador estC = new EstudianteControlador();
//        Scanner es = new Scanner(System.in);
//        Ejemplar[] listaEjemplares = new Ejemplar[4]; // Lista estática con 4 posiciones
//        int indice = 0; // Índice para controlar la inserción en el array
//
//        // Listar libros al iniciar
//        ArrayList<Libro> listaLibros = libC.listarLibros();
//        if (listaLibros.isEmpty()) {
//            System.out.println("No hay libros disponibles.");
//        } else {
//            // Imprimir encabezados de la tabla
//            System.out.println("+----------------------+-----------------+-----------------+--------------------------------+-----------------+------------+");
//            System.out.println("| Título               | Fecha Publicado | ISBN            | Autor                          | Género          | Ejemplares |");
//            System.out.println("+----------------------+-----------------+-----------------+--------------------------------+-----------------+------------+");
//
//            for (Libro l : listaLibros) {
//                l.imprimirDetalles(); // Llama al método para imprimir detalles
//            }
//            System.out.println("+----------------------+-----------------+-----------------+--------------------------------+-----------------+------------+");
//        }
//
//        // Bucle para buscar libros por título
//        while (true) {
//            System.out.print("Ingrese el título del libro o 0 (salir): ");
//            String op = es.nextLine(); // Variable local para manejar la entrada del usuario
//            // Verificar si el usuario desea salir
//            if (op.equals("0")) {
//                break;
//            }
//
//            // Usar la variable local en lugar de "titulo"
//            String titulo = op; // Ahora 'titulo' tiene el valor que ingresó el usuario
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
//}
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

