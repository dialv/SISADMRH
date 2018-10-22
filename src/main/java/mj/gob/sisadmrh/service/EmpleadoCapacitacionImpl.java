/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadocapacitacion;
import mj.gob.sisadmrh.repository.EmpleadoCapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jorge
 */
@Service
public class EmpleadoCapacitacionImpl implements EmpleadoCapacitacionSevice{
    @Autowired
    private EmpleadoCapacitacionRepository empleadoCapacitacionRep;

    @Override
    public Iterable<Empleadocapacitacion> listAllEmpleadoCapacitacion() {
        return empleadoCapacitacionRep.findAll();
    }

    @Override
    public Optional<Empleadocapacitacion> getEmpleadoCapacitacionById(Integer id) {
      return  empleadoCapacitacionRep.findById(id);
    }

    @Override
    public Empleadocapacitacion saveEmpleadoCapacitacion(Empleadocapacitacion empleadocapacitacion) {
return empleadoCapacitacionRep.save(empleadocapacitacion);
    }

    @Override
    public void deleteEmpleadoCapacitacion(Integer id) {
empleadoCapacitacionRep.deleteById(id);
    }
    
}
