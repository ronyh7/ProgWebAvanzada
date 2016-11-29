package com.ProgWebA.repositorios;

import com.ProgWebA.entidades.Evento;
import com.ProgWebA.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rony- on 10/18/2016.
 */
public interface EventoRepository extends JpaRepository<Evento, Long> {
    
    Evento findById(int id);

    //Documentación de algunas formas de hacer las consultas.
    //http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

    //List<Usuario> findAllByCiudadIsNotNull();
    //List<Usuario> findAllByNombreStartingWith(String nombre);
    //Indicando que ignore el tamaño de la letra.
    //List<Usuario> findAllByNombreStartingWithIgnoreCase(String nombre);

    //Ordenando la lista de profesores por fecha.
    //List<Usuario> findAllByOrderByFechaNacimientoDesc();

    //Trabajando con los querys de HQL.
   /*@Query("select u from Usuario u where u.username = :username")
    Usuario consultaUsuarioCedula(@Param("cedula") String username);

    @Query(value = "select * from Usuario p where p.cedula = :cedula", nativeQuery = true)
    Usuario consultaUsuarioCedulaNativo(@Param("cedula") String cedula);*/
}
