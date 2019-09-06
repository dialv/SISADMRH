package mj.gob.sisadmrh.repository;

import java.util.List;
import mj.gob.sisadmrh.model.Comision;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author dialv
 */
public interface ComisionRepository extends CrudRepository<Comision, Integer>{
    @Query("SELECT o FROM Comision o WHERE o.estadocomision!= 0")
    public Iterable<Comision> listAllActivos();  
    
     @Query(value = "select concat(e.nombreempleado,' ',e.apellidoempleado) as Nombre,p.nombrepuesto,c.numeroacuerdocomision,c.nombrecomision,DATE_FORMAT(c.fechadesdecomision, '%d/%m/%Y') as Desde,DATE_FORMAT(c.fechahastacomision, '%d/%m/%Y') as Hasta from empleado e INNER JOIN puesto p on e.codigopuesto=p.codigopuesto INNER join comision c on e.codigoempleado=c.codigoempleado\n" +
"WHERE e.estadoempleado!=0 and e.estadoempleado!=4 and  e.estadoempleado!=5 and e.estadoempleado!=2 and p.estadopuesto!=0 and c.estadocomision!=0 and c.fechadesdecomision>= STR_TO_DATE(:FINICIAL, '%d/%m/%Y')\n" +
"and c.fechadesdecomision<=STR_TO_DATE(:FFINAL, '%d/%m/%Y')",
             nativeQuery = true)
    List<Object[]> findByComisionExcel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);
}
