package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Reserva;
import java.sql.SQLException;
import modelo.DetalleReserva;
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
        String consultaSQL = "INSERT INTO Reservas (res_fechaRetiro, res_fechaReserva, res_fechaDevolucion,res_estado, est_id) VALUES (?, NOW(), ?,?);";
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
    
    public void crearDetReserva(int idReserva, ArrayList<Ejemplar> listaEjemplares) {
    try {
        // Iterar sobre la lista de ejemplares para insertarlos en la tabla Detalles_reservas
        for (Ejemplar ejemplar : listaEjemplares) {
            String consultaEjemplar = "INSERT INTO detalles_reservas(res_id,eje_id) VALUES (?, ?);";
            PreparedStatement Ejemplar = connection.prepareStatement(consultaEjemplar);
            Ejemplar.setInt(1, idReserva); // Usar el id de la reserva pasada como parámetro
            Ejemplar.setInt(2, ejemplar.getIdEjemplar()); // Asumiendo que Ejemplar tiene un método getId()
            Ejemplar.executeUpdate();
            Ejemplar.close(); // Cerrar el PreparedStatement después de cada inserción
        }

        System.out.println("Los detalles de la reserva han sido insertados con éxito.");
    } catch (SQLException e) {
        System.out.println("ERROR al insertar los detalles de la reserva: " + e.getMessage());
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
    public void obtenerReservasPendientes() {
    ArrayList<DetalleReserva> reservasPendientes = new ArrayList<>();

    try {
        String consulta = "SELECT l.lib_titulo AS Titulo, " +
                          "e.eje_codigoEjem AS CodigoEjemplar, " +
                          "CONCAT(a.aut_nombres, ' ', a.aut_apellidos) AS Autor, " +
                          "l.lib_isbn AS ISBN, " +
                          "r.res_fechaReserva AS FechaReserva, " +
                          "r.res_estado AS EstadoReserva " +
                          "FROM Reservas r " +
                          "JOIN Detalles_reservas dr ON r.res_id = dr.res_id " +
                          "JOIN Ejemplares e ON dr.eje_id = e.eje_id " +
                          "JOIN Libros l ON e.lib_id = l.lib_id " +
                          "JOIN Autores a ON l.aut_id = a.aut_id " +
                          "WHERE r.res_estado = 'Pendiente' " +
                          "ORDER BY r.res_fechaReserva ASC";

        PreparedStatement statement = connection.prepareStatement(consulta);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            DetalleReserva reserva = new DetalleReserva();
            reserva.setTitulo(rs.getString("Titulo"));
            reserva.setCodigoEjemplar(rs.getString("CodigoEjemplar"));
            reserva.setAutor(rs.getString("Autor"));
            reserva.setIsbn(rs.getString("ISBN"));
            reserva.setFechaReserva(rs.getString("FechaReserva"));
            reserva.setEstadoReserva(rs.getString("EstadoReserva"));
            reservasPendientes.add(reserva);
        }

        rs.close(); // Cerrar ResultSet
        statement.close(); // Cerrar PreparedStatement

        System.out.println("Reservas pendientes obtenidas con éxito.");

    } catch (SQLException e) {
        System.out.println("ERROR al obtener las reservas pendientes: " + e.getMessage());
    }
    
    // Aquí puedes retornar la lista o procesarla según lo necesites
    // return reservasPendientes;
}
}
