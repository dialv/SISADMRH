package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadocaparecibidas;
import mj.gob.sisadmrh.repository.EmpleadoCaprecibidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class EmpleadoCaprecibidasServiceImpl implements EmpleadoCaprecibidasService {

    
    private EmpleadoCaprecibidasRepository empleadocaprecibidasrep;

    @Autowired
    public void setEmpleadoCaprecibidasRepository(EmpleadoCaprecibidasRepository empleadoCaprecibidasRepository) {
        this.empleadocaprecibidasrep = empleadoCaprecibidasRepository;
    }


    @Override
    public Iterable<Empleadocaparecibidas> listAllEmpleadocaprecibidass() {
           return empleadocaprecibidasrep.findAll();
    }

    @Override
    public Optional<Empleadocaparecibidas> getEmpleadocaprecibidasById(Integer id) {
        return empleadocaprecibidasrep.findById(id);
    }

    @Override
    public Empleadocaparecibidas saveEmpleadocaprecibidas(Empleadocaparecibidas empleadocaprecibidas) {
        return empleadocaprecibidasrep.save(empleadocaprecibidas);
    }

    @Override
    public void deleteEmpleadocaprecibidas(Integer id) {
        empleadocaprecibidasrep.deleteById(id);
    }


}
