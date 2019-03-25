package mj.gob.sisadmrh.service;

import java.util.List;
import java.util.Optional;
import mj.gob.sisadmrh.model.Usuariorol;
import mj.gob.sisadmrh.repository.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

    
    private UsuarioRolRepository usuarioRep;

    @Autowired
    public void setUsuarioRolRepository(UsuarioRolRepository usuarioRolRepository) {
        this.usuarioRep = usuarioRolRepository;
    }

    @Override
    public Iterable<Usuariorol> listAllUsuariosrol() {
        return usuarioRep.findAll();
    }

    @Override
    public Optional<Usuariorol> getUsuariorolById(Integer id) {
        return usuarioRep.findById(id);
    }

    @Override
    public Usuariorol saveUsuariorol(Usuariorol usuariorol) {
        return usuarioRep.save(usuariorol);
    }

    @Override
    public List<String> getListroles(Integer usuario) {
        return usuarioRep.getListroles(usuario);
    }

    @Override
    public void deleteUsuariorol(Integer id) {
        usuarioRep.deleteById(id);
    }
}
