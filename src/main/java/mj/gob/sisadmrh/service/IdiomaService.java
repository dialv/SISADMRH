/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Idioma;

/**
 *
 * @author Mmachuca
 */

public interface IdiomaService {
    Iterable <Idioma> listAllIdioma();
    Iterable <Idioma> listAllActivos();
    
    Optional<Idioma> getIdiomaById(Integer id);

    Idioma saveIdioma(Idioma empleado);

    void deleteIdioma(Integer id);
    
    Iterable<Idioma> findByDato(int id) ;
}
