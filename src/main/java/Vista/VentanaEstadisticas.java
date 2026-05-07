package Vista;

import Controlador.SessionController;
import Modelo.Estadisticas;

import javax.swing.*;

public class VentanaEstadisticas {

    private SessionController session;

    public VentanaEstadisticas(SessionController session){
        this.session = session;
    }

    public void mostrar(){

        Estadisticas e =
                session.getResultadoController()
                        .obtenerEstadisticas();

        JOptionPane.showMessageDialog(
                null,
                "=== ESTADÍSTICAS ===\n\n" +
                        "Total jugadas: " + e.getTotalJugadas() +
                        "\nVictorias: " + e.getVictorias() +
                        "\nPorcentaje: " + e.getPorcentajeVictorias() + "%"
        );
    }
}