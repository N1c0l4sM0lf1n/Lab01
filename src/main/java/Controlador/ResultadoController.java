package Controlador;

import Modelo.Resultado;
import java.util.ArrayList;
import java.util.List;

public class ResultadoController {

    private final List<Resultado> historial = new ArrayList<>();

    public void agregarResultado(Resultado r) {
        historial.add(r);
    }

    public List<Resultado> getHistorial() {
        return historial;
    }
}