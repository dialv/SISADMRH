package mj.gob.sisadmrh.service;

import java.util.List;
import java.util.Optional;
import mj.gob.sisadmrh.model.Puesto;

/**
 *
 * @author dialv
 */
public interface PuestoService {

    Iterable<Puesto> listAllPuestos();

    Iterable<Puesto> listAllActivos();

    Optional<Puesto> getPuestoById(Integer id);

    Puesto savePuesto(Puesto puesto);

    void deletePuesto(Integer id);

    List<Object[]> PuestosoExcel(String finicial, String ffinal);
    
    Optional<Puesto> getPuestoByIdEmpleado(Integer id);

}
