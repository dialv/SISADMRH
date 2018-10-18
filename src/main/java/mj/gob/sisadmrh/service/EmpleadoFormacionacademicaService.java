package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadoformacion;

/**
 *
 * @author dialv
 */
public interface EmpleadoFormacionacademicaService {
    Iterable <Empleadoformacion> listAllEmpleadoformacionacademicas();
    
    Optional<Empleadoformacion> getEmpleadoformacionacademicaById(Integer id);

    Empleadoformacion saveEmpleadoformacionacademica(Empleadoformacion formacionacademica);

    void deleteEmpleadoformacionacademica(Integer id);
}
