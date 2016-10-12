package Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by rony- on 9/27/2016.
 */
public class Usuario {
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private Date fechaDeNacimento;
    private boolean admin;
    private HashMap<Long,Integer> carrito;
    private ArrayList<ProductoComprado> productosComprados;


    public Usuario(String username, String password, String nombre, String apellido,Date fechaDeNacimento, boolean admin){
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido= apellido;
        this.fechaDeNacimento = fechaDeNacimento;
        this.admin= admin;
        this.carrito= new HashMap<>();
        this.productosComprados = new ArrayList<>();
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

    public HashMap<Long, Integer> getCarrito() {
        return carrito;
    }

    public void setCarrito(HashMap<Long, Integer> carrito) {
        this.carrito = carrito;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public ArrayList<ProductoComprado> getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados(ArrayList<ProductoComprado> productosComprados) {
        this.productosComprados = productosComprados;
    }
}
