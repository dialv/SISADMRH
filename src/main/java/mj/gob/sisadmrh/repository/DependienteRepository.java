package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Dependiente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author IPalacios
 */
public interface DependienteRepository extends CrudRepository<Dependiente, Integer>{
    @Query(value = "SELECT d.* FROM dependiente d , empleadodependiente ed WHERE d.estadodependiente!='0' and d.codigodependiente = ed.codigodependiente and ed.codigoempleado= :id ", nativeQuery = true)
    Iterable<Dependiente> findByDato(@Param("id") int dato);
    
    @Query(value = " SELECT d.* FROM dependiente d WHERE d.estadodependiente!='0' and d.nombredependiente=:nomdep "
                 + " and d.apellidodependiente=:apedep and d.parentesco=:parent ", nativeQuery = true)
    Iterable<Dependiente> findIntegrity(@Param("nomdep") String nomdep, @Param("apedep") String apedep,@Param("parent") String parent);
    
    @Query("SELECT o FROM Dependiente o WHERE o.estadodependiente != 0")
    public Iterable<Dependiente> listAllActivos(); 
    
}