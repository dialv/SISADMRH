/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.List;
import java.util.Optional;
import mj.gob.sisadmrh.model.Hijodiscapacidad;

/**
 *
 * @author Mmachuca
 */

public interface HijosdiscapacidadService {
    Iterable <Hijodiscapacidad> listAllHijodiscapacidad();
    Iterable <Hijodiscapacidad> listAllActivos();
    
    Optional<Hijodiscapacidad> getHijodiscapacidadById(Integer id);

    Hijodiscapacidad saveHijodiscapacidad(Hijodiscapacidad empleado);

    void deleteHijodiscapacidad(Integer id);
    void findIntegrity(Hijodiscapacidad hijodiscapacidad);
    
    Iterable<Hijodiscapacidad> findByDato(int id) ;
    
    List<Object[]> findhijoscap(String finicial,String ffinal);
}
