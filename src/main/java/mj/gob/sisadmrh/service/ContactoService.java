/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Contacto;

/**
 *
 * @author IPalacios
 */

public interface ContactoService {
    Iterable <Contacto> listAllContacto();
    Iterable <Contacto> listAllActivos();
    
    Optional<Contacto> getContactoById(Integer id);

    Contacto saveContacto(Contacto contacto);

    void deleteContacto(Integer id);
    
    Iterable<Contacto> findByDato(int id) ;
}
