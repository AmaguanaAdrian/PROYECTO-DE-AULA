package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Reserva;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class ReservaControlador {
// Conexión

    ConexionBDD conexion = new ConexionBDD();
    Connection connection = conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    // cualquier consulta a bdd hacia el bakend un resultset
    // Método para crear una reserva
    public void crearReserva(Reserva r, int idUsuario) {
        try {
            ReservaControlador resC = new ReservaControlador();
            // String estático con componentes dinámicos (gets)
            String consultaSQL = "INSERT INTO reservas (res_fechaRetiro, res_fechaReserva,res_fechaDevolucion, est_id) VALUES (?, NOW(), ?,?);";
            ejecutar = (com.mysql.jdbc.PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, r.getFechaRetiro());
            ejecutar.setString(2, r.getFechaDevolucion());
            ejecutar.setInt(3, r.getIdEstudiante());
            int resultado = ejecutar.executeUpdate();
            // Ejecuta
            if (resultado > 0) {
                System.out.println("La reserva ha sido creada con éxito");
            } else {
                System.out.println("Favor ingresar correctamente los datos solicitados");
            }
            ejecutar.close();
        } catch (SQLException e) {
            // Captura el error y permite que la consola siga ejecutándose
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // Método para buscar una reserva por ID
    public Reserva buscarReserva(int idReserva) {
        Reserva r = new Reserva();
        try {
            String consultaSQL = "SELECT * FROM Reserva WHERE res_id = " + idReserva;
            PreparedStatement ejecutar = connection.prepareCall(consultaSQL);
            ResultSet resultado = ejecutar.executeQuery();
            {
                System.out.println("No se encontró una reserva con el ID proporcionado");
            }
            ejecutar.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return r;
    }

    // Método para listar todas las reservas
    public List<Reserva> listarReservas() {
        List<Reserva> listaReservas = new ArrayList<>();
        try {
            String consultaSQL = "SELECT * FROM Reserva";
            PreparedStatement ejecutar = connection.prepareCall(consultaSQL);
            ResultSet resultado = ejecutar.executeQuery();
            ejecutar.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return listaReservas;
    }
}
