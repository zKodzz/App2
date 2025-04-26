package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Clase que representa un cultivo, que hereda de ElementoAgricola
public class Cultivo extends ElementoAgricola {
    // Atributo que representa la variedad del cultivo (por ejemplo, "Tomate", "Lechuga", etc.)
    private String variedad;
    
    // Atributo que representa la superficie del cultivo en hectáreas o metros cuadrados
    private double superficie;
    
    // Atributo que representa el código de la parcela donde se encuentra el cultivo
    private String codigoParcela;
    
    // Lista que almacena las actividades asociadas al cultivo
    private List<Actividad> actividades;

    // Constructor que inicializa los atributos del cultivo, incluyendo los heredados de ElementoAgricola
    public Cultivo(String nombre, String variedad, double superficie,
                   String codigoParcela, LocalDate fechaSiembra, String estado) {
        super(nombre, estado, fechaSiembra); // Llama al constructor de la clase padre
        this.variedad = variedad; // Inicializa la variedad del cultivo
        this.superficie = superficie; // Inicializa la superficie del cultivo
        this.codigoParcela = codigoParcela; // Inicializa el código de la parcela
        this.actividades = new ArrayList<>(); // Inicializa la lista de actividades como una nueva ArrayList
    }

    // Método para obtener la variedad del cultivo
    public String getVariedad() { 
        return variedad; 
    }
    
    // Método para obtener la superficie del cultivo
    public double getSuperficie() { 
        return superficie; 
    }
    
    // Método para obtener el código de la parcela
    public String getCodigoParcela() { 
        return codigoParcela; 
    }
    
    // Método para obtener la lista de actividades asociadas al cultivo
    public List<Actividad> getActividades() { 
        return actividades; 
    }
    
    // Método para agregar una nueva actividad a la lista de actividades del cultivo
    public void agregarActividad(Actividad a) { 
        actividades.add(a); 
    }

    // Método para establecer la variedad del cultivo
    public void setVariedad(String v) { 
        this.variedad = v; 
    }
    
    // Método para establecer la superficie del cultivo
    public void setSuperficie(double s) { 
        this.superficie = s; 
    }
    
    // Método para establecer el código de la parcela
    public void setCodigoParcela(String c) { 
        this.codigoParcela = c; 
    }
}
