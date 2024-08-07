package vista;

/**
 *
 * @author
 */
import Controlador.EjemplarControlador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Ejemplar;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Libros;

public class mainEjemplar {

    public static void main(String[] args) throws IOException {
        Scanner es = new Scanner(System.in);
        EjemplarControlador ejemplarControlador = new EjemplarControlador();
        int op1;

        do {
            menus.menuEjemplares();

            while (true) {
                try {
                    op1 = Integer.parseInt(es.nextLine());
                    if (op1 >= 0 && op1 <= 4) break;
                    else System.out.println("Opción no válida, por favor elija una opción entre 0 y 4.");
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                }
            }

            if (op1 == 1) {
                // Insertar ejemplar
                String codigoEjemplar;
                boolean estado;
                int idLibro;
                int numEjemplares;

                System.out.println("Ingrese el código del ejemplar:");
                codigoEjemplar = es.nextLine();

                while (true) {
                    System.out.println("¿El ejemplar está disponible? (1 para sí, 0 para no):");
                    String estadoStr = es.nextLine();
                    if (estadoStr.equals("1")) {
                        estado = true;
                        break;
                    } else if (estadoStr.equals("0")) {
                        estado = false;
                        break;
                    } else {
                        System.out.println("Entrada no válida. Por favor, ingrese 1 para disponible o 0 para no disponible.");
                    }
                }

                // Mostrar IDs de libros disponibles
                ArrayList<Libros> listaLibros = ejemplarControlador.listarLibros();
                System.out.println("IDs de libros disponibles:");
                for (Libros libro : listaLibros) {
                    System.out.println("ID Libro: " + libro.getIdLibro());
                }

                System.out.println("Ingrese el ID del libro:");
                while (true) {
                    try {
                        idLibro = Integer.parseInt(es.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("ID no válido. Por favor, ingrese un número entero.");
                    }
                }

                System.out.println("Ingrese el número de ejemplares:");
                while (true) {
                    try {
                        numEjemplares = Integer.parseInt(es.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Número de ejemplares no válido. Por favor, ingrese un número entero.");
                    }
                }
                // Código relevante para la inserción
                Ejemplar nuevoEjemplar = new Ejemplar(idLibro, codigoEjemplar, estado, numEjemplares);
                ejemplarControlador.crearEjemplar(nuevoEjemplar);
                
            } else if (op1 == 2) {
                // Mostrar lista de ejemplares
                ArrayList<Ejemplar> listaEjemplares = ejemplarControlador.listarEjemplares();
                System.out.println("Lista de ejemplares:");
                for (Ejemplar ej : listaEjemplares) {
                    System.out.println("Código: " + ej.getCodigoEjemplar() +
                            ", Estado: " + (ej.isEstado() ? "Disponible" : "No disponible") +
                            ", ID Libro: " + ej.getIdLibro() +
                            ", Número de ejemplares: " + ej.getNumEjemplares());
                }

            } else if (op1 == 3) {
                // Actualizar información de un ejemplar
                String codigoEjemplar;
                String nuevoCodigoEjemplar;
                boolean nuevoEstado;
                int nuevoIdLibro;
                int nuevoNumEjemplares;

                System.out.println("Ingrese el código del ejemplar a actualizar:");
                codigoEjemplar = es.nextLine();

                Ejemplar ejemplar = ejemplarControlador.buscarEjemplarPorCodigo(codigoEjemplar);
                if (ejemplar.getIdEjemplar() != 0) {
                    System.out.println("Ingrese el nuevo código del ejemplar:");
                    nuevoCodigoEjemplar = es.nextLine();

                    while (true) {
                        System.out.println("¿El ejemplar está disponible? (1 para sí, 0 para no):");
                        String estadoStr = es.nextLine();
                        if (estadoStr.equals("1")) {
                            nuevoEstado = true;
                            break;
                        } else if (estadoStr.equals("0")) {
                            nuevoEstado = false;
                            break;
                        } else {
                            System.out.println("Entrada no válida. Por favor, ingrese 1 para disponible o 0 para no disponible.");
                        }
                    }

                    // Mostrar IDs de libros disponibles
                    ArrayList<Libros> listaLibros = ejemplarControlador.listarLibros();
                    System.out.println("IDs de libros disponibles:");
                    for (Libros libro : listaLibros) {
                        System.out.println("ID Libro: " + libro.getIdLibro());
                    }

                    System.out.println("Ingrese el nuevo ID del libro:");
                    while (true) {
                        try {
                            nuevoIdLibro = Integer.parseInt(es.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("ID no válido. Por favor, ingrese un número entero.");
                        }
                    }

                    System.out.println("Ingrese el nuevo número de ejemplares:");
                    while (true) {
                        try {
                            nuevoNumEjemplares = Integer.parseInt(es.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Número de ejemplares no válido. Por favor, ingrese un número entero.");
                        }
                    }

                    Ejemplar ejemplarActualizado = new Ejemplar(nuevoIdLibro, nuevoCodigoEjemplar, nuevoEstado, nuevoNumEjemplares);
                    ejemplarActualizado.setIdEjemplar(ejemplar.getIdEjemplar());
                    ejemplarControlador.actualizarEjemplar(ejemplarActualizado);
                } else {
                    System.out.println("Ejemplar no encontrado.");
                }

            } else if (op1 == 4) {
                // Eliminar ejemplar
                String codigoEjemplar;

                System.out.println("Ingrese el código del ejemplar a eliminar:");
                codigoEjemplar = es.nextLine();

                Ejemplar ejemplar = ejemplarControlador.buscarEjemplarPorCodigo(codigoEjemplar);
                if (ejemplar.getIdEjemplar() != 0) {
                    ejemplarControlador.eliminarEjemplar(ejemplar.getIdEjemplar());
                } else {
                    System.out.println("Ejemplar no encontrado.");
                }

            } else if (op1 == 0) {
                // Regresar al menú principal
                System.out.println("Regresando al menú principal...");
                Main1.perfilBliotecario(args); // Asegúrate de que el método perfilBliotecario acepta args
                break;
            }
        } while (op1 != 0);

        es.close();
    }
}



//public class mainEjemplar {
//    public static void Main1(String[] args) {
//        Scanner es = new Scanner(System.in);
//        EjemplarControlador ejemplarControlador = new EjemplarControlador();
//        int op1;
//        
//        while (true) {
//            System.out.println("""
//                |   GESTIÓN DE EJEMPLARES     |
//                |-----------------------------|
//                |   OPCIONES:                 |
//                |   1. Insertar ejemplares    |
//                |   2. Listar ejemplares      |
//                |   3. Actualizar ejemplares  |
//                |   4. Eliminar ejemplares    |
//                |   0. Volver al menú         |
//                """);
//
//            while (true) {
//                try {
//                    op1 = Integer.parseInt(es.nextLine());
//                    if (op1 >= 0 && op1 <= 4) break;
//                    else System.out.println("Opción no válida, por favor elija una opción entre 0 y 4.");
//                } catch (NumberFormatException e) {
//                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
//                }
//            }
//
//            if (op1 == 1) {
//                // Insertar ejemplar
//                String codigoEjem;
//                boolean estado;
//                int idLibro;
//                boolean datosCorrectos = true;
//
//                while (true) {
//                    System.out.println("Ingrese el código del ejemplar:");
//                    codigoEjem = es.nextLine();
//                    if (!codigoEjem.isEmpty()) break;
//                    else {
//                        System.out.println("Código no puede estar vacío. ¿Volver a intentarlo? (si/no):");
//                        if (!es.nextLine().equalsIgnoreCase("si")) {
//                            datosCorrectos = false;
//                            break;
//                        }
//                    }
//                }
//
//                if (!datosCorrectos) continue;
//
//                while (true) {
//                    System.out.println("Ingrese el estado del ejemplar (true/false):");
//                    String estadoInput = es.nextLine();
//                    if (estadoInput.equalsIgnoreCase("true") || estadoInput.equalsIgnoreCase("false")) {
//                        estado = Boolean.parseBoolean(estadoInput);
//                        break;
//                    } else {
//                        System.out.println("Estado no válido. ¿Volver a intentarlo? (si/no):");
//                        if (!es.nextLine().equalsIgnoreCase("si")) {
//                            datosCorrectos = false;
//                            break;
//                        }
//                    }
//                }
//
//                if (!datosCorrectos) continue;
//
//                while (true) {
//                    System.out.println("Ingrese el ID del libro asociado:");
//                    try {
//                        idLibro = Integer.parseInt(es.nextLine());
//                        if (idLibro > 0) break;
//                        else System.out.println("ID del libro debe ser un número positivo. ¿Volver a intentarlo? (si/no):");
//                    } catch (NumberFormatException e) {
//                        System.out.println("Entrada no válida. Ingrese un número entero positivo.");
//                    }
//                }
//
//                if (!datosCorrectos) continue;
//
//                Ejemplar nuevoEjemplar = new Ejemplar(0, codigoEjem, estado, idLibro);
//                ejemplarControlador.crearEjemplar(nuevoEjemplar);
//
//            } else if (op1 == 2) {
//                // Mostrar lista de ejemplares
//                ArrayList<Ejemplar> listaEjemplares = ejemplarControlador.listarEjemplares();
//                for (Ejemplar e : listaEjemplares) {
//                    System.out.println(e.imprimir());
//                }
//
//            } else if (op1 == 3) {
//                // Actualizar información de un ejemplar
//                String codigoEjem;
//                boolean datosCorrectos = true;
//
//                while (true) {
//                    System.out.println("Ingrese el código del ejemplar que desea actualizar:");
//                    codigoEjem = es.nextLine();
//                    if (!codigoEjem.isEmpty()) break;
//                    else {
//                        System.out.println("Código no puede estar vacío. ¿Volver a intentarlo? (si/no):");
//                        if (!es.nextLine().equalsIgnoreCase("si")) {
//                            datosCorrectos = false;
//                            break;
//                        }
//                    }
//                }
//
//                if (!datosCorrectos) continue;
//
//                Ejemplares ejemplarExistente = ejemplarControlador.buscarDatosEjemplar(codigoEjem);
//                if (ejemplarExistente.getIdEjemplar() != 0) {
//                    while (true) {
//                        System.out.println("Ingrese el nuevo estado del ejemplar (true/false):");
//                        String estadoInput = es.nextLine();
//                        if (estadoInput.equalsIgnoreCase("true") || estadoInput.equalsIgnoreCase("false")) {
//                            ejemplarExistente.setEstado(Boolean.parseBoolean(estadoInput));
//                            break;
//                        } else {
//                            System.out.println("Estado no válido. ¿Volver a intentarlo? (si/no):");
//                            if (!es.nextLine().equalsIgnoreCase("si")) {
//                                datosCorrectos = false;
//                                break;
//                            }
//                        }
//                    }
//
//                    if (!datosCorrectos) continue;
//
//                    while (true) {
//                        System.out.println("Ingrese el nuevo código del ejemplar:");
//                        String nuevoCodigo = es.nextLine();
//                        if (!nuevoCodigo.isEmpty()) {
//                            ejemplarExistente.setCodigoEjemplar(nuevoCodigo);
//                            break;
//                        } else {
//                            System.out.println("Código no puede estar vacío. ¿Volver a intentarlo? (si/no):");
//                            if (!es.nextLine().equalsIgnoreCase("si")) {
//                                datosCorrectos = false;
//                                break;
//                            }
//                        }
//                    }
//
//                    if (!datosCorrectos) continue;
//
//                    ejemplarControlador.actualizarEjemplar(ejemplarExistente, codigoEjem);
//                } else {
//                    System.out.println("Ejemplar no encontrado.");
//                }
//
//            } else if (op1 == 4) {
//                // Eliminar ejemplar
//                String codigoEjem;
//                boolean datosCorrectos = true;
//
//                while (true) {
//                    System.out.println("Ingrese el código del ejemplar que desea eliminar:");
//                    codigoEjem = es.nextLine();
//                    if (!codigoEjem.isEmpty()) break;
//                    else {
//                        System.out.println("Código no puede estar vacío. ¿Volver a intentarlo? (si/no):");
//                        if (!es.nextLine().equalsIgnoreCase("si")) {
//                            datosCorrectos = false;
//                            break;
//                        }
//                    }
//                }
//
//                if (!datosCorrectos) continue;
//
//                ejemplarControlador.eliminarEjemplar(codigoEjem);
//
//            } else if (op1 == 0) {
//                System.out.println("Regresando al menú principal...\n");
//                Main1.Main1(null); // Asumiendo que el menú principal está en la clase 'Main1'
//                return; // Salir de este método y regresar al menú principal
//            }
//        }
//    }
//}
