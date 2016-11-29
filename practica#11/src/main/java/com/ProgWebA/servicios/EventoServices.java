package com.ProgWebA.servicios;

import com.ProgWebA.entidades.Evento;
import com.ProgWebA.entidades.Usuario;
import com.ProgWebA.repositorios.EventoRepository;
import com.ProgWebA.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rony- on 10/18/2016.
 */
@Service
public class EventoServices {

    //Inyectando el repositorio
    @Autowired
    private EventoRepository eventoRepository;


    public long cantidadEventos(){
        return eventoRepository.count();
    }

    /**
     * Indica que será una transacción, ver la anotación...
     * @param evento
     * @return
     */
    @Transactional
    public Evento creacionEvento(Evento evento){
        eventoRepository.save(evento);
        return evento;
    }



    public List<Evento> eventos(){

        return eventoRepository.findAll();
    }

    public Evento eventoID(int id){
        return eventoRepository.findById(id);
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
