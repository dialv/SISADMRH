/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Formacionacademica;
import mj.gob.sisadmrh.repository.FormacionacademicaRepository;
import mj.gob.sisadmrh.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mmachuca
 */
@Service
public class FormacionacademicaServicesImpl implements FormacionacademicaService {
    private FormacionacademicaRepository formacionacademicaRep;
    
        @Autowired
    public void setFormacionacademicaRepository(FormacionacademicaRepository formacionacademicaRepository) {
        this.formacionacademicaRep = formacionacademicaRepository;
    }

    @Override
    public Iterable<Formacionacademica> listAllFormacionacademica() {
        return formacionacademicaRep.findAll();
    }

    @Override
    public Optional<Formacionacademica> getFormacionacademicaById(Integer id) {
         return formacionacademicaRep.findById(id);
    }

    @Override
    public Formacionacademica saveFormacionacademica(Formacionacademica formacionacademica) {
        return formacionacademicaRep.save(formacionacademica);
    }

    @Override
    public void deleteFormacionacademica(Integer id) {
        formacionacademicaRep.deleteById(id);
    }
    
    @Override
    public Iterable<Formacionacademica> findByDato(int id) {
        return formacionacademicaRep.findByDato(id);
        
    }
}
