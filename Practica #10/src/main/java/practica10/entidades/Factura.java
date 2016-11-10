package practica10.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rony- on 10/23/2016.
 */
@Entity
public class Factura implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    private List<Alquiler> equiposAlquilados;

    @OneToOne
    private Usuario cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public List<Alquiler> getEquiposAlquilados() {
        return equiposAlquilados;
    }

    public void setEquiposAlquilados(List<Alquiler> equiposAlquilados) {
        this.equiposAlquilados = equiposAlquilados;
    }
}
