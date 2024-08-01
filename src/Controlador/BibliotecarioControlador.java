package Controlador;
/**
 *
 * @author
 */

import modelo.Bibliotecario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BibliotecarioControlador {
    // ATRIBUTOS
    private Bibliotecario bibliotecario;
    // CONEXION
    ConexionBDD conexion = new ConexionBDD();
    Connection connection = conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    // INSERTAR FILAS EN TABLA
    public void crearPersona(Bibliotecario b) {
        try {
            // String estático con componentes dinámicos (gets)
            String consultaSQL = "INSERT INTO bibliotecarios (bib_tituloRegistrado,usu_id)VALUES('"+b.getTituloRegistrado()+"',"+b.getIdUsuario()+");";
            PreparedStatement ejecutar=(PreparedStatement)connection.prepareCall(consultaSQL);
            int resultado = ejecutar.executeUpdate();
            // Ejecuta
            if (resultado > 0) {
                System.out.println("El Bibliotecario ha sido creada con éxito");
            } else {
                System.out.println("Favor ingresar correctamente los datos solicitados");
            }
            ejecutar.close();
        } catch (SQLException e) {
            // Captura el error y permite que la consola siga ejecutándose
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
