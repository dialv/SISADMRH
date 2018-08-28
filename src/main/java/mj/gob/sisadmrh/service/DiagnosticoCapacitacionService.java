/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.DiagnosticoCapacitacion;



/**
 *
 * @author jorge
 */
public interface DiagnosticoCapacitacionService {
     Iterable <DiagnosticoCapacitacion> listAllDiagnosticoCapacitacion();
    
    Optional<DiagnosticoCapacitacion> getDiagnosticoCapacitacionById(Integer id);

   DiagnosticoCapacitacion saveDiagnosticoCapacitacion(DiagnosticoCapacitacion diagnosticoCapacitacion);

    void deleteDiagnosticoCapacitacion(Integer id);
    
}
