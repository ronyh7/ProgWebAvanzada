package practica10.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practica10.entidades.FamiliaEquipo;
import practica10.entidades.SubFamiliaEquipo;
import practica10.entidades.Usuario;
import practica10.repositorios.SubFamiliaRepository;
import practica10.repositorios.UsuarioRepository;

import java.util.List;

/**
 * Created by rony- on 10/18/2016.
 */
@Service
public class SubFamiliaServices {

    //Inyectando el repositorio
    @Autowired
    private SubFamiliaRepository subFamiliaRepository;

    public long cantidadSubFamilia(){
        return subFamiliaRepository.count();
    }

    /**
     * Indica que será una transacción, ver la anotación...
     * @param subFamilia
     * @return
     */
    @Transactional
    public SubFamiliaEquipo creacionUsuario(SubFamiliaEquipo subFamilia){
        subFamiliaRepository.save(subFamilia);
        return subFamilia;
    }


    public List<SubFamiliaEquipo> subFamiliaEquipos(){

        return subFamiliaRepository.findAll();
    }

    public List<SubFamiliaEquipo> subFamiliasFamilia(FamiliaEquipo id){
        return subFamiliaRepository.findAllByFamilia(id);
    }



    public SubFamiliaEquipo subFamiliaEquipoID(int id) {
        return subFamiliaRepository.findById(id);
    }

}
