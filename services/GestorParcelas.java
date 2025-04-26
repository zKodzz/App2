package services;

import models.Cultivo;
import java.util.*;

public class GestorParcelas {
    private List<Cultivo> cultivos;
    private Set<String> parcelas;

    public GestorParcelas(List<Cultivo> cultivos) {
        this.cultivos = cultivos;
        parcelas = new HashSet<>();
        for (Cultivo c : cultivos) parcelas.add(c.getCodigoParcela());
    }

    public List<String> listar() {
        return new ArrayList<>(parcelas);
    }

    public void agregar(String codigo) {
        parcelas.add(codigo);
        System.out.println("Parcela agregada.");
    }

    public void eliminar(String codigo) {
        boolean enUso = cultivos.stream()
                          .anyMatch(c -> c.getCodigoParcela().equals(codigo));
        if (enUso) {
            System.out.println("No se puede eliminar: cultivos activos en esa parcela.");
            return;
        }
        parcelas.remove(codigo);
        System.out.println("Parcela eliminada.");
    }

    public void editar(String viejo, String nuevo) {
        if (!parcelas.contains(viejo)) {
            System.out.println("Código no existe.");
            return;
        }
        parcelas.remove(viejo);
        parcelas.add(nuevo);
        // renombrar en cultivos
        for (Cultivo c : cultivos) {
            if (c.getCodigoParcela().equals(viejo)) {
                c.setCodigoParcela(nuevo);
            }
        }
        System.out.println("Parcela renombrada.");
    }

    public void asignarCultivo(int idxCultivo, String nuevoCodigo) {
        if (!parcelas.contains(nuevoCodigo)) {
            System.out.println("Parcela no existe.");
            return;
        }
        Cultivo c = cultivos.get(idxCultivo);
        c.setCodigoParcela(nuevoCodigo);
        System.out.println("Cultivo reasignado a parcela " + nuevoCodigo + ".");
    }
}
