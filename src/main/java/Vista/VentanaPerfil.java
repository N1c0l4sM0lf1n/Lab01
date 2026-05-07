package Vista;

import Controlador.SessionController;
import Modelo.Usuario;

import javax.swing.*;

public class VentanaPerfil {

    private SessionController session;

    public VentanaPerfil(SessionController session){
        this.session = session;
    }

    public void mostrar(){

        Usuario u = session.getUsuario();

        JOptionPane.showMessageDialog(
                null,
                "=== PERFIL ===\n\n" +
                        "Usuario: " + u.getUsername() +
                        "\nNombre: " + u.getNombre()
        );
    }
}