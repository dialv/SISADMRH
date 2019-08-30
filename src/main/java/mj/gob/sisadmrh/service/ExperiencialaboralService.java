/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Experiencialaboral;

/**
 *
 * @author Mmachuca
 */

public interface ExperiencialaboralService {
    Iterable <Experiencialaboral> listAllExperiencialaboral();
    Iterable <Experiencialaboral> listAllActivos();
    
    Optional<Experiencialaboral> getExperiencialaboralById(Integer id);

    Experiencialaboral saveExperiencialaboral(Experiencialaboral empleado);

    void deleteExperiencialaboral(Integer id);
    
    void findIntegrity(Experiencialaboral experiencialaboral);
    
    Iterable<Experiencialaboral> findByDato(int id) ;
}
