package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadoexperiencialaboral;

/**
 *
 * @author dialv
 */
public interface EmpleadoExperiencialaboralService {
    Iterable <Empleadoexperiencialaboral> listAllEmpleadoexperiencialaborals();
    
    Optional<Empleadoexperiencialaboral> getEmpleadoexperiencialaboralById(Integer id);

    Empleadoexperiencialaboral saveEmpleadoexperiencialaboral(Empleadoexperiencialaboral experiencialaboral);

    void deleteEmpleadoexperiencialaboral(Integer id);
}
