/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Capacitacion;
import mj.gob.sisadmrh.model.Capacitador;
import mj.gob.sisadmrh.model.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jorge
 */
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer>{
//      @Query(value = "SELECT c.* FROM capacitador c "
//            + "WHERE c.nombrecapacitador LIKE :nom ", nativeQuery = true)
//
//    Iterable<Capacitador> findByDato(@Param("nom") String dato);
    
}
