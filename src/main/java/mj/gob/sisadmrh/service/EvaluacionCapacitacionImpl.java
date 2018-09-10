/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.EvaluacionCapacitacion;
import mj.gob.sisadmrh.repository.EvaluacionCapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service
public class EvaluacionCapacitacionImpl  implements EvaluacionCapacitacionService{
@Autowired
    private EvaluacionCapacitacionRepository evaCapacitacionRep;
public void SetEvaluacionCapacitacionRepository(EvaluacionCapacitacionRepository evaluacionCapacitacionRepository){
this.evaCapacitacionRep=evaluacionCapacitacionRepository;
}
    @Override
    public Iterable<EvaluacionCapacitacion> listAllEvaluacionCapacitacion() {
      return evaCapacitacionRep.findAll();
    }

    @Override
    public Optional<EvaluacionCapacitacion> getEvualuacionCapacitacionById(Integer id) {
      return evaCapacitacionRep.findById(id);
    }

    @Override
    public EvaluacionCapacitacion saveEvualuacionCapacitacion(EvaluacionCapacitacion evualuacionCapacitacion) {
       return evaCapacitacionRep.save(evualuacionCapacitacion);
    }

    @Override
    public void deleteEvualuacionCapacitacion(Integer id) {
        evaCapacitacionRep.deleteById(id);
    }

    @Override
    public Iterable<Capacitacion> findByCapacitacion(String dato) {
     return evaCapacitacionRep.findByCapacitacion(dato);
    }

  

 
    
}
