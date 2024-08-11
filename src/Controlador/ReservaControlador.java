package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Reserva;
import java.sql.SQLException;
import modelo.Ejemplar;

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

    public void crearReserva(Reserva r, int idUsuario, ArrayList<Ejemplar> listaEjemplares) {
    try {
        // Inserta la reserva
        String consultaSQL = "INSERT INTO Reservas (res_fechaRetiro, res_fechaReserva, res_fechaDevolucion, est_id) VALUES (?, NOW(), ?, ?);";
        ejecutar = (com.mysql.jdbc.PreparedStatement) connection.prepareCall(consultaSQL);
        ejecutar.setString(1, r.getFechaRetiro());
        ejecutar.setString(2, r.getFechaDevolucion());
        ejecutar.setInt(3, r.getIdEstudiante()); // Asegúrate de que este método esté correcto
        int resultado = ejecutar.executeUpdate();

        if (resultado > 0) {
            System.out.println("La reserva ha sido creada con éxito");

            // Obtener el ID de la reserva recién creada
            String consultaID = "SELECT LAST_INSERT_ID()";
            PreparedStatement stmt = connection.prepareStatement(consultaID);
            ResultSet rs = stmt.executeQuery();
            int idReserva = 0;
            if (rs.next()) {
                idReserva = rs.getInt(1);
            }

            // Insertar ejemplares asociados a la reserva en Detalles_reservas
            for (Ejemplar ejemplar : listaEjemplares) {
                String consultaEjemplar = "INSERT INTO Detalles_reservas (res_id, eje_id) VALUES (?, ?)";
                PreparedStatement stmtEjemplar = connection.prepareStatement(consultaEjemplar);
                stmtEjemplar.setInt(1, idReserva);
                stmtEjemplar.setInt(2, ejemplar.getIdEjemplar()); // Asumiendo que Ejemplar tiene un método getId()
                stmtEjemplar.executeUpdate();
                stmtEjemplar.close();
            }

        } else {
            System.out.println("Favor ingresar correctamente los datos solicitados");
        }
        ejecutar.close();
    } catch (SQLException e) {
        System.out.println("ERROR: " + e.getMessage());
    }
}
//    // cualquier consulta a bdd hacia el bakend un resultset
//    // Método para crear una reserva
//    public void crearReserva(Reserva r, int idUsuario) {
//        try {
//            ReservaControlador resC = new ReservaControlador();
//            // String estático con componentes dinámicos (gets)
//            String consultaSQL = "INSERT INTO reservas (res_fechaRetiro, res_fechaReserva,res_fechaDevolucion, est_id) VALUES (?, NOW(), ?,?);";
//            ejecutar = (com.mysql.jdbc.PreparedStatement) connection.prepareCall(consultaSQL);
//            ejecutar.setString(1, r.getFechaRetiro());
//            ejecutar.setString(2, r.getFechaDevolucion());
//            ejecutar.setInt(3, r.getIdEstudiante());
//            int resultado = ejecutar.executeUpdate();
//            // Ejecuta
//            if (resultado > 0) {
//                System.out.println("La reserva ha sido creada con éxito");
//            } else {
//                System.out.println("Favor ingresar correctamente los datos solicitados");
//            }
//            ejecutar.close();
//        } catch (SQLException e) {
//            // Captura el error y permite que la consola siga ejecutándose
//            System.out.println("ERROR: " + e.getMessage());
//        }
//    }

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
