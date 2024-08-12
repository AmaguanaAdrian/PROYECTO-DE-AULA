package vista;

import Controlador.EstudianteControlador;
import Controlador.LibroControlador;
import Controlador.ReservaControlador;
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
        ArrayList<String> listaTitulos = new ArrayList<>(); // Lista para guardar los títulos

        // Paso 1: Selección de libros por parte del usuario
        System.out.println("Seleccione los libros que desea reservar:");
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

        // Selección de ejemplares
        while (true) {
            System.out.print("Ingrese el título del libro o 0 (salir): ");
            String inputUsuario = scanner.nextLine().trim();
            if (inputUsuario.equals("0")) {
                break;
            }
            int idLibro = libroControlador.idPorTitulo(inputUsuario, "");
            if (idLibro == 0) {
                System.out.println("No se encontró el libro con título: " + inputUsuario);
                continue;
            }
            Ejemplar ejemplarDisponible = libroControlador.buscarEjemplarDisponible(idLibro);
            if (ejemplarDisponible != null) {
                System.out.println("Ejemplar disponible: " + ejemplarDisponible.getCodigoEjemplar());
                System.out.print("¿Desea seleccionar este libro? (si/no): ");
                String respuesta = scanner.nextLine().trim();
                if (respuesta.equalsIgnoreCase("si")) {
                    listaEjemplares.add(ejemplarDisponible);
                    listaTitulos.add(inputUsuario); // Agregar el título a la lista
                    System.out.println("Libro seleccionado: " + inputUsuario);
                    System.out.println("Ejemplares seleccionados hasta ahora:");
                    for (Ejemplar ejemplar : listaEjemplares) {
                        System.out.println(" - " + ejemplar.getCodigoEjemplar());
                    }

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
        int idEstudiante = estudianteControlador.buscarIdEstudiante(cedula);

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
        for (String titulo : listaTitulos) {
            System.out.println(" - " + titulo); // Imprimir los títulos de los libros seleccionados
        }

        // Paso 4: Confirmación de la reserva
        System.out.print("¿Desea confirmar la reserva? (si/no): ");
        String confirmacion = scanner.nextLine().trim();

        if (confirmacion.equalsIgnoreCase("si")) {
            // Insertar la reserva en la base de datos
            int idReserva = reservaControlador.crearReserva(reserva);
            if (idReserva > 0) {

                for (Ejemplar ejemplar : listaEjemplares) {
                    System.out.println("Intentando insertar eje_id: " + ejemplar.getIdEjemplar());
                }

                // Insertar detalles de la reserva
                reservaControlador.crearDetReserva(idReserva, listaEjemplares);
                System.out.println("Reserva creada exitosamente.");

                // Actualizar el estado de los ejemplares seleccionados
                // Actualizar el estado de los ejemplares seleccionados
                for (Ejemplar ejemplar : listaEjemplares) {
                    libroControlador.actualizarEstadoEjemplar(ejemplar.getCodigoEjemplar(), "Reservado");
                }

            } else {
                System.out.println("Error al crear la reserva.");

            }
        }
    }
}
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Controladores
//        LibroControlador libroControlador = new LibroControlador();
//        EstudianteControlador estudianteControlador = new EstudianteControlador();
//        ReservaControlador reservaControlador = new ReservaControlador();
//
//        ArrayList<Ejemplar> listaEjemplares = new ArrayList<>();
//        ArrayList<String> listaTitulos = new ArrayList<>(); // Lista para guardar los títulos
//
//        // Paso 1: Selección de libros por parte del usuario
//        System.out.println("Seleccione los libros que desea reservar:");
//        ArrayList<Libro> listaLibros = libroControlador.listarLibros();
//        if (listaLibros.isEmpty()) {
//            System.out.println("No hay libros disponibles.");
//            return; // Salir si no hay libros
//        } else {
//            // Imprimir encabezados de la tabla
//            System.out.println("+----------------------+-----------------+-----------------+--------------------------------+-----------------+------------+");
//            System.out.println("| Título               | Fecha Publicado | ISBN            | Autor                          | Género          | Ejemplares |");
//            System.out.println("+----------------------+-----------------+-----------------+--------------------------------+-----------------+------------+");
//
//            for (Libro libro : listaLibros) {
//                libro.imprimirDetalles(); // Llama al método para imprimir detalles
//            }
//            System.out.println("+----------------------+-----------------+-----------------+--------------------------------+-----------------+------------+");
//        }
//
//        // Selección de ejemplares
//        while (true) {
//            System.out.print("Ingrese el título del libro o 0 (salir): ");
//            String inputUsuario = scanner.nextLine().trim();
//            if (inputUsuario.equals("0")) {
//                break;
//            }
//            int idLibro = libroControlador.idPorTitulo(inputUsuario, "");
//            if (idLibro == 0) {
//                System.out.println("No se encontró el libro con título: " + inputUsuario);
//                continue;
//            }
//            Ejemplar ejemplarDisponible = libroControlador.buscarEjemplarDisponible(idLibro);
//            if (ejemplarDisponible != null) {
//                System.out.println("Ejemplar disponible: " + ejemplarDisponible.getCodigoEjemplar());
//                System.out.print("¿Desea seleccionar este libro? (si/no): ");
//                String respuesta = scanner.nextLine().trim();
//                if (respuesta.equalsIgnoreCase("si")) {
//                    listaEjemplares.add(ejemplarDisponible);
//                    listaTitulos.add(inputUsuario); // Agregar el título a la lista
//                    System.out.println("Libro seleccionado: " + inputUsuario);
//                    System.out.println("Ejemplares seleccionados hasta ahora:");
//                    for (Ejemplar ejemplar : listaEjemplares) {
//                        System.out.println(" - " + ejemplar.getCodigoEjemplar());
//                    }
//
//                    // Preguntar si desea continuar seleccionando libros
//                    System.out.print("¿Desea seleccionar otro libro? (si/no): ");
//                    String continuar = scanner.nextLine().trim();
//                    if (continuar.equalsIgnoreCase("no")) {
//                        break;
//                    }
//
//                } else {
//                    System.out.println("No se seleccionó el libro.");
//                }
//
//            } else {
//                System.out.println("No hay ejemplares disponibles para este libro.");
//            }
//        }
//
//        if (listaEjemplares.isEmpty()) {
//            System.out.println("No seleccionaste ningún libro.");
//            return;
//        }
//        System.out.print("Ingrese la cédula para registrar la reserva: ");
//        String cedula = scanner.nextLine().trim();
//        int idEstudiante = estudianteControlador.buscarIdEstudiante(cedula);
//
//        if (idEstudiante == 0) {
//            System.out.println("No se encontró un estudiante con la cédula proporcionada.");
//            return;
//        }
//        Reserva reserva = new Reserva();
//        System.out.print("Ingrese la fecha de retiro (yyyy-MM-dd): ");
//        reserva.setFechaRetiro(scanner.nextLine().trim());
//        System.out.print("Ingrese la fecha de devolución (yyyy-MM-dd): ");
//        reserva.setFechaDevolucion(scanner.nextLine().trim());
//        reserva.setIdEstudiante(idEstudiante);
//
//        // Mostrar detalles de la reserva
//        System.out.println("\nDetalles de la reserva:");
//        System.out.println("Cédula del estudiante: " + cedula);
//        System.out.println("Fecha de retiro: " + reserva.getFechaRetiro());
//        System.out.println("Fecha de devolución: " + reserva.getFechaDevolucion());
//        System.out.println("Libros seleccionados:");
//        for (String titulo : listaTitulos) {
//            System.out.println(" - " + titulo); // Imprimir los títulos de los libros seleccionados
//        }
//
//        // Paso 4: Confirmación de la reserva
//        System.out.print("¿Desea confirmar la reserva? (si/no): ");
//        String confirmacion = scanner.nextLine().trim();
//
//        if (confirmacion.equalsIgnoreCase("si")) {
//            // Insertar la reserva en la base de datos
//            int idReserva = reservaControlador.crearReserva(reserva);
//            if (idReserva > 0) {
//
//                for (Ejemplar ejemplar : listaEjemplares) {
//                    System.out.println("Intentando insertar eje_id: " + ejemplar.getIdEjemplar());
//                }
//
//                // Insertar detalles de la reserva
//                reservaControlador.crearDetReserva(idReserva, listaEjemplares);
//                System.out.println("Reserva creada exitosamente.");
//
//                // Actualizar el estado de los ejemplares seleccionados
//                
//            } else {
//                System.out.println("Error al crear la reserva.");
//            }
//        } else {
//            System.out.println("La reserva ha sido cancelada. No se guardará ninguna información.");
//        }
//    }

