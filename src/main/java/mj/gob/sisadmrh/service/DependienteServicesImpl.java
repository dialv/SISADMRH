package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Dependiente;
import mj.gob.sisadmrh.repository.DependienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Mmachuca
 */
@Service
public class DependienteServicesImpl implements DependienteService {
    private DependienteRepository dependienteRep;
    
        @Autowired
    public void setDependienteRepository(DependienteRepository dependienteRepository) {
        this.dependienteRep = dependienteRepository;
    }

    @Override
    public Iterable<Dependiente> listAllDependiente() {
        return dependienteRep.findAll();
    }

    @Override
    public Iterable<Dependiente> listAllActivos() {
        return dependienteRep.listAllActivos();
    }

    @Override
    public Optional<Dependiente> getDependienteById(Integer id) {
         return dependienteRep.findById(id);
    }

    @Override
    public Dependiente saveDependiente(Dependiente dependiente) {
        return dependienteRep.save(dependiente);
    }

    @Override
    public void deleteDependiente(Integer id) {
        dependienteRep.deleteById(id);
    }
    
    @Override
    public Iterable<Dependiente> findByDato(int id) {
        return dependienteRep.findByDato(id);
        
    }
    @Override
    public void findIntegrity(Dependiente dependiente) {
        if (dependienteRep.findIntegrity(dependiente.getNombredependiente(),
                dependiente.getApellidodependiente(), dependiente.getParentesco()).spliterator().getExactSizeIfKnown() > 1) {
            dependiente.setEstadodependiente(0);
            dependienteRep.save(dependiente);
            findIntegrity(dependiente);
        }
    }
    
}
