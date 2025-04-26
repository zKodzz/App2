package services;

import models.Cultivo;
import models.Actividad;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class GestorActividades {
    private List<Cultivo> cultivos;
    private Scanner scanner;

    public GestorActividades(List<Cultivo> cult, Scanner sc) {
        this.cultivos = cult;
        this.scanner = sc;
    }

    public void registrar() {
        listarCultivos();
        System.out.print("Seleccione nº de cultivo: ");
        int i = Integer.parseInt(scanner.nextLine()) - 1;
        System.out.print("Tipo de actividad: ");
        String tipo = scanner.nextLine();
        System.out.print("Fecha (YYYY-MM-DD): ");
        LocalDate f = LocalDate.parse(scanner.nextLine());
        cultivos.get(i).agregarActividad(new Actividad(tipo,f));
        System.out.println("Actividad registrada.");
    }

    public void listarActividades() {
        listarCultivos();
        System.out.print("Seleccione nº de cultivo: ");
        int i = Integer.parseInt(scanner.nextLine()) - 1;
        List<Actividad> acts = cultivos.get(i).getActividades();
        if (acts.isEmpty()) {
            System.out.println("No hay actividades.");
            return;
        }
        for (int j = 0; j < acts.size(); j++) {
            Actividad a = acts.get(j);
            System.out.printf("%d) %s [%s]%n", j+1, a.toString(),
              a.isCompletada() ? "COMPLETA" : "PENDIENTE");
        }
    }

    public void eliminar() {
        listarActividades();
        System.out.print("Cultivo nº: ");
        int i = Integer.parseInt(scanner.nextLine()) - 1;
        List<Actividad> acts = cultivos.get(i).getActividades();
        System.out.print("Seleccione nº de actividad a eliminar: ");
        int j = Integer.parseInt(scanner.nextLine()) - 1;
        acts.remove(j);
        System.out.println("Actividad eliminada.");
    }

    public void marcar() {
        listarActividades();
        System.out.print("Cultivo nº: ");
        int i = Integer.parseInt(scanner.nextLine()) - 1;
        List<Actividad> acts = cultivos.get(i).getActividades();
        System.out.print("Seleccione nº de actividad a marcar: ");
        int j = Integer.parseInt(scanner.nextLine()) - 1;
        acts.get(j).marcarCompletada();
        System.out.println("Actividad marcada como completada.");
    }

    private void listarCultivos() {
        for (int i = 0; i < cultivos.size(); i++) {
            Cultivo c = cultivos.get(i);
            System.out.printf("%d) %s - %s%n", i+1, c.getNombre(), c.getCodigoParcela());
        }
    }
}
