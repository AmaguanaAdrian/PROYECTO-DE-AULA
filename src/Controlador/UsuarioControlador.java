package controlador;

import Controlador.ConexionBDD;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import modelo.Usuario;

/**
 *
 * @author david
 */
public class UsuarioControlador {
    Usuario usu=new Usuario();
    
    //CONEXION 
    ConexionBDD conexion = new ConexionBDD();
    java.sql.Connection connection = conexion.conectar();
    java.sql.PreparedStatement ejecutar;
    ResultSet resultado;
   
    
    public void crearPersona(Usuario p){
        try {// EXCEPCION QUE LANZA LA CONSULATA
            String consultaSQL= "INSERT INTO usuarios( usu_nombres,usu_apellidos,usu_clave,usu_cedula,usu_direccion,usu_telefono,usu_correolnstitucional,usu_rol)VALUES('"+usu.getNombres()+"','"+usu.getApellidos()+"','"+usu.getClave()+"','"+usu.getCedula()+"','"+usu.getDireccion()+"',"+usu.getTelefono()+",'"+usu.getCorreoInstitucional()+"', "+usu.getRol()+");";
            ejecutar=(PreparedStatement)connection.prepareCall(consultaSQL);
            int res=ejecutar.executeUpdate();// utilizo un int cuando ingreso datos en la bdd
            if (res>0){
                System.out.println("La persona ha sido creada con exito");
                // CERRAR CONSULTA
                ejecutar.close();
            }else{
                System.out.println("Por favor ingrese correctamente los datos solicitados");
                ejecutar.close();
            }
        } catch (Exception e) {
            //captura el error y permite que la consola se siga ejecuntando
            System.out.println("Error1"+ e);
        }
    }
    // cualquier consulta a bdd hacia el bakend un resultset
    public int buscarIdUsuario(String cedula){
        try {
            String consultaSQL="select usu_id from usuarios where cedula='"+cedula+"';";
            ejecutar =(PreparedStatement)connection.prepareCall(cedula);
            ejecutar=(PreparedStatement)connection.prepareCall(consultaSQL);
            resultado=ejecutar.executeQuery();
            if (resultado.next()){
                int idUsuario = resultado.getInt("idUsuario");
                return idUsuario;
            }else {
                System.out.println("Ingrese una cedula valida");
                ejecutar.close();
            }
            
        } catch (Exception e) {
            System.out.println("Error2, comuniquese con el administrador"+e);
        }
        return 0;
    }
    
    
}
