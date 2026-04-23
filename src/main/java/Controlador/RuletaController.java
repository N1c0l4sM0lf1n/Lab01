package Controlador;

import Modelo.*;

public class RuletaController {

    private final Ruleta ruleta;
    private final SessionController session;

    public RuletaController(Ruleta ruleta, SessionController session) {
        this.ruleta = ruleta;
        this.session = session;
    }

    public Resultado jugar(int monto, TipoApuesta tipo) {

        int numero = ruleta.girar();
        boolean gano = ruleta.evaluar(numero, tipo);

        ruleta.apostar(monto, gano);

        Resultado r = new Resultado(numero, tipo, monto, gano);

        // 🔥 GUARDAR EN RUETA
        ruleta.registrarResultado(r);

        // 🔥 GUARDAR EN USUARIO
        session.getUsuario().agregarResultado(r);

        return r;
    }

    public int getSaldo() {
        return ruleta.getSaldo();
    }

    public void depositar(int monto) {
        ruleta.depositar(monto);
    }
}