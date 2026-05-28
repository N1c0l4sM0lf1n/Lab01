package Controlador;

import Modelo.*;

import java.util.List;

public class ResultadoController {

    private SessionController session;

    private IRepositorioResultados repositorio;

    public ResultadoController(
            SessionController session,
            IRepositorioResultados repositorio){

        this.session = session;
        this.repositorio = repositorio;
    }

    public List<Resultado> obtenerHistorial(){
        return repositorio.obtenerResultados();
    }

    public Estadisticas obtenerEstadisticas(){
        return new Estadisticas(repositorio);
    }
}