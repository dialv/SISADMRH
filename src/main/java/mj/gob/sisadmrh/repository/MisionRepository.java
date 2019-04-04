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
    @Query(value="select  concat(e.nombreempleado,' ',e.apellidoempleado),p.nombrepuesto,m.nombremision,m.objetivomision,m.departamentomision,m.paisdestino,m.ciudad from mision m inner join empleadomision em on m.codigomision=em.codigomision inner join empleado e on e.codigoempleado=em.codigoempleado  inner join puesto p on e.codigopuesto=p.codigopuesto "
            + " where m.fechasalidamision >= :FINICIAL and m.fechasalidamision <= :FFINAL and tipomision=0  "
, nativeQuery = true)

    List<Object[]> findByMisionExterna1(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
    //Para generar reportes de Misiones Externas2
    @Query(value = "SELECT  DATE_FORMAT(m.fechasalidamision, '%d/%m/%Y') , DATE_FORMAT(m.fecharegresomision, '%d/%m/%Y'),m.gastoviaje,m.numeroacuerdo,m.boleto,m.organismopatrocinador,"
            + "m.organismoinvita  from mision m "
        + " inner join empleadomision em on m.codigomision=em.codigomision "
        + " inner join empleado e on e.codigoempleado=em.codigoempleado "
      
        + " inner join puesto p on e.codigopuesto=p.codigopuesto  "+
" where m.fechasalidamision>=:FINICIAL" +
" AND m.fechasalidamision<=:FFINAL and tipomision=0 ",nativeQuery = true)
List<Object[]> findByMisionExterna2(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
//Para generar reporte de Misiones internas
@Query(value = "select  concat(e.nombreempleado,' ',e.apellidoempleado),p.nombrepuesto,m.nombremision,m.objetivomision,DATE_FORMAT(m.fechasalidamision, '%d/%m/%Y') , DATE_FORMAT(m.fecharegresomision, '%d/%m/%Y') ,m.departamentomision from mision m inner join empleadomision em on m.codigomision=em.codigomision inner join empleado e on e.codigoempleado=em.codigoempleado inner join puesto p on e.codigopuesto=p.codigopuesto"
     + " where m.fechasalidamision>=:FINICIAL" 
+ " AND m.fechasalidamision<=:FFINAL and tipomision=1 ",nativeQuery = true)
List<Object[]> findByMisionInterna(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);

@Query("SELECT o FROM Mision o WHERE o.estadomision != 0")
    public Iterable<Mision> listAllActivos(); 
}
