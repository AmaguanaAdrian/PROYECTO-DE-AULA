package Controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
//import static java.awt.Event.INSERT;
import java.sql.ResultSet;
import modelo.Estudiante;

/**
 *
 * @author david
 */
public class EstudianteControlador {
    //CONEXION 
   ConexionBDD conexion = new ConexionBDD();
    java.sql.Connection connection = conexion.conectar();
    java.sql.PreparedStatement ejecutar;

    // INSERTAR FILAS EN UNA TABLA
    public void crearPersona(Estudiante est) {
        try {// EXCEPCION QUE LANZA LA CONSULATA
            String consultaSQL = "INSERT INTO estudiantes (numeroMatricula,jornada,idpersona) VALUES ('"+est.getNumMatricula()+"','matutina',"+est.getIdUsuario()+");";
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
        } catch (Exception e) {
            //captura el error y permite que la consola se siga ejecuntando
            System.out.println("Error" + e);
        }
    }
   
}
