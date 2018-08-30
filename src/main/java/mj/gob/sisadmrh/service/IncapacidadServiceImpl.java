/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Incapacidad;
import mj.gob.sisadmrh.repository.IncapacidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service
public class IncapacidadServiceImpl implements IncapacidadService{
    @Autowired// aqui si no funciona ver lo del metodo repository
private IncapacidadRepository incapacidadRep;
    @Override
    public Iterable<Incapacidad> listAllIncapacidad() {
      return incapacidadRep.findAll();
       
    }

    @Override
    public Optional<Incapacidad> getIncapacidadById(Integer id) {
      return incapacidadRep.findById(id);
    }

    @Override
    public Incapacidad saveIIncapacidad(Incapacidad incapacidad) {
        return incapacidadRep.save(incapacidad);
       
    }

    @Override
    public void deleteIncapacidad(Integer id) {
        incapacidadRep.deleteById(id);
       
    }

    @Override
    public Iterable<Incapacidad> findByEmpleado(String dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
