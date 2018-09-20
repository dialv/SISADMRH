/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import java.util.List;
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
    @Query(value="select  o.codigoempleado, o.nombreempleado, o.fechaingresoministerio from Empleado o where codigopuesto= 3"
            + "AND o.fechaingresoministerio >= to_date(:FINICIAL,'dd-mm-yyyy') AND o.fechaingresoministerio <= to_date(:FFINAL,'dd-mm-yyyy')", nativeQuery = true) 
             List<Object[]> findabogados(@Param("FINICIAL") String finicial, @Param("FFINAL") String ffinal);
}
