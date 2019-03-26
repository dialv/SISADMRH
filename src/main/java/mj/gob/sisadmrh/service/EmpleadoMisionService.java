package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadomision;

/**
 *
 * @author dialv
 */
public interface EmpleadoMisionService {
    Iterable <Empleadomision> listAllEmpleadomisions();
    
    Optional<Empleadomision> getEmpleadomisionById(Integer id);

    Empleadomision saveEmpleadomision(Empleadomision empleadomision);

    void deleteEmpleadomision(Integer id);
}
