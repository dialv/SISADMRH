/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Idioma;
import mj.gob.sisadmrh.repository.IdiomaRepository;
import mj.gob.sisadmrh.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Mmachuca
 */
@Service
public class IdiomaServicesImpl implements IdiomaService {
    private IdiomaRepository idiomaRep;
    
        @Autowired
    public void setIdiomaRepository(IdiomaRepository idiomaRepository) {
        this.idiomaRep = idiomaRepository;
    }

    @Override
    public Iterable<Idioma> listAllIdioma() {
        return idiomaRep.findAll();
    }

    @Override
    public Iterable<Idioma> listAllActivos() {
        return idiomaRep.listAllActivos();
    }

    @Override
    public Optional<Idioma> getIdiomaById(Integer id) {
         return idiomaRep.findById(id);
    }

    @Override
    public Idioma saveIdioma(Idioma idioma) {
        return idiomaRep.save(idioma);
    }

    @Override
    public void deleteIdioma(Integer id) {
        idiomaRep.deleteById(id);
    }
    
    @Override
    public Iterable<Idioma> findByDato(int id) {
        return idiomaRep.findByDato(id);
        
    }
    
}
