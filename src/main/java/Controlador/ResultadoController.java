package Controlador;

import Modelo.*;

import java.util.List;

public class ResultadoController {

    private SessionController session;

    public ResultadoController(SessionController session){
        this.session = session;
    }

    public List<Resultado> obtenerHistorial(){
        return session.getUsuario().getHistorial();
    }

    public Estadisticas obtenerEstadisticas(){
        return new Estadisticas(obtenerHistorial());
    }
}