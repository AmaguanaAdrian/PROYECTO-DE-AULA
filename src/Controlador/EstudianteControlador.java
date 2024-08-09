package Controlador;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import modelo.Estudiante;
import java.sql.ResultSet;

/**
 *
 * @author
 */
public class EstudianteControlador {

    //CONEXION 
    ConexionBDD conexion = new ConexionBDD();
    java.sql.Connection connection = conexion.conectar();
    java.sql.PreparedStatement ejecutar;
    ResultSet resultado;

    // INSERTAR FILAS EN UNA TABLA
    public void crearEstudiante(Estudiante est) {
        try {// EXCEPCION QUE LANZA LA CONSULATA
            String consultaSQL = "INSERT INTO estudiantes (est_carreraCursando,est_numMatricula,est_nivelCursando,usu_id) VALUES ('" + est.getCarreraCursando() + "','" + est.getNumMatricula() + "'," + est.getNivelCursando() + "," + est.getIdUsuario() + ");";
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
    public Estudiante buscarEstLog(String cedula, String clave) {
        Estudiante est = new Estudiante();
//        CarreraControlador carc = new CarreraControlador();
        try {
            String consultaSQL = "SELECT usu_nombres, "
                    + "usu_apellidos, usu_clave, "
                    + "usu_cedula, "
                    + "usu_direccion, "
                    + "usu_telefono, "
                    + "usu_correolnstitucional, "
                    + "usu_rol, est_carreraCursando, "
                    + "est_numMatricula, "
                    + "est_nivelCursando FROM usuarios u, estudiantes e "
                    + "where u.usu_rol=1 "
                    + "and u.usu_cedula='"+cedula+"';";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            
            resultado = ejecutar.executeQuery(consultaSQL);
            
            if (resultado.next()) {
                est.setNombres(resultado.getString("usu_nombres"));
                est.setApellidos(resultado.getString("usu_apellidos"));
                est.setCorreoInstitucional(resultado.getString("usu_correoInstituciional"));
                est.setDireccion(resultado.getString("usu_direccion"));
                est.setTelefono(resultado.getString("usu_telefono"));
                est.setCedula(cedula);
                est.setClave(clave);
                est.setRol(resultado.getInt("usu_rol"));
                est.setNumMatricula(resultado.getString("est_numerMatricula"));
                est.setNivelCursando(resultado.getInt("est_nivelCursando"));
                ejecutar.close();
                return est;
            } else {
                est.setCedula("0");
            }
            ejecutar.close();
            return est;
        } catch (Exception e) {
            System.out.println("¡ERROR EN EL SISTEMA! COMUNIQUESE CON EL ADMINISTRADOR\n"
                    + "PARA SOLUCIONAR SU PROBLEMA: " + e);
        }
        return est;
        
        
        
    }
    public int buscarIdEstudiante(String cedula) {
        try {
            String consultaSQL = "select est_id from usuarios u, estudiantes e where u.usu_id=e.usu_id and usu_cedula='"+cedula+"' and usu_rol=1;";
            
            ejecutar = (java.sql.PreparedStatement) connection.prepareCall(consultaSQL);
            resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                int idEstudiante = resultado.getInt("est_id");
                return idEstudiante;
            } else {
                System.out.println("Ingrese una cédula valida");
                ejecutar.close();
            }

        } catch (SQLException e) {
            System.out.println("Error2, comuniquese con el administrador" + e);
        }
        return 0;
    }
    

}
