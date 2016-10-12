package Beans;

import Domain.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by rony- on 9/28/2016.
 */

@ViewScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean {
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private Date fechaDeNacimento;
    private boolean admin=false;

    @ManagedProperty(value = "#{menuBean}")
    private MenuBean menu;

    @PostConstruct
    public void inicio(){

    }

    public String nuevoUsuario() {
        Usuario usuario = new Usuario(this.username, this.password, this.nombre, this.apellido, this.fechaDeNacimento, this.admin);
        if (nuevoUsername(usuario)){
            menu.getUsuarios().add(usuario);
            menu.addMessage("Usuario Creado");
            limpiar();
        }
        else
            menu.addError("Este Usuario ya existe");
        return null;
    }

    public void limpiar(){
        this.username="";
        this.password="";
        this.nombre="";
        this.apellido="";
        this.admin=false;
    }

    public String login(){
        if(menu.getUsuarioLogueado()==null) {
            for (int i = 0; i < menu.getUsuarios().size(); i++) {
                if (menu.getUsuarios().get(i).getUsername().equals(this.username)) {
                    if (menu.getUsuarios().get(i).getPassword().equalsIgnoreCase(this.password)) {
                        menu.setUsuarioLogueado(menu.getUsuarios().get(i));
                        FacesContext facesContext = FacesContext.getCurrentInstance();
                        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                        session.setAttribute("usuario",menu.getUsuarios().get(i));
                        return "productosDisponibles.xhtml";
                    }
                }
            }
        }
        return null;
    }
    public boolean nuevoUsername(Usuario u){
        for(int i=0;i< menu.getUsuarios().size();i++){
            if(u.getUsername().equals(menu.getUsuarios().get(i).getUsername())){
                return false;
            }
        }
        return true;
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
