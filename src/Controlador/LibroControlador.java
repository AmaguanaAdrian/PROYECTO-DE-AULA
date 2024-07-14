/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Autor;
import modelo.Genero;
import modelo.Libro;
/**
 *
 * @author USER
 */

public class LibroControlador {
    // Configuración de conexión a la base de datos
    private String url = "jdbc:mysql://localhost:3306/libros_bd";
    private String usuario = "root";
    private String contraseña = "1005336308";

    // Constructor que inicializa la configuración de conexión
    public LibroControlador(String url, String usuario, String contraseña) {
        this.url = url;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    // Método para crear un autor en la base de datos
    public void crearAutor(Autor autor) {
        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña)) {
            String consultaSQL = "INSERT INTO autor (idAutor, premiosReconocimientos) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) {
                stmt.setInt(1, autor.getIdAutor());
                stmt.setString(2, autor.getPremiosReconocimientos());

                int res = stmt.executeUpdate();
                if (res > 0) {
                    System.out.println("Autor creado con éxito");
                } else {
                    System.out.println("Error al crear el autor");
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // Método para crear un género en la base de datos
    public void crearGenero(Genero genero) {
        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña)) {
            String consultaSQL = "INSERT INTO genero (idGenero, nombGenero) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) {
                stmt.setInt(1, genero.getIdGenero());
                stmt.setString(2, genero.getNombGenero());

                int res = stmt.executeUpdate();
                if (res > 0) {
                    System.out.println("Género creado con éxito");
                } else {
                    System.out.println("Error al crear el género");
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // Método para crear un libro en la base de datos
    public void crearLibro(Libro libro) {
        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña)) {
            String consultaSQL = "INSERT INTO libro (titulo, idAutor, isbn, anioPublicacion, estado, cantidadDisponible, idGenero) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(consultaSQL)) {
                stmt.setString(1, libro.getTitulo());
                stmt.setInt(2, libro.getAutor().getIdAutor());
                stmt.setString(3, libro.getIsbn());
                stmt.setInt(4, libro.getAnioPublicacion());
                stmt.setString(5, libro.getEstado());
                stmt.setInt(6, libro.getCantidadDisponible());
                stmt.setInt(7, libro.getGenero().getIdGenero());

                int res = stmt.executeUpdate();
                if (res > 0) {
                    System.out.println("El libro ha sido creado con éxito");
                } else {
                    System.out.println("Error al crear el libro");
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
