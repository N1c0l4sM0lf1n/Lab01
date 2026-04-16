package Modelo;

import java.util.Random;

public class Ruleta {

    private final Random rng = new Random();

    private final int[] numerosRojos = {
            1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36
    };

    public int girar() {
        return rng.nextInt(37);
    }

    public boolean esRojo(int n) {
        for (int rojo : numerosRojos) {
            if (rojo == n) return true;
        }
        return false;
    }

    public boolean evaluar(int numero, char tipo) {
        if (numero == 0) return false;

        return switch (tipo) {
            case 'R' -> esRojo(numero);
            case 'N' -> !esRojo(numero);
            case 'P' -> numero % 2 == 0;
            case 'I' -> numero % 2 != 0;
            default -> false;
        };
    }
}