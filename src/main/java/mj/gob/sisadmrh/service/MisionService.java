package mj.gob.sisadmrh.service;

import java.util.List;
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
      List<Object[]> findByMisionExterna1(String finicial, String ffinal);
      List<Object[]> findByMisionExterna2(String finicial, String ffinal);
        List<Object[]> findByMisionInterna(String finicial, String ffinal);
}
