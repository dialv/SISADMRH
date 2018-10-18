package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadodependiente;
import mj.gob.sisadmrh.repository.EmpleadoDependienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class EmpleadoDependienteServiceImpl implements EmpleadoDependienteService {

    
    private EmpleadoDependienteRepository empleadodependienterep;

    @Autowired
    public void setEmpleadoDependienteRepository(EmpleadoDependienteRepository empleadoDependienteRepository) {
        this.empleadodependienterep = empleadoDependienteRepository;
    }


    @Override
    public Iterable<Empleadodependiente> listAllEmpleadodependientes() {
           return empleadodependienterep.findAll();
    }

    @Override
    public Optional<Empleadodependiente> getEmpleadodependienteById(Integer id) {
        return empleadodependienterep.findById(id);
    }

    @Override
    public Empleadodependiente saveEmpleadodependiente(Empleadodependiente empleadodependiente) {
        return empleadodependienterep.save(empleadodependiente);
    }

    @Override
    public void deleteEmpleadodependiente(Integer id) {
        empleadodependienterep.deleteById(id);
    }


}
