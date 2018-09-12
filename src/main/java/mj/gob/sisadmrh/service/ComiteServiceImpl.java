/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Beneficio;
import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.Comite;
import mj.gob.sisadmrh.repository.ComiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author daniel
 */
@Service
public class ComiteServiceImpl implements ComiteService{
    private ComiteRepository comiteRep;
    
    @Autowired
    public void SetComiteRepository(ComiteRepository comiteRepository){
    this.comiteRep=comiteRepository;
    }

    @Override
    public Iterable<Comite> listAllComite() {
         return comiteRep.findAll();
     
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Comite> getComiteById(Integer id) {
     return   comiteRep.findById(id);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comite saveComite(Comite comite) {
    
return comiteRep.save(comite);
//   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteComite(Integer id) {
comiteRep.deleteById(id);
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
@Override
    public Iterable<Comite> findByDato(String dato) {
        return comiteRep.findByDato("%"+dato+"%");
        
    }
  public  Iterable<Comite> findByComite(String dato){
  
  return comiteRep.findByComite("%"+dato+"%");
          }

    @Override
    public Page<Comite> listAllComite(Pageable pePageable) {
return  comiteRep.findAll(pePageable);
    }
}
