/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadoasistenciacapacitacion;
import mj.gob.sisadmrh.repository.EmpleadoAsistenciaCapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service
public class EmpleadoAsitenciaCapacitacionServiceImpl implements EmpleadoAsistenciaCapacitacionService{
@Autowired
    private EmpleadoAsistenciaCapacitacionRepository empleadoasistenciaCapacitacionRep;
    @Override
    public Iterable<Empleadoasistenciacapacitacion> listAllEmpleadoAsistenciaCapacitacion() {
return empleadoasistenciaCapacitacionRep.findAll();
    }

    @Override
    public Optional<Empleadoasistenciacapacitacion> getEmpleadoAsistenciaCapacitacionById(Integer id) {
return empleadoasistenciaCapacitacionRep.findById(id);
    }

    @Override
    public Empleadoasistenciacapacitacion saveEmpleadoAsistenciaCapacitacion(Empleadoasistenciacapacitacion empleadoasistenciacapacitacion) {
return empleadoasistenciaCapacitacionRep.save(empleadoasistenciacapacitacion);
    }

    @Override
    public void deleteEmpleadoAsistenciaCapacitacion(Integer id) {
        empleadoasistenciaCapacitacionRep.deleteById(id);
    }
    
}
