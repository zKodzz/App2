package services;

import models.Cultivo;
import models.Actividad;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

// Clase que gestiona las operaciones relacionadas con los cultivos
public class GestorCultivos {
    private List<Cultivo> cultivos; // Lista de cultivos gestionados
    private Scanner scanner; // Scanner para la entrada de datos del usuario

    // Constructor que inicializa la lista de cultivos y el scanner
    public GestorCultivos(List<Cultivo> cultivos, Scanner sc) {
        this.cultivos = cultivos; // Asigna la lista de cultivos
        this.scanner = sc; // Asigna el scanner para la entrada de datos
    }

    // Método para listar todos los cultivos registrados
    public void listar() {
        if (cultivos.isEmpty()) { // Verifica si la lista de cultivos está vacía
            System.out.println("No hay cultivos registrados."); // Informa que no hay cultivos
            return; // Sale del método
        }
        // Itera sobre la lista de cultivos y muestra sus detalles
        for (int i = 0; i < cultivos.size(); i++) {
            Cultivo c = cultivos.get(i); // Obtiene el cultivo en la posición i
            System.out.printf("%d) %s (%s), %.1f ha, Parcela: %s, Estado: %s%n",
                i + 1, c.getNombre(), c.getVariedad(), c.getSuperficie(),
                c.getCodigoParcela(), c.getEstado()); // Muestra el índice, nombre, variedad, superficie, código de parcela y estado del cultivo
        }
    }

    // Método para crear un nuevo cultivo
    public void crear() {
        // Solicita al usuario los detalles del nuevo cultivo
        System.out.print("Nombre: "); String nombre = scanner.nextLine();
        System.out.print("Variedad: "); String var = scanner.nextLine();
        System.out.print("Superficie (ha): "); double sup = Double.parseDouble(scanner.nextLine());
        System.out.print("Código Parcela: "); String parc = scanner.nextLine();
        System.out.print("Fecha siembra (YYYY-MM-DD): "); 
        LocalDate fecha = LocalDate.parse(scanner.nextLine());
        System.out.print("Estado (ACTIVO/EN_RIESGO/COSECHADO): ");
        String est = scanner.nextLine();
        // Agrega el nuevo cultivo a la lista
        cultivos.add(new Cultivo(nombre, var, sup, parc, fecha, est));
        System.out.println("Cultivo creado."); // Confirma que el cultivo ha sido creado
    }

    // Método para eliminar un cultivo
    public void eliminar() {
        listar(); // Muestra la lista de cultivos
        System.out.print("Seleccione nº de cultivo a eliminar: "); // Solicita al usuario seleccionar un cultivo
        int idx = Integer.parseInt(scanner.nextLine()) - 1; // Lee la selección del usuario y ajusta el índice
        if (idx < 0 || idx >= cultivos.size()) { // Verifica si el índice es válido
            System.out.println("Índice inválido."); return; // Informa si el índice es inválido y sale del método
        }
        Cultivo c = cultivos.get(idx); // Obtiene el cultivo seleccionado
        // Verifica si hay actividades pendientes asociadas al cultivo
        boolean pendiente = c.getActividades().stream()
                            .anyMatch(a -> !a.isCompletada());
        if (pendiente) { // Si hay actividades pendientes
            System.out.println("No se puede eliminar: actividades pendientes."); // Informa que no se puede eliminar
            return; // Sale del método
        }
        cultivos.remove(idx); // Elimina el cultivo de la lista
        System.out.println("Cultivo eliminado."); // Confirma que el cultivo ha sido eliminado
    }

    // Método para editar un cultivo existente
    public void editar() {
        listar(); // Muestra la lista de cultivos
        System.out.print("Seleccione nº de cultivo a editar: "); // Solicita al usuario seleccionar un cultivo
        int idx = Integer.parseInt(scanner.nextLine()) - 1; // Lee la selección del usuario y ajusta el índice
        if (idx < 0 || idx >= cultivos.size()) { // Verifica si el índice es válido
            System.out.println("Índice inválido."); return; // Informa si el índice es inválido y sale del método
        }
                System.out.println("1.Nombre 2.Variedad 3.Superficie 4.Parcela 5.Fecha 6.Estado 7.Salir");
        System.out.print("Campo a editar: "); // Solicita al usuario seleccionar el campo a editar
        int op = Integer.parseInt(scanner.nextLine()); // Lee la opción seleccionada
        switch(op) {
            case 1: // Opción para editar el nombre
                System.out.print("Nuevo nombre: ");
                c.setNombre(scanner.nextLine()); // Actualiza el nombre del cultivo
                break;
            case 2: // Opción para editar la variedad
                System.out.print("Nueva variedad: ");
                c.setVariedad(scanner.nextLine()); // Actualiza la variedad del cultivo
                break;
            case 3: // Opción para editar la superficie
                System.out.print("Nueva superficie: ");
                c.setSuperficie(Double.parseDouble(scanner.nextLine())); // Actualiza la superficie del cultivo
                break;
            case 4: // Opción para editar el código de parcela
                System.out.print("Nueva parcela: ");
                c.setCodigoParcela(scanner.nextLine()); // Actualiza el código de parcela del cultivo
                break;
            case 5: // Opción para editar la fecha de siembra
                System.out.print("Nueva fecha siembra (YYYY-MM-DD): ");
                c.setFechaSiembra(LocalDate.parse(scanner.nextLine())); // Actualiza la fecha de siembra del cultivo
                break;
            case 6: // Opción para editar el estado
                System.out.print("Nuevo estado: ");
                c.setEstado(scanner.nextLine()); // Actualiza el estado del cultivo
                break;
            default: // Opción para salir
                return; // Sale del método si la opción no es válida
        }
        System.out.println("Cultivo actualizado."); // Confirma que el cultivo ha sido actualizado
    }
}
