/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author USER
 */
public class ReservaControlador {
    // Conexión
    Conexion conexion = new Conexion();
    Connection connection = conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;
    // Método para crear una reserva
    public void crearReserva(Reserva r) {
        try {
            // String estático con componentes dinámicos (gets)
            String consultaSQL = "INSERT INTO Reserva (est_id, res_fechaRetiro, res_fechaReserva, res_fechaDevolucion) VALUES (" + r.getIdEstudiante() + ", '" + r.getFechaRetiro() + "', '" + r.getFechaReserva() + "', '" + r.getFechaDevolucion() + "');";
            PreparedStatement ejecutar = connection.prepareCall(consultaSQL);
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
            if (resultado.next()) {
                r.setIdReserva(resultado.getInt("res_id"));
                r.setIdEstudiante(resultado.getInt("est_id"));
                r.setFechaRetiro(resultado.getString("res_fechaRetiro"));
                r.setFechaReserva(resultado.getString("res_fechaReserva"));
                r.setFechaDevolucion(resultado.getString("res_fechaDevolucion"));
            } else {
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
            while (resultado.next()) {
                Reserva r = new Reserva();
                r.setIdReserva(resultado.getInt("res_id"));
                r.setIdEstudiante(resultado.getInt("est_id"));
                r.setFechaRetiro(resultado.getString("res_fechaRetiro"));
                r.setFechaReserva(resultado.getString("res_fechaReserva"));
                r.setFechaDevolucion(resultado.getString("res_fechaDevolucion"));
                listaReservas.add(r);
            }
            ejecutar.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return listaReservas;
    }
}
