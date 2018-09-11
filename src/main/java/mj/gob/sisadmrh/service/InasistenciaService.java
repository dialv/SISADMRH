/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Comite;
import mj.gob.sisadmrh.model.Inasistencia;

/**
 *
 * @author jorge
 */
public interface InasistenciaService {
       Iterable <Inasistencia> listAllInasistencia();
    
    Optional<Inasistencia> getInasistenciaById(Integer id);

    Inasistencia saveInasistencia(Inasistencia inasistencia);

    void deleteInasistencia(Integer id);
    Iterable<Inasistencia> findByEmpleado(String dato);
    Iterable<Inasistencia> findByMotivo(String dato);
    
    
}
