/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.List;
import java.util.Optional;
import mj.gob.sisadmrh.model.AsistenciaCapacitacion;


/**
 *
 * @author daniel
 */
public interface AsistenciaCapacitacionService {
    Iterable <AsistenciaCapacitacion> listAllAsistenciacapacitacion();
    
    Optional<AsistenciaCapacitacion> getAsistenciacapacitacionById(Integer id);

    AsistenciaCapacitacion saveAsistenciacapacitacion(AsistenciaCapacitacion asistenciaCapacitacion);

    void deleteAsistenciacapacitacion(Integer id);
    Iterable<AsistenciaCapacitacion> findByCapacitacion(String dato);
   // servira para jalar el empleado,puesto y ubicacionfisica 
    List<Object[]> findnamesBycemp(String emp);
    
}
