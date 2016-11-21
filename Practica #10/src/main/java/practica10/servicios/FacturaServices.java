package practica10.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practica10.entidades.Factura;
import practica10.entidades.Usuario;
import practica10.repositorios.FacturaRepository;
import practica10.repositorios.UsuarioRepository;

import java.util.List;

/**
 * Created by rony- on 10/18/2016.
 */
@Service
public class FacturaServices {

    //Inyectando el repositorio
    @Autowired
    private FacturaRepository facturaRepository;

    public long cantidadFacturas(){
        return facturaRepository.count();
    }

    /**
     * Indica que será una transacción, ver la anotación...
     * @param factura
     * @return
     */
    @Transactional
    public Factura creacionFactura(Factura factura){
        facturaRepository.save(factura);
        return factura;
    }

    public List<Factura> facturas(){

        return facturaRepository.findAll();
    }

    public List<Factura> facturaUsuario(Usuario usuario){
        return facturaRepository.findByCliente(usuario);
    }

    public Factura facturaID(int id){
        return facturaRepository.findById(id);
    }


    //public Usuario usuarioPorUsername(String username) {
        //return usuarioRepository.consultaUsuario(username);
    //}
}
