/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Caparecibidas;

/**
 *
 * @author Mmachuca
 */

public interface CaparecibidasService {
    Iterable <Caparecibidas> listAllCaparecibidas();
    Iterable <Caparecibidas> listAllActivos();
    
    Optional<Caparecibidas> getCaparecibidasById(Integer id);

    Caparecibidas saveCaparecibidas(Caparecibidas empleado);

    void deleteCaparecibidas(Integer id);
    
    Iterable<Caparecibidas> findByDato(int id) ;
}
