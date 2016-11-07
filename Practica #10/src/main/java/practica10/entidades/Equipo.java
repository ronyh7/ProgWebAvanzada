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
    long id;



    private String nombre;
    private String descripcion;
    private int cantidad;
    @ManyToOne
    private SubFamiliaEquipo familia;

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

    public SubFamiliaEquipo getFamilia() {
        return familia;
    }

    public void setFamilia(SubFamiliaEquipo familia) {
        this.familia = familia;
    }
}
