package practica10.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

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
    FamiliaEquipo familiaEquipo;

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

    public FamiliaEquipo getFamiliaEquipo() {
        return familiaEquipo;
    }

    public void setFamiliaEquipo(FamiliaEquipo familiaEquipo) {
        this.familiaEquipo = familiaEquipo;
    }
}
