package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadocaparecibidas;

/**
 *
 * @author dialv
 */
public interface EmpleadoCaprecibidasService {
    Iterable <Empleadocaparecibidas> listAllEmpleadocaprecibidass();
    
    Optional<Empleadocaparecibidas> getEmpleadocaprecibidasById(Integer id);

    Empleadocaparecibidas saveEmpleadocaprecibidas(Empleadocaparecibidas caprecibidas);

    void deleteEmpleadocaprecibidas(Integer id);
}
