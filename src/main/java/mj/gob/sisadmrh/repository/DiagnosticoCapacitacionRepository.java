package mj.gob.sisadmrh.repository;

import java.util.List;
import mj.gob.sisadmrh.model.DiagnosticoCapacitacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jorge
 */
public interface DiagnosticoCapacitacionRepository  extends CrudRepository<DiagnosticoCapacitacion, Integer>{
      @Query(value = "SELECT dc.* FROM DiagnosticoCapacitacion dc WHERE dc.nombreubicacion LIKE :nom ", nativeQuery = true)
    Iterable<DiagnosticoCapacitacion> findByUbicacion(@Param("nom") String dato);
    
    @Query(value="SELECT \n" +
"     d.codigodiagnosticocapacitacion ,\n" +
"     d.cargoautorizadiagnosticocapacitacion ,\n" +
"     d.direccion,\n" +
"     d.mescapacitacion ,\n" +
"     d.necesidadcapacitacion ,\n" +
"     d.nombreautorizadiagnosticocapacitacion ,\n" +
"     d.resultadoobtener ,\n" +
"     d.codigocapacitacion ,\n" +
"     c.nombrecapacitacion  \n" +
"FROM  diagnosticocapacitacion d, capacitacion c where d.codigocapacitacion=c.codigocapacitacion"
            , nativeQuery = true) 
            List<Object[]>  Diagnosticoexcel(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);

               @Query("SELECT o FROM DiagnosticoCapacitacion o WHERE o.estadodiagnostico != 0")
    public Iterable<DiagnosticoCapacitacion> listAllActivos(); 
}
