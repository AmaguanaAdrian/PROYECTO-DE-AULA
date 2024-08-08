package vista;
import Controlador.AutorControlador;
import Controlador.GeneroControlador;
import Controlador.LibrosControlador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import modelo.Autor;
import modelo.Genero;
import modelo.Libros;

/**
 *
 * @author
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class mainLibros {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader br = new BufferedReader(reader);
        Scanner es = new Scanner(System.in);
        LibrosControlador libroControlador = new LibrosControlador();
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

            if (op1 == 1) {
                // Insertar autor
                boolean datosCorrectos = true;
                String nombreAutor, apellidosAutor, fechaNaceAutor;

                while (true) {
                    System.out.println("Ingrese el nombre del autor:");
                    nombreAutor = br.readLine();
                    if (Funciones.isValidText(nombreAutor)) {
                        break;
                    } else {
                        System.out.println("Nombre no puede estar vacío ni contener caracteres especiales. ¿Volver a intentarlo? (si/no):");
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
                    System.out.println("Ingrese los apellidos del autor:");
                    apellidosAutor = br.readLine();
                    if (Funciones.isValidText(apellidosAutor)) {
                        break;
                    } else {
                        System.out.println("Apellidos no pueden estar vacíos ni contener caracteres especiales. ¿Volver a intentarlo? (si/no):");
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
                    System.out.println("Ingrese la fecha de nacimiento del autor (AAAA-MM-DD):");
                    fechaNaceAutor = es.nextLine();
                    if (Funciones.isValidDate(fechaNaceAutor)) {
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

                // Crear autor y obtener su ID
                Autor nuevoAutor = new Autor(fechaNaceAutor, nombreAutor, apellidosAutor);
                int autorId = autorControlador.crearAutorYObtenerId(nuevoAutor);
                if (autorId == -1) {
                    System.out.println("Error al crear el autor. No se puede proceder a ingresar el libro.");
                    continue;
                }

                // Insertar libro
                String titulo, fechaPublicado, isbn;
                int generoId;

                while (true) {
                    System.out.println("Ingrese el título del libro:");
                    titulo = br.readLine();
                    if (Funciones.isValidText(titulo)) {
                        break;
                    } else {
                        System.out.println("Título no puede estar vacío ni contener caracteres especiales. ¿Volver a intentarlo? (si/no):");
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
                    System.out.println("Ingrese la fecha de publicación del libro (AAAA-MM-DD):");
                    fechaPublicado = es.nextLine();
                    if (Funciones.isValidDate(fechaPublicado)) {
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

                while (true) {
                    System.out.println("Ingrese el ISBN del libro:");
                    isbn = br.readLine();
                    if (Funciones.isValidISBN(isbn)) {
                        break;
                    } else {
                        System.out.println("ISBN no puede estar vacío y debe tener 10 o 13 dígitos. ¿Volver a intentarlo? (si/no):");
                        if (!es.nextLine().equalsIgnoreCase("si")) {
                            datosCorrectos = false;
                            break;
                        }
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
                    System.out.println("Ingrese el ID del género:");
                    try {
                        generoId = Integer.parseInt(es.nextLine());
                        if (generoControlador.buscarGeneroPorId(generoId) != null) {
                            break;
                        } else {
                            System.out.println("ID de género no válido. ¿Volver a intentarlo? (si/no):");
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

                Libros nuevoLibro = new Libros(titulo, fechaPublicado, isbn);
                libroControlador.crearLibro(nuevoLibro, autorId, generoId);
//<<<<<<< HEAD
////<<<<<<< HEAD
//
//            } else if (op1 == 2) {
//                // Mostrar lista de libros
//                ArrayList<Libros> listaLibros = libroControlador.listarLibros();
//                for (Libros l : listaLibros) {
//                    System.out.println(l.imprimir());
//                }
//
//            } else if (op1 == 3) {
//                // Actualizar información de un libro
//                String isbn, nuevoTitulo, nuevaFechaPublicado;
//                boolean datosCorrectos = true;
//
//                while (true) {
//                    System.out.println("Ingrese el ISBN del libro que desea actualizar:");
//                    isbn = es.nextLine();
//                    if (isbn.matches("\\d{13}")) {
//                        break;
//                    } else {
//                        System.out.println("ISBN debe contener exactamente 13 dígitos. ¿Volver a intentarlo? (si/no):");
//                        if (!es.nextLine().equalsIgnoreCase("si")) {
//                            datosCorrectos = false;
//                            break;
//                        }
//                    }
//                }
//
//                if (!datosCorrectos) {
//                    continue;
//                }
//
//                Libros libroExistente = libroControlador.buscarDatosLibro(isbn);
//                if (libroExistente.getIdLibro() != 0) {
//                    while (true) {
//                        System.out.println("Ingrese el nuevo título del libro:");
//                        nuevoTitulo = es.nextLine();
//                        if (!nuevoTitulo.isEmpty() && !nuevoTitulo.matches(".*\\d.*")) {
//                            break;
//                        } else {
//                            System.out.println("Título no puede estar vacío ni contener números. ¿Volver a intentarlo? (si/no):");
//                            if (!es.nextLine().equalsIgnoreCase("si")) {
//                                datosCorrectos = false;
//                                break;
//                            }
//                        }
//                    }
//
//                    if (!datosCorrectos) {
//                        continue;
//                    }
//
//                    while (true) {
//                        System.out.println("Ingrese la nueva fecha de publicación (YYYY-MM-DD):");
//                        nuevaFechaPublicado = es.nextLine();
//                        if (nuevaFechaPublicado.matches("\\d{4}-\\d{2}-\\d{2}")) {
//                            break;
//                        } else {
//                            System.out.println("Fecha no válida. ¿Volver a intentarlo? (si/no):");
//                            if (!es.nextLine().equalsIgnoreCase("si")) {
//                                datosCorrectos = false;
//                                break;
//                            }
//                        }
//                    }
//
//                    if (!datosCorrectos) {
//                        continue;
//                    }
//
//                    Libros actualizadoLibro = new Libros(libroExistente.getIdLibro(), nuevoTitulo, nuevaFechaPublicado, isbn);
//                    libroControlador.actualizarLibro(actualizadoLibro, isbn);
//                } else {
//                    System.out.println("Libro no encontrado.");
//                }
//
//            } else if (op1 == 4) {
//                // Eliminar libro
//                String isbn;
//                boolean datosCorrectos = true;
//                while (true) {
//                    System.out.println("Ingrese el ISBN del libro que desea eliminar:");
//                    isbn = es.nextLine();
//                    if (isbn.matches("\\d{13}")) {
//                        break;
//                    } else {
//                        System.out.println("ISBN debe contener exactamente 13 dígitos. ¿Volver a intentarlo? (si/no):");
//                        if (!es.nextLine().equalsIgnoreCase("si")) {
//                            datosCorrectos = false;
//                            break;
//                        }
//                    }
//                }
//
//                if (!datosCorrectos) {
//                    continue;
//                }
//
//                libroControlador.eliminarLibro(isbn);
//
//            } else if (op1 == 0) {
//                // Regresar al menú principal
//                perfiles.perfilBliotecario(args);// Llama al menú principal del bibliotecario
//=======
//>>>>>>> 6e6b4f98520a9e933d1205c30ce3f0126d0449cd
//=======

//            } else if (op1 == 2) {
                // Mostrar lista de libros
//                ArrayList<Libros> listaLibros = libroControlador.listarLibros();
//                for (Libros l : listaLibros) {
////                    System.out.println(l.imprimir());
//                }

            } else if (op1 == 3) {
                // Actualizar información de un libro
                String isbn, nuevoTitulo, nuevaFechaPublicado;
                boolean datosCorrectos = true;

                while (true) {
                    System.out.println("Ingrese el ISBN del libro que desea actualizar:");
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

                Libros libroExistente = libroControlador.buscarDatosLibro(isbn);
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

//                    Libros actualizadoLibro = new Libros(libroExistente.getIdLibro(), nuevoTitulo, nuevaFechaPublicado, isbn);
//                    libroControlador.actualizarLibro(actualizadoLibro, isbn);
                } else {
                    System.out.println("Libro no encontrado.");
                }

            } else if (op1 == 4) {
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

            } else if (op1 == 0) {
                // Regresar al menú principal
                Main1.perfilBliotecario(args);// Llama al menú principal del bibliotecario
//>>>>>>> parent of 744508a (Corrección de faltas)
            }

        } while (op1 != 0);
        menus.menuBiblio();
        System.out.println("Saliendo al perfil ...");
    }
}
