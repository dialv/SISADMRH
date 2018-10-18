package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadodependiente;

/**
 *
 * @author dialv
 */
public interface EmpleadoDependienteService {
    Iterable <Empleadodependiente> listAllEmpleadodependientes();
    
    Optional<Empleadodependiente> getEmpleadodependienteById(Integer id);

    Empleadodependiente saveEmpleadodependiente(Empleadodependiente dependiente);

    void deleteEmpleadodependiente(Integer id);
}
