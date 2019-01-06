package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Usuario;

/**
 *
 * @author dialv
 */
public interface UsuarioService {
    Iterable <Usuario> listAllUsuarios();
    
    Optional<Usuario> getUsuarioById(Integer id);

    Usuario saveUsuario(Usuario usuario);

    void deleteUsuario(Integer id);

    Iterable<Usuario> listAllActivos();
}
