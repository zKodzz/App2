package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cultivo extends ElementoAgricola {
    private String variedad;
    private double superficie;
    private String codigoParcela;
    private List<Actividad> actividades;

    public Cultivo(String nombre, String variedad, double superficie,
                   String codigoParcela, LocalDate fechaSiembra, String estado) {
        super(nombre, estado, fechaSiembra);
        this.variedad = variedad;
        this.superficie = superficie;
        this.codigoParcela = codigoParcela;
        this.actividades = new ArrayList<>();
    }

    public String getVariedad() { return variedad; }
    public double getSuperficie() { return superficie; }
    public String getCodigoParcela() { return codigoParcela; }
    public List<Actividad> getActividades() { return actividades; }
    public void agregarActividad(Actividad a) { actividades.add(a); }

    public void setVariedad(String v) { this.variedad = v; }
    public void setSuperficie(double s) { this.superficie = s; }
    public void setCodigoParcela(String c) { this.codigoParcela = c; }
}
