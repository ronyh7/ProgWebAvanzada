package Domain;

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
    private Carro carro;
    private HashMap<Producto,Integer> carrito;

    public Usuario(String username, String password, String nombre, String apellido, Date fechaDeNacimento){
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido= apellido;
        this.fechaDeNacimento = fechaDeNacimento;
        this.carro = new Carro();
        this.setCarrito(new HashMap());

    }

    public Usuario(String username, String password, String nombre, String apellido){
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido= apellido;
        this.carro = new Carro();

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

    public HashMap<Producto, Integer> getCarrito() {
        return carrito;
    }

    public void setCarrito(HashMap<Producto, Integer> carrito) {
        this.carrito = carrito;
    }
}
