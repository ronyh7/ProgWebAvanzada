package Beans;

import Domain.Producto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * Created by rony- on 10/4/2016.
 */
@SessionScoped
@ManagedBean(name = "productoBean")
public class ProductoBean {
    private long id;
    private String nombre;
    private String descripcion;
    private int cantidad;
    @ManagedProperty(value = "#{menuBean}")
    private MenuBean menu;

    public String addProducto(){
        Producto p1= new Producto(this.id,this.nombre,this.descripcion,this.cantidad);
        menu.getProductos().add(p1);
        return null;
    }

    public String producto(long id){
        for(int i=0; i < menu.getProductos().size(); i++) {
            if (menu.getProductos().get(i).getId() == id) {
                this.nombre = menu.getProductos().get(i).getNombre();
                this.descripcion = menu.getProductos().get(i).getDescripcion();
                break;
            }
        }
        return null;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public MenuBean getMenu() {
        return menu;
    }

    public void setMenu(MenuBean menu) {
        this.menu = menu;
    }
}
