package vista;

//import controlador.ConexionBDD;
import Controlador.EstudianteControlador;
import controlador.PersonaControlador;
import java.util.Scanner;
import modelo.Estudiante;
import modelo.Usuario;

/**
 *
 * @author david
 */
public class main {

    public static void main(String[] args) {
        Scanner es = new Scanner(System.in);
        int i = 1;
        do {
            System.out.println("--------BIENVENIDO AL SISTEMA DE RESERVA DE LIBROS---------");
            System.out.println("--Si no te gusta leer, no has encotrado el libro correcto--");
            System.out.println("Elija la opción que Usted requiera ejecutar:\n"
                    + "1.Crear Cuenta\n"
                    + "2.Iniciar sesión\n"
                    + "0.Salir\n");
            int op = es.nextInt();
            if (op == 1) {
                System.out.println("Elija la opcion\n"
                        + "1.Crear cuenta estudiante\n"
                        + "2.Crear persona");
                int mp = es.nextInt();

                if (mp == 1) {
                    System.out.println("---FORMULARIO DE CREACIÓN DE CUENTA DE ESTUDIANTE---");
                    System.out.println("Ingrese los siguientes datos\n");
                    Estudiante est = new Estudiante();
                    System.out.println("Ingrese sus nombres");
                    est.setNombres(es.next());
                    System.out.println("Ingrese sus apellidos");
                    est.setApellidos(es.next());
                    System.out.println("Ingrese una contraseña");
                    est.setContraseña(es.next());
                    System.out.println("Ingrese su cedula ");
                    est.setCedula(es.next());
                    System.out.println("Ingrese un direccion\n");
                    est.setDireccion(es.next());
                    System.out.println("Igrese su número de telefono\n");
                    est.setTelefono(es.nextInt());
                    System.out.println("Ingrese un correo electronico institucional\n");
                    est.setCorreoInstitucional(es.next());
                    System.out.println("Ingrese el nombre la carrera que esta cursando\n");
                    est.setCarreraCursando(es.next());
                    System.out.println("Ingrese el número de su matricula\n");
                    est.setNumMatricula(es.next());
                    System.out.println("Ingrese con números el nivel que esta cursando actualmente\n");
                    est.setNivelCursando(es.nextInt());

                    EstudianteControlador ec = new EstudianteControlador();
                    ec.crearPersona(est);
                } else if (mp == 2) {
                    System.out.println("---FORMULARIO DE CREACIÓN DE CUENTA DE ESTUDIANTE---");
                    System.out.println("Ingrese los siguientes datos\n");
                    Usuario est1 = new Usuario();
                    System.out.println("Ingrese sus nombres\n");
                    est1.setNombres(es.next());
                    System.out.println("Ingrese sus apellidos\n");
                    est1.setApellidos(es.next());
                    System.out.println("Ingrese una contraseña\n");
                    est1.setContraseña(es.next());
                    System.out.println("Ingrese su cedula \n");
                    est1.setCedula(es.next());
                    System.out.println("Ingrese un direccion\n");
                    est1.setDireccion(es.next());
                    System.out.println("Igrese su número de telefono\n");
                    est1.setTelefono(es.nextInt());

                    PersonaControlador pc = new PersonaControlador();
                    pc.crearPersona(est1);

                } else if (mp != 1 && mp != 2) {
                    System.out.println("---ERROR! INGRESE UNA OPCION CORRECTA---");
                }
            } else {
                System.out.println("Ingrese una opción del menú");
            }

        } while (i == 1);

//         CONEXION A BASE DE DATOS
//    ConexionBDD cb=new ConexionBDD();
//    cb.conectar();
    }
}
