package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Rol;

/**
 *
 * @author dialv
 */
public interface RolService {
    Iterable <Rol> listAllRoles();
    
    Optional<Rol> getRolById(Integer id);

    Rol saveRol(Rol rol);

    void deleteRol(Integer id);

    Iterable<Rol> listAllActivos();
}
