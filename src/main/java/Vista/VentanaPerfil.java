package Vista;
import javax.swing.*;
import java.awt.*;

public class VentanaPerfil {

    private final SessionController session;
    private final JFrame frame = new JFrame("Perfil");

    private final JTextField txtNombre = new JTextField();

    public VentanaPerfil(SessionController session) {
        this.session = session;
        configurar();
    }

    private void configurar() {
        frame.setSize(300,200);
        frame.setLayout(new GridLayout(5,1));

        JLabel lblUser = new JLabel(
                "Usuario: " + session.getUsuario().getUsername()
        );

        JLabel lblSaldo = new JLabel(
                "Saldo: $" + session.getRuleta().getSaldo()
        );

        JButton btnGuardar = new JButton("Guardar nombre");
        JButton btnDepositar = new JButton("Depositar 500");

        txtNombre.setText(session.getUsuario().getNombre());

        btnGuardar.addActionListener(e -> {
            session.getUsuario().setNombre(txtNombre.getText());
            JOptionPane.showMessageDialog(frame, "Nombre actualizado");
        });

        btnDepositar.addActionListener(e -> {
            session.getRuleta().depositar(500);
            lblSaldo.setText("Saldo: $" + session.getRuleta().getSaldo());
        });

        frame.add(lblUser);
        frame.add(new JLabel("Nombre:"));
        frame.add(txtNombre);
        frame.add(lblSaldo);
        frame.add(btnGuardar);
        frame.add(btnDepositar);
    }

    public void mostrar() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}