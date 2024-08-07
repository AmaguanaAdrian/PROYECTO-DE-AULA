package vista;

import Controlador.BibliotecarioControlador;
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
//    public static void mainPrincipal(String[] args) throws IOException {
//        //        CONEXION A BASE DE DATOS
////        ConexionBDD cb = new ConexionBDD();
////        cb.conectar();
//
//        Funciones.cls();
//        // Imprime un mensaje de bienvenida 
//        menus.introduccion();
//
//        // Espera a que el usuario presione Enter
//        Scanner es = new Scanner(System.in);
//        es.nextLine();
//        Funciones.cls();
//        MainP.mainPrincipal(args);
//    }

    
    
    
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
                    // Llamar al método mainBibliotecario de la clase MainBibliotecario
                    Funciones.login(args);
                    b = 1;
                }
                case 2 -> {
                    boolean datosValidos = false;
                    while (!datosValidos) {
                        System.out.println("Ingrese los datos personales del estudiante: ");
                        
                        Usuario u = new Usuario();
                        System.out.print("Ingrese sus Nombres: ");
                        u.setNombres(es.nextLine());
                        
                        System.out.print("Ingrese sus Apellidos: ");
                        u.setApellidos(es.nextLine());
                        
                        System.out.print("Ingrese su número de cédula: ");
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
                            "5. TECNOLOGÍA SUPERIOR EN PROCESAMIENTO DE ALIMENTOS\n"
                        };
                        
                        boolean carreraSeleccionada = false;
                        while (!carreraSeleccionada) {
                            System.out.print("Seleccione la carrera que está cursando: ");
                            for (String carrera : carreras) {
                                System.out.print(carrera);
                            }
                            
                            int carreraOpcion = es.nextInt();
                            es.nextLine(); // Consumir el salto de línea pendiente
                            
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
                    }   b = 2;
                }
                case 3 -> {
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
                }
                default -> {
                    System.out.println("Error: solo se permiten números 1, 2, 3 o 0. Intente de nuevo.");
                    b = -1; // BANDERA
                }
            }

        } while (b != 0);
    }
}
