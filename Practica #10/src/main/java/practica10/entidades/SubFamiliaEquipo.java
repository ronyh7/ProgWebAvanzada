package practica10.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by rony- on 10/18/2016.
 */
@Entity
public class SubFamiliaEquipo implements Serializable{

    @Id
    @GeneratedValue
    private
    long id;

    private String nombre;

    @OneToOne
    private
    FamiliaEquipo familia;

    @OneToMany
    private List<Equipo> equipos;

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

    public FamiliaEquipo getFamilia() {
        return familia;
    }

    public void setFamiliaEquipo(FamiliaEquipo familia) {
        this.familia = familia;
    }
}
