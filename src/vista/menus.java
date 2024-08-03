package vista;

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
                           
                           """);

    }

    public static void menu1() {
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
                              |   0. Salir                                     |
                               
                               """);

    }

    public static void menu2() {
        System.out.println("""
                              |   GESTIÓN DE LIBROS     |
                              |-------------------------|
                              |   OPCIONES:             |
                              |   1. Insertar libros    |
                              |   2. Listar libros      |
                              |   3. Actualizar libros  |
                              |   4. Eliminar libros    |
                              |   0. Salir              |
                              
                               """);
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
                            |   0. Salir              |
                            
                            """);
    }
    public static void menuAutores() {
        System.out.println("""
                               
                           |----------------------MENU AUTORES-----------------------|
                           |---------------------------------------------------------|
                           |   Elija la opción que Usted requiera ejecutar:          |
                           |   1. Insertar autor                                     |
                           |   2. Mostrar lista de autores registrados               |
                           |   3. Actualizar información de un autor (por nombre)    |
                           |   4. Eliminar autor (por nombre)                        |
                           |   0. Salir                                              |
                           """);
    }
    
}
