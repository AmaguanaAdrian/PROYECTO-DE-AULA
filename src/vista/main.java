package vista;
import Controlador.BibliotecarioControlador;
import Controlador.EstudianteControlador;
import Controlador.BibliotecarioControlador;
import Controlador.ConexionBDD;
import Controlador.ReservaControlador;
import controlador.UsuarioControlador;
import java.util.Scanner;
import modelo.Bibliotecario;
import modelo.Estudiante;
import modelo.Reserva;
import modelo.Usuario;
public class main {
    public static void main(String[] args) {
        //        CONEXION A BASE DE DATOS
        ConexionBDD cb = new ConexionBDD();
        cb.conectar();

        Scanner es = new Scanner(System.in);
        int i = 1;

        do {
            menus.menu1();

            int op1 = es.nextInt();
            es.nextLine(); // salto de línea pendiente

            if (op1 == 1) {
                System.out.println("-----DATOS DE PERSONALES-----");
                Bibliotecario b = new Bibliotecario();

                System.out.println("Ingrese los nombres:");
                b.setNombres(es.nextLine());

                System.out.println("Ingrese los apellidos:");
                b.setApellidos(es.nextLine());

                System.out.println("Ingrese la clave:");
                b.setClave(es.nextLine());

                System.out.println("Ingrese la cédula:");
                b.setCedula(es.nextLine());

                System.out.println("Ingrese la dirección:");
                b.setDireccion(es.nextLine());

                System.out.println("Ingrese el teléfono:");
                while (!es.hasNext()) {
                    System.out.println("Por favor, ingrese un número válido para el teléfono:");
                    es.next(); // Detecta entrada incorrecta
                }
                b.setTelefono(es.next());
                es.nextLine(); // salto de línea pendiente

                System.out.println("Ingrese el correo institucional:");
                b.setCorreoInstitucional(es.nextLine());

                System.out.println("-----DATOS DEL BIBLIOTECARIO-----");
                System.out.println("Ingrese el titulo registrado en Senecyt:");
                b.setTituloRegistrado(es.nextLine());

                BibliotecarioControlador bc = new BibliotecarioControlador();
                bc.crearPersona(b);

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
                Usuario p = new Usuario();
                System.out.println("Ingrese sus Nombres:");
                p.setNombres(es.nextLine());

                System.out.println("Ingrese sus Apellidos:");
                p.setApellidos(es.nextLine());

                System.out.println("Ingrese su número de cédula:");
                p.setCedula(es.next());

                System.out.println("Ingrese una Clave:");
                p.setClave(es.next());

                System.out.println("Ingrese una Dirección:");
                p.setDireccion(es.next());

                System.out.println("Ingrese su Correo Electrónico Institucional:");
                p.setCorreoInstitucional(es.next());

                System.out.println("Ingrese su número Telefónico:");
                p.setTelefono(es.next());
                es.nextLine(); // Consumir el salto de línea pendiente
                System.out.println("Ingrese el rol:");
                p.setRol(es.nextInt());

                UsuarioControlador usuC = new UsuarioControlador();
                System.out.println(p.imprimir());
                usuC.crearUsuario(p);

                
//                System.out.println("Ingrese los siguientes datos de estudiante\n");
//                // OBTENER ID DE LA SUPER CLASE
//                int idUsuario = usuC.buscarIdUsuario(p.getCedula());
//                System.out.println("-------------------" + idUsuario);
//                
//                Estudiante est = new Estudiante();
//                System.out.println("Ingrese la carrera que está cursando:");
//                est.setCarreraCursando(es.next());
//
//                System.out.println("Ingrese número de matrícula:");
//                est.setNumMatricula(es.next());
//                
//                EstudianteControlador estC = new EstudianteControlador();
//                
//                est.setIdUsuario(idUsuario);
//                estC.crearUsuario(est);
                
            } else if (op1 == 4) {
                // Llama al main de la clase mainLibros
                mainLibros.main(null);
            } else if (op1 == 0) {
                i = 0;
            }
        } while (i == 1);
        es.close();
    }
}
