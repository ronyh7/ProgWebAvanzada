package practica10.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import practica10.entidades.Factura;
import practica10.entidades.Usuario;

import java.util.List;

/**
 * Created by rony- on 10/18/2016.
 */
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    @Override
    Factura findOne(Long aLong);

    Factura findById(int id);

    @Override
    List<Factura> findAll();

    @Query("select u from Factura u where u.cliente = :cliente order by u.fecha")
    List<Factura> findByCliente(@Param("cliente") Usuario cliente);
    @Query("select f from Factura f where f.facturada = true and f.activa=true")
    List<Factura> findActivas();
    @Query("select f from Factura f where f.facturada=true and f.activa=false")
    List<Factura> findPasadas();



    //@Query("select u from Factura u where u.cliente = :cliente and u.checkedOut='true'")
    //Documentación de algunas formas de hacer las consultas.
    //http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

    //Ordenando la lista de profesores por fecha.
    //List<Usuario> findAllByOrderByFechaNacimientoDesc();

    //Trabajando con los querys de HQL.
}
