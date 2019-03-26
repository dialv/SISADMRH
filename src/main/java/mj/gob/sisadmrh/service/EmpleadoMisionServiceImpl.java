package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadomision;
import mj.gob.sisadmrh.repository.EmpleadoMisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dialv
 */
@Service
public class EmpleadoMisionServiceImpl implements EmpleadoMisionService {

    
    private EmpleadoMisionRepository empleadomisionrep;

    @Autowired
    public void setEmpleadoMisionepository(EmpleadoMisionRepository empleadoMisionRepository) {
        this.empleadomisionrep = empleadoMisionRepository;
    }
    @Override
    public Iterable<Empleadomision> listAllEmpleadomisions() {
        return this.empleadomisionrep.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Empleadomision> getEmpleadomisionById(Integer id) {
       return this.empleadomisionrep.findById(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleadomision saveEmpleadomision(Empleadomision empleadomision) {
       return this.empleadomisionrep.save(empleadomision); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEmpleadomision(Integer id) {
        this.empleadomisionrep.deleteById(id); //To change body of generated methods, choose Tools | Templates.
    }


}
