package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaRuleta {

    private final JFrame frame = new JFrame("Modelo.Ruleta");
    private final JTextField txtMonto = new JTextField();
    private final JComboBox<String> comboTipo =
            new JComboBox<>(new String[]{"R", "N", "P", "I"});
    private final JButton btnJugar = new JButton("Girar");

    private final Ruleta ruleta = new Ruleta();

    public VentanaRuleta() {
        configurarVentana();
        configurarEventos();
    }

    private void configurarVentana() {
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4,2));

        frame.add(new JLabel("Monto:"));
        frame.add(txtMonto);

        frame.add(new JLabel("Apuesta:"));
        frame.add(comboTipo);

        frame.add(btnJugar);
    }

    private void configurarEventos() {
        btnJugar.addActionListener(e -> jugar());
    }

    public void mostrar() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void jugar() {
        try {
            int monto = Integer.parseInt(txtMonto.getText());
            char tipo = comboTipo.getSelectedItem().toString().charAt(0);

            int numero = ruleta.girar();
            boolean gana = ruleta.evaluar(numero, tipo);

            String mensaje = "Número: " + numero + "\n";

            if (gana) {
                mensaje += "Ganaste!";
            } else {
                mensaje += "Perdiste.";
            }

            JOptionPane.showMessageDialog(frame, mensaje);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Monto inválido");
        }
    }
}