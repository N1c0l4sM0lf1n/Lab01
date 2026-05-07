package Vista;

import Controlador.SessionController;
import Modelo.*;

import javax.swing.*;

public class VentanaRuleta {

    private SessionController session;

    public VentanaRuleta(SessionController session){
        this.session = session;
    }

    // ESTE MÉTODO LO AGREGAS
    public void mostrar(){
        jugar();
    }

    public void jugar(){

        String opcion = JOptionPane.showInputDialog(
                "ROJO / NEGRO / PAR / IMPAR"
        );

        int monto = Integer.parseInt(
                JOptionPane.showInputDialog("Monto:")
        );

        ApuestaBase apuesta;

        switch (opcion.toUpperCase()) {
            case "ROJO":
                apuesta = new ApuestaRojo(monto);
                break;
            case "NEGRO":
                apuesta = new ApuestaNegro(monto);
                break;
            case "PAR":
                apuesta = new ApuestaPar(monto);
                break;
            default:
                apuesta = new ApuestaImpar(monto);
        }

        Resultado r =
                session.getRuletaController().jugar(apuesta);

        JOptionPane.showMessageDialog(
                null,
                "Número: " + r.getNumero()
                        + "\nTipo: " + r.getTipo()
                        + "\nResultado: " +
                        (r.isGano() ? "Ganaste" : "Perdiste")
        );
    }
}