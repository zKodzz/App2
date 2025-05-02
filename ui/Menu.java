package ui;

import models.Cultivo;
import services.*;
import java.util.List;
import java.util.Scanner;

// Clase que representa el menú principal de la aplicación
public class Menu {

    // Método para mostrar el menú principal y gestionar las opciones seleccionadas
    public static void mostrarMenu(List<Cultivo> cultivos) {
        Scanner sc = new Scanner(System.in); // Inicializa el scanner para la entrada de datos
        GestorCultivos gc = new GestorCultivos(cultivos, sc); // Crea un gestor de cultivos
        GestorParcelas gp = new GestorParcelas(cultivos); // Crea un gestor de parcelas
        GestorActividades ga = new GestorActividades(cultivos, sc); // Crea un gestor de actividades

        int opt; // Variable para almacenar la opción seleccionada
        do {
            // Muestra las opciones del menú principal
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Gestión de Cultivos");
            System.out.println("2. Gestión de Parcelas");
            System.out.println("3. Gestión de Actividades");
            System.out.println("4. Búsqueda / Reportes");
            System.out.println("5. Salir y guardar");
            System.out.print("Opción: ");
            opt = Integer.parseInt(sc.nextLine()); // Lee la opción seleccionada

            // Ejecuta la acción correspondiente según la opción seleccionada
            switch (opt) {
                case 1: submenuCultivos(gc, sc); break; // Llama al submenú de cultivos
                case 2: submenuParcelas(gp, cultivos, sc); break; // Llama al submenú de parcelas
                case 3: submenuActividades(ga, sc); break; // Llama al submenú de actividades
                case 4: submenuReportes(cultivos, sc); break; // Llama al submenú de reportes
                case 5: System.out.println("Guardando y saliendo..."); break; // Mensaje de salida
                default: System.out.println("Opción inválida."); // Mensaje de opción inválida
            }
        } while (opt != 5); // Repite hasta que el usuario elija salir
    }

    // Método para mostrar el submenú de gestión de cultivos
    private static void submenuCultivos(GestorCultivos gc, Scanner sc) {
        int op; // Variable para almacenar la opción seleccionada
        do {
            // Muestra las opciones del submenú de cultivos
            System.out.println("\n-- Cultivos --");
            System.out.println("1. Listar");
            System.out.println("2. Crear");
            System.out.println("3. Eliminar");
            System.out.println("4. Editar");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine()); // Lee la opción seleccionada
            // Ejecuta la acción correspondiente según la opción seleccionada
            switch (op) {
                case 1: gc.listar(); break; // Lista los cultivos
                case 2: gc.crear(); break; // Crea un nuevo cultivo
                case 3: gc.eliminar(); break; // Elimina un cultivo
                case 4: gc.editar(); break; // Edita un cultivo existente
                case 5: break; // Vuelve al menú principal
                default: System.out.println("Inválido."); // Mensaje de opción inválida
            }
        } while (op != 5); // Repite hasta que el usuario elija volver
    }

    // Método para mostrar el submenú de gestión de parcelas
    private static void submenuParcelas(GestorParcelas gp, List<Cultivo> cultivos, Scanner sc) {
        int op; // Variable para almacenar la opción seleccionada
        do {
            // Muestra las opciones del submenú de parcelas
            System.out.println("\n-- Parcelas --");
            System.out.println("1. Listar");
            System.out.println("2. Agregar");
            System.out.println("3. Eliminar");
            System.out.println("4. Editar Código");
            System.out.println("5. Asignar cultivo a parcela");
            System.out.println("6. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine()); // Lee la opción seleccionada

            // Ejecuta la acción correspondiente según la opción seleccionada
            switch (op) {
                case 1:
                    List<String> p = gp.listar(); // Lista las parcelas
                    p.forEach(c -> System.out.println("- " + c)); // Muestra cada parcela
                                        break;
                case 2:
                    System.out.print("Nuevo código parcela: "); // Solicita el nuevo código de parcela
                    gp.agregar(sc.nextLine()); // Agrega la nueva parcela
                    break;
                case 3:
                    System.out.print("Código a eliminar: "); // Solicita el código de parcela a eliminar
                    gp.eliminar(sc.nextLine()); // Elimina la parcela
                    break;
                case 4:
                    System.out.print("Código viejo: "); // Solicita el código viejo de la parcela
                    String viejo = sc.nextLine();
                    System.out.print("Código nuevo: "); // Solicita el nuevo código de la parcela
                    String nuevo = sc.nextLine();
                    gp.editar(viejo, nuevo); // Edita el código de la parcela
                    break;
                case 5:
                    System.out.print("Nº cultivo a reasignar: "); // Solicita el número del cultivo a reasignar
                    int ci = Integer.parseInt(sc.nextLine()) - 1; // Lee el índice del cultivo
                    System.out.print("Nuevo código parcela: "); // Solicita el nuevo código de parcela
                    String np = sc.nextLine();
                    gp.asignarCultivo(ci, np); // Asigna el cultivo a la nueva parcela
                    break;
                case 6: break; // Vuelve al menú principal
                default: System.out.println("Inválido."); // Mensaje de opción inválida
            }
        } while (op != 6); // Repite hasta que el usuario elija volver
    }

    // Método para mostrar el submenú de gestión de actividades
    private static void submenuActividades(GestorActividades ga, Scanner sc) {
        int op; // Variable para almacenar la opción seleccionada
        do {
            // Muestra las opciones del submenú de actividades
            System.out.println("\n-- Actividades --");
            System.out.println("1. Registrar");
            System.out.println("2. Listar por cultivo");
            System.out.println("3. Eliminar");
            System.out.println("4. Marcar completada");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine()); // Lee la opción seleccionada
            // Ejecuta la acción correspondiente según la opción seleccionada
            switch(op) {
                case 1: ga.registrar(); break; // Registra una nueva actividad
                case 2: ga.listarActividades(); break; // Lista las actividades por cultivo
                case 3: ga.eliminar(); break; // Elimina una actividad
                case 4: ga.marcar(); break; // Marca una actividad como completada
                case 5: break; // Vuelve al menú principal
                default: System.out.println("Inválido."); // Mensaje de opción inválida
            }
        } while (op != 5); // Repite hasta que el usuario elija volver
    }

    // Método para mostrar el submenú de reportes
    private static void submenuReportes(List<Cultivo> cultivos, Scanner sc) {
        System.out.println("\n-- Reportes --");
        System.out.println("1. Buscar por nombre/variedad"); // Opción para buscar cultivos
        System.out.println("2. Listar por estado"); // Opción para listar cultivos por estado
        System.out.print("Opción: ");
        int op = Integer.parseInt(sc.nextLine()); // Lee la opción seleccionada
        // Ejecuta la acción correspondiente según la opción seleccionada
        switch (op) {
            case 1:
                System.out.print("Texto a buscar: "); // Solicita el texto a buscar
                String txt = sc.nextLine().toLowerCase(); // Lee el texto y lo convierte a minúsculas
                // Filtra y muestra los cultivos que coinciden con el texto buscado
                cultivos.stream()
                    .filter(c -> c.getNombre().toLowerCase().contains(txt)
                              || c.getVariedad().toLowerCase().contains(txt))
                    .forEach(c -> System.out.printf("%s (%s) - %s%n",
                       c.getNombre(), c.getVariedad(), c.getEstado())); // Muestra los cultivos encontrados
                break;
            case 2:
                System.out.print("Estado (ACTIVO/EN_RIESGO/COSECHADO): "); // Solicita el estado a filtrar
                String st = sc.nextLine().toUpperCase(); // Lee el estado y lo convierte a mayúsculas
                // Filtra y muestra los cultivos que coinciden con el estado buscado
                cultivos.stream()
                    .filter(c -> c.getEstado().equalsIgnoreCase(st)) // Filtra los cultivos por estado
                    .forEach(c -> System.out.printf("%s (%s)%n",
                       c.getNombre(), c.getVariedad())); // Muestra los cultivos encontrados
                break;
            default:
                System.out.println("Inválido."); // Mensaje de opción inválida
        }
    }
}
