package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadobeneficio;

/**
 *
 * @author dialv
 */
public interface EmpleadoBeneficioService {
    Iterable <Empleadobeneficio> listAllEmpleadobeneficios();
    
    Optional<Empleadobeneficio> getEmpleadobeneficioById(Integer id);

    Empleadobeneficio saveEmpleadobeneficio(Empleadobeneficio beneficio);

    void deleteEmpleadobeneficio(Integer id);
}
