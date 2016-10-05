package Beans;

import Domain.*;
import org.primefaces.push.annotation.Singleton;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;

@ApplicationScoped
@ManagedBean(name ="menuBean")
public class MenuBean {

    private Usuario usuarioLogueado=null;
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();

    @PostConstruct
    public void inicio(){
        login();
    }

    public  String login(){
        if(usuarioLogueado==null){
            usuarioLogueado = new Usuario("admin","admin","administrador","del sistema",new Date());
            getUsuarios().add(usuarioLogueado);
            usuarioLogueado.getCarro().getProductos().put(1L,1);
            Producto p = new Producto(1,"Tampons","BIG TAMPONS",1);
            getProductos().add(p);
        }
        return null;
    }

    public String producto(long id){

        return "producto.xhtml?id="+id;
    }



    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
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


}
