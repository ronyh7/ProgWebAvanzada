package practica10.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by rony- on 10/18/2016.
 */
@Entity
public class Usuario implements Serializable{
    @Id
    @GeneratedValue
    private
    long id;

    private String nombre;
    private String apellido;
    private String cedula;
    private String username;
    private String password;
    private String rol;

    public Usuario(String nombre, String apellido, String cedula, String username, String password, String rol){
        this.nombre=nombre;
        this.apellido=apellido;
        this.cedula=cedula;
        this.username=username;
        this.password=password;
        this.rol=rol;
    }




    public boolean isAdmin(){
        if(getRol().equals("admin"))
            return true;

        return false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
