package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.mapper.AppUserMapper;
import mj.gob.sisadmrh.model.Usuario;
import mj.gob.sisadmrh.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    
    private UsuarioRepository usuarioRep;

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRep = usuarioRepository;
    }

    @Override
    public Iterable<Usuario> listAllUsuarios() {
        return usuarioRep.findAll();
    }

    @Override
    public Iterable<Usuario> listAllActivos() {
        return usuarioRep.listAllActivos();
    }

    @Override
    public Optional<Usuario> getUsuarioById(Integer id) {
        return usuarioRep.findById(id);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRep.save(usuario);
    }

    @Override
    public void deleteUsuario(Integer id) {
        usuarioRep.deleteById(id);
    }


    

   
}
