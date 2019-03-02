package mj.gob.sisadmrh.repository;

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
    
    @Query(value="SELECT\n" +
"     diagnosticocapacitacion.codigodiagnosticocapacitacion ,\n" +
"     diagnosticocapacitacion.cargoautorizadiagnosticocapacitacion ,\n" +
"     diagnosticocapacitacion.direccion,\n" +
"     diagnosticocapacitacion.mescapacitacion ,\n" +
"     diagnosticocapacitacion.necesidadcapacitacion ,\n" +
"     diagnosticocapacitacion.nombreautorizadiagnosticocapacitacion ,\n" +
"     diagnosticocapacitacion.resultadoobtener ,\n" +
"     diagnosticocapacitacion.codigocapacitacion ,\n" +
"     diagnosticocapacitacion.temacapacitacion  \n" +
"FROM\n" +
"     diagnosticocapacitacion diagnosticocapacitacion"
            , nativeQuery = true) 
            Iterable <DiagnosticoCapacitacion> Diagnosticoexcel(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);

               @Query("SELECT o FROM DiagnosticoCapacitacion o WHERE o.estadodiagnostico != 0")
    public Iterable<DiagnosticoCapacitacion> listAllActivos(); 
}
