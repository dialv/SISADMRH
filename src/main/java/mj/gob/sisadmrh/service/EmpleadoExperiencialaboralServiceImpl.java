package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadoexperiencialaboral;
import mj.gob.sisadmrh.repository.EmpleadoExperiencialaboralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class EmpleadoExperiencialaboralServiceImpl implements EmpleadoExperiencialaboralService {

    
    private EmpleadoExperiencialaboralRepository empleadoexperiencialaboralrep;

    @Autowired
    public void setEmpleadoExperiencialaboralRepository(EmpleadoExperiencialaboralRepository empleadoExperiencialaboralRepository) {
        this.empleadoexperiencialaboralrep = empleadoExperiencialaboralRepository;
    }


    @Override
    public Iterable<Empleadoexperiencialaboral> listAllEmpleadoexperiencialaborals() {
           return empleadoexperiencialaboralrep.findAll();
    }

    @Override
    public Optional<Empleadoexperiencialaboral> getEmpleadoexperiencialaboralById(Integer id) {
        return empleadoexperiencialaboralrep.findById(id);
    }

    @Override
    public Empleadoexperiencialaboral saveEmpleadoexperiencialaboral(Empleadoexperiencialaboral empleadoexperiencialaboral) {
        return empleadoexperiencialaboralrep.save(empleadoexperiencialaboral);
    }

    @Override
    public void deleteEmpleadoexperiencialaboral(Integer id) {
        empleadoexperiencialaboralrep.deleteById(id);
    }


}
