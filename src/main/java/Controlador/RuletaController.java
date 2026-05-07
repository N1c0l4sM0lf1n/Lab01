package Controlador;

import Modelo.*;

public class RuletaController {

    private Ruleta ruleta;
    private SessionController session;

    public RuletaController(Ruleta ruleta,
                            SessionController session){
        this.ruleta = ruleta;
        this.session = session;
    }

    public Resultado jugar(ApuestaBase apuesta){
        Resultado r = ruleta.jugar(apuesta);

        session.getUsuario().agregarResultado(r);

        return r;
    }

    public int getSaldo(){
        return ruleta.getSaldo();
    }
}