package Vista;

import Controlador.SessionController;
import Modelo.Resultado;

import javax.swing.*;

public class VentanaHistorial {

    public VentanaHistorial(SessionController session){

        StringBuilder sb = new StringBuilder();

        for(Resultado r :
                session.getResultadoController().obtenerHistorial()){

            sb.append(r.getTipo())
                    .append(" - ")
                    .append(r.getNumero())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null,sb.toString());
    }
}