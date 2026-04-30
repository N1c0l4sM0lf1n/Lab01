package Vista;

import Controlador.SessionController;
import Modelo.Estadisticas;

import javax.swing.*;
import java.awt.*;

public class VentanaEstadisticas {

    private final SessionController session;
    private final JFrame frame = new JFrame("Estadísticas");

    public VentanaEstadisticas(SessionController session) {
        this.session = session;
        configurar();
    }

    private void configurar() {
        frame.setSize(400,300);
        frame.setLayout(new GridLayout(6,1));

        Estadisticas e = session.getResultadoController().obtenerEstadisticas();

        frame.add(new JLabel("Total jugadas: " + e.getTotalJugadas()));
        frame.add(new JLabel("Victorias: " + e.getVictorias()));
        frame.add(new JLabel("Porcentaje: " + e.getPorcentajeVictorias() + "%"));
        frame.add(new JLabel("Racha máxima: " + e.getRachaMaxima()));
        frame.add(new JLabel("Tipo más jugado: " + e.getTipoMasJugado()));
    }

    public void mostrar() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}