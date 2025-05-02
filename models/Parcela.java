package models;

// Clase que representa una parcela agrícola
public class Parcela {
    // Atributo que representa el código único de la parcela
    private String codigo;

    // Constructor que inicializa el código de la parcela
    public Parcela(String codigo) {
        this.codigo = codigo; // Asigna el código proporcionado al atributo de la parcela
    }

    // Método para obtener el código de la parcela
    public String getCodigo() { 
        return codigo; 
    }
    
    // Método para establecer un nuevo código para la parcela
    public void setCodigo(String nuevo) { 
        this.codigo = nuevo; // Actualiza el código de la parcela con el nuevo valor proporcionado
    }
}
