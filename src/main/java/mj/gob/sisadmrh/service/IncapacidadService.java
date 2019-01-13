package mj.gob.sisadmrh.service;
import java.util.Optional;
import mj.gob.sisadmrh.model.Incapacidad;

/**
 *
 * @author jorge
 */
public interface IncapacidadService {
        Iterable <Incapacidad> listAllIncapacidad();
        Iterable <Incapacidad> listAllActivos();
    
    Optional<Incapacidad> getIncapacidadById(Integer id);

    Incapacidad saveIIncapacidad(Incapacidad incapacidad);

    void deleteIncapacidad(Integer id);
    Iterable<Incapacidad> findByEmpleado(String dato);
    
    

    
}
