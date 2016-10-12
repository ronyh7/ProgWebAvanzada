package Domain;

import java.util.ArrayList;

/**
 * Created by rony- on 9/27/2016.
 */
public class Producto {
    private long id;
    private String nombre;
    private String descripcion;
    private float precio;
    private int cantidad;
    private ArrayList<Comentario> comentarios;
    private int ratingPromedio;
    private ArrayList<Usuario> usuariosOpiniones;
    private ArrayList<String> imagenes;

    public Producto(long id, String nombre, String descripcion, int cantidad, float precio){
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.cantidad=cantidad;
        this.precio=precio;
        comentarios = new ArrayList<>();
        usuariosOpiniones = new ArrayList<>();
        imagenes = new ArrayList<>();
    }

    public Producto(){}

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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public int getRatingPromedio() {
        return ratingPromedio;
    }

    public void setRatingPromedio(int ratingPromedio) {
        this.ratingPromedio = ratingPromedio;
    }

    public ArrayList<Usuario> getUsuariosOpiniones() {
        return usuariosOpiniones;
    }

    public void setUsuariosOpiniones(ArrayList<Usuario> usuariosOpiniones) {
        this.usuariosOpiniones = usuariosOpiniones;
    }

    public ArrayList<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<String> imagenes) {
        this.imagenes = imagenes;
    }
}
