package Beans;

import Domain.Comentario;
import Domain.Producto;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

import javax.faces.bean.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

/**
 * Created by rony- on 10/4/2016.
 */
@ViewScoped
@ManagedBean(name = "productoBean")
public class ProductoBean {
    private long id;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private float precio;
    private int cantidadC;
    @ManagedProperty(value = "#{menuBean}")
    private MenuBean menu;
    @ManagedProperty(value = "#{carroBean}")
    private CarroBean carro;
    private String tituloComentario;
    private String comentario;
    private int rating;
    private Producto producto;
    private UploadedFile file;
    private String imagen;


    public String addProducto() throws IOException{
        this.producto= new Producto(menu.getProductoID(),this.nombre,this.descripcion,this.cantidad,this.precio);
        this.imagen = upload();
        this.producto.getImagenes().add(this.imagen);
        menu.getProductos().add(this.producto);
        limpiar();
        return null;
    }

    public String productoid(long id){
        for(int i=0; i < menu.getProductos().size(); i++) {
            if (menu.getProductos().get(i).getId() == id) {
                producto=menu.getProductos().get(i);
                this.nombre = menu.getProductos().get(i).getNombre();
                this.descripcion = menu.getProductos().get(i).getDescripcion();
                this.cantidad = menu.getProductos().get(i).getCantidad();
                this.precio= menu.getProductos().get(i).getPrecio();
                break;
            }
        }
        return null;
    }
    public String upload() throws IOException {
        String s = this.file.getFileName().substring(0,this.file.getFileName().length()-4);
        String s1 = this.file.getFileName().substring(this.file.getFileName().length()-3);
        Path folder = Paths.get("C:/Users/rony-/Documents/ProgWebAvanzada/Practica #9/target/jsf-primefaces-helloworld-1.0/resources/images");
        //Path folder = Paths.get("C:/Users/rony-/Documents/ProgWebAvanzada/Practica #9/src/main/webapp/resources/images");

        Path path = Files.createTempFile(folder, s + "-", "." + s1);

        try (InputStream input = this.file.getInputstream()) {
            Files.copy(input, path, StandardCopyOption.REPLACE_EXISTING);
        }
        return path.getFileName().toString();
    }
    public void limpiar(){
        this.nombre="";
        this.descripcion="";
        this.cantidad=0;
        this.precio=0;
        this.imagen="";
        this.file=null;
    }

    public void publicarComentario(){
        Comentario c = new Comentario(this.tituloComentario,this.comentario,this.rating);
        producto.getComentarios().add(c);
        producto.getUsuariosOpiniones().add(menu.getUsuarioLogueado());
    }

    public boolean usuarioOpinion(){
        return !producto.getUsuariosOpiniones().contains(menu.getUsuarioLogueado()) || menu.getUsuarioLogueado().getProductosComprados().contains(producto);
    }

    public ArrayList<Comentario> listaComentarios(){
        return producto.getComentarios();
    }
    public String addCarro(long id){
        if(menu.getUsuarioLogueado()!=null) {
            if(this.cantidadC <= producto.getCantidad()) {
                menu.getUsuarioLogueado().getCarrito().put(id, this.cantidadC);
                getCarro().actualizarCarro(producto,this.cantidadC);
            }
            else{
                menu.addError("No hay suficiente inventario");
            }
        }
        return null;
    }

    public String editar(long id){
        if(this.nombre.isEmpty() || this.descripcion.isEmpty() || this.cantidad<1 || this.precio<1){
            menu.addMessage("Fallo la edicion");
            return null;
        }
        else if(menu.getUsuarioLogueado().isAdmin()){
            producto.setNombre(this.nombre);
            producto.setDescripcion(this.descripcion);
            producto.setCantidad(this.cantidad);
            menu.addMessage("Edicion guardada");
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

    public CarroBean getCarro() {
        return carro;
    }

    public void setCarro(CarroBean carro) {
        this.carro = carro;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTituloComentario() {
        return tituloComentario;
    }

    public void setTituloComentario(String tituloComentario) {
        this.tituloComentario = tituloComentario;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public int getCantidadC() {
        return cantidadC;
    }

    public void setCantidadC(int cantidadC) {
        this.cantidadC = cantidadC;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
