package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadohijodiscapacidad;
import mj.gob.sisadmrh.repository.EmpleadoHijosdiscapacidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class EmpleadoHijosdiscapacidadServiceImpl implements EmpleadoHijosdiscapacidadService {

    
    private EmpleadoHijosdiscapacidadRepository empleadohijodiscapacidadrep;

    @Autowired
    public void setEmpleadoHijosdiscapacidadRepository(EmpleadoHijosdiscapacidadRepository empleadoHijosdiscapacidadRepository) {
        this.empleadohijodiscapacidadrep = empleadoHijosdiscapacidadRepository;
    }


    @Override
    public Iterable<Empleadohijodiscapacidad> listAllEmpleadohijodiscapacidads() {
           return empleadohijodiscapacidadrep.findAll();
    }

    @Override
    public Optional<Empleadohijodiscapacidad> getEmpleadohijodiscapacidadById(Integer id) {
        return empleadohijodiscapacidadrep.findById(id);
    }

    @Override
    public Empleadohijodiscapacidad saveEmpleadohijodiscapacidad(Empleadohijodiscapacidad empleadohijodiscapacidad) {
        return empleadohijodiscapacidadrep.save(empleadohijodiscapacidad);
    }

    @Override
    public void deleteEmpleadohijodiscapacidad(Integer id) {
        empleadohijodiscapacidadrep.deleteById(id);
    }


}
