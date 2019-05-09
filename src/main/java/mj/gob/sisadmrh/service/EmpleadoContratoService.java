package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadocontrato;

/**
 *
 * @author dialv
 */
public interface EmpleadoContratoService {
    Iterable <Empleadocontrato> listAllEmpleadocontratos();
    
    Optional<Empleadocontrato> getEmpleadocontratoById(Integer id);

    Empleadocontrato saveEmpleadocontrato(Empleadocontrato contrato);

    void deleteEmpleadocontrato(Integer id);
}
