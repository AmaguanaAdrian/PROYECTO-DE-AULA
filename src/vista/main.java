/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import Controlador.BibliotecarioControlador;
import java.util.Scanner;
import modelo.Bibliotecario;

/**
 *
 * @author USER
 */
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner es = new Scanner(System.in);
        int i = 1;
        
        do {
            System.out.println("BIENVENIDO");
            System.out.println("Elija la opción que Usted requiera ejecutar:\n"
                    + "1.Crear Bibliotecario\n"
                    + "0.Salir");
            int op1 = es.nextInt();
            es.nextLine(); // Consumir el salto de línea pendiente
            
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
                b.setContraseña(es.nextLine());

                System.out.println("Ingrese la cédula:");
                b.setCedula(es.nextLine());

                System.out.println("Ingrese la fecha de nacimiento (yyyy-MM-dd):");
                b.setFechaNace(es.nextLine());

                System.out.println("Ingrese la dirección:");
                b.setDireccion(es.nextLine());

                System.out.println("Ingrese el teléfono:");
                while (!es.hasNextDouble()) {
                    System.out.println("Por favor, ingrese un número válido para el teléfono:");
                    es.next(); // Consumir la entrada incorrecta
                }
                b.setTelefono(es.nextDouble());
                es.nextLine(); // Consumir el salto de línea pendiente

                System.out.println("Ingrese el correo institucional:");
                b.setCorreoInstitucional(es.nextLine());

                System.out.println("Ingrese el sexo:");
                b.setSexo(es.nextLine());

                System.out.println("Ingrese el puesto del bibliotecario:");
                b.setPuesto(es.nextLine());

                System.out.println("Ingrese el horario del bibliotecario (por ejemplo, 8.5 para horas diarias):");
                while (!es.hasNextDouble()) {
                    System.out.println("Por favor, ingrese un número válido para el horario:");
                    es.next(); // Consumir la entrada incorrecta
                }
                b.setHorario(es.nextDouble());
                es.nextLine(); // Consumir el salto de línea pendiente

                BibliotecarioControlador bc = new BibliotecarioControlador();
                bc.crearPersona(b);
            } else if (op1 == 0) {
                i = 0;
            }
        } while (i == 1);
        
        es.close(); // Cerrar el scanner al final
    }
}

