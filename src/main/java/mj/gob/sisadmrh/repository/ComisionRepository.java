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
    
     @Query(value = "SELECT e.NOMBREEMPLEADO, p.nombrepuesto, c.numeroacuerdocomision, c.nombrecomision,DATE_FORMAT(c.fechadesdecomision, '%d/%m/%Y') , DATE_FORMAT(c.fechahastacomision, '%d/%m/%Y')  FROM miembroscomision m inner join comision c on m.codigocomision\n" +
"= c.codigocomision inner join empleado e on m.CODIGOEMPLEADO=e.CODIGOEMPLEADO inner join puesto p on p.codigopuesto=e.codigopuesto ",
             nativeQuery = true)
    List<Object[]> findByComisionExcel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);
}
