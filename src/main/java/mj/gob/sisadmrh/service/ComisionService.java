package mj.gob.sisadmrh.service;

import java.util.List;
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
     List<Object[]> findByComisionExcel(String finicial, String ffinal);//metood para generar el exel

}
