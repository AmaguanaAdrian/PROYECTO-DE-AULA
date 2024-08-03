package controlador;
import Controlador.ConexionBDD;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import modelo.Autor;

/**
 *
 * @author
 */
public class AutorControlador {

    private Autor A;
    
    ConexionBDD conexion = new ConexionBDD();
    Connection connection = (Connection) conexion.conectar();
    PreparedStatement ejecutar;
    ResultSet resultado;

    public void crearAutor(Autor A) {
        try {
            String consultaSQL = "INSERT INTO Autores(aut_nombres,aut_apellidos,aut_fechaNace)VALUES(?,?,?);";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, A.getNombres());
            ejecutar.setString(2, A.getApellidos());
            ejecutar.setString(3, A.getFechaNace());
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                System.out.println("El Autor ha sido creado con éxito");
            } else {
                System.out.println("Favor ingresar correctamente los datos solicitados");
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR1: " + e);
        }
    }

    // BUSCAR AUTOR POR NOMBRE
    public String buscarAutor(String nombre) {
        try {
            String consultaSQL = "SELECT aut_nombres from Autores where aut_nombres=?;"; 
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, nombre);
            resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                String aut_nombre = resultado.getString("aut_nombres");
                return aut_nombre;
            } else {
            }
                System.out.println("Ingrese un nombre válido");
                return null;
        } catch (Exception e) {
            System.out.println("Comuníquese con el administrador para el error: " + e);
            return null;

        }

    }

    // LISTAR TODOS LOS AUTORES
    public ArrayList<Autor> listarAutores() {
        ArrayList<Autor> listarAutores = new ArrayList<>();
        try {
            String consultaSQL = "SELECT  aut_nombres,aut_apellidos, aut_fechaNace from Autores;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                Autor A = new Autor();
                A.setNombres(resultado.getString("aut_nombres"));
                A.setApellidos(resultado.getString("aut_apellidos"));
                A.setFechaNace(resultado.getString("aut_fechaNace"));
                listarAutores.add(A);
            }
//            resultado.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return listarAutores;
    }

    // ACTUALIZAR INFORMACIÓN
    public void actualizarAutor(Autor A, String nombre) {
        try {
            String consultaSQL = "UPDATE autores SET aut_nombres=?,aut_apellidos =?, aut_fechaNace =? WHERE aut_nombres =?;";
            if (connection == null || connection.isClosed()) {
                System.out.println("La conexión a la base de datos no es válida");
                return;
            }
            PreparedStatement ejecutar = (PreparedStatement) connection.prepareStatement(consultaSQL);
            ejecutar.setString(1, A.getNombres());
            ejecutar.setString(2, A.getApellidos());
            ejecutar.setString(3, A.getFechaNace());
            ejecutar.setString(4, nombre);
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                System.out.println("Actualización exitosa");
            } else {
                System.out.println("Revise datos del autor que desea actualizar");
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR actualizar informacion: " + e);
        }
    }

    // BUSCAR DATOS DE UN AUTOR POR NOMBRE
    public Autor buscarDatosAutor(String nombre) {
        Autor A = new Autor();
        try {
            String consultaSQL = "SELECT  aut_nombres,aut_apellidos, aut_fechaNace FROM Autores WHERE aut_nombres = ?;";
            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
            ejecutar.setString(1, nombre);
            resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                A.setNombres(resultado.getString("aut_nombres"));
                A.setApellidos(resultado.getString("aut_apellidos"));
                A.setFechaNace(resultado.getString("aut_fechaNace"));
                resultado.close();
                return A;
            } else {
                System.out.println("Ingrese un nombre válido");
                resultado.close();
            }
        } catch (Exception e) {
            System.out.println("ERROR Buscar autor: " + e);
        }
        return A;
    }

    // ELIMINAR AUTOR POR NOMBRE
    public void eliminarAutor(String nombre) {
        try {
            String consultaSQL = "DELETE FROM Autores WHERE aut_nombres = ?;";
            ejecutar =(PreparedStatement) connection.prepareStatement(consultaSQL);
            ejecutar.setString(1, nombre);
            int res = ejecutar.executeUpdate();
            if (res > 0) {
//                ejecutar.close();
                System.out.println("Autor eliminado con éxito");
            } else {
                System.out.println("No se pudo eliminar el autor. Verifique el nombre ingresado.");
            }
            
//            connection.close(); 
        } catch (Exception e) {
            System.out.println("Error al eliminar autor: " + e.getMessage());
        }
    }

}