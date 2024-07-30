package Controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import controlador.ConexionBDD;
//import static java.awt.Event.INSERT;
import java.sql.ResultSet;
import modelo.Estudiante;

/**
 *
 * @author david
 */
public class EstudianteControlador {

    // ATRIBUTO DEL MODELO
    private Estudiante estudiante;
    //CONEXION 
    ConexionBDD conexion = new ConexionBDD();
    Connection connection = (Connection) conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    // INSERTAR FILAS EN UNA TABLA
    public void crearPersona(Estudiante est) {
        try {// EXCEPCION QUE LANZA LA CONSULATA
            String consultaSQL = "insert into estudiante(est_nombres,est_apellidos,est_usuario,est_contraseña,est_cedula,est_fechaNace,est_direccion,est_telefono,est_correoInstitucional, est_sexo,est_carreraCursando,est_numMatricula,est_nivelCursando)values('"+est.getNombres()+"','"+est.getApellidos()+"','"+est.getUsuario()+"','"+est.getContraseña()+"','"+est.getCedula()+"','"+est.getFechaNace()+"','"+est.getDireccion()+"',"+est.getTelefono()+",'"+est.getCorreoInstitucional()+"','"+est.getSexo()+"','"+est.getCarreraCursando()+"','"+est.getNumMatricula()+"',"+est.getNivelCursando()+");";
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
