package Controlador;

import Modelo.*;

public class SessionController {

    private Usuario usuarioActual;
    private Ruleta ruleta;
    private RuletaController ruletaController;
    private ResultadoController resultadoController;

    public void registrarUsuario(String u, String p, String n) {
        usuarioActual = new Usuario(u, p, n);
        ruleta = new Ruleta(1000);

        ruletaController = new RuletaController(ruleta, this);
        resultadoController = new ResultadoController(this);
    }

    public boolean iniciarSesion(String u, String p) {
        return usuarioActual != null &&
                usuarioActual.validarCredenciales(u, p);
    }

    public Usuario getUsuario() {
        return usuarioActual;
    }

    public RuletaController getRuletaController() {
        return ruletaController;
    }

    public ResultadoController getResultadoController() {
        return resultadoController;
    }

    public void cerrarSesion() {
        usuarioActual = null;
    }
}