package practica10.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practica10.entidades.Alquiler;
import practica10.entidades.Usuario;
import practica10.repositorios.AlquilerRepository;
import practica10.repositorios.UsuarioRepository;

import java.util.List;

/**
 * Created by rony- on 10/18/2016.
 */
@Service
public class AlquilerServices {

    //Inyectando el repositorio
    @Autowired
    private AlquilerRepository alquilerRepository;

    public long cantidadAlquileres(){
        return alquilerRepository.count();
    }

    /**
     * Indica que será una transacción, ver la anotación...
     * @param alquiler
     * @return
     */
    @Transactional
    public Alquiler creacionAlquiler(Alquiler alquiler){
        alquilerRepository.save(alquiler);
        return alquiler;
    }

    public List<Alquiler> alquileres(){

        return alquilerRepository.findAll();
    }

    public Alquiler alquilerID(int id){
        return alquilerRepository.consultaAlquiler(id);
    }

    public void borrarAlquiler(Alquiler alquiler){
        alquilerRepository.delete(alquiler);
    }

    /**
     *
     * @param nombre
     * @return
     */
    //public Usuario usuarioPorUsername(String username) {
        //return usuarioRepository.consultaUsuario(username);
    //}
}
