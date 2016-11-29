package com.ProgWebA.servicios;

import com.ProgWebA.entidades.Usuario;
import com.ProgWebA.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
        List<Usuario> usuarios = usuarioRepository.findAll();
        if(usuarios.size()==0) {
            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setRol("ROLE_ADMIN");
            creacionUsuario(admin);
        }

    }

    public Usuario user(String username){
        return usuarioRepository.findByUsername(username);
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
