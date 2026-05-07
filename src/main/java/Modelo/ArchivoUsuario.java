package Modelo;

import java.io.*;

public class ArchivoUsuario {

    private static final String ARCHIVO = "usuarios.txt";

    public static void guardarUsuario(Usuario usuario) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO,true))) {

            bw.write(usuario.getUsername() + "," + usuario.getNombre());
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}