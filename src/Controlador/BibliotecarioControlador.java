/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
/**
 *
 * @author USER
 */
import controlador.ConexionBDD;
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
            String consultaSQL = "INSERT INTO Bibliotecario (bib_idPersona, bib_nombres, bib_apellidos, bib_usuario, bib_contraseña, bib_cedula, bib_fechaNace, bib_direccion, bib_telefono, bib_correoInstitucional, bib_sexo, bib_puesto, bib_horario) VALUES ('" + b.getNombres() + "', '" + b.getApellidos() + "', '" + b.getUsuario() + "', '" + b.getClave() + "', '" + b.getCedula() + "', '" + b.getFechaNace() + "', '" + b.getDireccion() + "', " + b.getTelefono() + ", '" + b.getCorreoInstitucional() + "', '" + b.getSexo() + "', '" + b.getPuesto() + "', " + b.getHorario() + ");";
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
