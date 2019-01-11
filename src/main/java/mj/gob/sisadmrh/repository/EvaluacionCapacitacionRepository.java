package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.EvaluacionCapacitacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jorge
 */
public interface EvaluacionCapacitacionRepository extends CrudRepository<EvaluacionCapacitacion, Integer>{
   @Query(value = "SELECT ec.* FROM EvualuacionCapacitacion ec WHERE ec.nombrecapacitacion LIKE :nom ", nativeQuery = true)
    Iterable<Capacitacion> findByCapacitacion(@Param("nom") String dato);  

           @Query("SELECT o FROM EvaluacionCapacitacion o WHERE o.estadoevaluacion != 0")
    public Iterable<EvaluacionCapacitacion> listAllActivos(); 
}
