/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Formacionacademica;

/**
 *
 * @author IPalacios
 */

public interface FormacionacademicaService {
    Iterable <Formacionacademica> listAllFormacionacademica();
    
    Optional<Formacionacademica> getFormacionacademicaById(Integer id);

    Formacionacademica saveFormacionacademica(Formacionacademica empleado);

    void deleteFormacionacademica(Integer id);
}
