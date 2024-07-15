package vista;

//import controlador.ConexionBDD;
import Controlador.EstudianteControlador;
import java.util.Scanner;
import modelo.Estudiante;

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
            if (op == 1){
                System.out.println("Elija la opcion\n"
                        + "1.Crear cuenta estudiante");
                int mp=es.nextInt();
                if (mp == 1) {
                    if (mp == 1) {
                        System.out.println("---FORMULARIO DE CREACIÓN DE CUENTA DE ESTUDIANTE---");
                        System.out.println("Ingrese los siguientes datos\n");
                        Estudiante est=new Estudiante();
                        System.out.println("Ingrese sus nombres\n");
                        est.setNombres(es.next());
                        System.out.println("Ingrese sus apellidos\n");
                        est.setApellidos(es.next());
                        System.out.println("Ingrese un usuario\n");
                        est.setUsuario(es.next());
                        System.out.println("ingrese una conraseña\n");
                        est.setContraseña(es.next());
                        System.out.println("Ingrese su cedula \n");
                        est.setCedula(es.next());
                        System.out.println("Ingrese su fecha de nacimiento de la fomra (aa-mm-dd)\n");
                        est.setFechaNace(es.next());
                        System.out.println("Ingrese un direccion\n");
                        est.setDireccion(es.next());
                        System.out.println("Igrese su número de telefono\n");
                        est.setTelefono(es.nextDouble());
                        System.out.println("Ingrese un correo electronico institucional\n");
                        est.setCorreoInstitucional(es.next());
                        System.out.println("Ingrese f si es femenino o m si es masculino\n");
                        est.setSexo(es.next());
                        System.out.println("Ingrese el nombre la carrera que esta cursando\n");
                        est.setCarreraCursando(es.next());
                        System.out.println("Ingrese el número de su matricula\n");
                        est.setNumMatricula(es.next());
                        System.out.println("Ingrese con números el nivel que esta cursando actualmente\n");
                        est.setNivelCursando(es.nextInt());
                        
                        EstudianteControlador ec=new EstudianteControlador();
                    ec.crearPersona(est);
                        
                        
                    } else if (mp != 1) {
                        System.out.println("---ERROR! INGRESE UNA OPCION CORRECTA---");
                    }
                } else {
                    System.out.println("Ingrese una opción del menú");
                }
            } else if (op == 0) {
                i = 0;
            }

        } while (i == 1);
        
//         CONEXION A BASE DE DATOS
//    ConexionBDD cb=new ConexionBDD();
//    cb.conectar();
        
    }
}
