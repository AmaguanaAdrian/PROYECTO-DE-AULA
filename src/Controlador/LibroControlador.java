package Controlador;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Libro;
import com.mysql.jdbc.PreparedStatement;
import java.util.List;
import modelo.Ejemplar;

/**
 *
 * @author
 */
public class LibroControlador {

    private Connection connection;
    private PreparedStatement ejecutar;
    private ResultSet resultado;

    public LibroControlador() {
        ConexionBDD conexion = new ConexionBDD();
        connection = (Connection) conexion.conectar();
    }

    // Crear un nuevo libro
    public int crearLibro(Libro libro, int op, int generoId) {
        String consultaSQL = "INSERT INTO Libros (lib_titulo, lib_fechaPublicado, lib_isbn,lib_numEjemplares, aut_id, gen_id) VALUES (?, ?, ?, ?, ?,?);";
        int idLibro = -1; // Inicializamos el ID del libro a -1

        try {
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, libro.getTitulo());
            ejecutar.setString(2, libro.getFechaPublicado());
            ejecutar.setString(3, libro.getIsbn());
            ejecutar.setInt(4, libro.getNumEjemplares());
            ejecutar.setInt(5, op);
            ejecutar.setInt(6, generoId);
            ejecutar.executeUpdate();

            // Obtenemos el ID del libro recién creado
            ResultSet rs = ejecutar.getGeneratedKeys();
            if (rs.next()) {
                idLibro = rs.getInt(1);
            }

            if (idLibro > 0) {
                System.out.println("El libro ha sido creado con éxito");
            } else {
                System.out.println("Favor ingresar correctamente los datos solicitados");
            }
        } catch (Exception e) {
            System.out.println("ERROR al crear libro: " + e);
        } finally {
//        cerrarRecursos();
        }

        return idLibro; // Devolvemos el ID del libro
    }

    // Buscar libro por título
    public Libro buscarDatosLibro(String titulo) {
        Libro libro = new Libro();
        String consultaSQL = "SELECT lib_titulo, lib_fechaPublicado, lib_isbn FROM Libros WHERE lib_titulo = ?;";
        try {
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, titulo);
            resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                libro.setTitulo(resultado.getString("lib_titulo"));
                libro.setFechaPublicado(resultado.getString("lib_fechaPublicado"));
                libro.setIsbn(resultado.getString("lib_isbn"));
            } else {
                System.out.println("Ingrese un título válido");
            }
        } catch (Exception e) {
            System.out.println("ERROR buscar libro: " + e);
        } finally {
//            cerrarRecursos();
        }
        return libro;
    }
    // Listar todos los libros

    public ArrayList<Libro> listarLibros() {
        ArrayList<Libro> listarLibros = new ArrayList<>();
        String consultaSQL = "SELECT lib_titulo, lib_fechaPublicado, lib_isbn, "
                + 
                "lib_numEjemplares, "
                + "aut.aut_nombres AS autor_nombres, aut.aut_apellidos AS autor_apellidos, "
                + "gen.gen_nombreGen AS genero "
                + "FROM Libros lib "
                + "JOIN Autores aut ON lib.aut_id = aut.aut_id "
                + "JOIN Generos gen ON lib.gen_id = gen.gen_id;";
        try {
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                Libro libro = new Libro();
                libro.setTitulo(resultado.getString("lib_titulo"));
                libro.setFechaPublicado(resultado.getString("lib_fechaPublicado"));
                libro.setIsbn(resultado.getString("lib_isbn"));
                libro.setNumEjemplares(resultado.getInt("lib_numEjemplares")); // Obtener el número de ejemplares
                String autorNombre = resultado.getString("autor_nombres") + " " + resultado.getString("autor_apellidos");
                libro.setAutor(autorNombre); // Asegúrate de que el método setAutor exista en la clase Libro
                libro.setGenero(resultado.getString("genero")); // Asegúrate de que el método setGenero exista en la clase Libro
                listarLibros.add(libro);
            }
        } catch (Exception e) {
            System.out.println("ERROR listar libros: " + e);
        } finally {
            // cerrarRecursos();
        }
        return listarLibros;
    }

    // Listar libros por título
    public ArrayList<Libro> listarLibrosPorTitulo(String titulo) {
        ArrayList<Libro> listarLibros = new ArrayList<>();
        String consultaSQL = "SELECT lib_titulo, lib_fechaPublicado, lib_isbn FROM Libros WHERE lib_titulo = ?;";
        try {
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, titulo);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                Libro libro = new Libro();
                libro.setTitulo(resultado.getString("lib_titulo"));
                libro.setFechaPublicado(resultado.getString("lib_fechaPublicado"));
                libro.setIsbn(resultado.getString("lib_isbn"));
                listarLibros.add(libro);
            }
        } catch (Exception e) {
            System.out.println("ERROR listar libros: " + e);
        } finally {
//            cerrarRecursos();
        }
        return listarLibros;
    }

    // Buscar ID de libro por título
    public int idPorTitulo(String titulo, String nuevoLibro) {
        int idLibro = 0;
        String consultaSQL = "SELECT lib_id FROM Libros WHERE lib_titulo = ?;";
        try {
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, titulo);
            resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                idLibro = resultado.getInt("lib_id");
            } else {
                System.out.println("Ingrese un título válido");
            }
        } catch (Exception e) {
            System.out.println("ERROR buscar ID libro: " + e);
        } finally {
//            cerrarRecursos();
        }
        return idLibro;
    }

    public boolean buscarEjemplaresDisponibles(int idLibro) {
        try {
            String consultaSQL = "SELECT e.eje_estado "
                    + "FROM Ejemplares e, Libros l "
                    + "WHERE l.lib_id = e.lib_id "
                    + "AND e.lib_id = ? "
                    + "AND e.eje_estado = 1"; // Solo seleccionamos los ejemplares con estado 1 (disponible)
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setInt(1, idLibro);
            ResultSet rs = ejecutar.executeQuery();
            return rs.next(); // Si hay al menos un registro, devuelve true
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            return false; // Si hay un error, devuelve false
        }
    }

    public String infoLibro1(int idLibro) {
        try {
            String consultaSQL = "SELECT l.lib_titulo, a.aut_nombres, a.aut_apellidos, l.lib_fechaPublicado "
                    + "FROM Libros l, Autores a "
                    + "WHERE l.aut_id = a.aut_id "
                    + "AND l.lib_id = ?";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setInt(1, idLibro);
            ResultSet rs = ejecutar.executeQuery();
            if (rs.next()) {
                String titulo = rs.getString("lib_titulo");
                String autorNombres = rs.getString("aut_nombres");
                String autorApellidos = rs.getString("aut_apellidos");
                String fechaPublicacion = rs.getString("lib_fechaPublicado");
                return titulo + " - " + autorNombres + " " + autorApellidos + " - " + fechaPublicacion;
            } else {
                return "No se encontró información del libro";
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            return "Error al obtener información del libro";
        }
    }
    public String obtenerTituloPorId(int idEjemplar) {
        String consultaSQL = "SELECT lib_titulo FROM Libros WHERE lib_id = ?;";
        String titulo = "Título no encontrado"; // Valor por defecto si no se encuentra el libro
        try {
            PreparedStatement ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setInt(1, idEjemplar);
            ResultSet rs = ejecutar.executeQuery();

            if (rs.next()) {
                titulo = rs.getString("lib_titulo");
            }
        } catch (Exception e) {
            System.out.println("ERROR al obtener el título: " + e);
        } finally {
            // cerrarRecursos(); // Asegúrate de cerrar la conexión, ResultSet, y PreparedStatement si es necesario
        }

        return titulo;
    }
}
