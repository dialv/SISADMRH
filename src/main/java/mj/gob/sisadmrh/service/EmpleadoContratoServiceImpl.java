package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadocontrato;
import mj.gob.sisadmrh.repository.EmpleadoContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class EmpleadoContratoServiceImpl implements EmpleadoContratoService {

    
    private EmpleadoContratoRepository empleadocontratorep;

    @Autowired
    public void setEmpleadoContratoRepository(EmpleadoContratoRepository empleadoContratoRepository) {
        this.empleadocontratorep = empleadoContratoRepository;
    }


    @Override
    public Iterable<Empleadocontrato> listAllEmpleadocontratos() {
           return empleadocontratorep.findAll();
    }

    @Override
    public Optional<Empleadocontrato> getEmpleadocontratoById(Integer id) {
        return empleadocontratorep.findById(id);
    }

    @Override
    public Empleadocontrato saveEmpleadocontrato(Empleadocontrato empleadocontrato) {
        return empleadocontratorep.save(empleadocontrato);
    }

    @Override
    public void deleteEmpleadocontrato(Integer id) {
        empleadocontratorep.deleteById(id);
    }


}
