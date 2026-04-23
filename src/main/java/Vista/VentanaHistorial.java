package Vista;

import Controlador.SessionController;
import Modelo.Resultado;

import javax.swing.*;
import java.awt.*;

public class VentanaHistorial {

    private final SessionController session;
    private final JFrame frame = new JFrame("Historial");

    public VentanaHistorial(SessionController session) {
        this.session = session;
        configurar();
    }

    private void configurar() {
        frame.setSize(400,300);
        frame.setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setEditable(false);

        StringBuilder sb = new StringBuilder();

        for (Resultado r : session.getResultadoController().obtenerHistorial()) {
            sb.append("Número: ").append(r.getNumero())
                    .append(" | Apuesta: ").append(r.getTipo())
                    .append(" | Monto: ").append(r.getMonto())
                    .append(" | ").append(r.isGano() ? "GANÓ" : "PERDIÓ")
                    .append("\n");
        }

        area.setText(sb.toString());

        frame.add(new JScrollPane(area), BorderLayout.CENTER);
    }

    public void mostrar() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}