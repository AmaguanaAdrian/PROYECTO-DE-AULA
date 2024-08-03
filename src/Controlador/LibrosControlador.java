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
    ConexionBDD conexion=new ConexionBDD();
    Connection connection=(Connection)conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado; 
    public void crearLibro(Libros l) {
    try {
        String consultaSQL = "INSERT INTO Libros (lib_titulo, lib_fechaPublicado, lib_isbn, aut_id, gen_id) VALUES (?, ?, ?, ?, ?);";
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
        String consultaSQL = "SELECT lib_id FROM Libros WHERE lib_isbn = ?;";
        ejecutar=(PreparedStatement)connection.prepareCall(consultaSQL);
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

// LISTAR TODOS LOS LIBROS
public ArrayList<Libros> listarLibros() {
    ArrayList<Libros> listaLibros = new ArrayList<>();
    try {
        String consultaSQL = "SELECT lib_id, lib_titulo, lib_fechaPublicado, lib_isbn FROM Libros;";
        ejecutar=(PreparedStatement)connection.prepareCall(consultaSQL);
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

// ACTUALIZAR INFORMACIÓN DE UN LIBRO
public void actualizarLibro(Libros l, String isbn) {
    try {
        String consultaSQL = "UPDATE Libros SET lib_titulo = ?, lib_fechaPublicado = ? WHERE lib_isbn = ?;";
        ejecutar=(PreparedStatement)connection.prepareCall(consultaSQL);
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
        String consultaSQL = "SELECT lib_id, lib_titulo, lib_fechaPublicado, lib_isbn FROM Libros WHERE lib_isbn = ?;";
        ejecutar=(PreparedStatement)connection.prepareCall(consultaSQL);
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

// ELIMINAR LIBRO POR ISBN
public void eliminarLibro(String isbn) {
    try {
        String consultaSQL = "DELETE FROM Libros WHERE lib_isbn = ?;";
        ejecutar=(PreparedStatement)connection.prepareCall(consultaSQL);
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
