package practica10.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rony- on 10/18/2016.
 */
@Entity
public class Usuario implements Serializable{
    @Id
    private String username;

    private String nombre;
    private String apellido;
    private String cedula;

    private String password;

    private int enabled;

    @OneToMany(mappedBy = "usuario")
    private List<Rol> roles;

    @Transient
    private String rolesTemp;

    public Usuario(String nombre, String apellido, String cedula, String username, String password){
        this.nombre=nombre;
        this.apellido=apellido;
        this.cedula=cedula;
        this.username=username;
        this.password=password;
        this.setEnabled(1);
    }

    public Usuario(){
        this.setEnabled(1);
    }




    public boolean isAdmin(){
        if(getRol().equals("admin"))
            return true;

        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

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

    public List<Rol> getRol() {
        return roles;
    }

    public void setRol(List<Rol> rol) {
        this.roles = rol;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getRolesTemp() {
        return rolesTemp;
    }

    public void setRolesTemp(String rolesTemp) {
        this.rolesTemp = rolesTemp;
    }
}
