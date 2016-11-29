package com.ProgWebA.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Created by rony- on 11/22/2016.
 */
@Entity
public class Usuario {
    @Id
    private String username;
    private String password;
    private String nombre;
    private String correo;
    private String rol;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
