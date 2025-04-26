package ui;

import models.Cultivo;
import services.*;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void mostrarMenu(List<Cultivo> cultivos) {
        Scanner sc = new Scanner(System.in);
        GestorCultivos gc = new GestorCultivos(cultivos, sc);
        GestorParcelas gp = new GestorParcelas(cultivos);
        GestorActividades ga = new GestorActividades(cultivos, sc);

        int opt;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Gestión de Cultivos");
            System.out.println("2. Gestión de Parcelas");
            System.out.println("3. Gestión de Actividades");
            System.out.println("4. Búsqueda / Reportes");
            System.out.println("5. Salir y guardar");
            System.out.print("Opción: ");
            opt = Integer.parseInt(sc.nextLine());

            switch (opt) {
                case 1: submenuCultivos(gc, sc); break;
                case 2: submenuParcelas(gp, cultivos, sc); break;
                case 3: submenuActividades(ga, sc); break;
                case 4: submenuReportes(cultivos, sc); break;
                case 5: System.out.println("Guardando y saliendo..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opt != 5);
    }

    private static void submenuCultivos(GestorCultivos gc, Scanner sc) {
        int op;
        do {
            System.out.println("\n-- Cultivos --");
            System.out.println("1. Listar");
            System.out.println("2. Crear");
            System.out.println("3. Eliminar");
            System.out.println("4. Editar");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1: gc.listar(); break;
                case 2: gc.crear(); break;
                case 3: gc.eliminar(); break;
                case 4: gc.editar(); break;
                case 5: break;
                default: System.out.println("Inválido.");
            }
        } while (op != 5);
    }

    private static void submenuParcelas(GestorParcelas gp, List<Cultivo> cultivos, Scanner sc) {
        int op;
        do {
            System.out.println("\n-- Parcelas --");
            System.out.println("1. Listar");
            System.out.println("2. Agregar");
            System.out.println("3. Eliminar");
            System.out.println("4. Editar Código");
            System.out.println("5. Asignar cultivo a parcela");
            System.out.println("6. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    List<String> p = gp.listar();
                    p.forEach(c -> System.out.println("- " + c));
                    break;
                case 2:
                    System.out.print("Nuevo código parcela: ");
                    gp.agregar(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Código a eliminar: ");
                    gp.eliminar(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Código viejo: ");
                    String viejo = sc.nextLine();
                    System.out.print("Código nuevo: ");
                    String nuevo = sc.nextLine();
                    gp.editar(viejo, nuevo);
                    break;
                case 5:
                    System.out.print("Nº cultivo a reasignar: ");
                    int ci = Integer.parseInt(sc.nextLine()) - 1;
                    System.out.print("Nuevo código parcela: ");
                    String np = sc.nextLine();
                    gp.asignarCultivo(ci, np);
                    break;
                case 6: break;
                default: System.out.println("Inválido.");
            }
        } while (op != 6);
    }

    private static void submenuActividades(GestorActividades ga, Scanner sc) {
        int op;
        do {
            System.out.println("\n-- Actividades --");
            System.out.println("1. Registrar");
            System.out.println("2. Listar por cultivo");
            System.out.println("3. Eliminar");
            System.out.println("4. Marcar completada");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());
            switch(op) {
                case 1: ga.registrar(); break;
                case 2: ga.listarActividades(); break;
                case 3: ga.eliminar(); break;
                case 4: ga.marcar(); break;
                case 5: break;
                default: System.out.println("Inválido.");
            }
        } while (op != 5);
    }

    private static void submenuReportes(List<Cultivo> cultivos, Scanner sc) {
        System.out.println("\n-- Reportes --");
        System.out.println("1. Buscar por nombre/variedad");
        System.out.println("2. Listar por estado");
        System.out.print("Opción: ");
        int op = Integer.parseInt(sc.nextLine());
        switch (op) {
            case 1:
                System.out.print("Texto a buscar: ");
                String txt = sc.nextLine().toLowerCase();
                cultivos.stream()
                    .filter(c -> c.getNombre().toLowerCase().contains(txt)
                              || c.getVariedad().toLowerCase().contains(txt))
                    .forEach(c -> System.out.printf("%s (%s) - %s%n",
                       c.getNombre(), c.getVariedad(), c.getEstado()));
                break;
            case 2:
                System.out.print("Estado (ACTIVO/EN_RIESGO/COSECHADO): ");
                String st = sc.nextLine().toUpperCase();
                cultivos.stream()
                    .filter(c -> c.getEstado().equalsIgnoreCase(st))
                    .forEach(c -> System.out.printf("%s (%s)%n",
                       c.getNombre(), c.getVariedad()));
                break;
            default:
                System.out.println("Inválido.");
        }
    }
}
