package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Mision;

/**
 *
 * @author dialv
 */
public interface MisionService {
    Iterable <Mision> listAllMisiones();
    
    Optional<Mision> getMisionById(Integer id);

    Mision saveMision(Mision mision);

    void deleteMision(Integer id);
    
}
