/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Dependiente;
import mj.gob.sisadmrh.repository.DependienteRepository;
import mj.gob.sisadmrh.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author IPalacios
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
    
}
