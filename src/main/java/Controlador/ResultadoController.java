package Controlador;

import Modelo.Resultado;
import java.util.List;

public class ResultadoController {

    private final SessionController session;

    public ResultadoController(SessionController session) {
        this.session = session;
    }

    public List<Resultado> obtenerHistorial() {
        return session.getUsuario().getHistorial();
    }
}