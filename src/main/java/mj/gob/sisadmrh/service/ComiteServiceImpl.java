package mj.gob.sisadmrh.service;

import java.util.List;
import java.util.Optional;
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
         }

    @Override
    public Iterable<Comite> listAllActivos() {
         return comiteRep.listAllActivos();
         }

    @Override
    public Optional<Comite> getComiteById(Integer id) {
     return   comiteRep.findById(id);
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
      @Override
    public List<Object[]> findByeComitesR(String finicial, String ffinal) {
        return comiteRep.findByeComitesR(finicial, ffinal);// metood para generar exel de los comites
    }

   

    
}
