package vista;

import Controlador.LibrosControlador;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Libros;

/**
 *
 * @author
 */
public class mainLibros {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader br = new BufferedReader(reader);
        Scanner es = new Scanner(System.in);
        LibrosControlador libroControlador = new LibrosControlador();

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
                // Insertar libro
                
                int autorId, generoId;
                boolean datosCorrectos = true;
                String titulo, fechaPublicado, isbn;
                while (true) {
                    System.out.println("Ingrese el título del libro:");
                    titulo = br.readLine();
                    if (Funciones.isValidText(titulo)) {
                        break;
                    } else {
                        System.out.println("Título no puede estar vacío ni contener carácteres especiales. ¿Volver a intentarlo? (si/no):");
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
                    System.out.println("Ingrese la fecha de publicación (AAAA-MM-DD):");
                    fechaPublicado = es.nextLine();
                    if (Funciones.isValidDate(fechaPublicado)){
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
                    System.out.println("Ingrese el codigo ISBN el libro:");
                    isbn = es.nextLine();
//                    matches("\\d{12}")
                    if (isbn.length()==12) {
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

                // Mostrar autores y géneros disponibles
//                libroControlador.mostrarAutores();
                System.out.println("Seleccione el ID del autor:");
                autorId = Integer.parseInt(es.nextLine());

                libroControlador.mostrarGeneros();
                System.out.println("Seleccione el ID del género:");
                generoId = Integer.parseInt(es.nextLine());

                Libros nuevoLibro = new Libros(0, titulo, fechaPublicado, isbn);
                libroControlador.crearLibro(nuevoLibro, autorId, generoId);

            } else if (op1 == 2) {
                // Mostrar lista de libros
                ArrayList<Libros> listaLibros = libroControlador.listarLibros();
                for (Libros l : listaLibros) {
                    System.out.println(l.imprimir());
                }

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

                    Libros actualizadoLibro = new Libros(libroExistente.getIdLibro(), nuevoTitulo, nuevaFechaPublicado, isbn);
                    libroControlador.actualizarLibro(actualizadoLibro, isbn);
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

                libroControlador.eliminarLibro(isbn);

            } else if (op1 == 0) {
                // Regresar al menú principal
                Main1.perfilBliotecario(args);// Llama al menú principal del bibliotecario
            }
        } while (op1 != 0);

        es.close();
    }
}
//public class mainLibros {
//
//    public static void main(String[] args) {
//        Scanner es = new Scanner(System.in);
//
//        int op1;
//        do {
//            LibrosControlador libroControlador = new LibrosControlador();
//            menus.menuLibros();
//
//            while (true) {
//                try {
//                    op1 = Integer.parseInt(es.nextLine());
//                    if (op1 >= 0 && op1 <= 4) {
//                        break;
//                    } else {
//                        System.out.println("Opción no válida, por favor elija una opción entre 0 y 4.");
//                    }
//                } catch (NumberFormatException e) {
//                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
//                }
//            }
//
//            if (op1 == 1) {
//                // Insertar libro
//                String titulo, fechaPublicado, isbn;
//                boolean datosCorrectos = true;
//                while (true) {
//                    System.out.println("Ingrese el título del libro:");
//                    titulo = es.nextLine();
//                    if (!titulo.isEmpty() && !titulo.matches(".*\\d.*")) {
//                        break;
//                    } else {
//                        System.out.println("Título no puede estar vacío ni contener números. ¿Volver a intentarlo? (si/no):");
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
//                while (true) {
//                    System.out.println("Ingrese la fecha de publicación (YYYY-MM-DD):");
//                    fechaPublicado = es.nextLine();
//                    if (fechaPublicado.matches("\\d{4}-\\d{2}-\\d{2}")) {
//                        break;
//                    } else {
//                        System.out.println("Fecha no válida. ¿Volver a intentarlo? (si/no):");
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
//                while (true) {
//                    System.out.println("Ingrese el ISBN del libro:");
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
//                Libros nuevoLibro = new Libros(0, titulo, fechaPublicado, isbn);
//                libroControlador.crearLibro(nuevoLibro);
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
//                Main1.perfilBliotecario(args);// Llama al menú principal del bibliotecario
////                return; // Termina el método actual para regresar al menú principal
//            }
//        } while (op1 != 0);
//
////        es.close();
//    }
//}
