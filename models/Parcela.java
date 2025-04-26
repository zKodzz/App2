package models;

public class Parcela {
    private String codigo;

    public Parcela(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String nuevo) { this.codigo = nuevo; }
}
