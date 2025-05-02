package services;

import models.Cultivo;
import java.util.*;

// Clase que gestiona las parcelas asociadas a los cultivos
public class GestorParcelas {
    private List<Cultivo> cultivos; // Lista de cultivos gestionados
    private Set<String> parcelas; // Conjunto de códigos de parcelas únicas

    // Constructor que inicializa la lista de cultivos y el conjunto de parcelas
    public GestorParcelas(List<Cultivo> cultivos) {
        this.cultivos = cultivos; // Asigna la lista de cultivos
        parcelas = new HashSet<>(); // Inicializa el conjunto de parcelas
        // Agrega los códigos de parcela de cada cultivo al conjunto
        for (Cultivo c : cultivos) parcelas.add(c.getCodigoParcela());
    }

    // Método para listar todas las parcelas registradas
    public List<String> listar() {
        return new ArrayList<>(parcelas); // Devuelve una lista con los códigos de parcelas
    }

    // Método para agregar una nueva parcela
    public void agregar(String codigo) {
        parcelas.add(codigo); // Agrega el código de la nueva parcela al conjunto
        System.out.println("Parcela agregada."); // Confirma que la parcela ha sido agregada
    }

    // Método para eliminar una parcela
    public void eliminar(String codigo) {
        // Verifica si hay cultivos activos en la parcela que se desea eliminar
        boolean enUso = cultivos.stream()
                          .anyMatch(c -> c.getCodigoParcela().equals(codigo));
        if (enUso) { // Si hay cultivos en uso
            System.out.println("No se puede eliminar: cultivos activos en esa parcela."); // Informa que no se puede eliminar
            return; // Sale del método
        }
        parcelas.remove(codigo); // Elimina la parcela del conjunto
        System.out.println("Parcela eliminada."); // Confirma que la parcela ha sido eliminada
    }

    // Método para editar el código de una parcela
    public void editar(String viejo, String nuevo) {
        // Verifica si el código viejo existe en el conjunto de parcelas
        if (!parcelas.contains(viejo)) {
            System.out.println("Código no existe."); // Informa que el código no existe
            return; // Sale del método
        }
        parcelas.remove(viejo); // Elimina el código viejo del conjunto
        parcelas.add(nuevo); // Agrega el nuevo código al conjunto
        // Renombra el código de parcela en los cultivos asociados
        for (Cultivo c : cultivos) {
            if (c.getCodigoParcela().equals(viejo)) {
                c.setCodigoParcela(nuevo); // Actualiza el código de parcela en el cultivo
            }
        }
        System.out.println("Parcela renombrada."); // Confirma que la parcela ha sido renombrada
    }

    // Método para asignar un cultivo a una nueva parcela
    public void asignarCultivo(int idxCultivo, String nuevoCodigo) {
        // Verifica si la nueva parcela existe en el conjunto
        if (!parcelas.contains(nuevoCodigo)) {
            System.out.println("Parcela no existe."); // Informa que la parcela no existe
            return; // Sale del método
        }
        Cultivo c = cultivos.get(idxCultivo); // Obtiene el cultivo en la posición indicada
        c.setCodigoParcela(nuevoCodigo); // Asigna el nuevo código de parcela al cultivo
        System.out.println("Cultivo reasignado a parcela " + nuevoCodigo + "."); // Confirma que el cultivo ha sido reasignado
    }
}
