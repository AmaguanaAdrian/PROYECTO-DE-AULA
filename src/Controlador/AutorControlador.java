package Controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Autor;
public class AutorControlador {
    private Connection connection;
    private PreparedStatement ejecutar;
    private ResultSet resultado;

    public AutorControlador() {
        ConexionBDD conexion = new ConexionBDD();
        connection = conexion.conectar();
    }

    // Crear un nuevo autor y devolver su ID
    public int crearAutorYObtenerId(Autor A) {
        String consultaSQL = "INSERT INTO Autores (aut_nombres, aut_apellidos, aut_fechaNace) VALUES (?, ?, ?);";
        try {
            ejecutar = connection.prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            ejecutar.setString(1, A.getNombres());
            ejecutar.setString(2, A.getApellidos());
            ejecutar.setString(3, A.getFechaNace());
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                resultado = ejecutar.getGeneratedKeys();
                if (resultado.next()) {
                    System.out.println("El Autor ha sido creado con éxito");
                    return resultado.getInt(1); // Devuelve el ID generado
                }
            } else {
                System.out.println("Favor ingresar correctamente los datos solicitados");
            }
        } catch (Exception e) {
            System.out.println("ERROR al crear autor: " + e);
        } finally {
            cerrarRecursos();
        }
        return -1; // En caso de error, devolver -1
    }

    // Obtener el ID del autor dado su nombre
    public int obtenerIdAutor(String nombre) {
        String consultaSQL = "SELECT aut_id FROM Autores WHERE aut_nombres = ?;";
        try {
            ejecutar = connection.prepareStatement(consultaSQL);
            ejecutar.setString(1, nombre);
            resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                return resultado.getInt("aut_id");
            } else {
                System.out.println("No se encontró un autor con ese nombre.");
                return -1;
            }
        } catch (Exception e) {
            System.out.println("ERROR al obtener el ID del autor: " + e);
            return -1;
        } finally {
            cerrarRecursos();
        }
    }

    // Buscar autor por nombre
    public Autor buscarDatosAutor(String nombre) {
        Autor A = new Autor();
        String consultaSQL = "SELECT aut_nombres, aut_apellidos, aut_fechaNace FROM Autores WHERE aut_nombres = ?;";
        try {
            ejecutar = connection.prepareStatement(consultaSQL);
            ejecutar.setString(1, nombre);
            resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                A.setNombres(resultado.getString("aut_nombres"));
                A.setApellidos(resultado.getString("aut_apellidos"));
                A.setFechaNace(resultado.getString("aut_fechaNace"));
            } else {
                System.out.println("Ingrese un nombre válido");
            }
        } catch (Exception e) {
            System.out.println("ERROR Buscar autor: " + e);
        } finally {
            cerrarRecursos();
        }
        return A;
    }

    // Listar todos los autores
    public ArrayList<Autor> listarAutores() {
        ArrayList<Autor> listarAutores = new ArrayList<>();
        String consultaSQL = "SELECT aut_id, aut_nombres, aut_apellidos, aut_fechaNace FROM Autores;";
        try {
            ejecutar = connection.prepareStatement(consultaSQL);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                Autor A = new Autor();
                A.setIdAutor(resultado.getInt("aut_id"));
                A.setNombres(resultado.getString("aut_nombres"));
                A.setApellidos(resultado.getString("aut_apellidos"));
                A.setFechaNace(resultado.getString("aut_fechaNace"));
                listarAutores.add(A);
            }
        } catch (Exception e) {
            System.out.println("ERROR listar autores: " + e);
        } finally {
            cerrarRecursos();
        }
        return listarAutores;
    }

    // Listar autores por nombre
    public ArrayList<Autor> listarAutorPorNombre(String nombre) {
        ArrayList<Autor> listarAutores = new ArrayList<>();
        String consultaSQL = "SELECT aut_nombres, aut_apellidos, aut_fechaNace FROM Autores WHERE aut_nombres = ?;";
        try {
            ejecutar = connection.prepareStatement(consultaSQL);
            ejecutar.setString(1, nombre);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                Autor A = new Autor();
                A.setNombres(resultado.getString("aut_nombres"));
                A.setApellidos(resultado.getString("aut_apellidos"));
                A.setFechaNace(resultado.getString("aut_fechaNace"));
                listarAutores.add(A);
            }
        } catch (Exception e) {
            System.out.println("ERROR listar autores: " + e);
        } finally {
            cerrarRecursos();
        }
        return listarAutores;
    }

    // Cerrar recursos
    private void cerrarRecursos() {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (ejecutar != null) {
                ejecutar.close();
            }
        } catch (Exception e) {
            System.out.println("ERROR al cerrar recursos: " + e);
        }
    }
}

//public class AutorControlador {
//    private Connection connection;
//    private PreparedStatement ejecutar;
//    private ResultSet resultado;
//
//    public AutorControlador() {
//        ConexionBDD conexion = new ConexionBDD();
//        connection = conexion.conectar();
//    }
//
//    // Crear un nuevo autor
//    public void crearAutor(Autor A) {
//        String consultaSQL = "INSERT INTO Autores (aut_nombres, aut_apellidos, aut_fechaNace) VALUES (?, ?, ?);";
//        try {
//            ejecutar = connection.prepareStatement(consultaSQL);
//            ejecutar.setString(1, A.getNombres());
//            ejecutar.setString(2, A.getApellidos());
//            ejecutar.setString(3, A.getFechaNace());
//            int res = ejecutar.executeUpdate();
//            if (res > 0) {
//                System.out.println("El Autor ha sido creado con éxito");
//            } else {
//                System.out.println("Favor ingresar correctamente los datos solicitados");
//            }
//        } catch (Exception e) {
//            System.out.println("ERROR al crear autor: " + e);
//        } finally {
//            cerrarRecursos();
//        }
//    }
//
//    // Obtener el ID del autor dado su nombre
//    public int obtenerIdAutor(String nombre) {
//        String consultaSQL = "SELECT aut_id FROM Autores WHERE aut_nombres = ?;";
//        try {
//            ejecutar = connection.prepareStatement(consultaSQL);
//            ejecutar.setString(1, nombre);
//            resultado = ejecutar.executeQuery();
//            if (resultado.next()) {
//                return resultado.getInt("aut_id");
//            } else {
//                System.out.println("No se encontró un autor con ese nombre.");
//                return -1;
//            }
//        } catch (Exception e) {
//            System.out.println("ERROR al obtener el ID del autor: " + e);
//            return -1;
//        } finally {
//            cerrarRecursos();
//        }
//    }
//
//    // Buscar autor por nombre
//    public Autor buscarDatosAutor(String nombre) {
//        Autor A = new Autor();
//        String consultaSQL = "SELECT aut_nombres, aut_apellidos, aut_fechaNace FROM Autores WHERE aut_nombres = ?;";
//        try {
//            ejecutar = connection.prepareStatement(consultaSQL);
//            ejecutar.setString(1, nombre);
//            resultado = ejecutar.executeQuery();
//            if (resultado.next()) {
//                A.setNombres(resultado.getString("aut_nombres"));
//                A.setApellidos(resultado.getString("aut_apellidos"));
//                A.setFechaNace(resultado.getString("aut_fechaNace"));
//            } else {
//                System.out.println("Ingrese un nombre válido");
//            }
//        } catch (Exception e) {
//            System.out.println("ERROR Buscar autor: " + e);
//        } finally {
//            cerrarRecursos();
//        }
//        return A;
//    }
//
//    // Listar todos los autores
//    public ArrayList<Autor> listarAutores() {
//        ArrayList<Autor> listarAutores = new ArrayList<>();
//        String consultaSQL = "SELECT aut_nombres, aut_apellidos, aut_fechaNace FROM Autores;";
//        try {
//            ejecutar = connection.prepareStatement(consultaSQL);
//            resultado = ejecutar.executeQuery();
//            while (resultado.next()) {
//                Autor A = new Autor();
//                A.setNombres(resultado.getString("aut_nombres"));
//                A.setApellidos(resultado.getString("aut_apellidos"));
//                A.setFechaNace(resultado.getString("aut_fechaNace"));
//                listarAutores.add(A);
//            }
//        } catch (Exception e) {
//            System.out.println("ERROR al listar autores: " + e);
//        } finally {
//            cerrarRecursos();
//        }
//        return listarAutores;
//    }
//
//    // Actualizar información de un autor
//    public void actualizarAutor(Autor A, String nombre) {
//        String consultaSQL = "UPDATE Autores SET aut_nombres = ?, aut_apellidos = ?, aut_fechaNace = ? WHERE aut_nombres = ?;";
//        try {
//            ejecutar = connection.prepareStatement(consultaSQL);
//            ejecutar.setString(1, A.getNombres());
//            ejecutar.setString(2, A.getApellidos());
//            ejecutar.setString(3, A.getFechaNace());
//            ejecutar.setString(4, nombre);
//            int res = ejecutar.executeUpdate();
//            if (res > 0) {
//                System.out.println("Actualización exitosa");
//            } else {
//                System.out.println("Revise datos del autor que desea actualizar");
//            }
//        } catch (Exception e) {
//            System.out.println("ERROR al actualizar información: " + e);
//        } finally {
//            cerrarRecursos();
//        }
//    }
//
//    // Eliminar autor por nombre
//    public void eliminarAutor(String nombre) {
//        String consultaSQL = "DELETE FROM Autores WHERE aut_nombres = ?;";
//        try {
//            ejecutar = connection.prepareStatement(consultaSQL);
//            ejecutar.setString(1, nombre);
//            int res = ejecutar.executeUpdate();
//            if (res > 0) {
//                System.out.println("Autor eliminado con éxito");
//            } else {
//                System.out.println("No se pudo eliminar el autor. Verifique el nombre ingresado.");
//            }
//        } catch (Exception e) {
//            System.out.println("ERROR al eliminar autor: " + e.getMessage());
//        } finally {
//            cerrarRecursos();
//        }
//    }
//
//    // Método para cerrar recursos
//    private void cerrarRecursos() {
//        try {
//            if (resultado != null) resultado.close();
//            if (ejecutar != null) ejecutar.close();
//        } catch (Exception e) {
//            System.out.println("ERROR al cerrar recursos: " + e);
//        }
//    }
//}


//public class AutorControlador { 
//    ConexionBDD conexion = new ConexionBDD();
//    Connection connection = (Connection) conexion.conectar();
//    PreparedStatement ejecutar;
//    ResultSet resultado;
//
//    public void crearAutor(Autor A) {
//        try {
//            String consultaSQL = "INSERT INTO Autores(aut_nombres,aut_apellidos,aut_fechaNace)VALUES(?,?,?);";
//            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
//            ejecutar.setString(1, A.getNombres());
//            ejecutar.setString(2, A.getApellidos());
//            ejecutar.setString(3, A.getFechaNace());
//            int res = ejecutar.executeUpdate();
//            if (res > 0) {
//                System.out.println("El Autor ha sido creado con éxito");
//            } else {
//                System.out.println("Favor ingresar correctamente los datos solicitados");
//            }
//            ejecutar.close();
//        } catch (Exception e) {
//            System.out.println("ERROR1: " + e);
//        }
//    }
//
//    // BUSCAR AUTOR POR NOMBRE
//    public String buscarAutor(String nombre) {
//        try {
//            String consultaSQL = "SELECT aut_nombres from Autores where aut_nombres=?;"; 
//            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
//            ejecutar.setString(1, nombre);
//            resultado = ejecutar.executeQuery();
//            if (resultado.next()) {
//                String aut_nombre = resultado.getString("aut_nombres");
//                return aut_nombre;
//            } else {
//            }
//                System.out.println("Ingrese un nombre válido");
//                return null;
//        } catch (Exception e) {
//            System.out.println("Comuníquese con el administrador para el error: " + e);
//            return null;
//
//        }
//
//    }
//
//    // LISTAR TODOS LOS AUTORES
//    public ArrayList<Autor> listarAutores() {
//        ArrayList<Autor> listarAutores = new ArrayList<>();
//        try {
//            String consultaSQL = "SELECT  aut_nombres,aut_apellidos, aut_fechaNace from Autores;";
//            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
//            resultado = ejecutar.executeQuery();
//            while (resultado.next()) {
//                Autor A = new Autor();
//                A.setNombres(resultado.getString("aut_nombres"));
//                A.setApellidos(resultado.getString("aut_apellidos"));
//                A.setFechaNace(resultado.getString("aut_fechaNace"));
//                listarAutores.add(A);
//            }
////            resultado.close();
//        } catch (Exception e) {
//            System.out.println("ERROR: " + e);
//        }
//        return listarAutores;
//    }
//
//    // ACTUALIZAR INFORMACIÓN
//    public void actualizarAutor(Autor A, String nombre) {
//        try {
//            String consultaSQL = "UPDATE autores SET aut_nombres=?,aut_apellidos =?, aut_fechaNace =? WHERE aut_nombres =?;";
//            if (connection == null || connection.isClosed()) {
//                System.out.println("La conexión a la base de datos no es válida");
//                return;
//            }
//            PreparedStatement ejecutar = (PreparedStatement) connection.prepareStatement(consultaSQL);
//            ejecutar.setString(1, A.getNombres());
//            ejecutar.setString(2, A.getApellidos());
//            ejecutar.setString(3, A.getFechaNace());
//            ejecutar.setString(4, nombre);
//            int res = ejecutar.executeUpdate();
//            if (res > 0) {
//                System.out.println("Actualización exitosa");
//            } else {
//                System.out.println("Revise datos del autor que desea actualizar");
//            }
//            ejecutar.close();
//        } catch (Exception e) {
//            System.out.println("ERROR actualizar informacion: " + e);
//        }
//    }
//
//    // BUSCAR DATOS DE UN AUTOR POR NOMBRE
//    public Autor buscarDatosAutor(String nombre) {
//        Autor A = new Autor();
//        try {
//            String consultaSQL = "SELECT  aut_nombres,aut_apellidos, aut_fechaNace FROM Autores WHERE aut_nombres = ?;";
//            ejecutar = (PreparedStatement) connection.prepareCall(consultaSQL);
//            ejecutar.setString(1, nombre);
//            resultado = ejecutar.executeQuery();
//            if (resultado.next()) {
//                A.setNombres(resultado.getString("aut_nombres"));
//                A.setApellidos(resultado.getString("aut_apellidos"));
//                A.setFechaNace(resultado.getString("aut_fechaNace"));
//                resultado.close();
//                return A;
//            } else {
//                System.out.println("Ingrese un nombre válido");
//                resultado.close();
//            }
//        } catch (Exception e) {
//            System.out.println("ERROR Buscar autor: " + e);
//        }
//        return A;
//    }
//
//    // ELIMINAR AUTOR POR NOMBRE
//    public void eliminarAutor(String nombre) {
//        try {
//            String consultaSQL = "DELETE FROM Autores WHERE aut_nombres = ?;";
//            ejecutar =(PreparedStatement) connection.prepareStatement(consultaSQL);
//            ejecutar.setString(1, nombre);
//            int res = ejecutar.executeUpdate();
//            if (res > 0) {
////                ejecutar.close();
//                System.out.println("Autor eliminado con éxito");
//            } else {
//                System.out.println("No se pudo eliminar el autor. Verifique el nombre ingresado.");
//            }
//            
////            connection.close(); 
//        } catch (Exception e) {
//            System.out.println("Error al eliminar autor: " + e.getMessage());
//        }
//    }
//    
//
//}