/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.List;
import java.util.Optional;
import mj.gob.sisadmrh.model.DiagnosticoCapacitacion;
import mj.gob.sisadmrh.model.Ubicacionfisica;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mj.gob.sisadmrh.repository.DiagnosticoCapacitacionRepository;

/**
 *
 * @author jorge
 */
@Service
public class DiagnosticoCapacitacionServiceImpl  implements DiagnosticoCapacitacionService{
    @Autowired
    private DiagnosticoCapacitacionRepository diagnostivoRep;

    @Override
    public Iterable<DiagnosticoCapacitacion> listAllDiagnosticoCapacitacion() {
        return diagnostivoRep.findAll();
      
    }

    @Override
    public Optional<DiagnosticoCapacitacion> getDiagnosticoCapacitacionById(Integer id) {
        return diagnostivoRep.findById(id);
      
    }

    @Override
    public DiagnosticoCapacitacion saveDiagnosticoCapacitacion(DiagnosticoCapacitacion diagnosticoCapacitacion) {
        return diagnostivoRep.save(diagnosticoCapacitacion);
      
    }

    @Override
    public void deleteDiagnosticoCapacitacion(Integer id) {
        diagnostivoRep.deleteById(id);
     
    }

    @Override
    public Iterable<DiagnosticoCapacitacion> findByUbicacion(String dato) {
        return diagnostivoRep.findByUbicacion("%"+dato+"%");
    }
    
     @Override
    public List<Object[]> Diagnosticoexcel(String finicial, String ffinal) {
        return diagnostivoRep.Diagnosticoexcel(finicial, ffinal);
        
    }

    @Override
    public Iterable<DiagnosticoCapacitacion> listAllActivos() {
    return diagnostivoRep.listAllActivos();
              
    }
    
}
