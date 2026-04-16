package Controlador;

import Modelo.*;

public class RuletaController {

    private final Ruleta ruleta;

    public RuletaController(Ruleta ruleta) {
        this.ruleta = ruleta;
    }

    public Resultado jugar(int monto, TipoApuesta tipo) {
        int numero = ruleta.girar();
        boolean gano = ruleta.evaluar(numero, tipo);

        ruleta.apostar(monto, gano);

        return new Resultado(numero, tipo, monto, gano);
    }

    public int getSaldo() {
        return ruleta.getSaldo();
    }

    public void depositar(int monto) {
        ruleta.depositar(monto);
    }
}