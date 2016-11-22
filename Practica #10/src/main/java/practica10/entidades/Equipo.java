package practica10.entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rony- on 10/18/2016.
 */
@Entity
public class Equipo implements Serializable {
    @Id
    @GeneratedValue
    private
    int id;

    private String nombre;
    private String descripcion;
    private String imagen;
    private int cantidad;
    private int cobroDia;
    @ManyToOne
    private SubFamiliaEquipo familia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public SubFamiliaEquipo getFamilia() {
        return familia;
    }

    public void setFamilia(SubFamiliaEquipo familia) {
        this.familia = familia;
    }

    public int getCobroDia() {
        return cobroDia;
    }

    public void setCobroDia(int cobroDia) {
        this.cobroDia = cobroDia;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
