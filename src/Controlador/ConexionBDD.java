package Controlador;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class ConexionBDD {

    java.sql.Connection conexion;

    public java.sql.Connection conectar() {
        //LANZAR CÓDIGO DE PRUEBA 
        try {
            //Manera de Conexión a la Base de Datos
            Class.forName("com.mysql.jdbc.Driver");
            //Parámetros de conexión url/usuario/clave en mysql
//            Adrian_branch
//          conexion=DriverManager.getConnection("jdbc:mysql://localhost/proyecto2?autoReconnect=true&useSSL=false","root","1005336308KA");
//            System.out.println("CONECTADO"); 
//            DavidF_branch
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/proyecto2?autoReconnect=true&useSSL=false", "root", "1002010");
////            System.out.println("CONECTADO"); 
        } catch (ClassNotFoundException | SQLException e)//CAPTURAR ERRORES 
        {
            System.out.println("ERROR DE CONEXION A LA BASE DE DATOS"+e);
        }
        return conexion;
    }

}
