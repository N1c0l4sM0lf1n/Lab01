package Modelo;

import java.util.List;

public class Estadisticas {

	private int totalJugadas;
	private int victorias;
	private double porcentajeVictorias;

	public Estadisticas(
			IRepositorioResultados repositorio){

		List<Resultado> historial =
				repositorio.obtenerResultados();

		totalJugadas = historial.size();

		for(Resultado r : historial){

			if(r.isGano()){
				victorias++;
			}
		}

		if(totalJugadas > 0){

			porcentajeVictorias =
					(victorias * 100.0)
							/ totalJugadas;
		}
	}

	public int getTotalJugadas() {
		return totalJugadas;
	}

	public int getVictorias() {
		return victorias;
	}

	public double getPorcentajeVictorias() {
		return porcentajeVictorias;
	}
}