package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadoubicacionfisica;

/**
 *
 * @author dialv
 */
public interface EmpleadoUbicacionfisicaService {
    Iterable <Empleadoubicacionfisica> listAllEmpleadoubicacionfisicas();
    
    Optional<Empleadoubicacionfisica> getEmpleadoubicacionfisicaById(Integer id);

    Empleadoubicacionfisica saveEmpleadoubicacionfisica(Empleadoubicacionfisica ubicacionfisica);

    void deleteEmpleadoubicacionfisica(Integer id);
}
