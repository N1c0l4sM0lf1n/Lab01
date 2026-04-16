package Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistro {

    private final JFrame frame = new JFrame("Registro");
    private final JTextField txtUsuario = new JTextField();
    private final JPasswordField txtClave = new JPasswordField();
    private final JTextField txtNombre = new JTextField();
    private final JButton btnRegistrar = new JButton("Registrar");

    public VentanaRegistro() {
        configurarVentana();
        configurarEventos();
    }

    private void configurarVentana() {
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 2));

        frame.add(new JLabel("Modelo.Usuario:"));
        frame.add(txtUsuario);

        frame.add(new JLabel("Clave:"));
        frame.add(txtClave);

        frame.add(new JLabel("Nombre:"));
        frame.add(txtNombre);

        frame.add(btnRegistrar);
    }

    private void configurarEventos() {
        btnRegistrar.addActionListener(e -> registrar());
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void registrar() {
        String u = txtUsuario.getText();
        String p = new String(txtClave.getPassword());
        String n = txtNombre.getText();

        if (u.isEmpty() || p.isEmpty() || n.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Complete todos los campos");
            return;
        }

        VentanaLogin.USUARIOS.add(new Usuario(u, p, n));

        JOptionPane.showMessageDialog(frame, "Modelo.Usuario registrado");

        frame.dispose();
        new VentanaLogin().mostrarVentana();
    }
}