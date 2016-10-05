package Beans;

import Domain.Carro;
import Domain.Usuario;
import javafx.scene.control.Menu;
import org.primefaces.push.annotation.Singleton;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by rony- on 9/28/2016.
 */

@SessionScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean {
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private Date fechaDeNacimento;
    private Carro carro = new Carro();
    @ManagedProperty(value = "#{menuBean}")
    private MenuBean menu;

    @PostConstruct
    public void inicio(){

    }



    public String nuevoUsuario(){
        Usuario usuario = new Usuario(this.username,this.password,this.nombre,this.apellido,this.fechaDeNacimento);
        menu.getUsuarios().add(usuario);
        return null;
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

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
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

    public Date getFechaDeNacimento() {
        return fechaDeNacimento;
    }

    public void setFechaDeNacimento(Date fechaDeNacimento) {
        this.fechaDeNacimento = fechaDeNacimento;
    }

    public MenuBean getMenu() {
        return menu;
    }

    public void setMenu(MenuBean menu) {
        this.menu = menu;
    }
}
