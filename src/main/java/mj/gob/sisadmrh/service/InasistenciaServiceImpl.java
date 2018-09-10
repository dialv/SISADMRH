/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Inasistencia;
import mj.gob.sisadmrh.repository.InasistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service
public class InasistenciaServiceImpl implements InasistenciaService{
    private InasistenciaRepository inasistenciaRep;
   @Autowired
    public void SetInasistenciaRepository(InasistenciaRepository inasistenciaRepository){
    this.inasistenciaRep=inasistenciaRepository;
    }

    @Override
    public Iterable<Inasistencia> listAllInasistencia() {
     return inasistenciaRep.findAll();
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Inasistencia> getInasistenciaById(Integer id) {
      return inasistenciaRep.findById(id);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inasistencia saveInasistencia(Inasistencia inasistencia) {
     return inasistenciaRep.save(inasistencia);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInasistencia(Integer id) {
        inasistenciaRep.deleteById(id);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Inasistencia> findByMotivo(String dato) {
 return inasistenciaRep.findByMotivo("%"+dato+"%");
    }
     public Iterable<Inasistencia> findByEmpleado(String dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
