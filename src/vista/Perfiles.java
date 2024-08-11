package vista;

import Controlador.AutorControlador;
import Controlador.EstudianteControlador;
import Controlador.BibliotecarioControlador;
import Controlador.LibroControlador;
import Controlador.ReservaControlador;
import controlador.UsuarioControlador;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Autor;
import modelo.Bibliotecario;
import modelo.Estudiante;
import modelo.Reserva;
import modelo.Usuario;
import java.io.IOException;
import modelo.Ejemplar;
import modelo.Libro;

public class Perfiles {

    public static void perfilBliotecario(String[] args) throws IOException {

        Scanner es = new Scanner(System.in);
        int i = 1;

        do {
            menus.menuBiblio();
            int op1 = es.nextInt();
            es.nextLine();
            switch (op1) {
                case 1 -> {
                    System.out.println("-----INGRESE LOS DATOS PARA EL REGISTRO-----");
                    Usuario u = new Usuario();
                    System.out.print("Ingrese los dos nombres: ");
                    u.setNombres(es.nextLine());
                    System.out.print("Ingrese los dos apellidos: ");
                    u.setApellidos(es.nextLine());
                    System.out.print("Ingrese la clave: ");
                    u.setClave(es.nextLine());
                    System.out.print("Ingrese la cédula: ");
                    u.setCedula(es.nextLine());
                    System.out.print("Ingrese la dirección: ");
                    u.setDireccion(es.nextLine());
                    System.out.print("Ingrese el teléfono: ");
                    while (!es.hasNext()) {
                        System.out.print("!Error!...Por favor, ingrese un número de teléfono válido: ");
                        es.next(); // Detecta entrada incorrecta
                    }
                    u.setTelefono(es.next());
                    es.nextLine(); // salto de línea pendiente
                    System.out.print("Ingrese el correo institucional: ");
                    u.setCorreoInstitucional(es.nextLine());
                    u.setRol(2);
                    UsuarioControlador usuC = new UsuarioControlador();
                    usuC.crearUsuario(u);
                    // OBTENER ID DE LA SUPER CLASE
                    int idUsuario = usuC.buscarIdUsuario(u.getCedula());
//                System.out.println("-------------------" + idUsuario);
//                System.out.println("-----DATOS DEL BIBLIOTECARIO-----");
                    Bibliotecario b = new Bibliotecario();
                    System.out.print("Ingrese el titulo registrado en Senecyt: ");
                    b.setTituloRegistrado(es.nextLine());
                    BibliotecarioControlador bc = new BibliotecarioControlador();
                    b.setIdUsuario(idUsuario);
                    bc.crearBibliotecario(b);
                }
                case 2 -> {
                    //ver si se elimina esta opcion o se le cambia po buscar reservas que esten pendientes
                }
                case 3 -> {
                    System.out.println("Ingrese los datos personales del estudiante");
                    Usuario u = new Usuario();
                    System.out.print("Ingrese sus Nombres: ");
                    u.setNombres(es.nextLine());
                    System.out.print("Ingrese sus Apellidos: ");
                    u.setApellidos(es.nextLine());
                    System.out.print("Ingrese su número de cédula: ");
                    u.setCedula(es.next());
                    System.out.print("Ingrese una Clave: ");
                    u.setClave(es.next());
                    System.out.print("Ingrese una Dirección: ");
                    u.setDireccion(es.next());
                    System.out.print("Ingrese su Correo Electrónico Institucional: ");
                    u.setCorreoInstitucional(es.next());
                    System.out.print("Ingrese su número Telefónico: ");
                    u.setTelefono(es.next());
                    es.nextLine(); // Consumir el salto de línea pendiente
                    u.setRol(1);
                    UsuarioControlador usuC = new UsuarioControlador();
                    //                System.out.println(p.imprimir());
                    usuC.crearUsuario(u);
                    // OBTENER ID DE LA SUPER CLASE
                    int idUsuario = usuC.buscarIdUsuario(u.getCedula());
//                    System.out.println("-------------------" + idUsuario);
//                    System.out.println("Ingrese los siguientes datos de estudiante");
                    Estudiante est = new Estudiante();
                    System.out.print("Ingrese la carrera que está cursando: ");
                    est.setCarreraCursando(es.next());
                    System.out.print("Ingrese número de matrícula: ");
                    est.setNumMatricula(es.next());
                    System.out.print("Ingrese el nivel que esta cursando actualmente: ");
                    est.setNivelCursando(es.nextInt());
                    est.setIdUsuario(idUsuario);
                    EstudianteControlador estC = new EstudianteControlador();
                    estC.crearEstudiante(est);
                    break;
                }
                case 4 -> // Llama al Perfiles de la clase mainLibros
                    mainLibros.main(null);
                case 5 -> // Llama al Perfiles de la clase mainGenero
                    mainGenero.main(null);
                case 6 -> {
                    do {
                        AutorControlador AutorControlador = new AutorControlador();
                        menus.menuAutores();

                        op1 = es.nextInt();
                        es.nextLine();
                        switch (op1) {
                            case 1 -> {
                                // Insertar Autor
                                System.out.println("Ingrese el nombre del autor");
                                String nombre = es.nextLine();
                                System.out.println("Ingrese el apellido del autor:");
                                String apellido = es.nextLine();
                                System.out.println("Ingrese la fecha de naciemiento (YYYY-MM-DD :");
                                String fechaNace = es.nextLine();
                                Autor A = new Autor(fechaNace, nombre, apellido);
//                                AutorControlador.crearAutor(A);
                            }
                            case 2 -> {
                                // Mostrar lista de autores
                                ArrayList<Autor> listarAutores = AutorControlador.listarAutores();
                                for (Autor A : listarAutores) {
                                    System.out.println(A.imprimir());
                                }
                            }
                            case 3 -> {
                                // Actualizar información de un Autor
                                System.out.println("Ingrese el nombre del autor que desea actualizar:");
                                String nombre = es.nextLine();
                                Autor AutorExistente = AutorControlador.buscarDatosAutor(nombre);
                                if (AutorExistente == null) {
                                    System.out.println("Autor no encontrado.");
                                } else {
                                    System.out.println("Ingrese el nombre del autor a actualizar:");
                                    String nuevoNombre = es.nextLine();

                                    System.out.println("Ingrese el apellido del autor a actualizar:");
                                    String nuevoApellido = es.nextLine();

                                    System.out.println("Ingrese la nueva fecha de nacimiento (YYYY-MM-DD):");
                                    String nuevaFechaNace = es.nextLine();

                                    Autor AutActualizado = new Autor(nuevaFechaNace, nuevoNombre, nuevoApellido);
//                                    AutorControlador.actualizarAutor(AutActualizado, AutorExistente);
                                }
                            }
                            case 4 -> {
                                // Eliminar Autor
                                System.out.println("Ingrese el nombre del autor que desea eliminar:");
//                                String nombre = es.nextLine();
//                                AutorControlador.eliminarAutor(nombre);
                            }
                            case 0 -> {
                                System.out.println("Saliendo...");
                                return;
                            }
                            default ->
                                System.out.println("Opción no válida, por favor elija una opción entre 0 y 4.");
                        }
                    } while (op1 != 0);

                }
                case 7 -> { // Llama al perfiles de la clase mainGenero
//                
//                    mainEjemplar.main(null);
                }
                case 0 -> {
                    return;
                }

                default -> {
                }
            }
        } while (true);

    }

    public static void perfilAdmin(String[] args) throws IOException {

        Scanner es = new Scanner(System.in);

        do {
            menus.menuAdmin();
            int op = es.nextInt();
            es.nextLine(); // Consume el salto de línea

            switch (op) {
                case 1 -> {
                    System.out.println("-----INGRESE LOS DATOS PARA EL REGISTRO-----");
                    Usuario u = new Usuario();

                    System.out.print("Ingrese los dos nombres: ");
                    u.setNombres(es.nextLine());

                    System.out.print("Ingrese los dos apellidos: ");
                    u.setApellidos(es.nextLine());

                    System.out.print("Ingrese la clave: ");
                    u.setClave(es.nextLine());

                    System.out.print("Ingrese la cédula: ");
                    u.setCedula(es.nextLine());

                    System.out.print("Ingrese la dirección: ");
                    u.setDireccion(es.nextLine());

                    System.out.print("Ingrese el teléfono: ");
                    while (!es.hasNext()) {
                        System.out.print("!Error!...Por favor, ingrese un número de teléfono válido: ");
                        es.next(); // Detecta entrada incorrecta
                    }
                    u.setTelefono(es.next());
                    es.nextLine(); // salto de línea pendiente

                    System.out.print("Ingrese el correo institucional: ");
                    u.setCorreoInstitucional(es.nextLine());
                    u.setRol(2);

                    UsuarioControlador usuC = new UsuarioControlador();
                    usuC.crearUsuario(u);

                    // OBTENER ID DE LA SUPER CLASE
                    int idUsuario = usuC.buscarIdUsuario(u.getCedula());
//                System.out.println("-------------------" + idUsuario);

//                System.out.println("-----DATOS DEL BIBLIOTECARIO-----");
                    Bibliotecario bib = new Bibliotecario();

                    System.out.print("Ingrese el titulo registrado en Senecyt: ");
                    bib.setTituloRegistrado(es.nextLine());

                    BibliotecarioControlador bc = new BibliotecarioControlador();
                    bib.setIdUsuario(idUsuario);
                    bc.crearBibliotecario(bib);
                }
                case 0 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default ->
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (true);

    }

    public static void perfilEstudiante(String[] args) {

        Scanner es = new Scanner(System.in);
        do {
            menus.menuEstudiante();
            int op = es.nextInt();
            switch (op) {
                case 1 -> {

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
                            System.out.println("No se encontró el libro con título: " + titulo);
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

                case 2 -> {
                    menus.menuBusquedaLibros();
                    int op1 = es.nextInt();
                    switch (op1) {
                        case 1 -> {
                        }
                        case 2 -> {
                        }
                        case 3 -> {
                        }
                        case 0 -> {
                            Perfiles.perfilEstudiante(args);
                            break;
                        }
                        default -> {
                            System.out.println("Ingrese una opción valida");
                        }
                    }
                }
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Ingrese una opción valida");
                }
            }

        } while (true);

    }
}
