import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaLogin {

    public static final List<Usuario> USUARIOS = new ArrayList<>();

    private final JFrame frame = new JFrame("Login - Casino");
    private final JTextField txtUsuario = new JTextField();
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    private final JButton btnRegistro = new JButton("Registrarse");

    public VentanaLogin() {
        inicializarUsuarios();
        configurarVentana();
        configurarEventos();
    }

    private void inicializarUsuarios() {
        USUARIOS.add(new Usuario("admin", "1234", "Administrador"));
        USUARIOS.add(new Usuario("nico", "123", "Nicolás"));
    }

    private void configurarVentana() {
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 2));

        frame.add(new JLabel("Usuario:"));
        frame.add(txtUsuario);

        frame.add(new JLabel("Clave:"));
        frame.add(txtClave);

        frame.add(btnIngresar);
        frame.add(btnRegistro);
    }

    private void configurarEventos() {
        btnIngresar.addActionListener(e -> login());
        btnRegistro.addActionListener(e -> abrirRegistro());
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void login() {
        String user = txtUsuario.getText();
        String pass = new String(txtClave.getPassword());

        String nombre = validarCredenciales(user, pass);

        if (!nombre.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Bienvenido " + nombre);
            frame.dispose();

            new VentanaMenu().mostrar();

        } else {
            JOptionPane.showMessageDialog(frame, "Credenciales incorrectas");
        }
    }

    private String validarCredenciales(String u, String p) {
        for (Usuario user : USUARIOS) {
            if (user.validarCredenciales(u, p)) {
                return user.getNombre();
            }
        }
        return "";
    }

    private void abrirRegistro() {
        frame.dispose();
        new VentanaRegistro().mostrarVentana();
    }
}