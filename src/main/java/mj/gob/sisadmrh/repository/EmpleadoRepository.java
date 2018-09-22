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
    @Query(value="select  o.* from empleado o where codigopuesto= :tipo"
            + " AND o.fechaingresoministerio >= :FINICIAL "
            + " AND o.fechaingresoministerio <= :FFINAL"
            , nativeQuery = true) 
            Iterable <Empleado> findabogados(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal,
                                             @Param("tipo") Integer tipo);
            
    @Query(value="SELECT e.nombreempleado,p.nombrepuesto,c.numeroacuerdocomite,"
            + "c.nombrecomite,c.fechadesdecomite,c.fechahastacomite FROM empleado e "
            + "inner join empleadopuesto ep on e.codigopuesto=ep.codigopuesto "
            + "inner join puesto p on ep.codigopuesto=p.codigopuesto "
            + "INNER JOIN comite c on e.codigoempleado=c.codigoempleado "
            + "where c.fechadesdecomite >= :FINICIAL  and c.fechahastacomite <= :FFINAL"
            , nativeQuery = true) 
            List<Object[]> renuncias(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
}
