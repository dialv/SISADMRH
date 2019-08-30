/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.List;
import java.util.Optional;
import mj.gob.sisadmrh.model.Contrato;
import mj.gob.sisadmrh.repository.ContratoRepository;
import mj.gob.sisadmrh.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mmachuca
 */
@Service
public class ContratoServicesImpl implements ContratoService {
    private ContratoRepository contratoRep;
    
        @Autowired
    public void setContratoRepository(ContratoRepository contratoRepository) {
        this.contratoRep = contratoRepository;
    }

    @Override
    public Iterable<Contrato> listAllContrato() {
        return contratoRep.findAll();
    }
    @Override
    public Iterable<Contrato> listAllActivos() {
        return contratoRep.listAllActivos();
    }

    @Override
    public Optional<Contrato> getContratoById(Integer id) {
         return contratoRep.findById(id);
    }

    @Override
    public Contrato saveContrato(Contrato contrato) {
        return contratoRep.save(contrato);
    }

    @Override
    public void deleteContrato(Integer id) {
        contratoRep.deleteById(id);
    }
    
    @Override
    public Iterable<Contrato> findByDato(int id) {
        return contratoRep.findByDato(id);
        
    }
        
     @Override
     public List<Object[]> getContratoByIdEmpleado(Integer id,Integer id2) {
     return contratoRep.getContratoByIdEmpleado(id,id2);
    }
    
}
