package practica10.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import practica10.entidades.SubFamiliaEquipo;
import practica10.entidades.Usuario;

import java.util.List;

/**
 * Created by rony- on 10/18/2016.
 */
public interface SubFamiliaRepository extends JpaRepository<SubFamiliaEquipo, Long> {



}
