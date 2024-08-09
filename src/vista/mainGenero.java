package vista;

import Controlador.GeneroControlador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Genero;

/**
 *
 * @author
 */

public class mainGenero {

    public static void main(String[] args) throws IOException {
        Scanner es = new Scanner(System.in);
        int op1;

        do {
            GeneroControlador generoControlador = new GeneroControlador();
            menus.menuGenero();

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
                // Insertar género
                String nombreGenero;
                boolean datosCorrectos = true;
                while (true) {
                    System.out.println("Ingrese el nombre del género:");
                    nombreGenero = es.nextLine();
                    if (!nombreGenero.isEmpty() && !nombreGenero.matches(".*\\d.*")) {
                        break;
                    } else {
                        System.out.println("Nombre del género incorrecto. ¿Volver a intentarlo? (si/no):");
                        if (!es.nextLine().equalsIgnoreCase("si")) {
                            datosCorrectos = false;
                            break;
                        }
                    }
                }

                if (!datosCorrectos) {
                    continue;
                }

                Genero nuevoGenero = new Genero(nombreGenero);
                generoControlador.crearGenero(nuevoGenero);

            } else if (op1 == 2) {
                // Mostrar lista de géneros
                ArrayList<Genero> listaGeneros = generoControlador.listarGeneros();
                System.out.println("  Lista de géneros:");
                for (Genero g : listaGeneros) {
                    System.out.println(g.getNombreGenero());
                }

            } else if (op1 == 3) {
                // Actualizar información de un género
                String nombreActual, nuevoNombre;
                boolean datosCorrectos = true;
                while (true) {
                    System.out.println("Ingrese el nombre actual del género que desea actualizar:");
                    nombreActual = es.nextLine();
                    if (!nombreActual.isEmpty() && !nombreActual.matches(".*\\d.*")) {
                        break;
                    } else {
                        System.out.println("Nombre del género no encontrado. ¿Volver a intentarlo? (si/no):");
                        if (!es.nextLine().equalsIgnoreCase("si")) {
                            datosCorrectos = false;
                            break;
                        }
                    }
                }

                if (!datosCorrectos) {
                    continue;
                }

                int idGenero = generoControlador.buscarIdGenero(nombreActual);
                if (idGenero > 0) {
                    while (true) {
                        System.out.println("Ingrese el nuevo nombre del género:");
                        nuevoNombre = es.nextLine();
                        if (!nuevoNombre.isEmpty() && !nuevoNombre.matches(".*\\d.*")) {
                            break;
                        } else {
                            System.out.println("Nombre del género no puede estar vacío ni contener números. ¿Volver a intentarlo? (si/no):");
                            if (!es.nextLine().equalsIgnoreCase("si")) {
                                datosCorrectos = false;
                                break;
                            }
                        }
                    }

                    if (!datosCorrectos) {
                        continue;
                    }

                    Genero generoActualizado = new Genero(nuevoNombre);
                    generoControlador.actualizarGenero(generoActualizado, idGenero);
                } else {
                    System.out.println("Género no encontrado.");
                }

            } else if (op1 == 4) {
                // Eliminar género
                String nombreEliminar;
                boolean datosCorrectos = true;
                while (true) {
                    System.out.println("Ingrese el nombre del género que desea eliminar:");
                    nombreEliminar = es.nextLine();
                    if (!nombreEliminar.isEmpty() && !nombreEliminar.matches(".*\\d.*")) {
                        break;
                    } else {
                        System.out.println("Nombre del género no encontrado. ¿Volver a intentarlo? (si/no):");
                        if (!es.nextLine().equalsIgnoreCase("si")) {
                            datosCorrectos = false;
                            break;
                        }
                    }
                }

                if (!datosCorrectos) {
                    continue;
                }

                generoControlador.eliminarGenero(nombreEliminar);

            } else if (op1 == 0) {
                System.out.println("Regresando al menú principal...\n");
                Perfiles.perfilBliotecario(null);
                return; // Salir de este método y regresar al menú principal
            }
        } while (op1 != 0);

        es.close();
    }
}
