package Controlador;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Libros;
import com.mysql.jdbc.PreparedStatement;
/**
 *
 * @author
 */
public class LibrosControlador {
    ConexionBDD conexion=new ConexionBDD();
    Connection connection=(Connection)conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado; 
    public void crearLibro(Libros l) {
    try {
        String consultaSQL = "INSERT INTO libros (li_titulo, lib_fechaPublicado, lib_isbn) VALUES (?, ?, ?);";
        ejecutar=(PreparedStatement)connection.prepareCall(consultaSQL);
        ejecutar.setString(1, l.getTitulo());
        ejecutar.setString(2, l.getFechaPublicado());
        ejecutar.setString(3, l.getIsbn());
        int res = ejecutar.executeUpdate();
        if (res > 0) {
            System.out.println("El libro ha sido creado con éxito");
        } else {
            System.out.println("Favor ingresar correctamente los datos solicitados");
        }
        ejecutar.close();
    } catch (Exception e) {
        System.out.println("ERROR: " + e);
    }
}

       // BUSCAR LIBRO POR ISBN
    public int buscarIdLibro(String isbn) {
        try {
            String consultaSQL = "SELECT idLibro FROM libros WHERE isbn = ?;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, isbn);
            resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                int idLibro = resultado.getInt("idLibro");
                return idLibro;
            } else {
                System.out.println("Ingrese un ISBN válido");
            }
            resultado.close();
        } catch (Exception e) {
            System.out.println("Comuníquese con el administrador para el error: " + e);
        }
        return 0;
    }

    // LISTAR TODOS LOS LIBROS
    public ArrayList<Libros> listarLibros() {
        ArrayList<Libros> listaLibros = new ArrayList<>();
        try {
            String consultaSQL = "SELECT idLibro, titulo, fechaPublicado, isbn FROM libros;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                Libros l = new Libros();
                l.setIdLibro(resultado.getInt("idLibro"));
                l.setTitulo(resultado.getString("titulo"));
                l.setFechaPublicado(resultado.getString("fechaPublicado"));
                l.setIsbn(resultado.getString("isbn"));
                listaLibros.add(l);
            }
            resultado.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return listaLibros;
    }

    // ACTUALIZAR INFORMACIÓN DE UN LIBRO
    public void actualizarLibro(Libros l, String isbn) {
        try {
            String consultaSQL = "UPDATE libros SET titulo = ?, fechaPublicado = ? WHERE isbn = ?;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, l.getTitulo());
            ejecutar.setString(2, l.getFechaPublicado());
            ejecutar.setString(3, isbn);
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                System.out.println("Actualización exitosa");
            } else {
                System.out.println("Revise datos a actualizar");
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    // BUSCAR DATOS DE UN LIBRO POR ISBN
    public Libros buscarDatosLibro(String isbn) {
        Libros l = new Libros();
        try {
            String consultaSQL = "SELECT idLibro, titulo, fechaPublicado, isbn FROM libros WHERE isbn = ?;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, isbn);
            resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                l.setIdLibro(resultado.getInt("idLibro"));
                l.setTitulo(resultado.getString("titulo"));
                l.setFechaPublicado(resultado.getString("fechaPublicado"));
                l.setIsbn(resultado.getString("isbn"));
                resultado.close();
                return l;
            } else {
                System.out.println("Ingrese un ISBN válido");
                resultado.close();
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return l;
    }

    // ELIMINAR LIBRO POR ISBN
    public void eliminarLibro(String isbn) {
        try {
            String consultaSQL = "DELETE FROM libros WHERE isbn = ?;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, isbn);
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                System.out.println("Libro eliminado con éxito");
            } else {
                System.out.println("No se pudo eliminar el libro. Verifique el ISBN.");
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}
