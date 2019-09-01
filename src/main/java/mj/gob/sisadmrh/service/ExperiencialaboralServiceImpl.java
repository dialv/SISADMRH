package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Experiencialaboral;
import mj.gob.sisadmrh.repository.ExperiencialaboralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class ExperiencialaboralServiceImpl implements ExperiencialaboralService {

    
    private ExperiencialaboralRepository experiencialaboralRep;

    @Autowired
    public void setExperiencialaboralRepository(ExperiencialaboralRepository experiencialaboralRepository) {
        this.experiencialaboralRep = experiencialaboralRepository;
    }

    @Override
    public Iterable<Experiencialaboral> listAllExperiencialaboral() {
        return experiencialaboralRep.findAll();
    }
    @Override
    public Iterable<Experiencialaboral> listAllActivos() {
        return experiencialaboralRep.listAllActivos();
    }

    @Override
    public Optional<Experiencialaboral> getExperiencialaboralById(Integer id) {
        return experiencialaboralRep.findById(id);
    }

    @Override
    public Experiencialaboral saveExperiencialaboral(Experiencialaboral experiencialaboral) {
        return experiencialaboralRep.save(experiencialaboral);
    }

    @Override
    public void deleteExperiencialaboral(Integer id) {
        experiencialaboralRep.deleteById(id);
    }
    
     @Override
    public Iterable<Experiencialaboral> findByDato(int id) {
        return experiencialaboralRep.findByDato(id);
        
    }
    
     @Override
    public Experiencialaboral findByExperienciaBycodigoContrato(int id) {
        return experiencialaboralRep.findByExperienciaBycodigoContrato(id);
        
    }
    
    
    @Override
    public void findIntegrity(Experiencialaboral experiencialaboral) {
        Iterable<Experiencialaboral> lista = experiencialaboralRep.findIntegrity(
                experiencialaboral.getSectorexperiencialaboral(), 
                experiencialaboral.getNombreinstitucion(),
                experiencialaboral.getCargo());
        if (lista.spliterator().getExactSizeIfKnown() > 1) {
            lista.iterator().next().setEstadoexp(0);
            experiencialaboralRep.save(lista.iterator().next());
            findIntegrity(lista.iterator().next());
        }
    }

}
