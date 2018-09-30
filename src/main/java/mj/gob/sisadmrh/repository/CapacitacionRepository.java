/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import java.util.List;
import mj.gob.sisadmrh.model.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author daniel
 */
public interface CapacitacionRepository extends CrudRepository<Capacitacion, Integer>{
    @Query(value = "SELECT c.* FROM capacitacion c "
            + "WHERE c.nombrecapacitacion LIKE :nom ", nativeQuery = true)

    Iterable<Capacitacion> findByDato(@Param("nom") String dato);

    
    
    
    
    
    
    // consulta para generar el exel
 @Query(value = "SELECT  e.nombreempleado,p.nombrepuesto,"
         + "ca.duracionhoracapacitacion,"
         + "c.nombrecapacitador,ca.nombrecapacitacion," 
+ "ca.departamentoresponsable,ca.fechacapacitaciondesde,ca.fechacapacitacionhasta from empleado e " 
+ "inner join empleadopuesto ep on e.codigopuesto=ep.codigopuesto" 
+ " inner join puesto p on ep.codigopuesto=p.codigopuesto " 
+ " inner join capacitador c on e.codigoempleado=c.codigoempleado" 
+ " inner join capacitacion ca on c.codigocapacitador=c.codigocapacitador" 
+ " where ca.codigocapacitacion = :CODIGO " 
+ " and fechacapacitaciondesde >= :FINICIAL " 
+ " and ca.fechacapacitacionhasta  <= :FFINAL ", 
         nativeQuery = true)

    public List<Object[]> findByCapacitacionesR(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal,
                                             @Param("CODIGO") String codigo);
}

