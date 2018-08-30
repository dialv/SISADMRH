/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;
import java.util.Optional;
import mj.gob.sisadmrh.model.Incapacidad;

/**
 *
 * @author jorge
 */
public interface IncapacidadService {
        Iterable <Incapacidad> listAllIncapacidad();
    
    Optional<Incapacidad> getIncapacidadById(Integer id);

    Incapacidad saveIIncapacidad(Incapacidad incapacidad);

    void deleteIncapacidad(Integer id);
    Iterable<Incapacidad> findByEmpleado(String dato);
    

    
}
