package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadoubicacionfisica;
import mj.gob.sisadmrh.repository.EmpleadoUbicacionfisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class EmpleadoUbicacionfisicaServiceImpl implements EmpleadoUbicacionfisicaService {

    
    private EmpleadoUbicacionfisicaRepository empleadoubicacionfisicarep;

    @Autowired
    public void setEmpleadoUbicacionfisicaRepository(EmpleadoUbicacionfisicaRepository empleadoUbicacionfisicaRepository) {
        this.empleadoubicacionfisicarep = empleadoUbicacionfisicaRepository;
    }


    @Override
    public Iterable<Empleadoubicacionfisica> listAllEmpleadoubicacionfisicas() {
           return empleadoubicacionfisicarep.findAll();
    }

    @Override
    public Optional<Empleadoubicacionfisica> getEmpleadoubicacionfisicaById(Integer id) {
        return empleadoubicacionfisicarep.findById(id);
    }

    @Override
    public Empleadoubicacionfisica saveEmpleadoubicacionfisica(Empleadoubicacionfisica empleadoubicacionfisica) {
        return empleadoubicacionfisicarep.save(empleadoubicacionfisica);
    }

    @Override
    public void deleteEmpleadoubicacionfisica(Integer id) {
        empleadoubicacionfisicarep.deleteById(id);
    }


}
