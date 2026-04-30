package Modelo;

import java.util.*;

public class Estadisticas {

	private int totalJugadas;
	private int victorias;
	private double porcentajeVictorias;
	private int rachaMaxima;
	private TipoApuesta tipoMasJugado;

	public Estadisticas(List<Resultado> historial) {
		calcular(historial);
	}

	private void calcular(List<Resultado> historial) {

		totalJugadas = historial.size();

		if (totalJugadas == 0) return;

		int rachaActual = 0;
		Map<TipoApuesta, Integer> contador = new HashMap<>();

		for (Resultado r : historial) {

			if (r.isGano()) {
				victorias++;
				rachaActual++;
				rachaMaxima = Math.max(rachaMaxima, rachaActual);
			} else {
				rachaActual = 0;
			}

			contador.put(r.getTipo(),
					contador.getOrDefault(r.getTipo(), 0) + 1);
		}

		porcentajeVictorias = (victorias * 100.0) / totalJugadas;

		tipoMasJugado = Collections.max(
				contador.entrySet(),
				Map.Entry.comparingByValue()
		).getKey();
	}

	public int getTotalJugadas() { return totalJugadas; }
	public int getVictorias() { return victorias; }
	public double getPorcentajeVictorias() { return porcentajeVictorias; }
	public int getRachaMaxima() { return rachaMaxima; }
	public TipoApuesta getTipoMasJugado() { return tipoMasJugado; }

}