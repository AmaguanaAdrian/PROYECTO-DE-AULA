package Controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;
import modelo.Ejemplar;
import java.sql.ResultSet;
import modelo.Libro;

/**
 *
 * @author USER
 */
public class EjemplarControlador {

    ConexionBDD conexion = new ConexionBDD();
    Connection connection = (Connection) conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    public void crearEjemplar(Ejemplar ej, int idLibro) {
        try {
            String consultaSQL = "INSERT INTO Ejemplares (eje_codigoEjem, lib_id ) VALUES (?, ?);";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);  // Usa `prepareStatement` en lugar de `prepareCall`
            ejecutar.setString(1, ej.getCodigoEjemplar());
            ejecutar.setInt(2, idLibro);
//        ejecutar.setInt(4, ej.getNumEjemplares());  // Asegúrate de que este campo existe en la tabla `ejemplares`
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                System.out.println("El ejemplar ha sido creado con éxito");
            } else {
                System.out.println("Favor ingresar correctamente los datos solicitados");
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    // Buscar ejemplar por código
    public Ejemplar buscarEjemplarPorCodigo(String codigoEjemplar) {
        Ejemplar ejemplar = new Ejemplar();
        try {
            String consultaSQL = "SELECT  eje_codigoEjem, eje_estado, lib_id FROM Ejemplares WHERE eje_codigoEjem = ?;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, codigoEjemplar);
            resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                ejemplar.setCodigoEjemplar(resultado.getString("eje_codigoEjem"));
                ejemplar.setEstado(resultado.getBoolean("eje_estado"));
                ejemplar.setIdLibro(resultado.getInt("lib_id"));
                resultado.close();
                return ejemplar;
            } else {
                System.out.println("Ingrese un código de ejemplar válido");
                resultado.close();
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return ejemplar;
    }

    // Listar todos los ejemplares
    public ArrayList<Ejemplar> listarEjemplares() {
        ArrayList<Ejemplar> listaEjemplares = new ArrayList<>();
        try {
            String consultaSQL = "SELECT  eje_codigoEjem, eje_estado, lib_id FROM Ejemplares;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                Ejemplar ejemplar = new Ejemplar();
                ejemplar.setCodigoEjemplar(resultado.getString("eje_codigoEjem"));
                ejemplar.setEstado(resultado.getBoolean("eje_estado"));
                ejemplar.setIdLibro(resultado.getInt("lib_id"));
                listaEjemplares.add(ejemplar);
            }
            resultado.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return listaEjemplares;
    }

    // Actualizar información de un ejemplar
    public void actualizarEjemplar(Ejemplar ejemplar) {
        try {
            String consultaSQL = "UPDATE Ejemplares SET eje_codigoEjem = ?, eje_estado = ?, lib_id = ? WHERE eje_id = ?;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, ejemplar.getCodigoEjemplar());
            ejecutar.setBoolean(2, ejemplar.getEstado());
            ejecutar.setInt(3, ejemplar.getIdLibro());
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                System.out.println("Actualización exitosa");
            } else {
                System.out.println("Revise los datos a actualizar");
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    // Eliminar ejemplar por ID
    public void eliminarEjemplar(int idEjemplar) {
        try {
            String consultaSQL = "DELETE FROM Ejemplares WHERE eje_id = ?;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setInt(1, idEjemplar);
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                System.out.println("Ejemplar eliminado con éxito");
            } else {
                System.out.println("No se pudo eliminar el ejemplar. Verifique el ID.");
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    public ArrayList<Libro> listarLibros() {
        ArrayList<Libro> listaLibros = new ArrayList<>();
        try {
            String consultaSQL = "SELECT lib_id, lib_titulo FROM Libros;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                Libro libro = new Libro();
                libro.setIdLibro(resultado.getInt("lib_id"));
                libro.setTitulo(resultado.getString("lib_titulo"));
                listaLibros.add(libro);
            }
            resultado.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return listaLibros;
    }
    

}
