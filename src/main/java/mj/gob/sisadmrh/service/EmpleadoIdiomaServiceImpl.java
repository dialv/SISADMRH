package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadoidioma;
import mj.gob.sisadmrh.repository.EmpleadoIdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class EmpleadoIdiomaServiceImpl implements EmpleadoIdiomaService {

    
    private EmpleadoIdiomaRepository empleadoidiomarep;

    @Autowired
    public void setEmpleadoIdiomaRepository(EmpleadoIdiomaRepository empleadoIdiomaRepository) {
        this.empleadoidiomarep = empleadoIdiomaRepository;
    }


    @Override
    public Iterable<Empleadoidioma> listAllEmpleadoidiomas() {
           return empleadoidiomarep.findAll();
    }

    @Override
    public Optional<Empleadoidioma> getEmpleadoidiomaById(Integer id) {
        return empleadoidiomarep.findById(id);
    }

    @Override
    public Empleadoidioma saveEmpleadoidioma(Empleadoidioma empleadoidioma) {
        return empleadoidiomarep.save(empleadoidioma);
    }

    @Override
    public void deleteEmpleadoidioma(Integer id) {
        empleadoidiomarep.deleteById(id);
    }


}
