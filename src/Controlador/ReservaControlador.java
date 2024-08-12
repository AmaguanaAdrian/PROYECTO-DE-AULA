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
import modelo.Libro;
import modelo.Usuario;
import java.sql.PreparedStatement;

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

    public int crearReserva(Reserva r) {
        int idReserva = 0;
        try {
            String consultaSQL = "INSERT INTO Reservas (res_fechaRetiro, res_fechaReserva, res_fechaDevolucion, res_estado, est_id) VALUES (?, NOW(), ?, ?, ?);";
            PreparedStatement ejecutar = connection.prepareStatement(consultaSQL);
            ejecutar.setString(1, r.getFechaRetiro());
            ejecutar.setString(2, r.getFechaDevolucion());
            ejecutar.setString(3, "Pendiente"); // Ejemplo de estado, ajusta según corresponda
            ejecutar.setInt(4, r.getIdEstudiante());

//            String consultaSQL = "INSERT INTO Reservas (res_fechaRetiro, res_fechaReserva, res_fechaDevolucion,res_estado, est_id) VALUES (?, NOW(), ?,?);";
//            PreparedStatement ejecutar = connection.prepareStatement(consultaSQL);
//            ejecutar.setString(1, r.getFechaRetiro());
//            ejecutar.setString(2, r.getFechaDevolucion());
//            ejecutar.setInt(3, r.getIdEstudiante());
            int resultado = ejecutar.executeUpdate();
            if (resultado > 0) {
                System.out.println("La reserva ha sido creada con éxito");

                String consultaID = "SELECT LAST_INSERT_ID();";
                PreparedStatement stmt = connection.prepareStatement(consultaID);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    idReserva = rs.getInt(1);
                }
            } else {
                System.out.println("Favor ingresar correctamente los datos solicitados");
            }
            ejecutar.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return idReserva;
    }

    // Método para crear los detalles de la reserva
    public void crearDetReserva(int idReserva, ArrayList<Ejemplar> listaEjemplares) {
        try {
            for (Ejemplar ejemplar : listaEjemplares) {
                if (ejemplar.getIdEjemplar() > 0) { // Verifica que el ID sea válido
                    String consultaEjemplar = "INSERT INTO Detalles_reservas (res_id, eje_id) VALUES (?, ?);";
                    com.mysql.jdbc.PreparedStatement stmtEjemplar = (com.mysql.jdbc.PreparedStatement) connection.prepareStatement(consultaEjemplar);
                    stmtEjemplar.setInt(1, idReserva);
                    stmtEjemplar.setInt(2, ejemplar.getIdEjemplar());
                    stmtEjemplar.executeUpdate();
                    stmtEjemplar.close();
                } else {
                    System.out.println("ID de ejemplar inválido: " + ejemplar.getIdEjemplar());
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR al insertar detalles de la reserva: " + e.getMessage());
        }
    }
//    
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
            String consulta = "SELECT l.lib_titulo AS Titulo, "
                    + "e.eje_codigoEjem AS CodigoEjemplar, "
                    + "CONCAT(a.aut_nombres, ' ', a.aut_apellidos) AS Autor, "
                    + "l.lib_isbn AS ISBN, "
                    + "r.res_fechaReserva AS FechaReserva, "
                    + "r.res_estado AS EstadoReserva "
                    + "FROM Reservas r "
                    + "JOIN Detalles_reservas dr ON r.res_id = dr.res_id "
                    + "JOIN Ejemplares e ON dr.eje_id = e.eje_id "
                    + "JOIN Libros l ON e.lib_id = l.lib_id "
                    + "JOIN Autores a ON l.aut_id = a.aut_id "
                    + "WHERE r.res_estado = 'Pendiente' "
                    + "ORDER BY r.res_fechaReserva ASC";

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

    public List<Reserva> buscarReservasPorCedula(String cedula) {
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            String consulta = "SELECT u.usu_nombres, u.usu_apellidos, r.res_fechaRetiro, r.res_fechaDevolucion, r.res_estado, eje.eje_codigoEjem, l.lib_titulo "
                    + "FROM usuarios u "
                    + "JOIN estudiantes e ON u.usu_id = e.usu_id "
                    + "JOIN reservas r ON e.est_id = r.est_id "
                    + "JOIN detalles_reservas dr ON r.res_id = dr.res_id "
                    + "JOIN ejemplares eje ON dr.det_id = eje.eje_id "
                    + "JOIN libros l ON eje.lib_id = l.lib_id "
                    + "WHERE u.usu_cedula = ?";

            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, cedula);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Reserva reserva = new Reserva();
                Usuario usu = new Usuario();
                Ejemplar eje = new Ejemplar();
                Libro lib = new Libro();
                usu.setNombres(rs.getString("usu_nombres"));
                usu.setApellidos(rs.getString("usu_apellidos"));
                reserva.setFechaRetiro(rs.getString("res_fechaRetiro"));
                reserva.setFechaDevolucion(rs.getString("res_fechaDevolucion"));
                eje.setEstado(rs.getBoolean("res_estado"));
                eje.setCodigoEjemplar(rs.getString("eje_codigoEjem"));
                lib.setTitulo(rs.getString("lib_titulo"));
                reservas.add(reserva);
            }

            System.out.println("Reservas encontradas con éxito.");

        } catch (SQLException e) {
            System.out.println("ERROR al buscar reservas por cédula: " + e.getMessage());
        }

        return reservas;
    }

    // Método para actualizar el estado de los ejemplares asociados a una reserva
    public void actualizarEstadoEjemplares(int idReserva, String estado) {
        try {
            String consulta = "UPDATE Ejemplares SET eje_estado = ? WHERE eje_id IN (SELECT dr.eje_id FROM Detalles_reservas dr WHERE dr.res_id = ?)";
            try (PreparedStatement ejecutar = connection.prepareStatement(consulta)) {
                ejecutar.setString(1, estado);
                ejecutar.setInt(2, idReserva);
                ejecutar.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("ERROR al actualizar estado de los ejemplares: " + e.getMessage());
        }
    }

    public void cambiarEstadoReserva(int idReserva, String estado) {
        try {
            String consulta = "UPDATE Reservas SET res_estado = ? WHERE res_id = ?";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, estado);
            statement.setInt(2, idReserva);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("ERROR al cambiar estado de la reserva: " + e.getMessage());
        }
    }

}
