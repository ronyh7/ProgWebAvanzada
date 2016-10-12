package Beans;

import Domain.*;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

@ApplicationScoped
@ManagedBean(name ="menuBean")
public class MenuBean {

    private Usuario usuarioLogueado=null;
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();
    private long productoID=0;
    @PostConstruct
    public void inicio(){
        Usuario usuario = new Usuario("admin","admin","administrador","del sistema",new Date(),true);
        getUsuarios().add(usuario);
        Producto p = new Producto(getProductoID(),"Folder","Amarillo",5,20);
        p.getImagenes().add("yellow-folder-4798781363324364238.jpg");
        Producto p1= new Producto(getProductoID(),"PC i3","4GB ram",20,1500);
        p1.getImagenes().add("192rzrjxoksfojpg-5679309492736358166.jpg");
        getProductos().add(p1);
        getProductos().add(p);
    }

    public boolean userExists(){
        boolean user=false;
        if(usuarioLogueado!=null)
            user=true;
        return user;
    }
    public boolean userDoesnExist(){
        return !userExists();
    }


    public String producto(long id){

        return "producto.xhtml?id="+id;
    }

    public String logout(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        session.invalidate();
        usuarioLogueado=null;
        return null;
    }
    public String login(){
        return "login.xhtml";
    }



    public Usuario getUsuarioLogueado() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        Usuario usuario = (Usuario)session.getAttribute("usuario");
        return usuario;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }


    public long getProductoID() {
        productoID++;
        return productoID;
    }

    public boolean isAdmin() {
        return usuarioLogueado.isAdmin();
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void addError(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void setProductoID(long productoID) {
        this.productoID = productoID;
    }

}
