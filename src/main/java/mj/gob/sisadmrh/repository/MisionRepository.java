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
    @Query(value="select  concat(e.nombreempleado,' ',e.apellidoempleado) as Empleado,p.nombrepuesto,m.nombremision,m.objetivomision,m.departamentomision,m.paisdestino,m.ciudad from mision m inner join empleadomision em on m.codigomision=em.codigomision inner join empleado e on e.codigoempleado=em.codigoempleado inner join empleadomision ep on m.codigomision=ep.codigomision inner join puesto p on p.codigopuesto=e.codigopuesto\n" +
"where e.estadoempleado in(1,3) and m.estadomision=1 and p.estadopuesto!=0 and  tipomision=1 and m.fechasalidamision >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') and m.fechasalidamision <= STR_TO_DATE(:FFINAL, '%d/%m/%Y')  "
, nativeQuery = true)

    List<Object[]> findByMisionExterna1(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
    //Para generar reportes de Misiones Externas2
    @Query(value = "SELECT  DATE_FORMAT(m.fechasalidamision, '%d/%m/%Y') as Desde, DATE_FORMAT(m.fecharegresomision, '%d/%m/%Y') as Hasta, m.gastoviaje,m.numeroacuerdo,m.boleto,m.viaticos ,m.organismopatrocinador,m.organismoinvita from mision m inner join empleadomision em on m.codigomision=em.codigomision inner join empleado e on e.codigoempleado=em.codigoempleado inner join empleadomision ep on m.codigomision=ep.codigomision inner join puesto p on p.codigopuesto=e.codigopuesto\n" +
"where e.estadoempleado in(1,3) and m.estadomision=1 and p.estadopuesto!=0 and tipomision =1 and m.fechasalidamision >= STR_TO_DATE(:FINICIAL, '%d/%m/%Y') and m.fechasalidamision <= STR_TO_DATE(:FFINAL, '%d/%m/%Y')  ",nativeQuery = true)
List<Object[]> findByMisionExterna2(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
//Para generar reporte de Misiones internas
@Query(value = "select  concat(e.nombreempleado, ' ', e.apellidoempleado) as Empleado,p.nombrepuesto,m.nombremision,m.objetivomision,DATE_FORMAT(m.fechasalidamision, '%d/%m/%Y') as Desde, DATE_FORMAT(m.fecharegresomision, '%d/%m/%Y') as Hasta from mision m inner join empleadomision em on m.codigomision=em.codigomision inner join empleado e on e.codigoempleado=em.codigoempleado inner join puesto p on e.codigopuesto=p.codigopuesto\n" +
"where e.estadoempleado in(1,3) and m.estadomision=1 and p.estadopuesto!=0 and tipomision =2 and m.fechasalidamision>=STR_TO_DATE(:FINICIAL, '%d/%m/%Y')" 
+ " AND m.fechasalidamision<=STR_TO_DATE(:FFINAL, '%d/%m/%Y')  ",nativeQuery = true)
List<Object[]> findByMisionInterna(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);

@Query("SELECT o FROM Mision o WHERE o.estadomision != 0")
    public Iterable<Mision> listAllActivos(); 
}
