/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.repository.CapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapacitacionServiceImpl implements CapacitacionService{
private CapacitacionRepository capacitacionRep;
@Autowired
public void SetCapacitacionRepository(CapacitacionRepository capacitacionRepository){
this.capacitacionRep=capacitacionRepository;
}
    @Override
    public Iterable<Capacitacion> listAllCapacitacion() {
        return capacitacionRep.findAll();
      
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Capacitacion> getCapacitacionById(Integer id) {
      return capacitacionRep.findById(id);
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
   
 public Capacitacion saveCapacitacion(Capacitacion capacitacion) {
  return capacitacionRep.save(capacitacion);
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCapacitacion(Integer id) {
       capacitacionRep.deleteById(id);
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Capacitacion> findByDato(String dato) {
        return capacitacionRep.findByDato("%"+dato+"%");
        
    }
    
}
