/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import modelo.Usuario;

/**
 *
 * @author USER
 */
public class PersonaControlador {
    //ATRIBUTOS
    //DEL MODELO
    private Usuario persona;
    //CONEXION
    Conexion conexion=new Conexion();
    Connection connection=(Connection)conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado; // consult.set
    
    //INSERTAR FILAS EN TABLA
    //Insetar filas en una tabla
    public void crearPersona(Usuario p){
        try {//exception que lanza la consulta
            //String estatico con componentes dinamicos(gets)
            String consultaSQL = "INSERT INTO personas(per_nombres, per_apellidos, per_usuario, per_clave, per_cedula, per_fechaNace, per_direccion, per_telefono, per_correoInstitucional, per_sexo) VALUES ('" + p.getNombres() + "', '" + p.getApellidos() + "','" + p.getClave() + "', '" + p.getCedula() + "', '" + p.getFechaNace() + "', '" + p.getDireccion() + "', " + p.getTelefono() + ", '" + p.getCorreoInstitucional() + "');";
            ejecutar=(PreparedStatement)connection.prepareCall(consultaSQL);
            //DAR CLICK EN EL PLAY EJECUTA LA CONSULTA
            int res=ejecutar.executeUpdate();
            if (res>0){
                System.out.println("La persona ha sido creada con éxito");
                ejecutar.close();
            }else{
                System.out.println("Favor ingresar correctamente los datos solicitados");
                ejecutar.close();
            }
        } catch (Exception e) {
           //captura el error y permite que la consola siga ejecuntadose
            //Ejecutando 
            System.out.println("ERROR:"+e);
        }
            
   }
    public int buscarIdPersona(String cedula){
        try {
            String consultaSQL = "SELECT idpersona FROM persona WHERE cedula='"+cedula+"';";
            ejecutar = (PreparedStatement)connection.prepareCall(consultaSQL);
            resultado = ejecutar.executeQuery();
            if(resultado.next()){
                int idPersona = resultado.getInt("idpersona");
                return idPersona;
            }else{
                System.out.println("Ingrese una cedula valida");
            }
        } catch (Exception e) {
            System.out.println("Comuniquese con el administrador para el error"+e);
        }
        return 0;
    }
}
