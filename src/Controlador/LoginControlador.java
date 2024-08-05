package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class LoginControlador {
    public static int login(String cedula, String clave, Connection connection) {
        try {
            String query = "SELECT * FROM usuarios WHERE usu_cedula =? AND usu_clave =?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, cedula);
            pstmt.setString(2, clave);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int usuRol = rs.getInt("usu_rol");
                return usuRol;
            } else {
                return -1; // Usuario o contraseña incorrectos
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta SQL: " + e.getMessage());
            return -1; // Error en la consulta
        }
    }
}
