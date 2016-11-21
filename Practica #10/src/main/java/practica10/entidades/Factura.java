package practica10.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rony- on 10/23/2016.
 */
@Entity
public class Factura implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(mappedBy = "factura")
    private List<Alquiler> equiposAlquilados;

    @OneToOne
    private Usuario cliente;

    private Date fecha;

    private boolean facturada;

    private boolean activa;

    @Transient
    private float total;

    @Transient
    private boolean vacia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Factura(){
        equiposAlquilados=new ArrayList<>();
        setTotal(0);
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

    public boolean isFacturada() {
        return facturada;
    }

    public void setFacturada(boolean facturada) {
        this.facturada = facturada;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        float r=0;
        for(int i=0;i<equiposAlquilados.size();i++){
            r+=equiposAlquilados.get(i).getEquipo().getCobroDia();
        }
        return r;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean isVacia() {
        for(int i=0;i<equiposAlquilados.size();i++){
            if(!equiposAlquilados.get(i).isDevuelto()){
                return false;
            }
        }
        return true;
    }

    public void setVacia(boolean vacia) {
        this.vacia = vacia;
    }
}
