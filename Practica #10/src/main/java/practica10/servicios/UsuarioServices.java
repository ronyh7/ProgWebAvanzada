package practica10.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practica10.entidades.Usuario;
import practica10.repositorios.UsuarioRepository;

import java.util.List;

/**
 * Created by rony- on 10/18/2016.
 */
@Service
public class UsuarioServices {

    //Inyectando el repositorio
    @Autowired
    private UsuarioRepository usuarioRepository;

    public long cantidadProfesores(){
        return usuarioRepository.count();
    }

    /**
     * Indica que será una transacción, ver la anotación...
     * @param usuario
     * @return
     */
    @Transactional
    public Usuario creacionUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
        return usuario;
    }

    @Transactional
    public void admin(){
        Usuario admin = new Usuario("Rony","Hernandez","N/A", "admin","admin","admin");
        creacionUsuario(admin);
    }

    public List<Usuario> usuarios(){

        return usuarioRepository.findAll();
    }

    /**
     *
     * @param nombre
     * @return
     */
    /*public List<Usuario> listaProfesorInicia(String nombre){
        System.out.println("Nombre recibido: "+nombre);
        return usuarioRepository.findAllByNombreStartingWith(nombre);
    }

    public List<Usuario> listaProfesorIniciaIgnorandoCase(String nombre){
        System.out.println("Nombre recibido: "+nombre);
        return usuarioRepository.findAllByNombreStartingWithIgnoreCase(nombre);
    }*/

    //public Usuario usuarioPorUsername(String username) {
        //return usuarioRepository.consultaUsuario(username);
    //}
}
