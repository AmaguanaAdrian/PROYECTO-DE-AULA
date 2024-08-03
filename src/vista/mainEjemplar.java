package vista;

/**
 *
 * @author
 */
import Controlador.EjemplarControlador;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Ejemplar;

public class mainEjemplar {

    public static void main(String[] args) {
        Scanner es = new Scanner(System.in);
        int op1;

        do {
            menus.menuEjemplares();

           EjemplarControlador ejemplarControlador = new EjemplarControlador();

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
                System.out.println("Ingrese el código del ejemplar:");
                String codigoEjemplar = es.nextLine();

                boolean estado;
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

                System.out.println("Ingrese el ID del libro:");
                int idLibro = Integer.parseInt(es.nextLine());

                Ejemplar nuevoEjemplar = new Ejemplar(codigoEjemplar, estado, idLibro);
                ejemplarControlador.crearEjemplar(nuevoEjemplar);

            } else if (op1 == 2) {
                // Mostrar lista de ejemplares
                ArrayList<Ejemplar> listaEjemplares = ejemplarControlador.listarEjemplares();
                System.out.println("Lista de ejemplares:");
                for (Ejemplar ej : listaEjemplares) {
                    System.out.println("Código: " + ej.getCodigoEjemplar() + ", Estado: " + (ej.isEstado() ? "Disponible" : "No disponible") + ", ID Libro: " + ej.getIdLibro());
                }

            } else if (op1 == 3) {
                // Actualizar información de un ejemplar
                System.out.println("Ingrese el código del ejemplar a actualizar:");
                String codigoEjemplar = es.nextLine();

                Ejemplar ejemplar = ejemplarControlador.buscarEjemplarPorCodigo(codigoEjemplar);
                if (ejemplar.getIdEjemplar() != 0) {
                    System.out.println("Ingrese el nuevo código del ejemplar:");
                    String nuevoCodigoEjemplar = es.nextLine();

                    boolean nuevoEstado;
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

                    System.out.println("Ingrese el nuevo ID del libro:");
                    int nuevoIdLibro = Integer.parseInt(es.nextLine());

                    Ejemplar ejemplarActualizado = new Ejemplar(nuevoCodigoEjemplar, nuevoEstado, nuevoIdLibro);
                    ejemplarActualizado.setIdEjemplar(ejemplar.getIdEjemplar());
                    ejemplarControlador.actualizarEjemplar(ejemplarActualizado);
                } else {
                    System.out.println("Ejemplar no encontrado.");
                }

            } else if (op1 == 4) {
                // Eliminar ejemplar
                System.out.println("Ingrese el código del ejemplar a eliminar:");
                String codigoEjemplar = es.nextLine();

                Ejemplar ejemplar = ejemplarControlador.buscarEjemplarPorCodigo(codigoEjemplar);
                if (ejemplar.getIdEjemplar() != 0) {
                    ejemplarControlador.eliminarEjemplar(ejemplar.getIdEjemplar());
                } else {
                    System.out.println("Ejemplar no encontrado.");
                }

            } else if (op1 == 0) {
                System.out.println("Regresando al menú principal...");
                main.main(null);
                break; 
            }
        } while (op1 != 0);

        es.close();
    }
 }

//public class mainEjemplar {
//    public static void main(String[] args) {
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
//                main.main(null); // Asumiendo que el menú principal está en la clase 'main'
//                return; // Salir de este método y regresar al menú principal
//            }
//        }
//    }
//}