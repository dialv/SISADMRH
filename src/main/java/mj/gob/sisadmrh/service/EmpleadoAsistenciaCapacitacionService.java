/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleadoasistenciacapacitacion;

/**
 *
 * @author jorge
 */
public interface EmpleadoAsistenciaCapacitacionService {
//    Iterable <Empleadoasistenciacapacitacion> listAllEmpleadoAsistenciaCapacitacion();
    
//    Optional<Empleadoasistenciacapacitacion> getEmpleadoAsistenciaCapacitacionById(Integer id);
//     Empleadoasistenciacapacitacion saveEmpleadoAsistenciaCapacitacion(Empleadoasistenciacapacitacion empleadoasistenciacapacitacion);
//     void deleteEmpleadoAsistenciaCapacitacion(Integer id);
     
     
     Iterable <Empleadoasistenciacapacitacion> listAllEmpleadoAsistenciaCapacitacion();
    
    Optional<Empleadoasistenciacapacitacion> getEmpleadoAsistenciaCapacitacionById(Integer id);

    Empleadoasistenciacapacitacion saveEmpleadoAsistenciaCapacitacion(Empleadoasistenciacapacitacion empleadoasistenciacapacitacion);

    void deleteEmpleadoAsistenciaCapacitacion(Integer id);
    
}
