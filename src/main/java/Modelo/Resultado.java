package Modelo;

public class Resultado {

    private int numero;
    private TipoApuesta tipo;
    private int monto;
    private boolean gano;

    public Resultado(int numero, TipoApuesta tipo, int monto, boolean gano) {
        this.numero = numero;
        this.tipo = tipo;
        this.monto = monto;
        this.gano = gano;
    }

    public int getNumero() { return numero; }
    public TipoApuesta getTipo() { return tipo; }
    public int getMonto() { return monto; }
    public boolean isGano() { return gano; }
}