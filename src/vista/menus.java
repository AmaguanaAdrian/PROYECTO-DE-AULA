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
    public static void menu1(){
        System.out.println("""
                              |          SISTEMA DE RESERVA DE LIBROS          |
                              |------------------------------------------------|
                              |  OPCIONES:                                     |
                              |   1. Crear Bibliotecario                       |
                              |   2. Hacer Reserva                             |
                              |   3. Crear Estudiante                          |
                              |   4. Gestión de Libros                         | 
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
}
