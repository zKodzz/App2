package models;

import java.time.LocalDate;

// Clase abstracta que representa un elemento agrícola, que puede ser extendido por otras clases
public abstract class ElementoAgricola {
    // Atributo que representa el nombre del elemento agrícola (por ejemplo, el nombre de un cultivo)
    protected String nombre;
    
    // Atributo que representa el estado del elemento agrícola (por ejemplo, "En crecimiento", "Cosechado", etc.)
    protected String estado;
    
    // Atributo que representa la fecha de siembra del elemento agrícola
    protected LocalDate fechaSiembra;

    // Constructor que inicializa los atributos del elemento agrícola
    public ElementoAgricola(String nombre, String estado, LocalDate fechaSiembra) {
        this.nombre = nombre; // Inicializa el nombre del elemento agrícola
        this.estado = estado; // Inicializa el estado del elemento agrícola
        this.fechaSiembra = fechaSiembra; // Inicializa la fecha de siembra
    }

    // Método para obtener el nombre del elemento agrícola
    public String getNombre() { 
        return nombre; 
    }
    
    // Método para obtener el estado del elemento agrícola
    public String getEstado() { 
        return estado; 
    }
    
    // Método para obtener la fecha de siembra del elemento agrícola
    public LocalDate getFechaSiembra() { 
        return fechaSiembra; 
    }
    
    // Método para establecer el nombre del elemento agrícola
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    
    // Método para establecer el estado del elemento agrícola
    public void setEstado(String estado) { 
        this.estado = estado; 
    }
    
    // Método para establecer la fecha de siembra del elemento agrícola
    public void setFechaSiembra(LocalDate fechaSiembra) { 
        this.fechaSiembra = fechaSiembra; 
    }
}
