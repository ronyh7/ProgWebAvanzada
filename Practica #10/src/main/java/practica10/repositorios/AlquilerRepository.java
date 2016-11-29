package practica10.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import practica10.entidades.Alquiler;
import practica10.entidades.Usuario;

import java.util.List;

/**
 * Created by rony- on 10/18/2016.
 */
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {

    @Override
    Alquiler findOne(Long aLong);

    //List<Alquiler> findAll();


    //Documentación de algunas formas de hacer las consultas.
    //http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

    //Ordenando la lista de profesores por fecha.
    //List<Usuario> findAllByOrderByFechaNacimientoDesc();

    //Trabajando con los querys de HQL.
    @Query("select a from Alquiler a where a.id = :id")
    Alquiler consultaAlquiler(@Param("id") int id);


    @Query("select avg(u.diasAlquilado), u.equipo.familia.nombre from Alquiler u where u.devuelto='true' group by u.equipo.familia.id")
    List<Object> diasSubfamilias();

    @Query("select avg(u.diasAlquilado), u.equipo.familia.familia.nombre from Alquiler u where u.devuelto='true' group by u.equipo.familia.familia.id")
    List<Object> diasFamilias();


}
