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
    @Column(name = "enabled", nullable = false, columnDefinition = "int default 1")
    private int enabled;
    private String imagen;


    @OneToMany(mappedBy = "usuario")
    private List<Rol> roles;

    @Transient
    private String rolesTemp;
    @Transient
    private boolean admin;

    public Usuario(){
        this.username=" ";
        this.imagen=" ";
        this.setEnabled(1);
        this.admin=false;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
