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
public class mainDetReserva {

    public static void main(String[] args) {

        Scanner es = new Scanner(System.in);

        // Controladores
        LibroControlador libC = new LibroControlador();
        EstudianteControlador estC = new EstudianteControlador();
        ReservaControlador rc = new ReservaControlador();

        ArrayList<Ejemplar> listaEjemplares = new ArrayList<>();
        int idEstudiante = 0;

        // Paso 1: Selección de libros por parte del usuario
        System.out.println("Seleccione los libros que desea reservar:");

        // Listar libros disponibles
        ArrayList<Libro> listaLibros = libC.listarLibros();
        if (listaLibros.isEmpty()) {
            System.out.println("No hay libros disponibles.");
            return; // Salir si no hay libros
        } else {
            // Imprimir encabezados de la tabla
            System.out.println("+----------------------+-----------------+-----------------+--------------------------------+-----------------+------------+");
            System.out.println("| Título               | Fecha Publicado | ISBN            | Autor                          | Género          | Ejemplares |");
            System.out.println("+----------------------+-----------------+-----------------+--------------------------------+-----------------+------------+");

            for (Libro l : listaLibros) {
                l.imprimirDetalles(); // Llama al método para imprimir detalles
            }
            System.out.println("+----------------------+-----------------+-----------------+--------------------------------+-----------------+------------+");
        }

        // Bucle para seleccionar libros
        while (true) {
            System.out.print("Ingrese el título del libro o 0 (salir): ");
            String inputUsuario = es.nextLine(); // Variable local para manejar la entrada del usuario

            // Verificar si el usuario desea salir
            if (inputUsuario.equals("0")) {
                break;
            }

            String titulo = inputUsuario; // Ahora 'titulo' tiene el valor que ingresó el usuario

            int idEjemplar = libC.idPorTitulo(titulo, "");
            if (idEjemplar == 0) {
                System.out.println("No se encontró el libro con título: " + titulo );
                continue;
            }

            boolean hayEjemplaresDisponibles = libC.buscarEjemplaresDisponibles(idEjemplar);
            if (hayEjemplaresDisponibles) {
                System.out.println("Hay ejemplares disponibles para este libro.");
                System.out.print("¿Desea seleccionar este libro? (si/no): ");
                String respuesta = es.nextLine();

                if (respuesta.equalsIgnoreCase("si")) {
                    // Crear objeto Ejemplar con los datos necesarios
                    Ejemplar ejemplar = new Ejemplar(idEjemplar);
                    listaEjemplares.add(ejemplar); // Agrega el ejemplar a la lista
                } else {
                    System.out.println("No se seleccionó el libro.");
                }

            } else {
                System.out.println("No hay ejemplares disponibles para este libro.");
            }
        }

        if (listaEjemplares.isEmpty()) {
            System.out.println("No seleccionaste ningún libro.");
            return; // Salir si no se seleccionó ningún libro
        }

        // Paso 2: Obtener la cédula del estudiante y verificar su existencia
        System.out.print("Ingrese la cédula para registrar la reserva: ");
        String cedula = es.next();
        idEstudiante = estC.buscarIdEstudiante(cedula);
        es.nextLine(); // Limpiar el buffer de entrada

        if (idEstudiante == 0) {
            System.out.println("No se encontró un estudiante con la cédula proporcionada.");
            return; // Salir si no se encuentra el estudiante
        }

        // Paso 3: Ingreso de datos de la reserva
        Reserva r = new Reserva();

        System.out.print("Ingrese la fecha de retiro (yyyy-MM-dd): ");
        r.setFechaRetiro(es.nextLine());
        System.out.print("Ingrese la fecha de devolucion (yyyy-MM-dd): ");
        r.setFechaDevolucion(es.nextLine());
        r.setIdEstudiante(idEstudiante);

        // Paso 4: Confirmación de la reserva
        System.out.print("¿Desea confirmar la reserva? (si/no): ");
        String confirmacion = es.nextLine();

        if (confirmacion.equalsIgnoreCase("si")) {
            // Insertar la reserva en la base de datos
            rc.crearReserva(r, idEstudiante, listaEjemplares);
            System.out.println("Reserva creada exitosamente.");
        } else {
            System.out.println("La reserva ha sido cancelada. No se guardará ninguna información.");
            // No se hace nada, simplemente se descartan los datos en memoria.
        }
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

