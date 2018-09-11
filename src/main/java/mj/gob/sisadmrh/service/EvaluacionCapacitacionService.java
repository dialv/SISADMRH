/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.AsistenciaCapacitacion;
import mj.gob.sisadmrh.model.Capacitacion;

import mj.gob.sisadmrh.model.EvaluacionCapacitacion;

/**
 *
 * @author jorge
 */
public interface EvaluacionCapacitacionService {
     Iterable <EvaluacionCapacitacion> listAllEvaluacionCapacitacion();
    
    Optional<EvaluacionCapacitacion> getEvualuacionCapacitacionById(Integer id);

    EvaluacionCapacitacion saveEvualuacionCapacitacion(EvaluacionCapacitacion evualuacionCapacitacion);

    void deleteEvualuacionCapacitacion(Integer id);
  
    Iterable<Capacitacion> findByCapacitacion(String dato);
    
}
