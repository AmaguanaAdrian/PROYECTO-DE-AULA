package vista;

import Controlador.AutorControlador;
import Controlador.EjemplarControlador;
import Controlador.GeneroControlador;
import Controlador.LibroControlador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import modelo.Autor;
import modelo.Genero;
import modelo.Libro;

/**
 *
 * @author
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Ejemplar;

public class mainLibros {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader br = new BufferedReader(reader);
        Scanner es = new Scanner(System.in);
        LibroControlador libroControlador = new LibroControlador();
        AutorControlador autorControlador = new AutorControlador();
        GeneroControlador generoControlador = new GeneroControlador();

        int op1;
        do {
            menus.menuLibros();

            while (true) {
                try {
                    op1 = Integer.parseInt(es.nextLine());
                    if (op1 >= 0 && op1 <= 4) {
                        break;
                    } else {
                        System.out.println("Opción no válida, por favor elija una opción entre 0 y 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                }
            }
            switch (op1) {
                case 1 -> {
                    boolean datosCorrectos = true;
                    int op = 0;
                    String nombreAutor, apellidosAutor, fechaNaceAutor, titulo, fechaPublicado, isbn;
                    int autorId, generoId, numeroEjemplares;

                    AutorControlador autC = new AutorControlador();
                    ArrayList<Autor> listarAutores = autC.listarAutores();
                    System.out.println("  Lista de Autores");
                    for (Autor A : listarAutores) {
                        System.out.println(A.getIdAutor() + " - " + A.getNombres() + " " + A.getApellidos());
                    }

                    System.out.println("0. Registrar otro Autor");
                    System.out.println("Ingrese el número del Autor:");
                    op = es.nextInt();
                    es.nextLine();

                    if (op == 0) {
                        while (true) {
                            System.out.print("Ingrese el nombre del autor: ");
                            nombreAutor = br.readLine();
                            if (Funciones.isValidText(nombreAutor)) {
                                break;
                            } else {
                                System.out.print("Nombre no puede estar vacío ni contener caracteres especiales. ¿Volver a intentarlo? (si/no): ");
                                if (!es.nextLine().equalsIgnoreCase("si")) {
                                    datosCorrectos = false;
                                    break;
                                }
                            }
                        }

                        if (!datosCorrectos) {
                            continue;
                        }

                        while (true) {
                            System.out.print("Ingrese los apellidos del autor: ");
                            apellidosAutor = br.readLine();
                            if (Funciones.isValidText(apellidosAutor)) {
                                break;
                            } else {
                                System.out.print("Apellidos no pueden estar vacíos ni contener caracteres especiales. ¿Volver a intentarlo? (si/no): ");
                                if (!es.nextLine().equalsIgnoreCase("si")) {
                                    datosCorrectos = false;
                                    break;
                                }
                            }
                        }

                        if (!datosCorrectos) {
                            continue;
                        }

                        while (true) {
                            System.out.print("Ingrese la fecha de nacimiento del autor (AAAA-MM-DD): ");
                            fechaNaceAutor = es.nextLine();
                            if (Funciones.isValidDate(fechaNaceAutor)) {
                                break;
                            } else {
                                System.out.print("Fecha no válida. ¿Volver a intentarlo? (si/no): ");
                                if (!es.nextLine().equalsIgnoreCase("si")) {
                                    datosCorrectos = false;
                                    break;
                                }
                            }
                        }

                        if (!datosCorrectos) {
                            continue;
                        }

                        // Crear autor y obtener su ID
                        Autor nuevoAutor = new Autor(fechaNaceAutor, nombreAutor, apellidosAutor);
                        autorId = autorControlador.crearAutorYObtenerId(nuevoAutor);
                        if (autorId == -1) {
                            System.out.print("Error al crear el autor. No se puede proceder a ingresar el libro.");
                            continue;
                        }

                    } else {
                        Autor Au = new Autor();
                        Au.setIdAutor(op);
                    }

                    // Aquí se crea un nuevo libro
                    Libro nuevoLibro = new Libro();

                    while (true) {
                        System.out.println("Ingrese el título del libro:");
                        titulo = br.readLine();
                        if (Funciones.isValidText(titulo)) {
                            break;
                        } else {
                            System.out.println("Título no puede estar vacío ni contener caracteres especiales. ¿Volver a intentarlo? (si/no):");
                            String respuesta = es.nextLine();
                            if (!respuesta.equalsIgnoreCase("si")) {
                                datosCorrectos = false;
                                break;
                            }
                        }
                    }

                    if (!datosCorrectos) {
                        continue;
                    }

                    while (true) {
                        System.out.print("Ingrese la fecha de publicación del libro (AAAA-MM-DD): ");
                        fechaPublicado = es.nextLine();
                        if (Funciones.isValidDate(fechaPublicado)) {
                            break;
                        } else {
                            System.out.print("Fecha no válida. ¿Volver a intentarlo? (si/no): ");
                            String respuesta = es.nextLine();
                            if (!respuesta.equalsIgnoreCase("si")) {
                                datosCorrectos = false;
                                break;
                            }
                        }
                    }

                    if (!datosCorrectos) {
                        continue;
                    }

                    while (true) {
                        System.out.print("Ingrese el ISBN del libro: ");
                        isbn = br.readLine();
                        if (Funciones.isValidISBN(isbn)) {
                            break;
                        } else {
                            System.out.print("ISBN no puede estar vacío y debe tener 10 o 13 dígitos. ¿Volver a intentarlo? (si/no): ");
                            String respuesta = es.nextLine();
                            if (!respuesta.equalsIgnoreCase("si")) {
                                datosCorrectos = false;
                                break;
                            }
                        }
                    }

                    if (!datosCorrectos) {
                        continue;
                    }

                    while (true) {
                        System.out.print("Ingrese el número de ejemplares del libro: ");
                        try {
                            numeroEjemplares = Integer.parseInt(br.readLine());
                            if (numeroEjemplares > 0) {
                                break;
                            } else {
                                System.out.print("Número de ejemplares debe ser mayor que 0. ¿Volver a intentarlo? (si/no): ");
                                String respuesta = es.nextLine();
                                if (!respuesta.equalsIgnoreCase("si")) {
                                    datosCorrectos = false;
                                    break;
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada no válida. Por favor, ingrese un número.");
                        }
                    }

                    if (!datosCorrectos) {
                        continue;
                    }

                    // Mostrar lista de géneros
                    ArrayList<Genero> listaGeneros = generoControlador.listarGeneros();
                    System.out.println("  Lista de géneros:");
                    for (Genero g : listaGeneros) {
                        System.out.println(g.getId() + " - " + g.getNombreGenero());
                    }

                    while (true) {
                        System.out.println("0.  Ingresar otro genero");
                        System.out.print("Ingrese el número del género:");
                        try {
                            generoId = Integer.parseInt(es.nextLine());
                            if (generoId == 0) {
                                System.out.print("Ingrese el nombre del género: ");
                                String nombreGenero = es.nextLine();

                                Genero nuevoGenero = new Genero(nombreGenero);

                                generoControlador.crearGenero(nuevoGenero);
                                System.out.println("Género creado con éxito!");
                                listaGeneros = generoControlador.listarGeneros();
                                System.out.println("  Lista de géneros actualizada:");
                                for (Genero g : listaGeneros) {
                                    System.out.println(g.getId() + " - " + g.getNombreGenero());
                                }
                            } else if (generoControlador.buscarGeneroPorId(generoId) != null) {
                                break;
                            } else {
                                System.out.print("ID de género no válido. ¿Volver a intentarlo? (si/no):");
                                if (!es.nextLine().equalsIgnoreCase("si")) {
                                    datosCorrectos = false;
                                    break;
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada no válida. Por favor, ingrese un número.");
                        }
                    }
                    if (!datosCorrectos) {
                        continue;
                    }
                    nuevoLibro.setTitulo(titulo);
                    nuevoLibro.setFechaPublicado(fechaPublicado);
                    nuevoLibro.setIsbn(isbn);
                    nuevoLibro.setNumEjemplares(numeroEjemplares);

                    int idLibro = libroControlador.crearLibro(nuevoLibro, op, generoId);

//                  Crear ejemplares
                    for (int i = 0; i < numeroEjemplares; i++) {
                        System.out.print("Ingrese el código del ejemplar " + (i + 1) + ": ");
                        String codigoEjemplar = es.nextLine();

                        Ejemplar ejemplar = new Ejemplar();
                        ejemplar.setIdLibro(idLibro); // Use the retrieved idLibro value
                        ejemplar.setCodigoEjemplar(codigoEjemplar);
                        // ... otros campos del ejemplar ...
                        EjemplarControlador ejeC = new EjemplarControlador();
                        ejeC.crearEjemplar(ejemplar, idLibro);
                    }

                }

                case 2 -> {
                    // Mostrar lista de libros
                    ArrayList<Libro> listaLibros = libroControlador.listarLibros();
                    if (listaLibros.isEmpty()) {
                        System.out.println("No hay libros disponibles.");
                    } else {
                        // Imprimir encabezados de la tabla
                        System.out.println("+----------------------+-----------------+-----------------+--------------------------------+-----------------+------------+");
                        System.out.println("| Título               | Fecha Publicado | ISBN            | Autor                          | Género          | Ejemplares |");
                        System.out.println("+----------------------+-----------------+-----------------+--------------------------------+-----------------+------------+");

                        for (Libro l : listaLibros) {
                            l.imprimirDetalles(); // Llama al método para imprimir detalles
                        }
                        System.out.println("+----------------------+-----------------+-----------------+--------------------------------+-----------------+------------+");
                    }
                }
                case 3 -> {
                    String isbn, nuevoTitulo, nuevaFechaPublicado;
                    boolean datosCorrectos = true;
                    while (true) {
                        System.out.println("Ingrese el ISBN del libro que desea actualizar:");
                        isbn = es.nextLine();
                        if (isbn.matches("\\d{12}")) {
                            break;
                        } else {
                            System.out.println("ISBN debe contener exactamente 13 dígitos. ¿Volver a intentarlo? (si/no):");
                            if (!es.nextLine().equalsIgnoreCase("si")) {
                                datosCorrectos = false;
                                break;
                            }
                        }
                    }
                    if (!datosCorrectos) {
                        continue;
                    }
                    Libro libroExistente = libroControlador.buscarDatosLibro(isbn);
                    if (libroExistente.getIdLibro() != 0) {
                        while (true) {
                            System.out.println("Ingrese el nuevo título del libro:");
                            nuevoTitulo = es.nextLine();
                            if (!nuevoTitulo.isEmpty() && !nuevoTitulo.matches(".*\\d.*")) {
                                break;
                            } else {
                                System.out.println("Título no puede estar vacío ni contener números. ¿Volver a intentarlo? (si/no):");
                                if (!es.nextLine().equalsIgnoreCase("si")) {
                                    datosCorrectos = false;
                                    break;
                                }
                            }
                        }

                        if (!datosCorrectos) {
                            continue;
                        }

                        while (true) {
                            System.out.println("Ingrese la nueva fecha de publicación (YYYY-MM-DD):");
                            nuevaFechaPublicado = es.nextLine();
                            if (nuevaFechaPublicado.matches("\\d{4}-\\d{2}-\\d{2}")) {
                                break;
                            } else {
                                System.out.println("Fecha no válida. ¿Volver a intentarlo? (si/no):");
                                if (!es.nextLine().equalsIgnoreCase("si")) {
                                    datosCorrectos = false;
                                    break;
                                }
                            }
                        }

                        if (!datosCorrectos) {
                            continue;
                        }

//                    Libro actualizadoLibro = new Libro(libroExistente.getIdLibro(), nuevoTitulo, nuevaFechaPublicado, isbn);
//                    libroControlador.(actualizadoLibro, isbn);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                }
                case 4 -> {
                    // Eliminar libro
                    String isbn;
                    boolean datosCorrectos = true;
                    while (true) {
                        System.out.println("Ingrese el ISBN del libro que desea eliminar:");
                        isbn = es.nextLine();
                        if (isbn.matches("\\d{13}")) {
                            break;
                        } else {
                            System.out.println("ISBN debe contener exactamente 13 dígitos. ¿Volver a intentarlo? (si/no):");
                            if (!es.nextLine().equalsIgnoreCase("si")) {
                                datosCorrectos = false;
                                break;
                            }
                        }
                    }
                    if (!datosCorrectos) {
                        continue;
                    }
//                libroControlador.eliminarLibro(isbn);

                }
                case 0 -> // Regresar al menú principal
                    Perfiles.perfilBliotecario(args);
                // Llama al menú principal del bibliotecario
                default -> {
                }
            }

        } while (op1
                != 0);
        menus.menuBiblio();

        System.out.println(
                "Saliendo al perfil ...");
    }
}
