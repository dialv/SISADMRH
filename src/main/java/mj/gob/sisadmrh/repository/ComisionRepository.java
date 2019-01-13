package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Comision;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author dialv
 */
public interface ComisionRepository extends CrudRepository<Comision, Integer>{
    @Query("SELECT o FROM Comision o WHERE o.estadocomision!= 0")
    public Iterable<Comision> listAllActivos();     
}
