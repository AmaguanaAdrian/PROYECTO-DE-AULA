package vista;

import Controlador.AutorControlador;
import Controlador.EstudianteControlador;
import Controlador.BibliotecarioControlador;
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

public class Main1 {

    public static void perfilBliotecario(String[] args) throws IOException {

        Scanner es = new Scanner(System.in);
        int i = 1;

        OUTER:
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
                    Reserva r = new Reserva();
                    System.out.println("Ingrese la fecha de retiro (yyyy-MM-dd):");
                    r.setFechaRetiro(es.nextLine());
                    System.out.println("Ingrese la fecha de reserva (yyyy-MM-dd):");
                    r.setFechaReserva(es.nextLine());
                    System.out.println("Ingrese la fecha de devolución (yyyy-MM-dd):");
                    r.setFechaDevolucion(es.nextLine());
                    ReservaControlador rc = new ReservaControlador();
                    rc.crearReserva(r);
                }
                case 3 -> {
                    System.out.println("Ingrese los datos personales del estudiante:");
                    Usuario u = new Usuario();
                    System.out.println("Ingrese sus Nombres:");
                    u.setNombres(es.nextLine());
                    System.out.println("Ingrese sus Apellidos:");
                    u.setApellidos(es.nextLine());
                    System.out.println("Ingrese su número de cédula:");
                    u.setCedula(es.next());
                    System.out.println("Ingrese una Clave:");
                    u.setClave(es.next());
                    System.out.println("Ingrese una Dirección:");
                    u.setDireccion(es.next());
                    System.out.println("Ingrese su Correo Electrónico Institucional:");
                    u.setCorreoInstitucional(es.next());
                    System.out.println("Ingrese su número Telefónico:");
                    u.setTelefono(es.next());
                    es.nextLine(); // Consumir el salto de línea pendiente
                    u.setRol(1);
                    UsuarioControlador usuC = new UsuarioControlador();
                    //                System.out.println(p.imprimir());
                    usuC.crearUsuario(u);
                    // OBTENER ID DE LA SUPER CLASE
                    int idUsuario = usuC.buscarIdUsuario(u.getCedula());
                    System.out.println("-------------------" + idUsuario);
                    System.out.println("Ingrese los siguientes datos de estudiante");
                    Estudiante est = new Estudiante();
                    System.out.println("Ingrese la carrera que está cursando:");
                    est.setCarreraCursando(es.next());
                    System.out.println("Ingrese número de matrícula:");
                    est.setNumMatricula(es.next());
                    System.out.println("Ingrese el nivel que esta cursando actualmente:");
                    est.setNivelCursando(es.nextInt());
                    est.setIdUsuario(idUsuario);
                    EstudianteControlador estC = new EstudianteControlador();
                    estC.crearEstudiante(est);
                    break OUTER;
                }
                case 4 -> // Llama al Main1 de la clase mainLibros
                    mainLibros.main(null);
                case 5 -> // Llama al Main1 de la clase mainGenero
                    mainGenero.main(null);
//<<<<<<< HEAD:src/vista/perfiles.java
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
//                                String AutorExistente = AutorControlador.buscarAutor(nombre);
//                                if (AutorExistente == null) {
                                    System.out.println("Autor no encontrado.");
//                                } else {
//                                    System.out.println("Ingrese el nombre del autor a actualizar:");
//                                    String nuevoNombre = es.nextLine();
//
//                                    System.out.println("Ingrese el apellido del autor a actualizar:");
//                                    String nuevoApellido = es.nextLine();
//
//                                    System.out.println("Ingrese la nueva fecha de nacimiento (YYYY-MM-DD):");
//                                    String nuevaFechaNace = es.nextLine();
//
//                                    Autor AutActualizado = new Autor(nuevaFechaNace, nuevoNombre, nuevoApellido);
////                                    AutorControlador.actualizarAutor(AutActualizado, AutorExistente);
//                                }
//                            }
//                            case 4 -> {
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
//<<<<<<< HEAD:src/vista/perfiles.java
                case 7 -> { // Llama al perfiles de la clase mainGenero
//=======
//                case 6 -> {
//                    do {
//                        AutorControlador AutorControlador = new AutorControlador();
//                        menus.menuAutores();
//
//                        op1 = es.nextInt();
//                        es.nextLine();
//                        switch (op1) {
//                            case 1 -> {
//                                // Insertar Autor
//                                System.out.println("Ingrese el nombre del autor");
//                                String nombre = es.nextLine();
//                                System.out.println("Ingrese el apellido del autor:");
//                                String apellido = es.nextLine();
//                                System.out.println("Ingrese la fecha de naciemiento (YYYY-MM-DD :");
//                                String fechaNace = es.nextLine();
//                                Autor A = new Autor(fechaNace, nombre, apellido);
//                                AutorControlador.crearAutor(A);
//                            }
//                            case 2 -> {
//                                // Mostrar lista de autores
//                                ArrayList<Autor> listarAutores = AutorControlador.listarAutores();
//                                for (Autor A : listarAutores) {
//                                    System.out.println(A.imprimir());
//                                }
//                            }
//                            case 3 -> {
//                                // Actualizar información de un Autor
//                                System.out.println("Ingrese el nombre del autor que desea actualizar:");
//                                String nombre = es.nextLine();
//                                String AutorExistente = AutorControlador.buscarDatosAutor(nombre);
//                                if (AutorExistente == null) {
//                                    System.out.println("Autor no encontrado.");
//                                } else {
//                                    System.out.println("Ingrese el nombre del autor a actualizar:");
//                                    String nuevoNombre = es.nextLine();
//
//                                    System.out.println("Ingrese el apellido del autor a actualizar:");
//                                    String nuevoApellido = es.nextLine();
//
//                                    System.out.println("Ingrese la nueva fecha de nacimiento (YYYY-MM-DD):");
//                                    String nuevaFechaNace = es.nextLine();
//
//                                    Autor AutActualizado = new Autor(nuevaFechaNace, nuevoNombre, nuevoApellido);
//                                    AutorControlador.actualizarAutor(AutActualizado, AutorExistente);
//                                }
//                            }
//                            case 4 -> {
//                                // Eliminar Autor
//                                System.out.println("Ingrese el nombre del autor que desea eliminar:");
//                                String nombre = es.nextLine();
//                                AutorControlador.eliminarAutor(nombre);
//                            }
//                            case 0 -> {
//                                System.out.println("Saliendo...");
//                                return;
//                            }
//                            default ->
//                                System.out.println("Opción no válida, por favor elija una opción entre 0 y 4.");
//                        }
//                    } while (op1 != 0);
//
////                }
//                case 7 -> { // Llama al Main1 de la clase mainGenero
////>>>>>>> 6e6b4f98520a9e933d1205c30ce3f0126d0449cd:src/vista/Main1.java
//=======
//                case 7 -> { // Llama al Main1 de la clase mainGenero
//>>>>>>> parent of 744508a (Corrección de faltas):src/vista/Main1.java
                    mainEjemplar.main(null);
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
//        int i = 1;
        OUTER:
        do {
            menus.menuEstudiante();
            int op = es.nextInt();
            switch (op) {
                case 1 -> {
                    //AQUI VA LO DE LA RESERVA
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
                            Main1.perfilEstudiante(args);
                            break OUTER;
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
