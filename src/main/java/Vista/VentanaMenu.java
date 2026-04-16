package Vista;

import javax.swing.*;
import java.awt.*;
import Controlador.SessionController;

public class VentanaMenu {

    private final SessionController session;
    private final JFrame frame = new JFrame("Menú");

    public VentanaMenu(SessionController session) {
        this.session = session;
        configurar();
    }

    private void configurar() {
        frame.setSize(300,200);
        frame.setLayout(new GridLayout(4,1));

        JButton btnJugar = new JButton("Jugar");
        JButton btnPerfil = new JButton("Perfil");
        JButton btnSalir = new JButton("Salir");

        JLabel lblSaldo = new JLabel();

        actualizarSaldo(lblSaldo);

        btnJugar.addActionListener(e -> {
            frame.dispose();
            new VentanaRuleta(session).mostrar();
        });

        btnPerfil.addActionListener(e -> {
            frame.dispose();
            new VentanaPerfil(session).mostrar();
        });

        btnSalir.addActionListener(e -> {
            session.cerrarSesion();
            frame.dispose();
            new VentanaLogin(session).mostrarVentana();
        });

        frame.add(lblSaldo);
        frame.add(btnJugar);
        frame.add(btnPerfil);
        frame.add(btnSalir);
    }

    private void actualizarSaldo(JLabel lbl) {
        int saldo = session.getRuletaController().getSaldo();
        lbl.setText("Saldo: $" + saldo);
    }

    public void mostrar() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}