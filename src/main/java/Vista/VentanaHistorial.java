package Vista;

import Controlador.SessionController;
import Modelo.Resultado;

import javax.swing.*;

public class VentanaHistorial {

    private SessionController session;

    public VentanaHistorial(SessionController session){
        this.session = session;
    }

    public void mostrar(){

        StringBuilder sb = new StringBuilder();

        for(Resultado r :
                session.getResultadoController().obtenerHistorial()){

            sb.append("Tipo: ")
                    .append(r.getTipo())
                    .append(" | Número: ")
                    .append(r.getNumero())
                    .append(" | Monto: ")
                    .append(r.getMonto())
                    .append(" | ")
                    .append(r.isGano() ? "Ganó" : "Perdió")
                    .append("\n");
        }

        if(sb.length() == 0){
            sb.append("No hay historial disponible.");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}