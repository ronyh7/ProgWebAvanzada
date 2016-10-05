package Domain;

/**
 * Created by rony- on 9/27/2016.
 */
public class Producto {
    private long id;
    private String nombre;
    private String descripcion;
    private int cantidad;

    public Producto(long id, String nombre, String descripcion, int cantidad){
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.cantidad=cantidad;
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
}
