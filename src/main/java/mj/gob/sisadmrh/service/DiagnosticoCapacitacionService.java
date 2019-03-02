package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.DiagnosticoCapacitacion;
import mj.gob.sisadmrh.model.Ubicacionfisica;
/**
 *
 * @author jorge
 */
public interface DiagnosticoCapacitacionService {
    Iterable <DiagnosticoCapacitacion> listAllDiagnosticoCapacitacion();
  
    Iterable <DiagnosticoCapacitacion> listAllActivos();
    
    Optional<DiagnosticoCapacitacion> getDiagnosticoCapacitacionById(Integer id);

    DiagnosticoCapacitacion saveDiagnosticoCapacitacion(DiagnosticoCapacitacion diagnosticoCapacitacion);

    void deleteDiagnosticoCapacitacion(Integer id);
    
    Iterable<DiagnosticoCapacitacion> findByUbicacion(String dato);
     
    Iterable <DiagnosticoCapacitacion> Diagnosticoexcel(String finicial, String ffinal);

}
