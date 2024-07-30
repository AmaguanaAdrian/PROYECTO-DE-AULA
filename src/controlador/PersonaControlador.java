/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import modelo.Usuario;

/**
 *
 * @author david
 */
public class PersonaControlador {
    private Usuario persona;
    
    //CONEXION 
    ConexionBDD conexion = new ConexionBDD();
    Connection connection = (Connection) conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;
    
    public void crearPersona(Usuario p){
        try {
            String consultaSQL="insert into personas(per_nombres,per_apellidos,per_usuario,per_contraseña,per_cedula,per_fechaNace,per_direccion,per_telefono,per_correoInstitucional\n" +
",per_sexo)values('"+p.getNombres()+"','"+p.getApellidos()+"','"+p.getUsuario()+"','"+p.getContraseña()+"','"+p.getCedula()+"','"+p.getFechaNace()+"','"+p.getDireccion()+"',"+p.getTelefono()+",'"+p.getCorreoInstitucional()+"','"+p.getSexo()+"');";
            ejecutar=(PreparedStatement)connection.prepareCall(consultaSQL);
            int respuesta=ejecutar.executeUpdate();
            if(respuesta >0){
                System.out.println("Persona creada con exito");
            }else{
                System.out.println("Ingrese datos correctos");
            }
        } catch (Exception e) {
            System.out.println("Error1"+e);
        }
    
    }
    public int buscarPersona(int cedula){
        try {
            String consultaSQL="select per_id from personas where per_cedula="+cedula+";";
            ejecutar=(PreparedStatement)connection.prepareCall(consultaSQL);
            resultado=ejecutar.executeQuery();
            if(resultado.next()){
                int idPersona=resultado.getInt("per_id");
                return idPersona;
               }else{
                System.out.println("Ingrese datos correctos");
            }
        } catch (Exception e) {
            System.out.println("Error1"+e);
        }
        return 0;
    
    }
    
}
