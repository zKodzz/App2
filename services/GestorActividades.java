package services;

import models.Cultivo;
import models.Actividad;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

// Clase que gestiona las actividades asociadas a los cultivos
public class GestorActividades {
    private List<Cultivo> cultivos; // Lista de cultivos gestionados
    private Scanner scanner; // Scanner para la entrada de datos del usuario

    // Constructor que inicializa la lista de cultivos y el scanner
    public GestorActividades(List<Cultivo> cult, Scanner sc) {
        this.cultivos = cult; // Asigna la lista de cultivos
        this.scanner = sc; // Asigna el scanner para la entrada de datos
    }

    // Método para registrar una nueva actividad en un cultivo
    public void registrar() {
        listarCultivos(); // Muestra la lista de cultivos disponibles
        System.out.print("Seleccione nº de cultivo: "); // Solicita al usuario seleccionar un cultivo
        int i = Integer.parseInt(scanner.nextLine()) - 1; // Lee la selección del usuario y ajusta el índice
        System.out.print("Tipo de actividad: "); // Solicita el tipo de actividad
        String tipo = scanner.nextLine(); // Lee el tipo de actividad
        System.out.print("Fecha (YYYY-MM-DD): "); // Solicita la fecha de la actividad
        LocalDate f = LocalDate.parse(scanner.nextLine()); // Lee y convierte la fecha a LocalDate
        // Agrega la nueva actividad al cultivo seleccionado
        cultivos.get(i).agregarActividad(new Actividad(tipo, f));
        System.out.println("Actividad registrada."); // Confirma que la actividad ha sido registrada
    }

    // Método para listar las actividades de un cultivo
    public void listarActividades() {
        listarCultivos(); // Muestra la lista de cultivos disponibles
        System.out.print("Seleccione nº de cultivo: "); // Solicita al usuario seleccionar un cultivo
        int i = Integer.parseInt(scanner.nextLine()) - 1; // Lee la selección del usuario y ajusta el índice
        List<Actividad> acts = cultivos.get(i).getActividades(); // Obtiene las actividades del cultivo seleccionado
        if (acts.isEmpty()) { // Verifica si no hay actividades
            System.out.println("No hay actividades."); // Informa que no hay actividades registradas
            return; // Sale del método si no hay actividades
        }
        // Muestra cada actividad con su estado (completa o pendiente)
        for (int j = 0; j < acts.size(); j++) {
            Actividad a = acts.get(j); // Obtiene la actividad
            System.out.printf("%d) %s [%s]%n", j + 1, a.toString(),
              a.isCompletada() ? "COMPLETA" : "PENDIENTE"); // Muestra el número, la descripción y el estado de la actividad
        }
    }

    // Método para eliminar una actividad de un cultivo
    public void eliminar() {
        listarActividades(); // Muestra las actividades disponibles
        System.out.print("Cultivo nº: "); // Solicita al usuario seleccionar un cultivo
        int i = Integer.parseInt(scanner.nextLine()) - 1; // Lee la selección del usuario y ajusta el índice
        List<Actividad> acts = cultivos.get(i).getActividades(); // Obtiene las actividades del cultivo seleccionado
        System.out.print("Seleccione nº de actividad a eliminar: "); // Solicita al usuario seleccionar una actividad
        int j = Integer.parseInt(scanner.nextLine()) - 1; // Lee la selección del usuario y ajusta el índice
        acts.remove(j); // Elimina la actividad seleccionada
        System.out.println("Actividad eliminada."); // Confirma que la actividad ha sido eliminada
    }

    // Método para marcar una actividad como completada
    public void marcar() {
        listarActividades(); // Muestra las actividades disponibles
        System.out.print("Cultivo nº: "); // Solicita al usuario seleccionar un cultivo
        int i = Integer.parseInt(scanner.nextLine()) - 1; // Lee la selección del usuario y ajusta el índice
        List<Actividad> acts = cultivos.get(i).getActividades(); // Obtiene las actividades del cultivo seleccionado
        System.out.print("Seleccione nº de actividad a marcar: "); // Solicita al usuario seleccionar una actividad
        int j = Integer.parseInt(scanner.nextLine()) - 1; // Lee la selección del usuario y ajusta el índice
        acts.get(j).marcarCompletada(); // Marca la actividad seleccionada como completada
        System.out.println("Actividad marcada como completada."); // Confirma que la actividad ha
            System.out.println("Actividad marcada como completada."); // Confirma que la actividad ha sido marcada
    }

    // Método privado para listar los cultivos disponibles
    private void listarCultivos() {
        // Itera sobre la lista de cultivos y muestra su nombre y código de parcela
        for (int i = 0; i < cultivos.size(); i++) {
            Cultivo c = cultivos.get(i); // Obtiene el cultivo en la posición i
            System.out.printf("%d) %s - %s%n", i + 1, c.getNombre(), c.getCodigoParcela()); // Muestra el índice, nombre y código de parcela del cultivo
        }
    }
}
