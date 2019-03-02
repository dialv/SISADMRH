package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Miembroscomision;
import mj.gob.sisadmrh.model.Usuariorol;
import mj.gob.sisadmrh.repository.MiembrosComisionRepository;
import mj.gob.sisadmrh.repository.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class MiembrosComisionServiceImpl implements MiembrosComisionService {

    
    private MiembrosComisionRepository miembrosRep;

    @Autowired
    public void setUsuarioRolRepository(MiembrosComisionRepository miembrosComisionRepository) {
        this.miembrosRep = miembrosComisionRepository;
    }

    @Override
    public Iterable<Miembroscomision> listAllMiembros() {
        return miembrosRep.findAll();
    }

    @Override
    public Optional<Miembroscomision> getmiembroById(Integer id) {
        return miembrosRep.findById(id);
    }

    @Override
    public Miembroscomision savemiembros(Miembroscomision usuariorol) {
        return miembrosRep.save(usuariorol);
    }

    @Override
    public void deleteMiembros(Integer id) {
        miembrosRep.deleteById(id);
    }
}
