package mj.gob.sisadmrh.service;

import java.util.List;
import java.util.Optional;
import mj.gob.sisadmrh.model.Comite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author daniel
 */
public interface ComiteService {

    Iterable<Comite> listAllComite();

    Iterable<Comite> listAllActivos();

    Page<Comite> listAllComite(Pageable pePageable);

    Optional<Comite> getComiteById(Integer id);

    Comite saveComite(Comite comite);

    void deleteComite(Integer id);

    Iterable<Comite> findByDato(String dato);

    Iterable<Comite> findByComite(String dato);

    List<Object[]> findByeComitesR(String finicial, String ffinal);//metood para generar el exel

}
