/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import java.util.List;
import mj.gob.sisadmrh.model.Mision;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author dialv
 */

//para generar el reporte de excel de misiones externas `
public interface MisionRepository extends CrudRepository<Mision, Integer>{
    //Para generar reportes de Misiones Externas1
    @Query(value="select e.nombreempleado,p.nombrepuesto,m.nombremision,m.objetivomision,m.departamentomision,m.paisdestino,m.ciudad from empleado e"
            + " inner join empleadopuesto ep on e.codigopuesto=ep.codigopuesto "
            + " inner join puesto p on ep.codigopuesto=p.codigopuesto "
            + " inner join empleadomision em on e.codigoempleado=em.codigoempleado "
            + " inner join mision m on em.codigomision=m.codigomision" 
            + " where m.fechasalidamision >= :FINICIAL and m.fecharegresomision <= :FFINAL "
, nativeQuery = true)

    List<Object[]> findByMisionExterna1(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
    //Para generar reportes de Misiones Externas2
    @Query(value = "SELECT  m.fechasalidamision,m.fecharegresomision,m.gastoviaje,m.numeroacuerdo,m.boleto,m.viaticos,m.organismopatrocinador,"
            + "m.organismoinvita from empleado e " +
" inner join empleadopuesto ep on e.codigopuesto=ep.codigopuesto inner join puesto p on ep.codigopuesto=p.codigopuesto " +
" inner join empleadomision em on e.codigoempleado=em.codigoempleado inner join mision m on em.codigomision=m.codigomision " +

" where m.fechasalidamision>=:FINICIAL" +
" AND m.fecharegresomision<=:FFINAL",nativeQuery = true)
List<Object[]> findByMisionExterna2(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
//Para generar reporte de Misiones internas
@Query(value = "select  e.nombreempleado,p.nombrepuesto,m.nombremision,"
        + "m.objetivomision,m.fechasalidamision,m.fecharegresomision,m.departamentomision from e.nombreempleado,p.nombrepuesto,m.nombremision,m.objetivomision,m.fechasalidamision,m.fecharegresomision,m.departamentomision from mision m inner join empleadomision em on m.codigomision=em.codigomision inner join empleado e on e.codigoempleado=em.codigoempleado inner join empleadopuesto ep on e.codigoempleado=ep.codigoempleado inner join puesto p on p.codigopuesto=ep.codigopuesto"
     + " where m.fechasalidamision>=:FINICIAL" 
+ " AND m.fecharegresomision<=:FFINAL",nativeQuery = true)
List<Object[]> findByMisionInterna(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);

    //Para generar reporte de Misiones internas
   
    
}
