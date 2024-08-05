package vista;

import Controlador.BibliotecarioControlador;
import Controlador.ConexionBDD;
import Controlador.EstudianteControlador;
import controlador.UsuarioControlador;
import java.io.IOException;
import java.util.Scanner;
import modelo.Estudiante;
import modelo.Usuario;
import modelo.Bibliotecario;
/**
 *
 * @author david
 */
public class MainP {
    public static void main(String[] args) throws IOException {
        Scanner es = new Scanner(System.in);
        int b = 0;
        do {
            menus.menu1();
            int op = es.nextInt();
            es.nextLine(); // Consumir el salto de línea pendiente

            if (op == 0) {
                System.out.println("Saliendo del programa....");
                b = 0;
            } else if (op == 1) {
                // Llamar al método mainBibliotecario de la clase MainBibliotecario
                Funciones.login(args);
                b = 1;
            } else if (op == 2) {
                boolean datosValidos = false;

                while (!datosValidos) {
                    System.out.println("Ingrese los datos personales del estudiante:");

                    Usuario u = new Usuario();
                    System.out.println("Ingrese sus Nombres:");
                    u.setNombres(es.nextLine());

                    System.out.println("Ingrese sus Apellidos:");
                    u.setApellidos(es.nextLine());

                    System.out.println("Ingrese su número de cédula:");
                    u.setCedula(es.next());
                    es.nextLine(); // Consumir el salto de línea pendiente

                    System.out.println("Ingrese una Clave:");
                    u.setClave(es.next());
                    es.nextLine(); // Consumir el salto de línea pendiente

                    System.out.println("Ingrese una Dirección:");
                    u.setDireccion(es.nextLine());

                    System.out.println("Ingrese su Correo Electrónico Institucional:");
                    u.setCorreoInstitucional(es.nextLine());

                    System.out.println("Ingrese su número Telefónico:");
                    u.setTelefono(es.next());
                    es.nextLine(); // Consumir el salto de línea pendiente
                    u.setRol(1);

                    UsuarioControlador usuC = new UsuarioControlador();
                    usuC.crearUsuario(u);

                    int idUsuario = usuC.buscarIdUsuario(u.getCedula());

                    Estudiante est = new Estudiante();

                    // Mostrar el menú para seleccionar la carrera
                    String[] carreras = {
                        "1. TECNOLOGÍA SUPERIOR EN DESARROLLO DE SOFTWARE",
                        "2. TECNOLOGÍA SUPERIOR EN REDES Y TELECOMUNICACIONES",
                        "3. TECNOLOGÍA SUPERIOR EN ELECTRONICA",
                        "4. TECNOLOGÍA SUPERIOR EN AUTOMATIZACIÓN E INSTRUMENTACIÓN",
                        "5. TECNOLOGÍA SUPERIOR EN PROCESAMIENTO DE ALIMENTOS"
                    };

                    boolean carreraSeleccionada = false;
                    while (!carreraSeleccionada) {
                        System.out.println("Seleccione la carrera que está cursando:");
                        for (String carrera : carreras) {
                            System.out.println(carrera);
                        }

                        int carreraOpcion = es.nextInt();
                        es.nextLine(); // Consumir el salto de línea pendiente

                        if (carreraOpcion >= 1 && carreraOpcion <= carreras.length) {
                            est.setCarreraCursando(carreras[carreraOpcion - 1].split("\\. ")[1]);
                            carreraSeleccionada = true;
                        } else {
                            System.out.println("Opción no válida, ¿desea intentar de nuevo? (S/N)");
                            String respuesta = es.nextLine();
                            if (respuesta.equalsIgnoreCase("N")) {
                                carreraSeleccionada = true; // Salir del bucle de carrera
                            }
                        }
                    }

                    System.out.println("Carrera seleccionada: " + est.getCarreraCursando());

                    System.out.println("Ingrese número de matrícula:");
                    est.setNumMatricula(es.next());
                    es.nextLine(); // Consumir el salto de línea pendiente

                    System.out.println("Ingrese el nivel que está cursando actualmente:");
                    est.setNivelCursando(es.nextInt());
                    es.nextLine(); // Consumir el salto de línea pendiente

                    est.setIdUsuario(idUsuario);

                    EstudianteControlador estC = new EstudianteControlador();
                    estC.crearEstudiante(est);

                    datosValidos = true; // Salir del bucle de datos válidos
                }

                b = 2;
            } else if (op == 3) {
                System.out.println("Ingrese los datos personales del bibliotecario:");

                Usuario u = new Usuario();
                System.out.println("Ingrese sus Nombres:");
                u.setNombres(es.nextLine());

                System.out.println("Ingrese sus Apellidos:");
                u.setApellidos(es.nextLine());

                System.out.println("Ingrese su número de cédula:");
                u.setCedula(es.next());
                es.nextLine(); // Consumir el salto de línea pendiente

                System.out.println("Ingrese una Clave:");
                u.setClave(es.next());
                es.nextLine(); // Consumir el salto de línea pendiente

                System.out.println("Ingrese una Dirección:");
                u.setDireccion(es.nextLine());

                System.out.println("Ingrese su Correo Electrónico Institucional:");
                u.setCorreoInstitucional(es.nextLine());

                System.out.println("Ingrese su número Telefónico:");
                u.setTelefono(es.next());
                es.nextLine(); // Consumir el salto de línea pendiente
                u.setRol(2);

                UsuarioControlador usuC = new UsuarioControlador();
                usuC.crearUsuario(u);

                int idUsuario = usuC.buscarIdUsuario(u.getCedula());

                Bibliotecario biblio = new Bibliotecario();
                biblio.setIdUsuario(idUsuario);

                System.out.println("Ingrese el título registrado:");
                biblio.setTituloRegistrado(es.next());
                es.nextLine(); // Consumir el salto de línea pendiente

                BibliotecarioControlador biblioC = new BibliotecarioControlador();
                biblioC.crearBibliotecario(biblio);
                
                b = 3;
            } else {
                System.out.println("Error: solo se permiten números 1, 2, 3 o 0. Intente de nuevo.");
                b = -1; // BANDERA
            }

        } while (b != 0);
    }
}

//public class MainP {
//    public static void main(String[] args) {
//        Scanner es = new Scanner(System.in);
//        int b = 0;
//        do {
//            menus.menu1();
//            int op = es.nextInt();
//            es.nextLine(); // Consumir el salto de línea pendiente
//
//            if (op == 0) {
//                System.out.println("Saliendo del programa....");
//                b = 0;
//            } else if (op == 1) {
//                // Llamar
//                Funciones.login(args);
//                b = 1;
//            } else if (op == 2) {
//                boolean datosValidos = false;
//
//                while (!datosValidos) {
//                    System.out.println("Ingrese los datos personales del estudiante:");
//
//                    Usuario u = new Usuario();
//                    System.out.println("Ingrese sus Nombres:");
//                    u.setNombres(es.nextLine());
//
//                    System.out.println("Ingrese sus Apellidos:");
//                    u.setApellidos(es.nextLine());
//
//                    System.out.println("Ingrese su número de cédula:");
//                    u.setCedula(es.next());
//                    es.nextLine(); // Consumir el salto de línea pendiente
//
//                    System.out.println("Ingrese una Clave:");
//                    u.setClave(es.next());
//                    es.nextLine(); // Consumir el salto de línea pendiente
//
//                    System.out.println("Ingrese una Dirección:");
//                    u.setDireccion(es.nextLine());
//
//                    System.out.println("Ingrese su Correo Electrónico Institucional:");
//                    u.setCorreoInstitucional(es.nextLine());
//
//                    System.out.println("Ingrese su número Telefónico:");
//                    u.setTelefono(es.next());
//                    es.nextLine(); // Consumir el salto de línea pendiente
//                    u.setRol(1);
//
//                    UsuarioControlador usuC = new UsuarioControlador();
//                    usuC.crearUsuario(u);
//
//                    int idUsuario = usuC.buscarIdUsuario(u.getCedula());
//
//                    Estudiante est = new Estudiante();
//
//                    // Mostrar el menú para seleccionar la carrera
//                    String[] carreras = {
//                        "1. TECNOLOGÍA SUPERIOR EN DESARROLLO DE SOFTWARE",
//                        "2. TECNOLOGÍA SUPERIOR EN REDES Y TELECOMUNICACIONES",
//                        "3. TECNOLOGÍA SUPERIOR EN ELECTRONICA",
//                        "4. TECNOLOGÍA SUPERIOR EN AUTOMATIZACIÓN E INSTRUMENTACIÓN",
//                        "5. TECNOLOGÍA SUPERIOR EN PROCESAMIENTO DE ALIMENTOS"
//                    };
//
//                    boolean carreraSeleccionada = false;
//                    while (!carreraSeleccionada) {
//                        System.out.println("Seleccione la carrera que está cursando:");
//                        for (String carrera : carreras) {
//                            System.out.println(carrera);
//                        }
//
//                        int carreraOpcion = es.nextInt();
//                        es.nextLine(); // Consumir el salto de línea pendiente
//
//                        if (carreraOpcion >= 1 && carreraOpcion <= carreras.length) {
//                            est.setCarreraCursando(carreras[carreraOpcion - 1].split("\\. ")[1]);
//                            carreraSeleccionada = true;
//                        } else {
//                            System.out.println("Opción no válida, ¿desea intentar de nuevo? (S/N)");
//                            String respuesta = es.nextLine();
//                            if (respuesta.equalsIgnoreCase("N")) {
//                                carreraSeleccionada = true; // Salir del bucle de carrera
//                            }
//                        }
//                    }
//
//                    System.out.println("Carrera seleccionada: " + est.getCarreraCursando());
//
//                    System.out.println("Ingrese número de matrícula:");
//                    est.setNumMatricula(es.next());
//                    es.nextLine(); // Consumir el salto de línea pendiente
//
//                    System.out.println("Ingrese el nivel que está cursando actualmente:");
//                    est.setNivelCursando(es.nextInt());
//                    es.nextLine(); // Consumir el salto de línea pendiente
//
//                    est.setIdUsuario(idUsuario);
//
//                    EstudianteControlador estC = new EstudianteControlador();
//                    estC.crearEstudiante(est);
//
//                    datosValidos = true; // Salir del bucle de datos válidos
//                }
//
//                b = 2;
//            } else if (op == 3) {
//                boolean datosValidos = false;
//
//                while (!datosValidos) {
//                    System.out.println("Ingrese los datos personales del bibliotecario:");
//
//                    Usuario u = new Usuario();
//                    System.out.println("Ingrese sus Nombres:");
//                    u.setNombres(es.nextLine());
//
//                    System.out.println("Ingrese sus Apellidos:");
//                    u.setApellidos(es.nextLine());
//
//                    System.out.println("Ingrese su número de cédula:");
//                    u.setCedula(es.next());
//                    es.nextLine(); // Consumir el salto de línea pendiente
//
//                    System.out.println("Ingrese una Clave:");
//                    u.setClave(es.next());
//                    es.nextLine(); // Consumir el salto de línea pendiente
//
//                    System.out.println("Ingrese una Dirección:");
//                    u.setDireccion(es.nextLine());
//
//                    System.out.println("Ingrese su Correo Electrónico Institucional:");
//                    u.setCorreoInstitucional(es.nextLine());
//
//                    System.out.println("Ingrese su número Telefónico:");
//                    u.setTelefono(es.next());
//                    es.nextLine(); // Consumir el salto de línea pendiente
//                    u.setRol(2); // Asignar el rol de Bibliotecario
//
//                    UsuarioControlador usuC = new UsuarioControlador();
//                    usuC.crearUsuario(u);
//
//                    int idUsuario = usuC.buscarIdUsuario(u.getCedula());
//
//                    Bibliotecario biblio = new Bibliotecario();
//                    biblio.setIdUsuario(idUsuario);
//
//                    System.out.println("Ingrese el título registrado:");
//                    biblio.setTituloRegistrado(es.nextLine());
//
//                    BibliotecarioControlador biblioC = new BibliotecarioControlador();
//                    biblioC.crearBibliotecario(biblio);
//
//                    datosValidos = true; // Salir del bucle de datos válidos
//                }
//
//                b = 3;
//            } else {
//                System.out.println("Error: solo se permiten números 1, 2, 3 o 0. Intente de nuevo.");
//                b = -1; // BANDERA
//            }
//
//        } while (b != 0);
//    }
//}
