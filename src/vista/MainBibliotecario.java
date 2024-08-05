package vista;

import Controlador.EstudianteControlador;
import Controlador.BibliotecarioControlador;
import Controlador.ReservaControlador;
import controlador.AutorControlador;
import controlador.UsuarioControlador;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Autor;
import modelo.Bibliotecario;
import modelo.Estudiante;
import modelo.Reserva;
import modelo.Usuario;
import java.io.IOException;

public class MainBibliotecario {

    public static void perfilBliotecario(String[] args) {

        Scanner es = new Scanner(System.in);
        int i = 1;

        do {
            menus.menuBiblio();

            int op1 = es.nextInt();
            es.nextLine(); // salto de línea pendiente

            if (op1 == 1) {
                System.out.println("-----DATOS DE PERSONALES-----");
                Usuario u = new Usuario();

                System.out.println("Ingrese los nombres:");
                u.setNombres(es.nextLine());

                System.out.println("Ingrese los apellidos:");
                u.setApellidos(es.nextLine());

                System.out.println("Ingrese la clave:");
                u.setClave(es.nextLine());

                System.out.println("Ingrese la cédula:");
                u.setCedula(es.nextLine());

                System.out.println("Ingrese la dirección:");
                u.setDireccion(es.nextLine());

                System.out.println("Ingrese el teléfono:");
                while (!es.hasNext()) {
                    System.out.println("Por favor, ingrese un número válido para el teléfono:");
                    es.next(); // Detecta entrada incorrecta
                }
                u.setTelefono(es.next());
                es.nextLine(); // salto de línea pendiente

                System.out.println("Ingrese el correo institucional:");
                u.setCorreoInstitucional(es.nextLine());
                u.setRol(2);

                UsuarioControlador usuC = new UsuarioControlador();
                usuC.crearUsuario(u);

                // OBTENER ID DE LA SUPER CLASE
                int idUsuario = usuC.buscarIdUsuario(u.getCedula());
                System.out.println("-------------------" + idUsuario);

                System.out.println("-----DATOS DEL BIBLIOTECARIO-----");
                Bibliotecario b = new Bibliotecario();

                System.out.println("Ingrese el titulo registrado en Senecyt:");
                b.setTituloRegistrado(es.nextLine());

                BibliotecarioControlador bc = new BibliotecarioControlador();
                b.setIdUsuario(idUsuario);
                bc.crearBibliotecario(b);

            } else if (op1 == 2) {
                Reserva r = new Reserva();
                System.out.println("Ingrese la fecha de retiro (yyyy-MM-dd):");
                r.setFechaRetiro(es.nextLine());

                System.out.println("Ingrese la fecha de reserva (yyyy-MM-dd):");
                r.setFechaReserva(es.nextLine());

                System.out.println("Ingrese la fecha de devolución (yyyy-MM-dd):");
                r.setFechaDevolucion(es.nextLine());

                ReservaControlador rc = new ReservaControlador();
                rc.crearReserva(r);

            } else if (op1 == 3) {
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

            } else if (op1 == 4) {
                // Llama al MainBibliotecario de la clase mainLibros
                mainLibros.main(null);
            } else if (op1 == 5) {
                // Llama al MainBibliotecario de la clase mainGenero
                mainGenero.main(null);
            } else if (op1 == 6) {
                do {
                    AutorControlador AutorControlador = new AutorControlador();
                    menus.menuAutores();

                    op1 = es.nextInt();
                    es.nextLine();
                    if (op1 == 1) {
                        // Insertar Autor
                        System.out.println("Ingrese el nombre del autor");
                        String nombre = es.nextLine();

                        System.out.println("Ingrese el apellido del autor:");
                        String apellido = es.nextLine();

                        System.out.println("Ingrese la fecha de naciemiento (YYYY-MM-DD :");
                        String fechaNace = es.nextLine();

                        Autor A = new Autor(fechaNace, nombre, apellido);
                        AutorControlador.crearAutor(A);

                    } else if (op1 == 2) {
                        // Mostrar lista de autores
                        ArrayList<Autor> listarAutores = AutorControlador.listarAutores();
                        for (Autor A : listarAutores) {
                            System.out.println(A.imprimir());
                        }
                    } else if (op1 == 3) {
                        // Actualizar información de un Autor
                        System.out.println("Ingrese el nombre del autor que desea actualizar:");
                        String nombre = es.nextLine();

                        String AutorExistente = AutorControlador.buscarAutor(nombre);
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
                            AutorControlador.actualizarAutor(AutActualizado, AutorExistente);
                        }
                    } else if (op1 == 4) {
                        // Eliminar Autor
                        System.out.println("Ingrese el nombre del autor que desea eliminar:");
                        String nombre = es.nextLine();
                        AutorControlador.eliminarAutor(nombre);

                    } else if (op1 == 0) {
                        System.out.println("Saliendo...");

                    } else {
                        System.out.println("Opción no válida, por favor elija una opción entre 0 y 4.");
                    }
                } while (op1 != 0);

            } else if (op1 == 7) {
                // Llama al MainBibliotecario de la clase mainGenero
                mainEjemplar.main(null);
            }
        } while (i == 1);
//        es.close();
    }
}
