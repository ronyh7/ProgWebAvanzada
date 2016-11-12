package practica10.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import practica10.entidades.Usuario;

import java.util.List;

/**
 * Created by rony- on 10/18/2016.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Usuario findByUsername(String username);

    //Documentación de algunas formas de hacer las consultas.
    //http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

    //List<Usuario> findAllByCiudadIsNotNull();
    List<Usuario> findAllByNombreStartingWith(String nombre);
    //Indicando que ignore el tamaño de la letra.
    List<Usuario> findAllByNombreStartingWithIgnoreCase(String nombre);

    //Ordenando la lista de profesores por fecha.
    //List<Usuario> findAllByOrderByFechaNacimientoDesc();

    //Trabajando con los querys de HQL.
   /*@Query("select u from Usuario u where u.username = :username")
    Usuario consultaUsuarioCedula(@Param("cedula") String username);

    @Query(value = "select * from Usuario p where p.cedula = :cedula", nativeQuery = true)
    Usuario consultaUsuarioCedulaNativo(@Param("cedula") String cedula);*/
}
