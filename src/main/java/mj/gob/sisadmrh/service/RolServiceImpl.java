package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Rol;
import mj.gob.sisadmrh.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class RolServiceImpl implements RolService {

    
    private RolRepository rolRep;

    @Autowired
    public void setRolRepository(RolRepository rolRepository) {
        this.rolRep = rolRepository;
    }

    @Override
    public Iterable<Rol> listAllRoles() {
        return rolRep.findAll();
    }

    @Override
    public Optional<Rol> getRolById(Integer id) {
        return rolRep.findById(id);
    }

    @Override
    public Rol saveRol(Rol rol) {
        return rolRep.save(rol);
    }

    @Override
    public void deleteRol(Integer id) {
        rolRep.deleteById(id);
    }

    @Override
    public Iterable<Rol> listAllActivos() {
        return rolRep.listAllActivos();
    }

}
