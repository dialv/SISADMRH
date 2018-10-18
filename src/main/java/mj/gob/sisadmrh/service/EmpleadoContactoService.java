package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadocontacto;

/**
 *
 * @author dialv
 */
public interface EmpleadoContactoService {
    Iterable <Empleadocontacto> listAllEmpleadocontactos();
    
    Optional<Empleadocontacto> getEmpleadocontactoById(Integer id);

    Empleadocontacto saveEmpleadocontacto(Empleadocontacto contacto);

    void deleteEmpleadocontacto(Integer id);
}
