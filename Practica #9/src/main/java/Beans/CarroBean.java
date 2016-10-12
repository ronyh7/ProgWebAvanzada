package Beans;

import Domain.Producto;
import Domain.ProductoComprado;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by rony- on 10/4/2016.
 */
@SessionScoped
@ManagedBean(name = "carroBean")
public class CarroBean {


    private HashMap<Long,Integer> carro = new HashMap<>();
    private ArrayList<Producto> productosActuales=new ArrayList<>();
    @ManagedProperty(value = "#{menuBean}")
    private MenuBean menu;
    private Date fechaDeVenta;

    @PostConstruct
    public void inicio(){
        crearCarro();
    }

    public void crearCarro(){
        if(menu.getUsuarioLogueado()!=null){
            carro= menu.getUsuarioLogueado().getCarrito();
            for(int i=0;i< menu.getProductos().size();i++){
                Long j = menu.getProductos().get(i).getId();
                if(carro.containsKey(j)){
                    Producto p = copiar(menu.getProductos().get(i),carro.get(j));
                    productosActuales.add(p);
                }
            }
        }
    }
    public String comprar(){
        for(int i=0; i < productosActuales.size();i++){
            for(int j=0; j< menu.getProductos().size();j++){
                if(productosActuales.get(i).getId()==menu.getProductos().get(j).getId()){
                    if(productosActuales.get(i).getCantidad() <= menu.getProductos().get(j).getCantidad()){
                        int t = menu.getProductos().get(j).getCantidad();
                        int t2= productosActuales.get(i).getCantidad();
                        menu.getProductos().get(j).setCantidad(t-t2);
                        Producto p = productosActuales.get(i);
                        ProductoComprado p1 = new ProductoComprado(p.getId(),p.getNombre(),p.getDescripcion(),p.getCantidad(),p.getPrecio());
                        menu.getUsuarioLogueado().getProductosComprados().add(p1);
                        carro.remove(productosActuales.get(i).getId());
                        productosActuales.remove(i);
                        i--;
                    }
                    else{
                        menu.addMessage("No hay inventario suficiente para vender esa cantidad");
                    }
                }
            }
        }
        return "productosDisponibles.xhtml";
    }
    public void actualizarCarro(Producto p, int cantidad){
        Producto pt = copiar(p,cantidad);
        productosActuales.add(pt);
    }
    public void borrarProducto(Producto p){
        carro.remove(p.getId());
        productosActuales.remove(p);
    }

    public Producto copiar(Producto producto, int cantidad){
        Producto p = new Producto();
        p.setId(producto.getId());
        p.setNombre(producto.getNombre());
        p.setDescripcion(producto.getDescripcion());
        p.setCantidad(cantidad);
        p.setPrecio(producto.getPrecio());

        return p;
    }

    public float total(){
        float total=0;
        for(int i=0;i<productosActuales.size();i++){
            total+= productosActuales.get(i).getCantidad() * productosActuales.get(i).getPrecio();
        }
        return total;
    }

    public HashMap<Long, Integer> getCarro() {
        return carro;
    }

    public void setCarro(HashMap<Long, Integer> carro) {
        this.carro = carro;
    }

    public MenuBean getMenu() {
        return menu;
    }

    public void setMenu(MenuBean menu) {
        this.menu = menu;
    }

    public ArrayList<Producto> getProductosActuales() {
        return productosActuales;
    }

    public void setProductosActuales(ArrayList<Producto> productosActuales) {
        this.productosActuales = productosActuales;
    }

    public Date getFechaDeVenta() {
        return fechaDeVenta;
    }

    public void setFechaDeVenta(Date fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }
}
