package Modelo;

import java.util.*;

public class Ruleta {

    private int saldo;
    private final Random rng = new Random();

    private final List<Resultado> resultados = new ArrayList<>();

    private final int[] numerosRojos = {
            1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36
    };

    public Ruleta(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public int girar() {
        return rng.nextInt(37);
    }

    public boolean evaluar(int numero, TipoApuesta tipo) {
        if (numero == 0) return false;

        return switch (tipo) {
            case ROJO -> esRojo(numero);
            case NEGRO -> !esRojo(numero);
            case PAR -> numero % 2 == 0;
            case IMPAR -> numero % 2 != 0;
        };
    }

    private boolean esRojo(int n) {
        for (int r : numerosRojos) {
            if (r == n) return true;
        }
        return false;
    }

    public void apostar(int monto, boolean gano) {
        if (gano) saldo += monto;
        else saldo -= monto;
    }

    public void depositar(int monto) {
        if (monto > 0) saldo += monto;
    }

    public int getSaldo() { return saldo; }

    public void registrarResultado(Resultado r) {
        resultados.add(r);
    }
}