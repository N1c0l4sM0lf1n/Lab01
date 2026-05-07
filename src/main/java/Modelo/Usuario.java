package Modelo;

import java.util.*;

public class Usuario {

    private String username;
    private String password;
    private String nombre;
    private List<Resultado> historial = new ArrayList<>();

    public Usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
    }

    public boolean validarCredenciales(String u, String p) {
        return username.equals(u) && password.equals(p);
    }

    public void agregarResultado(Resultado r) {
        historial.add(r);
    }

    public List<Resultado> getHistorial() {
        return historial;
    }

    public String getUsername() { return username; }
    public String getNombre() { return nombre; }
}