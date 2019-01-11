package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.EvaluacionCapacitacion;

/**
 *
 * @author jorge
 */
public interface EvaluacionCapacitacionService {
    Iterable <EvaluacionCapacitacion> listAllEvaluacionCapacitacion();
    
    Iterable <EvaluacionCapacitacion> listAllActivos();
    
    Optional<EvaluacionCapacitacion> getEvualuacionCapacitacionById(Integer id);

    EvaluacionCapacitacion saveEvualuacionCapacitacion(EvaluacionCapacitacion evualuacionCapacitacion);

    void deleteEvualuacionCapacitacion(Integer id);
  
    Iterable<Capacitacion> findByCapacitacion(String dato);
    
}