/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.CostoCapacitacion;
import mj.gob.sisadmrh.repository.CostoCapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostoCapacitacionServiceImpl implements CostoCapacitacionService{
    private CostoCapacitacionRepository costoCapacitacionRep;
    @Autowired
    public void SetCostoCapasitacionRepository(CostoCapacitacionRepository costoCapacitacionRepository){
    this.costoCapacitacionRep=costoCapacitacionRepository;
    }

    @Override
    public Iterable<CostoCapacitacion> listAllCostoCapacitacion() {
return costoCapacitacionRep.findAll();
        
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Iterable<CostoCapacitacion> listAllActivos() {
return costoCapacitacionRep.listAllActivos();
        
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<CostoCapacitacion> getCostoCapacitacionById(Integer id) {
return costoCapacitacionRep.findById(id);
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CostoCapacitacion saveCostoCapacitacion(CostoCapacitacion costoCapacitacion) {
      return costoCapacitacionRep.save(costoCapacitacion);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCostoCapacitacion(Integer id) {
costoCapacitacionRep.deleteById(id);
//hrow new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public Iterable<CostoCapacitacion> findByDato(String dato) {
        return costoCapacitacionRep.findByDato("%"+dato+"%");
        
    }
    
}
