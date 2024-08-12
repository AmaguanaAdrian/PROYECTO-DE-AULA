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
import java.util.List;
import modelo.DetalleReserva;
import modelo.Ejemplar;
import modelo.Libro;

public class Perfiles {

    public static void perfilBibliotecario(String[] args) throws IOException {

        Scanner es = new Scanner(System.in);
        int i = 1;

        do {
            menus.menuBiblio();
            int op1 = es.nextInt();
            es.nextLine();
            switch (op1) {
                case 1 -> {
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
                            "5. TECNOLOGÍA SUPERIOR EN PROCESAMIENTO DE ALIMENTOS\n"
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
                }

                case 2 -> {
                    menus.menuGestionReservas();
                    int op3 = es.nextInt();
                    es.nextLine();
                    switch (op3) {
                        case 1 -> {
//                            ReservaControlador reservaControlador = new ReservaControlador();
//                            List<DetalleReserva> reservasPendientes = reservaControlador.obtenerReservasPendientes();
//
//                            if (!reservasPendientes.isEmpty()) {
//                                System.out.println("Reservas pendientes:");
//                                for (DetalleReserva reserva : reservasPendientes) {
//                                    System.out.println("Nombre y Apellidos: " + reserva.getAutor());
//                                    System.out.println("Fecha de entrega: " + reserva.getFechaReserva());
//                                    System.out.println("Título del libro: " + reserva.getTitulo());
//                                    System.out.println("Estado de la reserva: " + reserva.getEstadoReserva());
//                                    System.out.println("--------------------");
//                                }
//                            } else {
//                                System.out.println("No hay reservas pendientes.");
//                            }
//                        }
                        }
                        case 2 -> {
                            
//                            Scanner scanner = new Scanner(System.in);
//                            ReservaControlador resC = new ReservaControlador();
//
//                            System.out.print("Ingrese la cédula del usuario: ");
//                            String cedula = scanner.nextLine();
//
//                            List<Reserva> reservas = resC.buscarReservasPorCedula(cedula);
//
//                            if (reservas.isEmpty()) {
//                                System.out.println("No se encontraron reservas con la cédula proporcionada.");
//                                return;
//                            }
//
//                            System.out.println("Se encontraron " + reservas.size() + " reservas asociadas a la cédula " + cedula);
//                            System.out.println("Seleccione la reserva que desea confirmar o cancelar:");
//
//                            List<DetalleReserva> detReservas = new ArrayList<>(); // Inicializar la lista vacía
//                            for (Reserva reserva : reservas) {
//                                DetalleReserva detReserva = new DetalleReserva(); // Crear una instancia de DetalleReserva
////                                detReserva.setIdReserva()); // Asignar la reserva a DetalleReserva usando setReserva
////                                Ejemplar ejemplar = resC.buscarEjemplarPorReserva(reserva.getIdReserva()); // Buscar el ejemplar asociado a la reserva
////                                detReserva.setEjemplar(ejemplar); // Asignar el ejemplar a DetalleReserva
//                                detReservas.add(detReserva); // Agregar DetalleReserva a la lista
//                            }
//
//                            // Mostrar detalles de las reservas encontradas
//                            for (DetalleReserva detReserva : detReservas) {
////                                Reserva reserva = detReserva.getReserva(); // Obtener el objeto Reserva asociado
////                                Ejemplar ejemplar = detReserva.getEjemplar(); // Obtener el objeto Ejemplar asociado
////                                Libro libro = ejemplar.getLibro(); // Obtener el objeto Libro asociado con el Ejemplar
////                                System.out.println(reserva.getFechaRetiro() + " - " + libro.getTitulo() + " - " + libro.getAutor());
//                            }
//
//                            int seleccion = scanner.nextInt();
//                            scanner.nextLine(); // Consumir el salto de línea
//
//                            Reserva reservaSeleccionada = reservas.get(seleccion - 1);
//
//                            System.out.print("¿Desea confirmar la reserva? (S/N): ");
//                            String respuesta = scanner.nextLine();
//
//                            ReservaControlador resC1 = new ReservaControlador();
//
//                            if (respuesta.equalsIgnoreCase("S")) {
//                                resC1.cambiarEstadoReserva(reservaSeleccionada.getIdReserva(), "Entregado");
//                                resC1.actualizarEstadoEjemplares(reservaSeleccionada.getIdReserva(), "Prestado");
//                                System.out.println("Reserva confirmada con éxito.");
//                            } else if (respuesta.equalsIgnoreCase("N")) {
//                                resC1.cambiarEstadoReserva(reservaSeleccionada.getIdReserva(), "Cancelado");
//                                resC1.actualizarEstadoEjemplares(reservaSeleccionada.getIdReserva(), "Disponible");
//                                System.out.println("Reserva cancelada con éxito.");
//                            }
                        }

                        case 3 -> {
                            // ...
                        }
                        case 0 -> {
                            return;
                        }

                        default -> {
                            System.out.println("Ingrese una opción que esté en el menú");
                        }
                    }
                }

            }

        } while (true);
    }
//    

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
                    mainDetReserva.main(args);
                    return;
                }

                case 2 -> {

//                    //listar las reservas pendientes
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
