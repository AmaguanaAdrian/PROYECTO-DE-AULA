package vista;

import Controlador.ConexionBDD;
import Controlador.EstudianteControlador;
import com.mysql.jdbc.Connection;
import controlador.LoginControlador;
import controlador.UsuarioControlador;
import java.io.IOException;
import java.util.Scanner;
import modelo.Estudiante;
import modelo.Usuario;

/**
 *
 * @author david
 */
public class MainP {

    public static void main(String[] args) throws IOException {
        Scanner es = new Scanner(System.in);
        int b = 0;
        Funciones.cls();
        // Imprime un mensaje de bienvenida 
        menus.introduccion();

        // Espera a que el usuario presione Enter
        es.nextLine();
        Funciones.cls();
//        MainP.main(args);

        do {
            menus.menu1();
            int op = es.nextInt();
            es.nextLine(); // Consumir el salto de línea pendiente
            switch (op) {
                case 0 -> {
                    System.out.println("Saliendo del programa....");
                    b = 0;
                }
                case 1 -> {
                    do {
                        // CONEXION 
                        ConexionBDD conexion = new ConexionBDD();
                        Connection connection = (Connection) conexion.conectar();

//                        Scanner es = new Scanner(System.in);
                        boolean loginCorrecto = false;

                        while (!loginCorrecto) {
                            System.out.println("------------------Inicio de sesión------------------");
                            System.out.print("    Ingrese su usuario: ");
                            String usuario = es.nextLine();
                            System.out.print("    Ingrese su contraseña: ");
                            String clave = es.nextLine();

                            int usu_rol = LoginControlador.login(usuario, clave, connection);
                            if (usu_rol > 0) {
                                System.out.println("----Bienvenido!----");
                                loginCorrecto = true;
                                if (usu_rol == 1) {
                                    // Acciones para usuarios con rol 1
                                    System.out.println("----Acceso como Estudiante----");
                                    Perfiles.perfilEstudiante(args);
                                    b = 1;

                                } else if (usu_rol == 2) {
                                    // Acciones para usuarios con rol 2
                                    System.out.println("----Acceso como Bibliotecario----");
                                    Perfiles.perfilBibliotecario(args);
                                    b = 1;

                                } else if (usu_rol == 3) {
                                    // Acciones para usuarios con rol 3
                                    System.out.println("----Acceso como Admin----");
                                    Perfiles.perfilAdmin(args);
                                    b = 1;
                                }
                            } else {
                                System.out.println("Usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.");
                                System.out.print("¿Desea intentar otra vez? (Si/No): ");
                                String respuesta = es.nextLine();
                                if (respuesta.equalsIgnoreCase("si")) {
                                    // No hace falta hacer nada, el bucle while seguirá ejecutándose
                                } else if (respuesta.equalsIgnoreCase("no")) {
                                    b = 1;
                                    break;// Cambia el valor de b para salir del bucle do-while
                                } else {
                                    System.out.println("Respuesta inválida. Por favor, ingrese Si o No.");
                                }
                            }
                        }

                    } while (b == 0);
                    b = 1;
                }
                case 2 -> {
                    boolean datosValidos = false;
                    while (!datosValidos) {
                        System.out.println("-----INGRESE LOS DATOS PARA EL REGISTRO-----");

                        Usuario u = new Usuario();
                        System.out.print("Ingrese sus Nombres: ");
                        u.setNombres(es.nextLine());

                        System.out.print("Ingrese sus Apellidos: ");
                        u.setApellidos(es.nextLine());

                        System.out.print("Ingrese su número de cédula\n"
                                + "(recuerde que este sera su usuario): ");
                        u.setCedula(es.next());
                        es.nextLine(); // Consumir el salto de línea pendiente

                        System.out.print("Ingrese una Clave: ");
                        u.setClave(es.next());
                        es.nextLine(); // Consumir el salto de línea pendiente

                        System.out.print("Ingrese una Dirección: ");
                        u.setDireccion(es.nextLine());

                        System.out.print("Ingrese su Correo Electrónico Institucional: ");
                        u.setCorreoInstitucional(es.nextLine());

                        System.out.print("Ingrese su número Telefónico: ");
                        u.setTelefono(es.next());
                        es.nextLine(); // Consumir el salto de línea pendiente
                        u.setRol(1);

                        UsuarioControlador usuC = new UsuarioControlador();
                        usuC.crearUsuario(u);

                        int idUsuario = usuC.buscarIdUsuario(u.getCedula());

                        Estudiante est = new Estudiante();

                        // Mostrar el menú para seleccionar la carrera
                        String[] carreras = {
                            "1. TECNOLOGÍA SUPERIOR EN DESARROLLO DE SOFTWARE\n",
                            "2. TECNOLOGÍA SUPERIOR EN REDES Y TELECOMUNICACIONES\n",
                            "3. TECNOLOGÍA SUPERIOR EN ELECTRONICA\n",
                            "4. TECNOLOGÍA SUPERIOR EN AUTOMATIZACIÓN E INSTRUMENTACIÓN\n",
                            "5. TECNOLOGÍA SUPERIOR EN PROCESAMIENTO DE ALIMENTOS\n",
                            "Seleccione utilizando los números del índice"
                        };
                        boolean carreraSeleccionada = false;
                        while (!carreraSeleccionada) {
                            System.out.print("Seleccione la carrera que está cursando: ");
                            for (String carrera : carreras) {
                                System.out.print(carrera);
                            }
                            int carreraOpcion = es.nextInt();
                            es.nextLine();
                            if (carreraOpcion >= 1 && carreraOpcion <= carreras.length) {
                                est.setCarreraCursando(carreras[carreraOpcion - 1].split("\\. ")[1]);
                                carreraSeleccionada = true;
                            } else {
                                System.out.print("Opción no válida, ¿desea intentar de nuevo? (Si/No): ");
                                String respuesta = es.nextLine();
                                if (respuesta.equalsIgnoreCase("No")) {
                                    carreraSeleccionada = true; // Salir del bucle de carrera
                                }
                            }
                        }
                        System.out.println("Carrera seleccionada: " + est.getCarreraCursando());
                        System.out.print("Ingrese número de matrícula: ");
                        est.setNumMatricula(es.next());
                        es.nextLine(); // Consumir el salto de línea pendiente
                        System.out.print("Ingrese el nivel que está cursando actualmente: ");
                        est.setNivelCursando(es.nextInt());
                        es.nextLine(); // Consumir el salto de línea pendiente
                        est.setIdUsuario(idUsuario);
                        EstudianteControlador estC = new EstudianteControlador();
                        estC.crearEstudiante(est);
                        datosValidos = true; // Salir del bucle de datos válidos
                    }
                    b = 2;
                }
                default -> {
                    System.out.println("Error: solo se permiten números 1, 2 o 0. Intente de nuevo.");
                    b = -1; // BANDERA
                }
            }

        } while (b != 0);
    }
}
