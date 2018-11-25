package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Estado;

/**
 *
 * @author dialv
 */
public interface EstadoService {
    Iterable <Estado> listAllEstado();
    
    Optional<Estado> getEstadoById(Integer id);

    Estado saveEstado(Estado estado);

    void deleteEstado(Integer id);
    
    Iterable<Estado> findBySuperior(Integer est); 
}
