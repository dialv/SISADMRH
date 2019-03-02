package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadoidioma;

/**
 *
 * @author dialv
 */
public interface EmpleadoIdiomaService {
    Iterable <Empleadoidioma> listAllEmpleadoidiomas();
    
    Optional<Empleadoidioma> getEmpleadoidiomaById(Integer id);

    Empleadoidioma saveEmpleadoidioma(Empleadoidioma idioma);

    void deleteEmpleadoidioma(Integer id);
}
