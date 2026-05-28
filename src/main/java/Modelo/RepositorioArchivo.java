package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioArchivo
        implements IRepositorioResultados {

    private static final String ARCHIVO =
            "historial.csv";

    @Override
    public void guardarResultado(Resultado r) {

        try(BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter(ARCHIVO,true))){

            bw.write(
                    r.getNumero() + "," +
                            r.getTipo() + "," +
                            r.getMonto() + "," +
                            r.isGano()
            );

            bw.newLine();

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Resultado> obtenerResultados() {

        List<Resultado> lista = new ArrayList<>();

        try(BufferedReader br =
                    new BufferedReader(
                            new FileReader(ARCHIVO))){

            String linea;

            while((linea = br.readLine()) != null){

                String[] datos = linea.split(",");

                int numero =
                        Integer.parseInt(datos[0]);

                String tipo = datos[1];

                int monto =
                        Integer.parseInt(datos[2]);

                boolean gano =
                        Boolean.parseBoolean(datos[3]);

                lista.add(
                        new Resultado(
                                numero,
                                tipo,
                                monto,
                                gano
                        )
                );
            }

        } catch(IOException e){
            e.printStackTrace();
        }

        return lista;
    }
}