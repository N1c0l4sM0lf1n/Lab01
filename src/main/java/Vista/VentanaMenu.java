package Vista;

import Controlador.SessionController;

import javax.swing.*;
import java.awt.*;

public class VentanaMenu {

    private final SessionController session;
    private final JFrame frame = new JFrame("Menú");

    public VentanaMenu(SessionController session) {
        this.session = session;
        configurar();
    }

    private void configurar() {
        frame.setSize(300,250);
        frame.setLayout(new GridLayout(4,1));

        JButton btnJugar = new JButton("Jugar");
        JButton btnHistorial = new JButton("Historial");
        JButton btnSalir = new JButton("Salir");
        JButton btnEstadisticas = new JButton("Estadísticas");

        btnJugar.addActionListener(e -> {
            frame.dispose();
            new VentanaRuleta(session).mostrar();
        });

        btnHistorial.addActionListener(e -> {
            frame.dispose();
            new VentanaHistorial(session).mostrar();
        });

        btnSalir.addActionListener(e -> {
            session.cerrarSesion();
            frame.dispose();
            new VentanaLogin(session).mostrarVentana();
        });

        btnEstadisticas.addActionListener(e -> {
            frame.dispose();
            new VentanaEstadisticas(session).mostrar();
        });

        frame.add(btnJugar);
        frame.add(btnHistorial);
        frame.add(btnSalir);
        frame.add(btnEstadisticas);
    }

    public void mostrar() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}