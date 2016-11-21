package practica10.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by rony- on 11/1/2016.
 */
@Entity
public class Rol implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private String rol;

    @ManyToOne
    private Usuario usuario;

    public Rol(){}


    public Rol(String rol){
        this.rol=rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
