/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
/**
 *
 * @author USER
 */
import Controlador.LibroControlador;
import modelo.Autor;
import modelo.Genero;
import modelo.Libro;

public class main {
    public static void main(String[] args) {
        // Configurar datos de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/libros_db";
        String usuario = "root";
        String contraseña = "1005336308KA";

        // Crear instancia del controlador
        LibroControlador libroControlador = new LibroControlador(url, usuario, contraseña);

        // Ejemplo de creación de Autor y Género
        Autor autor = new Autor(123, "Premioss de Literatura");
        Genero genero = new Genero(23, "Ciencia Ficción");

        // Insertar Autor y Género en la base de datos
        libroControlador.crearAutor(autor);
        libroControlador.crearGenero(genero);

        // Ejemplo de creación de un libro asociado al Autor y Género creados
        Libro libro = new Libro(67, "El del Viento", autor, "12345678923", 2007, "Disponible", 5, genero);

        // Insertar el libro en la base de datos
        libroControlador.crearLibro(libro);
    }
}
