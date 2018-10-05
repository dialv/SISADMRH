/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadocapacitacion;

/**
 *
 * @author jorge
 */
public interface EmpleadoCapacitacionSevice {
     Iterable <Empleadocapacitacion> listAllEmpleadoCapacitacion();
    
    Optional<Empleadocapacitacion> getEmpleadoCapacitacionById(Integer id);
     Empleadocapacitacion saveEmpleadoCapacitacion(Empleadocapacitacion empleadocapacitacion);
     void deleteEmpleadoCapacitacion(Integer id);
    
}
