package Vista;

import Controlador.SessionController;
import Modelo.TipoApuesta;
import Modelo.Resultado;

import javax.swing.*;
import java.awt.*;

public class VentanaRuleta {

    private final SessionController session;
    private final JFrame frame = new JFrame("Ruleta");

    private final JTextField txtMonto = new JTextField();

    private final JComboBox<String> comboTipo =
            new JComboBox<>(new String[]{"ROJO", "NEGRO", "PAR", "IMPAR"});

    private final JLabel lblSaldo = new JLabel();

    public VentanaRuleta(SessionController session) {
        this.session = session;
        configurar();
    }

    private void configurar() {
        frame.setSize(350, 250);
        frame.setLayout(new GridLayout(5, 2, 5, 5));

        JButton btnJugar = new JButton("Girar");
        JButton btnVolver = new JButton("Volver");

        btnJugar.addActionListener(e -> jugar());
        btnVolver.addActionListener(e -> volver());

        actualizarSaldo();

        frame.add(new JLabel("Monto:"));
        frame.add(txtMonto);

        frame.add(new JLabel("Tipo de apuesta:"));
        frame.add(comboTipo);

        frame.add(btnJugar);
        frame.add(btnVolver);

        frame.add(new JLabel("Saldo actual:"));
        frame.add(lblSaldo);
    }

    private void jugar() {
        try {
            int monto = Integer.parseInt(txtMonto.getText());

            if (monto <= 0) {
                JOptionPane.showMessageDialog(frame, "Monto inválido");
                return;
            }

            // Convertir a ENUM
            TipoApuesta tipo = TipoApuesta.valueOf(
                    comboTipo.getSelectedItem().toString()
            );

            // Usar controlador
            Resultado resultado = session.getRuletaController()
                    .jugar(monto, tipo);



            // Mostrar resultado
            String mensaje =
                    "Número: " + resultado.getNumero() +
                            "\nApuesta: " + resultado.getTipo() +
                            "\nMonto: $" + resultado.getMonto() +
                            "\nResultado: " + (resultado.isGano() ? "GANASTE" : "PERDISTE") +
                            "\nSaldo: $" + session.getRuletaController().getSaldo();

            JOptionPane.showMessageDialog(frame, mensaje);

            actualizarSaldo();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Ingrese un número válido");
        }
    }

    private void actualizarSaldo() {
        int saldo = session.getRuletaController().getSaldo();
        lblSaldo.setText("$" + saldo);
    }

    private void volver() {
        frame.dispose();
        new VentanaMenu(session).mostrar();
    }

    public void mostrar() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}