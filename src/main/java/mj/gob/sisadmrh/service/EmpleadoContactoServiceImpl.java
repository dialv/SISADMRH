package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadocontacto;
import mj.gob.sisadmrh.repository.EmpleadoContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class EmpleadoContactoServiceImpl implements EmpleadoContactoService {

    
    private EmpleadoContactoRepository empleadocontactorep;

    @Autowired
    public void setEmpleadoContactoRepository(EmpleadoContactoRepository empleadoContactoRepository) {
        this.empleadocontactorep = empleadoContactoRepository;
    }


    @Override
    public Iterable<Empleadocontacto> listAllEmpleadocontactos() {
           return empleadocontactorep.findAll();
    }

    @Override
    public Optional<Empleadocontacto> getEmpleadocontactoById(Integer id) {
        return empleadocontactorep.findById(id);
    }

    @Override
    public Empleadocontacto saveEmpleadocontacto(Empleadocontacto empleadocontacto) {
        return empleadocontactorep.save(empleadocontacto);
    }

    @Override
    public void deleteEmpleadocontacto(Integer id) {
        empleadocontactorep.deleteById(id);
    }


}
