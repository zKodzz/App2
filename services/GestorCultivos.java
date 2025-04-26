package services;

import models.Cultivo;
import models.Actividad;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GestorCultivos {
    private List<Cultivo> cultivos;
    private Scanner scanner;

    public GestorCultivos(List<Cultivo> cultivos, Scanner sc) {
        this.cultivos = cultivos;
        this.scanner = sc;
    }

    public void listar() {
        if (cultivos.isEmpty()) {
            System.out.println("No hay cultivos registrados.");
            return;
        }
        for (int i = 0; i < cultivos.size(); i++) {
            Cultivo c = cultivos.get(i);
            System.out.printf("%d) %s (%s), %.1f ha, Parcela: %s, Estado: %s%n",
                i+1, c.getNombre(), c.getVariedad(), c.getSuperficie(),
                c.getCodigoParcela(), c.getEstado());
        }
    }

    public void crear() {
        System.out.print("Nombre: "); String nombre = scanner.nextLine();
        System.out.print("Variedad: "); String var = scanner.nextLine();
        System.out.print("Superficie (ha): "); double sup = Double.parseDouble(scanner.nextLine());
        System.out.print("Código Parcela: "); String parc = scanner.nextLine();
        System.out.print("Fecha siembra (YYYY-MM-DD): "); 
        LocalDate fecha = LocalDate.parse(scanner.nextLine());
        System.out.print("Estado (ACTIVO/EN_RIESGO/COSECHADO): ");
        String est = scanner.nextLine();
        cultivos.add(new Cultivo(nombre,var,sup,parc,fecha,est));
        System.out.println("Cultivo creado.");
    }

    public void eliminar() {
        listar();
        System.out.print("Seleccione nº de cultivo a eliminar: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx<0 || idx>=cultivos.size()) {
            System.out.println("Índice inválido."); return;
        }
        Cultivo c = cultivos.get(idx);
        boolean pendiente = c.getActividades().stream()
                            .anyMatch(a -> !a.isCompletada());
        if (pendiente) {
            System.out.println("No se puede eliminar: actividades pendientes.");
            return;
        }
        cultivos.remove(idx);
        System.out.println("Cultivo eliminado.");
    }

    public void editar() {
        listar();
        System.out.print("Seleccione nº de cultivo a editar: ");
        int idx = Integer.parseInt(scanner.nextLine()) - 1;
        if (idx<0 || idx>=cultivos.size()) {
            System.out.println("Índice inválido."); return;
        }
        Cultivo c = cultivos.get(idx);
        System.out.println("1.Nombre 2.Variedad 3.Superficie 4.Parcela 5.Fecha 6.Estado 7.Salir");
        System.out.print("Campo a editar: ");
        int op = Integer.parseInt(scanner.nextLine());
        switch(op) {
            case 1:
                System.out.print("Nuevo nombre: ");
                c.setNombre(scanner.nextLine());
                break;
            case 2:
                System.out.print("Nueva variedad: ");
                c.setVariedad(scanner.nextLine());
                break;
            case 3:
                System.out.print("Nueva superficie: ");
                c.setSuperficie(Double.parseDouble(scanner.nextLine()));
                break;
            case 4:
                System.out.print("Nueva parcela: ");
                c.setCodigoParcela(scanner.nextLine());
                break;
            case 5:
                System.out.print("Nueva fecha siembra (YYYY-MM-DD): ");
                c.setFechaSiembra(LocalDate.parse(scanner.nextLine()));
                break;
            case 6:
                System.out.print("Nuevo estado: ");
                c.setEstado(scanner.nextLine());
                break;
            default:
                return;
        }
        System.out.println("Cultivo actualizado.");
    }
}
