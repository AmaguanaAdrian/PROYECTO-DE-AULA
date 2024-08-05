package vista;

import Controlador.ConexionBDD;
import Controlador.EstudianteControlador;
import controlador.UsuarioControlador;
import java.util.Scanner;
import modelo.Estudiante;
import modelo.Usuario;

/**
 *
 * @author david
 */
public class MainP {

    public static void main(String[] args) {

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
                Funciones.login(args);
                b = 1;
            } else if (op == 2) {
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

                // OBTENER ID DE LA SUPER CLASE
                int idUsuario = usuC.buscarIdUsuario(u.getCedula());

                Estudiante est = new Estudiante();
                System.out.println("Ingrese la carrera que está cursando:");
                est.setCarreraCursando(es.nextLine());

                System.out.println("Ingrese número de matrícula:");
                est.setNumMatricula(es.next());
                es.nextLine(); // Consumir el salto de línea pendiente

                System.out.println("Ingrese el nivel que esta cursando actualmente:");
                est.setNivelCursando(es.nextInt());
                es.nextLine(); // Consumir el salto de línea pendiente

                est.setIdUsuario(idUsuario);

                EstudianteControlador estC = new EstudianteControlador();
                estC.crearEstudiante(est);
                b = 2;

//                MainP.main(args);
            } else {
                System.out.println("Error: solo se permiten números 1, 2 o 0. Intente de nuevo.");
                b = -1; //BANDERA
            }

        } while (b != 0);

//        
    }

}
