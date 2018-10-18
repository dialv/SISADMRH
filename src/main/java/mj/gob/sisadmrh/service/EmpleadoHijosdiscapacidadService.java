package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadohijodiscapacidad;

/**
 *
 * @author dialv
 */
public interface EmpleadoHijosdiscapacidadService {
    Iterable <Empleadohijodiscapacidad> listAllEmpleadohijodiscapacidads();
    
    Optional<Empleadohijodiscapacidad> getEmpleadohijodiscapacidadById(Integer id);

    Empleadohijodiscapacidad saveEmpleadohijodiscapacidad(Empleadohijodiscapacidad hijodiscapacidad);

    void deleteEmpleadohijodiscapacidad(Integer id);
}
