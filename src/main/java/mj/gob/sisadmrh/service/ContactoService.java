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

    boolean findIntegrity(String nombre, String ape, String email);

    Optional<Contacto> getContactoById(Integer id);

    Contacto saveContacto(Contacto contacto);

    void deleteContacto(Integer id);
    
    Iterable<Contacto> findByDato(int id) ;
}
