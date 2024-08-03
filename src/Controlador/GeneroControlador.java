
package Controlador;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import modelo.Genero;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author 
 */


public class GeneroControlador {

    ConexionBDD conexion = new ConexionBDD();
    Connection connection = (Connection) conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    // Crear nuevo género
    public void crearGenero(Genero g) {
        try {
            String consultaSQL = "INSERT INTO generos (gen_nombreGen) VALUES (?);";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, g.getNombreGenero());
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                System.out.println("El género ha sido creado con éxito");
            } else {
                System.out.println("Favor ingresar correctamente los datos solicitados");
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    // Buscar ID de género por nombre
    public int buscarIdGenero(String nombreGenero) {
        try {
            String consultaSQL = "SELECT gen_id FROM generos WHERE gen_nombreGen = ?;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, nombreGenero);
            resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                int genId = resultado.getInt("gen_id");
                return genId;
            } else {
                System.out.println("Ingrese un nombre de género válido");
            }
            resultado.close();
        } catch (Exception e) {
            System.out.println("Comuníquese con el administrador para el error: " + e);
        }
        return 0;
    }

    // Listar todos los géneros
    public ArrayList<Genero> listarGeneros() {
        ArrayList<Genero> listaGeneros = new ArrayList<>();
        try {
            String consultaSQL = "SELECT gen_id, gen_nombreGen FROM generos;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                Genero g = new Genero();
                g.setNombreGenero(resultado.getString("gen_nombreGen"));
                listaGeneros.add(g);
            }
            resultado.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return listaGeneros;
    }

    // Actualizar información de un género
    public void actualizarGenero(Genero g, int genId) {
        try {
            String consultaSQL = "UPDATE generos SET gen_nombreGen = ? WHERE gen_id = ?;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, g.getNombreGenero());
            ejecutar.setInt(2, genId);
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

    // Buscar datos de un género por nombre
    public Genero buscarDatosGenero(String nombreGenero) {
        Genero g = new Genero();
        try {
            String consultaSQL = "SELECT gen_id, gen_nombreGen FROM generos WHERE gen_nombreGen = ?;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, nombreGenero);
            resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                g.setNombreGenero(resultado.getString("gen_nombreGen"));
                resultado.close();
                return g;
            } else {
                System.out.println("Ingrese un nombre de género válido");
                resultado.close();
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return g;
    }

    // Eliminar género por nombre
    public void eliminarGenero(String nombreGenero) {
        try {
            String consultaSQL = "DELETE FROM generos WHERE gen_nombreGen = ?;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, nombreGenero);
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                System.out.println("Género eliminado con éxito");
            } else {
                System.out.println("No se pudo eliminar el género. Verifique el nombre.");
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}



