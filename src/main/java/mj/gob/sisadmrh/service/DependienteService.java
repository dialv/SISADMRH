/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Dependiente;

/**
 *
 * @author IPalacios
 */

public interface DependienteService {
    Iterable <Dependiente> listAllDependiente();
    
    Optional<Dependiente> getDependienteById(Integer id);

    Dependiente saveDependiente(Dependiente empleado);

    void deleteDependiente(Integer id);
    
    Iterable<Dependiente> findByDato(int id) ;
}
