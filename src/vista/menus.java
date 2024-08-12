package vista;

/**
 *
 * @author
 */
public class menus {

    public static void introduccion() {
        System.out.println("""
    ╔══════════════════════════════════════════════════════════════════════╗
    ║                                                             ║
    ║      Bienvenido al Sistema de Reserva de Libros.            ║
    ║      Este sistema te permitirá gestionar                    ║
    ║      reservas de disponibles en bibliotecalibros            ║
    ║                  Podrás realizar                            ║
    ║       todas tus gestiones con facilidad y rapidez.          ║
    ║                                                             ║
    ║  ¡¡Presiona Enter para comenzar y explorar el sistema.¡     ║
    ║                                                             ║
    ╚══════════════════════════════════════════════════════════════════════╝

    """.indent(30));

    }

    public static void menuBiblio() {
        System.out.print("""
    |              PERFIL BIBLIOTECARIO              |
    |------------------------------------------------|
    |  OPCIONES:                                     |
    |   1. Registrar Bibliotecario                   |
    |   2  Registrar Estudiante                      |
    |   3. Gestion de reservas                       |
    |   4. Gestión de Libros                         |
    |   5. Gestion Genero                            |
    |   6. Gestion de Autores                        |
    |   7. Gestionar Ejemplares                      |
    |   0. Cerrar sesión                             | 
      """.indent(30));

        System.out.print("Opcion: ");

    }

    public static void menuEstudiante() {
        System.out.print("""
    |               PERFIL ESTUDIANTE                |
    |------------------------------------------------|
    |  OPCIONES:                                     |
    |   1. Realizar reserva                          |
    |   2. Buscar Libros (Titulo, Autor, Isbn)       |
    |   0. Salir del perfil                          | 
      """.indent(30));

        System.out.print("Opcion: ");

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
        System.out.print("Opción: ");
    }

    public static void menuGenero() {
        System.out.println("""
    |   GESTIÓN DE GÉNEROS    |
    |-------------------------|
    |   OPCIONES:             |
    |   1. Insertar género    |
    |   2. Listar géneros     |
    |   3. Actualizar género  |
    |   4. Eliminar género    |
    |   0. Volver al menú     |
    """.indent(30));
        System.out.print("Opción: ");
    }

    public static void menuAutores() {
        System.out.println("""
    |                      MENÚ AUTORES                       |
    |---------------------------------------------------------|
    |   OPCIONES:                                             |
    |   1. Insertar autor                                     |
    |   2. Mostrar lista de autores registrados               |
    |   3. Actualizar información de un autor (por nombre)    |
    |   4. Eliminar autor (por nombre)                        |
    |   0. Volver al menu                                     |
    """.indent(30));
        System.out.print("Opcion: ");
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
        System.out.print("Opción: ");
    }

    public static void menuBusquedaLibros() {
        System.out.print("""
    |      ELIJA UNA OPCIÓN PARA BUSCAR EL LIBRO     |
    |------------------------------------------------|
    |  OPCIONES:                                     |
    |   1. Tíulo                                     |
    |   2. Autor                                     |
    |   3. ISBN                                      |
    |   0. Regresar                                  | 
      """.indent(30));

        System.out.print("Opción: ");

    }
    public static void menu1() {
        System.out.print("""
    |ELIJA UNA OPCION DE LA ACCION QUE DESEA REALIZAR:|
    |-------------------------------------------------|
    |  OPCIONES:                                      |
    |   1. Iniciar sesión                             |
    |   2. Registrarse como Estudiante                |
    |   0. Salir del sistema                          |
      """.indent(30));

        System.out.print("Opción: ");

    }
    public static void menuAdmin() {
        System.out.println("""
    |   PERFIL: ADMIN     |
    |-----------------------------|
    |   OPCIONES:                 |
    |  1. Registrar bibliotecario |
    |  0. Cerrar sesión           |
    """.indent(30));
        System.out.print("Opción: ");
    }
    

}
