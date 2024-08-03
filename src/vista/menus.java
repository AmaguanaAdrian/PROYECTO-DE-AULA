package vista;
import java.io.IOException;

/**
 *
 * @author
 */
public class menus {

    public static void introduccion() {
        System.out.println("""
                           ╔═══════════════════════════════════════════════════════════════════╗
                           ║                                                         ║
                           ║      Bienvenido al Sistema de Reserva de Libros para    ║
                           ║      Bibliotecas. Este sistema te permitirá gestionar   ║
                           ║      reservas, préstamos y el genero de libros          ║
                           ║                  Podrás realizar                        ║
                           ║       todas tus gestiones con facilidad y rapidez.      ║
                           ║                                                         ║
                           ║  ¡¡Presiona Enter para comenzar y explorar el sistema.¡ ║
                           ║                                                         ║
                           ╚═══════════════════════════════════════════════════════════════════╝
                           
                           """.indent(30));
        

    }

    public static void menuBiblio() {
        System.out.println("""
                              |              PERFIL BIBLIOTECARIO              |
                              |------------------------------------------------|
                              |  OPCIONES:                                     |
                              |   1. Crear Bibliotecario                       |
                              |   2. Hacer Reserva                             |
                              |   3. Crear Estudiante                          |
                              |   4. Gestión de Libros                         |
                              |   5. Gestion Genero                            |
                              |   6. Gestion de Autores                        |
                              |   7. Gestionar Ejemplares                      |
                              |   0. Salir                                     |
                               
                               """.indent(30));

    }

    public static void menuLibros() {
        System.out.println("""
                                    |   GESTIÓN DE LIBROS     |
                                    |-------------------------|
                                    |   OPCIONES:             |
                                    |   1. Insertar libros    |
                                    |   2. Listar de libros   |
                                    |   3. Actualizar libros  |
                                    |   4. Eliminar libros    |
                                    |   0. Volver al menú     |
                                    """.indent(30));
    }
    
    public static void menuGenero() {
        System.out.println("""
                                    |   GESTIÓN DE GÉNEROS    |
                                    |-------------------------|
                                    |   OPCIONES:             |
                                    |   1. Insertar género    |
                                    |   2. Listar géneros     |
                                    |   3. Actualizar géner   |
                                    |   4. Eliminar género    |
                                    |   0. Volver al menu     |

                                    """.indent(30));
    }
    public static void menuAutores() {
        System.out.println("""
                               
                           |                      MENU AUTORES                       |
                           |---------------------------------------------------------|
                           |   OPCIONES:                                             |
                           |   1. Insertar autor                                     |
                           |   2. Mostrar lista de autores registrados               |
                           |   3. Actualizar información de un autor (por nombre)    |
                           |   4. Eliminar autor (por nombre)                        |
                           |   0. Volver al menu                                     |
                           """.indent(30));
    }
    public static void menuEjemplares() {
        System.out.println("""
                                        |   GESTIÓN DE EJEMPLARES     |
                                        |-----------------------------|
                                        |   OPCIONES:                 |
                                        |   1. Insertar ejemplares    |
                                        |   2. Listar ejemplares      |
                                        |   3. Actualizar ejemplares  |
                                        |   4. Eliminar ejemplares    |
                                        |   0. Volver al menú         |
                """.indent(30));
    }
    
    
}
