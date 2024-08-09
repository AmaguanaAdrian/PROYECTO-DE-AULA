package Controlador;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Libro;
import com.mysql.jdbc.PreparedStatement;
/**
 *
 * @author
 */
public class LibrosControlador {
    private Connection connection;
    private PreparedStatement ejecutar;
    private ResultSet resultado;

    public LibrosControlador() {
        ConexionBDD conexion = new ConexionBDD();
        connection = (Connection) conexion.conectar();
    }

    // Crear un nuevo libro
    public void crearLibro(Libro libro, int op, int generoId) {
        
        String consultaSQL = "INSERT INTO Libros (lib_titulo, lib_fechaPublicado, lib_isbn,lib_numEjemplares, aut_id, gen_id) VALUES (?, ?, ?, ?, ?,?);";
        try {
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, libro.getTitulo());
            ejecutar.setString(2, libro.getFechaPublicado());
            ejecutar.setString(3, libro.getIsbn());
            ejecutar.setInt(4, libro.getNumEjemplares());
            ejecutar.setInt(5, op);
            ejecutar.setInt(6, generoId);
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                System.out.println("El libro ha sido creado con éxito");
            } else {
                System.out.println("Favor ingresar correctamente los datos solicitados");
            }
        } catch (Exception e) {
            System.out.println("ERROR al crear libro: " + e);
        } finally {
//            cerrarRecursos();
        }
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
        String consultaSQL = "SELECT lib_titulo, lib_fechaPublicado, lib_isbn FROM Libros;";
        try {
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
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

    // Cerrar recursos
//    private void cerrarRecursos() {
//        try {
//            if (resultado != null) {
//                resultado.close();
//            }
//            if (ejecutar != null) {
//                ejecutar.close();
//            }
//        } catch (Exception e) {
//            System.out.println("ERROR al cerrar recursos: " + e);
//        }
//    }
}