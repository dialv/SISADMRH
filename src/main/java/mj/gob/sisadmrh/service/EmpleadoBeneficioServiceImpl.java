package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadobeneficio;
import mj.gob.sisadmrh.model.EmpleadobeneficioPK;
import mj.gob.sisadmrh.repository.EmpleadoBeneficioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class EmpleadoBeneficioServiceImpl implements EmpleadoBeneficioService {

    
    private EmpleadoBeneficioRepository empleadobeneficiorep;

    @Autowired
    public void setEmpleadoBeneficioRepository(EmpleadoBeneficioRepository empleadoBeneficioRepository) {
        this.empleadobeneficiorep = empleadoBeneficioRepository;
    }


    @Override
    public Iterable<Empleadobeneficio> listAllEmpleadobeneficios() {
           return empleadobeneficiorep.findAll();
    }

    @Override
    public Optional<Empleadobeneficio> getEmpleadobeneficioById(Integer id) {
        return empleadobeneficiorep.findById(id);
    }

    @Override
    public Empleadobeneficio saveEmpleadobeneficio(Empleadobeneficio empleadobeneficio) {
        return empleadobeneficiorep.save(empleadobeneficio);
    }

    @Override
    public void deleteEmpleadobeneficio(Empleadobeneficio id) {
        empleadobeneficiorep.delete(id);
    }


}
