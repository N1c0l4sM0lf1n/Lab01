package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin {

    private final SessionController session;
    private final JFrame frame = new JFrame("Login");

    private final JTextField txtUser = new JTextField();
    private final JPasswordField txtPass = new JPasswordField();

    public VentanaLogin(SessionController session) {
        this.session = session;
        configurar();
    }

    private void configurar() {
        frame.setSize(300,200);
        frame.setLayout(new GridLayout(3,2));

        JButton btnLogin = new JButton("Ingresar");
        JButton btnRegistro = new JButton("Registrar");

        btnLogin.addActionListener(e -> login());
        btnRegistro.addActionListener(e -> registrar());

        frame.add(new JLabel("Usuario:"));
        frame.add(txtUser);
        frame.add(new JLabel("Clave:"));
        frame.add(txtPass);
        frame.add(btnLogin);
        frame.add(btnRegistro);
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void login() {
        String u = txtUser.getText();
        String p = new String(txtPass.getPassword());

        if (session.iniciarSesion(u, p)) {
            frame.dispose();
            new VentanaMenu(session).mostrar();
        } else {
            JOptionPane.showMessageDialog(frame, "Error login");
        }
    }

    private void registrar() {
        try {
            session.registrarUsuario(
                    txtUser.getText(),
                    new String(txtPass.getPassword()),
                    "Jugador"
            );
            JOptionPane.showMessageDialog(frame, "Registrado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Datos inválidos");
        }
    }
}