package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Contacto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author IPalacios
 */

public interface ContactoRepository extends CrudRepository<Contacto, Integer>{
@Query(value = "SELECT c.* FROM contacto c, empleadocontacto ec WHERE c.estadocontacto!= '0' and c.codigocontacto = ec.codigocontacto and ec.codigoempleado= :id ", nativeQuery = true)
Iterable<Contacto> findByDato(@Param("id") int dato);

@Query(value = "SELECT c.* FROM contacto c WHERE c.estadocontacto!= '0' and c.nombrecontacto=:nombre and c.apellidocontacto=:ape and c.emailcontacto=:email", nativeQuery = true)
Iterable<Contacto> findIntegrity(@Param("nombre") String nombre, @Param("ape") String ape, @Param("email") String email );
    
@Query("SELECT o FROM Contacto o WHERE o.estadocontacto != '0'")
public Iterable<Contacto> listAllActivos();     

}