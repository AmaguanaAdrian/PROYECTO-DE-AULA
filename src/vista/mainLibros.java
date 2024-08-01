package vista;
import Controlador.LibrosControlador;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Libros;
/**
 *
 * @author
 */
public class mainLibros {
    public static void main(String[] args) {
        Scanner es = new Scanner(System.in);
        LibrosControlador libroControlador = new LibrosControlador();
        int op1; 
        do {
              System.out.println("""
                              |   GESTIÓN DE LIBROS     |
                              |-------------------------|
                              |   OPCIONES:             |
                              |   1. Insertar libros    |
                              |   2. Listar de libros   |
                              |   3. Actualizar libros  |
                              |  ´4. Eliminar libros    |
                              |   0. Salir              |
                              
                               """);

            op1 = es.nextInt();
            es.nextLine();
            if (op1 == 1) {
                // Insertar libro
                System.out.println("Ingrese el título del libro:");
                String titulo = es.nextLine();

                System.out.println("Ingrese la fecha de publicación (YYYY-MM-DD):");
                String fechaPublicado = es.nextLine();

                System.out.println("Ingrese el ISBN del libro:");
                String isbn = es.nextLine();

                Libros nuevoLibro = new Libros(0, titulo, fechaPublicado, isbn);
                libroControlador.crearLibro(nuevoLibro);

            } else if (op1 == 2) {
                // Mostrar lista de libros
                ArrayList<Libros> listaLibros = libroControlador.listarLibros();
                for (Libros l : listaLibros) {
                    System.out.println(l.imprimir());
                }

            } else if (op1 == 3) {
                // Actualizar información de un libro
                System.out.println("Ingrese el ISBN del libro que desea actualizar:");
                String isbn = es.nextLine();

                Libros libroExistente = libroControlador.buscarDatosLibro(isbn);
                if (libroExistente.getIdLibro() != 0) {
                    System.out.println("Ingrese el nuevo título del libro:");
                    String nuevoTitulo = es.nextLine();

                    System.out.println("Ingrese la nueva fecha de publicación (YYYY-MM-DD):");
                    String nuevaFechaPublicado = es.nextLine();

                    Libros actualizadoLibro = new Libros(libroExistente.getIdLibro(), nuevoTitulo, nuevaFechaPublicado, isbn);
                    libroControlador.actualizarLibro(actualizadoLibro, isbn);
                } else {
                    System.out.println("Libro no encontrado.");
                }

            } else if (op1 == 4) {
                // Eliminar libro
                System.out.println("Ingrese el ISBN del libro que desea eliminar:");
                String isbn = es.nextLine();
                libroControlador.eliminarLibro(isbn);

            } else if (op1 == 0) {
                System.out.println("Saliendo...");

            } else {
                System.out.println("Opción no válida, por favor elija una opción entre 0 y 4.");
            }
        } while (op1 != 0);

        es.close();
    }
}
