package com.tecsup.semana05crud.model.entities;

import java.io.Serializable;

public class Administrador implements Serializable {
    private String codigo;
    private String login;
    private String password;  // ✅ corregido
    private String nombres;
    private String apellidos;

    public Administrador() {}

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }   // ✅ corregido
    public void setPassword(String password) { this.password = password; } // ✅ corregido

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    @Override
    public String toString() {
        return "Administrador{" +
                "codigo='" + codigo + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
