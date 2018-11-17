/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.List;
import java.util.Optional;
import mj.gob.sisadmrh.model.Asistenciacapacitacion;


/**
 *
 * @author daniel
 */
public interface AsistenciaCapacitacionService {
    Iterable <Asistenciacapacitacion> listAllAsistenciacapacitacion();
    
    Optional<Asistenciacapacitacion> getAsistenciacapacitacionById(Integer id);

    Asistenciacapacitacion saveAsistenciacapacitacion(Asistenciacapacitacion asistenciaCapacitacion);

    void deleteAsistenciacapacitacion(Integer id);
    Iterable<Asistenciacapacitacion> findByCapacitacion(String dato);
   // servira para jalar el empleado,puesto y ubicacionfisica 
    List<Object[]> findnamesBycemp(String emp);
    
}
