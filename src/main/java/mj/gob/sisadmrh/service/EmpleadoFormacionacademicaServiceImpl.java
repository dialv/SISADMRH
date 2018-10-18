package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadoformacion;
import mj.gob.sisadmrh.repository.EmpleadoFormacionacademicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class EmpleadoFormacionacademicaServiceImpl implements EmpleadoFormacionacademicaService {

    
    private EmpleadoFormacionacademicaRepository empleadoformacionacademicarep;

    @Autowired
    public void setEmpleadoFormacionacademicaRepository(EmpleadoFormacionacademicaRepository empleadoFormacionacademicaRepository) {
        this.empleadoformacionacademicarep = empleadoFormacionacademicaRepository;
    }


    @Override
    public Iterable<Empleadoformacion> listAllEmpleadoformacionacademicas() {
           return empleadoformacionacademicarep.findAll();
    }

    @Override
    public Optional<Empleadoformacion> getEmpleadoformacionacademicaById(Integer id) {
        return empleadoformacionacademicarep.findById(id);
    }

    @Override
    public Empleadoformacion saveEmpleadoformacionacademica(Empleadoformacion empleadoformacionacademica) {
        return empleadoformacionacademicarep.save(empleadoformacionacademica);
    }

    @Override
    public void deleteEmpleadoformacionacademica(Integer id) {
        empleadoformacionacademicarep.deleteById(id);
    }


}
