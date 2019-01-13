package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Incapacidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jorge
 */
public interface IncapacidadRepository extends CrudRepository<Incapacidad, Integer>{

    @Query("SELECT o FROM Incapacidad o WHERE o.estadoincapacidad != 0")
    public Iterable<Incapacidad> listAllActivos();     
}
