package Modelo;

public class Usuario {

    private String username;
    private String password;
    private String nombre;

    public Usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
    }

    public Usuario() {
        this("invitado", "1234", "Invitado");
    }

    public boolean validarCredenciales(String u, String p) {
        return username.equals(u) && password.equals(p);
    }

    public String getUsername() {
        return username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre;
        }
    }
}