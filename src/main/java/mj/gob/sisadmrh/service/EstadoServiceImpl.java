package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Estado;
//import mj.gob.sisadmrh.model.Usuario;
import mj.gob.sisadmrh.repository.EstadoRepository;
//import mj.gob.sisadmrh.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class EstadoServiceImpl implements EstadoService {

    
    private EstadoRepository estadoRep;

    @Autowired
    public void setEstadoRepository(EstadoRepository estadoRepository) {
        this.estadoRep = estadoRepository;
    }

    @Override
    public Iterable<Estado> listAllEstado() {
        return estadoRep.findAll();
    }

    @Override
    public Optional<Estado> getEstadoById(Integer id) {
        return estadoRep.findById(id);
    }

    @Override
    public Estado saveEstado(Estado estado) {
        return estadoRep.save(estado);
    }

    @Override
    public void deleteEstado(Integer id) {
        estadoRep.deleteById(id);
    }

    @Override
    public Iterable<Estado> findBySuperior(Integer est) {
    return estadoRep.findBySuperior(est); 
    }
    

}
