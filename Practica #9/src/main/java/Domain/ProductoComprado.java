package Domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by rony- on 10/11/2016.
 */
public class ProductoComprado extends Producto {

    private Date FechaCompra;

    public ProductoComprado(long id, String nombre, String descripcion, int cantidad, float precio){
        this.setId(id);
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setCantidad(cantidad);
        this.setPrecio(precio);
        this.setComentarios(new ArrayList<Comentario>());
        this.setUsuariosOpiniones(new ArrayList<Usuario>());
        this.setImagenes(new ArrayList<String>());
        setFechaCompra(new Date());
    }
    public Date getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        FechaCompra = fechaCompra;
    }
}
