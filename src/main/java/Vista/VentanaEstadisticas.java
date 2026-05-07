package Vista;

import Controlador.SessionController;
import Modelo.Estadisticas;

import javax.swing.*;

public class VentanaEstadisticas {

    public VentanaEstadisticas(SessionController session){

        Estadisticas e =
                session.getResultadoController()
                        .obtenerEstadisticas();

        JOptionPane.showMessageDialog(null,
                "Total: " + e.getTotalJugadas()
                        + "\nVictorias: " + e.getVictorias()
                        + "\nPorcentaje: "
                        + e.getPorcentajeVictorias());
    }
}