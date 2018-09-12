/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Empleado;


/**
 *
 * @author jorge
 */
public interface EmpleadoService {
    Iterable <Empleado> listAllEmpleado();
    
    Optional<Empleado> getEmpleadoById(Integer id);

    Empleado saveEmpleado(Empleado empleado);

    void deleteEmpleado(Integer id);
}
