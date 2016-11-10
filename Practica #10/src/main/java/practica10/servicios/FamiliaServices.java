package practica10.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practica10.entidades.FamiliaEquipo;
import practica10.entidades.Usuario;
import practica10.repositorios.FamiliaRepository;
import practica10.repositorios.UsuarioRepository;

import java.util.List;

/**
 * Created by rony- on 10/18/2016.
 */
@Service
public class FamiliaServices {

    //Inyectando el repositorio
    @Autowired
    private FamiliaRepository familiaRepository;

    public long cantidadFamilias(){
        return familiaRepository.count();
    }

    /**
     * Indica que será una transacción, ver la anotación...
     * @param familiaEquipo
     * @return
     */
    @Transactional
    public FamiliaEquipo creacionFamilia(FamiliaEquipo familiaEquipo){
        familiaRepository.save(familiaEquipo);
        return familiaEquipo;
    }


    public List<FamiliaEquipo> familiaEquipos(){

        return familiaRepository.findAll();
    }


    public FamiliaEquipo familiaID(int id) {
        return familiaRepository.findById(id);
    }
}
