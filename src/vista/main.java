
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import Controlador.BibliotecarioControlador;
import Controlador.EstudianteControlador;

import Controlador.ReservaControlador;
import java.util.Scanner;
import modelo.Bibliotecario;
import modelo.Estudiante;
import modelo.Reserva;
import modelo.Usuario;


public class main {
    public static void main(String[] args) {
        Scanner es = new Scanner(System.in);
        int i = 1;

        
        do {
            System.out.println("BIENVENIDO");
            System.out.println("Elija la opción que Usted requiera ejecutar:\n"
                    + "1. Crear Bibliotecario\n"
                    + "2. Crear Reserva\n"
                    + "3. Crear Estudiante\n"
                    + "0. Salir");
            int op1 = es.nextInt();
            es.nextLine(); // salto de línea pendiente
            
            if (op1 == 1) {
                System.out.println("Ingrese los datos del bibliotecario:");
                Bibliotecario b = new Bibliotecario();

                System.out.println("Ingrese los nombres:");
                b.setNombres(es.nextLine());

                System.out.println("Ingrese los apellidos:");
                b.setApellidos(es.nextLine());

                System.out.println("Ingrese el usuario:");
                b.setUsuario(es.nextLine());

                System.out.println("Ingrese la contraseña:");
                b.setClave(es.nextLine());

                System.out.println("Ingrese la cédula:");
                b.setCedula(es.nextLine());

                System.out.println("Ingrese la fecha de nacimiento (yyyy-MM-dd):");
                b.setFechaNace(es.nextLine());

                System.out.println("Ingrese la dirección:");
                b.setDireccion(es.nextLine());

                System.out.println("Ingrese el teléfono:");
                while (!es.hasNextDouble()) {
                    System.out.println("Por favor, ingrese un número válido para el teléfono:");
                    es.next(); // Dtecta entrada incorrecta
                }
                b.setTelefono(es.nextDouble());
                es.nextLine(); // salto de línea pendiente

                System.out.println("Ingrese el correo institucional:");
                b.setCorreoInstitucional(es.nextLine());

                System.out.println("Ingrese el sexo:");
                b.setSexo(es.nextLine());

                System.out.println("Ingrese el puesto del bibliotecario:");
                b.setPuesto(es.nextLine());

                System.out.println("Ingrese el horario del bibliotecario (por ejemplo, 8.5 para horas diarias):");
                while (!es.hasNextDouble()) {
                    System.out.println("Por favor, ingrese un número válido para el horario:");
                    es.next(); // Dtecta la entrada incorrecta
                }
                b.setHorario(es.nextDouble());
                es.nextLine(); // salto de línea pendiente

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

                System.out.println("Ingrese un Usuario:");
                p.setUsuario(es.next());

                System.out.println("Ingrese una Clave:");
                p.setClave(es.next());

                System.out.println("Ingrese una Dirección:");
                p.setDireccion(es.next());

                System.out.println("Ingrese su Correo Electrónico:");
                p.setCorreoInstitucional(es.next());

                System.out.println("Ingrese el sexo:");
                p.setSexo(es.next());

                System.out.println("Ingrese su Fecha de Nacimiento:");
                p.setFechaNace(es.next());

                System.out.println("Ingrese un número Telefónico:");
                p.setTelefono(es.nextDouble());
                es.nextLine(); // Consumir el salto de línea pendiente


               
                Estudiante est = new Estudiante();
                System.out.println("Ingrese número de matrícula:");
                est.setNumMatricula(es.next());

                System.out.println("Ingrese la jornada de estudio:");
                est.setNumMatricula(es.next());

              
                EstudianteControlador estC = new EstudianteControlador();
                estC.crearPersona(est);
            } else if (op1 == 0) {
                i = 0;
            }
        } while (i == 1);
        
        es.close();
    }
}

