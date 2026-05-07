package Vista;

import Controlador.SessionController;

import javax.swing.*;
import java.awt.*;

public class VentanaMenu {

    private final SessionController session;
    private final JFrame frame;

    public VentanaMenu(SessionController session) {
        this.session = session;
        frame = new JFrame("Menú Principal");
        configurar();
    }

    private void configurar() {
        frame.setSize(400,300);
        frame.setLayout(new GridLayout(5,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnJugar = new JButton("Jugar Ruleta");
        JButton btnHistorial = new JButton("Ver Historial");
        JButton btnEstadisticas = new JButton("Ver Estadísticas");
        JButton btnPerfil = new JButton("Perfil");
        JButton btnSalir = new JButton("Cerrar Sesión");

        btnJugar.addActionListener(e ->
                new VentanaRuleta(session).mostrar()
        );

        btnHistorial.addActionListener(e ->
                new VentanaHistorial(session).mostrar()
        );

        btnEstadisticas.addActionListener(e ->
                new VentanaEstadisticas(session).mostrar()
        );

        btnPerfil.addActionListener(e ->
                new VentanaPerfil(session).mostrar()
        );

        btnSalir.addActionListener(e -> {
            session.cerrarSesion();
            frame.dispose();
            new VentanaLogin(session).mostrarVentana();
        });

        frame.add(btnJugar);
        frame.add(btnHistorial);
        frame.add(btnEstadisticas);
        frame.add(btnPerfil);
        frame.add(btnSalir);
    }

    public void mostrar() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}