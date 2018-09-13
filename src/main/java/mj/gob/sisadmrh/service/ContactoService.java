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
    
    Optional<Contacto> getContactoById(Integer id);

    Contacto saveContacto(Contacto empleado);

    void deleteContacto(Integer id);
}
