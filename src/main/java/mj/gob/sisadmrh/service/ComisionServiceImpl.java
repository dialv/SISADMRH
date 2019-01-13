package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Comision;
import mj.gob.sisadmrh.repository.ComisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class ComisionServiceImpl implements ComisionService {

    private ComisionRepository comisionRep;

    @Autowired
    public void setComisionRepository(ComisionRepository comisionRepository) {
        this.comisionRep = comisionRepository;
    }

    @Override
    public Iterable<Comision> listAllComisiones() {
        return comisionRep.findAll();
    }

    @Override
    public Optional<Comision> getComisionById(Integer id) {
        return comisionRep.findById(id);
    }

    @Override
    public Comision saveComision(Comision comision) {
        return comisionRep.save(comision);
    }

    @Override
    public void deleteComision(Integer id) {
        comisionRep.deleteById(id);
    }

    @Override
    public Iterable<Comision> listAllActivos() {
        return comisionRep.listAllActivos();
    }

}
