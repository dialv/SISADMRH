package mj.gob.sisadmrh.service;
import java.util.Optional;
import mj.gob.sisadmrh.model.Usuariorol;

/**
 *
 * @author dialv
 */
public interface UsuarioRolService {
    Iterable <Usuariorol> listAllUsuariosrol();
    
    Optional<Usuariorol> getUsuariorolById(Integer id);

    Usuariorol saveUsuariorol(Usuariorol usuariorol);

    void deleteUsuariorol(Integer id);
}
