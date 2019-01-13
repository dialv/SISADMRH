package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Comision;

/**
 *
 * @author dialv
 */
public interface ComisionService {

    Iterable<Comision> listAllComisiones();

    Iterable<Comision> listAllActivos();

    Optional<Comision> getComisionById(Integer id);

    Comision saveComision(Comision comision);

    void deleteComision(Integer id);

}
