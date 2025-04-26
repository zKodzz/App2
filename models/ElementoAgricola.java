package models;

import java.time.LocalDate;

public abstract class ElementoAgricola {
    protected String nombre;
    protected String estado;
    protected LocalDate fechaSiembra;

    public ElementoAgricola(String nombre, String estado, LocalDate fechaSiembra) {
        this.nombre = nombre;
        this.estado = estado;
        this.fechaSiembra = fechaSiembra;
    }

    public String getNombre() { return nombre; }
    public String getEstado() { return estado; }
    public LocalDate getFechaSiembra() { return fechaSiembra; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setFechaSiembra(LocalDate fechaSiembra) { this.fechaSiembra = fechaSiembra; }
}
