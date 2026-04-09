import javax.swing.*;
import java.awt.*;

public class VentanaMenu {

    private final JFrame frame = new JFrame("Menú");
    private final JButton btnJugar = new JButton("Jugar Ruleta");
    private final JButton btnSalir = new JButton("Cerrar Sesión");

    public VentanaMenu() {
        configurarVentana();
        configurarEventos();
    }

    private void configurarVentana() {
        frame.setSize(300, 150);
        frame.setLayout(new GridLayout(2,1));

        frame.add(btnJugar);
        frame.add(btnSalir);
    }

    private void configurarEventos() {
        btnJugar.addActionListener(e -> abrirRuleta());
        btnSalir.addActionListener(e -> cerrarSesion());
    }

    public void mostrar() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void abrirRuleta() {
        frame.dispose();
        new VentanaRuleta().mostrar();
    }

    private void cerrarSesion() {
        frame.dispose();
        new VentanaLogin().mostrarVentana();
    }
}