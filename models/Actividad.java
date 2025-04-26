package models;

import java.time.LocalDate;

public class Actividad {
    // Atributo que representa el tipo de actividad (por ejemplo, "Ejercicio", "Estudio", etc.)
    private String tipo;
    
    // Atributo que representa la fecha en la que se debe realizar la actividad
    private LocalDate fecha;
    
    // Atributo que indica si la actividad ha sido completada o no
    private boolean completada;

    // Constructor que inicializa el tipo y la fecha de la actividad, y establece completada en false
    public Actividad(String tipo, LocalDate fecha) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.completada = false; // Por defecto, la actividad no está completada al crearla
    }

    // Método para obtener el tipo de actividad
    public String getTipo() { 
        return tipo; 
    }
    
    // Método para obtener la fecha de la actividad
    public LocalDate getFecha() { 
        return fecha; 
    }
    
    // Método para verificar si la actividad ha sido completada
    public boolean isCompletada() { 
        return completada; 
    }
    
    // Método para marcar la actividad como completada
    public void marcarCompletada() { 
        this.completada = true; 
    }

    // Método que devuelve una representación en forma de cadena de la actividad
    @Override
    public String toString() {
        return tipo + ":" + fecha.toString(); // Devuelve el tipo y la fecha en formato "tipo:fecha"
    }
}
