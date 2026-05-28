package Modelo;

import java.util.Random;

public class Ruleta {

    private int saldo;
    private Random random = new Random();

    private IRepositorioResultados repositorio;

    private final int[] rojos = {
            1,3,5,7,9,12,14,16,18,
            19,21,23,25,27,30,32,34,36
    };

    public Ruleta(int saldo,
                  IRepositorioResultados repositorio) {

        this.saldo = saldo;
        this.repositorio = repositorio;
    }

    public Resultado jugar(ApuestaBase apuesta) {

        int numero = random.nextInt(37);

        String color = obtenerColor(numero);

        boolean gano =
                apuesta.acierta(numero,color);

        if(gano){
            saldo += apuesta.getMonto();
        } else {
            saldo -= apuesta.getMonto();
        }

        Resultado resultado =
                new Resultado(
                        numero,
                        apuesta.getEtiqueta(),
                        apuesta.getMonto(),
                        gano
                );

        repositorio.guardarResultado(resultado);

        return resultado;
    }

    public String obtenerColor(int numero){

        if(numero == 0){
            return "Verde";
        }

        for(int r : rojos){
            if(r == numero){
                return "Rojo";
            }
        }

        return "Negro";
    }

    public int getSaldo(){
        return saldo;
    }
}