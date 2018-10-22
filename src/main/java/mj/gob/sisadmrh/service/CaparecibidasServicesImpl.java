/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Caparecibidas;
import mj.gob.sisadmrh.repository.CaparecibidasRepository;
import mj.gob.sisadmrh.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Mmachuca
 */
@Service
public class CaparecibidasServicesImpl implements CaparecibidasService {
    private CaparecibidasRepository caparecibidasRep;
    
        @Autowired
    public void setCaparecibidasRepository(CaparecibidasRepository caparecibidasRepository) {
        this.caparecibidasRep = caparecibidasRepository;
    }

    @Override
    public Iterable<Caparecibidas> listAllCaparecibidas() {
        return caparecibidasRep.findAll();
    }

    @Override
    public Optional<Caparecibidas> getCaparecibidasById(Integer id) {
         return caparecibidasRep.findById(id);
    }

    @Override
    public Caparecibidas saveCaparecibidas(Caparecibidas caparecibidas) {
        return caparecibidasRep.save(caparecibidas);
    }

    @Override
    public void deleteCaparecibidas(Integer id) {
        caparecibidasRep.deleteById(id);
    }
    
    @Override
    public Iterable<Caparecibidas> findByDato(int id) {
        return caparecibidasRep.findByDato(id);
        
    }
    
}
