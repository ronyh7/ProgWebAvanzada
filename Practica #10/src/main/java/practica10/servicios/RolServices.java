package practica10.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practica10.entidades.Rol;
import practica10.entidades.SubFamiliaEquipo;
import practica10.repositorios.RolRepository;
import practica10.repositorios.SubFamiliaRepository;

import java.util.List;

/**
 * Created by rony- on 10/18/2016.
 */
@Service
public class RolServices {

    //Inyectando el repositorio
    @Autowired
    private RolRepository rolRepository;


    /**
     * Indica que será una transacción, ver la anotación...
     * @param rol
     * @return
     */
    @Transactional
    public Rol creacionRol (Rol rol){
        rolRepository.save(rol);
        return rol;
    }


    public List<Rol> roles(){

        return rolRepository.findAll();
    }


    //public Usuario usuarioPorUsername(String username) {
        //return usuarioRepository.consultaUsuario(username);
    //}
}
