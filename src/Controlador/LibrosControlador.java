package Controlador;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Libros;
import com.mysql.jdbc.PreparedStatement;
import java.util.Date;
import modelo.Autor;
/**
 *
 * @author
 */
public class LibrosControlador {
    ConexionBDD conexion = new ConexionBDD();
    Connection connection = (Connection) conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado; 

    public void crearLibro(Libros l, int autorId, int generoId) {
        try {
            String consultaSQL = "INSERT INTO Libros (lib_titulo, lib_fechaPublicado, lib_isbn, aut_id, gen_id) VALUES (?, ?, ?, ?, ?);";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, l.getTitulo());
            ejecutar.setDate(2, java.sql.Date.valueOf(l.getFechaPublicado())); // Convertir la fecha
            ejecutar.setString(3, l.getIsbn());
            ejecutar.setInt(4, autorId);
            ejecutar.setInt(5, generoId);
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

    public int buscarIdLibro(String isbn) {
        try {
            String consultaSQL = "SELECT lib_id FROM Libros WHERE lib_isbn = ?;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, isbn);
            resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                int idLibro = resultado.getInt("lib_id");
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

    public ArrayList<Libros> listarLibros() {
        ArrayList<Libros> listaLibros = new ArrayList<>();
        try {
            String consultaSQL = "SELECT lib_id, lib_titulo, lib_fechaPublicado, lib_isbn FROM Libros;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                Libros l = new Libros();
                l.setIdLibro(resultado.getInt("lib_id"));
                l.setTitulo(resultado.getString("lib_titulo"));
                l.setFechaPublicado(resultado.getString("lib_fechaPublicado"));
                l.setIsbn(resultado.getString("lib_isbn"));
                listaLibros.add(l);
            }
            resultado.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return listaLibros;
    }

    public void actualizarLibro(Libros l, String isbn) {
        try {
            String consultaSQL = "UPDATE Libros SET lib_titulo = ?, lib_fechaPublicado = ? WHERE lib_isbn = ?;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, l.getTitulo());
            ejecutar.setDate(2, java.sql.Date.valueOf(l.getFechaPublicado())); // Convertir la fecha
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

    public Libros buscarDatosLibro(String isbn) {
        Libros l = new Libros();
        try {
            String consultaSQL = "SELECT lib_id, lib_titulo, lib_fechaPublicado, lib_isbn FROM Libros WHERE lib_isbn = ?;";
           ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, isbn);
            resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                l.setIdLibro(resultado.getInt("lib_id"));
                l.setTitulo(resultado.getString("lib_titulo"));
                l.setFechaPublicado(resultado.getString("lib_fechaPublicado"));
                l.setIsbn(resultado.getString("lib_isbn"));
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

    public void eliminarLibro(String isbn) {
        try {
            String consultaSQL = "DELETE FROM Libros WHERE lib_isbn = ?;";
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
         // Método para mostrar autores
     

    // Método para mostrar géneros
    public void mostrarGeneros() {
        try {
            String consultaSQL = "SELECT gen_id, gen_nombreGen FROM generos;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                int idGenero = resultado.getInt("gen_id");
                String nombreGenero = resultado.getString("gen_nombreGen");
                System.out.println("ID Género: " + idGenero + ", Nombre: " + nombreGenero);
            }

            resultado.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

}