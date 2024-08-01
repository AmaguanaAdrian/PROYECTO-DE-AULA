/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import modelo.Estudiante;

/**
 *
 * @author USER
 */
public class EstudianteControlador {
    //CONEXION 
   ConexionBDD conexion = new ConexionBDD();
    java.sql.Connection connection = conexion.conectar();
    java.sql.PreparedStatement ejecutar;

    // INSERTAR FILAS EN UNA TABLA
    public void crearUsuario(Estudiante est) {
        try {// EXCEPCION QUE LANZA LA CONSULATA
            String consultaSQL = "INSERT INTO estudiantes (est_carreraCursando,est_numMatricula,est_nivelCursando,usu_id) VALUES ('"+est.getCarreraCursando()+"','"+est.getNumMatricula()+"',"+est.getNivelCursando()+","+est.getIdUsuario()+");";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            // DAR CLIC EN EL PLAY (ejecutar la consulta)
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                System.out.println("La persona ha sido creada con exito");
                // CERRAR CONSULTA
                ejecutar.close();
            } else {
                System.out.println("Por favor ingrese correctamente los datos solicitados");
                ejecutar.close();
            }
        } catch (SQLException e) {
            //captura el error y permite que la consola se siga ejecuntando
            System.out.println("Error" + e);
        }
    }
   
}