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
    int id;

    private String nombre;

    @OneToOne
    private
    FamiliaEquipo familia;

    @OneToMany(mappedBy = "familia")
    private List<Equipo> equipos;

    @Transient
    private int fID;

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

    public FamiliaEquipo getFamilia() {
        return familia;
    }

    public void setFamiliaEquipo(FamiliaEquipo familia) {
        this.familia = familia;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public int getfID() {
        return fID;
    }

    public void setfID(int fID) {
        this.fID = fID;
    }
}
