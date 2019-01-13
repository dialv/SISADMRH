package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Inasistencia;

/**
 *
 * @author jorge
 */
public interface InasistenciaService {

    Iterable<Inasistencia> listAllInasistencia();

    Iterable<Inasistencia> listAllActivos();

    Optional<Inasistencia> getInasistenciaById(Integer id);

    Inasistencia saveInasistencia(Inasistencia inasistencia);

    void deleteInasistencia(Integer id);

    Iterable<Inasistencia> findByEmpleado(String dato);

    Iterable<Inasistencia> findByMotivo(String dato);

}
