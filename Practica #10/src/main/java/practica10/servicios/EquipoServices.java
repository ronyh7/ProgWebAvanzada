package practica10.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practica10.entidades.Equipo;
import practica10.entidades.Usuario;
import practica10.repositorios.EquipoRepository;
import practica10.repositorios.UsuarioRepository;

import java.util.List;

/**
 * Created by rony- on 10/18/2016.
 */
@Service
public class EquipoServices {

    //Inyectando el repositorio
    @Autowired
    private EquipoRepository equipoRepository;

    public long cantidadEquipos(){
        return equipoRepository.count();
    }

    /**
     * Indica que será una transacción, ver la anotación...
     * @param equipo
     * @return
     */
    @Transactional
    public Equipo creacionEquipo(Equipo equipo){
        equipoRepository.save(equipo);
        return equipo;
    }


    public List<Equipo> equipos(){

        return equipoRepository.findAll();
    }

    public Equipo equipoByID(int id){
        return equipoRepository.findById(id);
    }


}
