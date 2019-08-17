package mj.gob.sisadmrh.repository;

import java.util.List;
import java.util.Optional;
import mj.gob.sisadmrh.model.Puesto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PuestoRepository extends CrudRepository<Puesto, Integer> {

    @Query(value = "SELECT\n"
            + "     puesto.`CODIGOPUESTO` ,\n"
            + "     puesto.`CATEGORIAPUESTO` ,\n"
            + "     puesto.`SUELDOBASE` ,\n"
            + "     puesto.`NOMBREPUESTO` ,\n"
            + "     puesto.`NOMBREJERARQUIA` ,\n"
            + "     puesto.`ESTADOPLANILLA` ,\n"
            + "     puesto.`FECHAAUTORIZACIONPUESTO` ,\n"
            + "     puesto.`FECHABAJA` ,\n"
            + "     puesto.`FECHACONTRATACIONDESDE` ,\n"
            + "     puesto.`FECHACONTRATACIONHASTA`,\n"
            + "     puesto.`FECHANOMBRAMIENTO` ,\n"
            + "     puesto.`FECHAMODIFICACION` ,\n"
            + "     puesto.`NIVELPUESTO` ,\n"
            + "     puesto.`SUBLINEA` ,\n"
            + "     puesto.`TIPOFINANZA` ,\n"
            + "     puesto.`UBICACIONPUESTO` ,\n"
            + "     puesto.`FORMAPAGO` ,\n"
            + "     puesto.`CATEGORIASUELDO` ,\n"
            + "     puesto.`FECHAVACANTE` ,\n"
            + "     puesto.`ULTIMOEMPLEADO` ,\n"
            + "     puesto.`NUMEROPARTIDAPUESTO` ,\n"
            + "     puesto.`NUMEROSUBPARTIDAPUESTO` ,\n"
            + "     puesto.`SUELDOTOPEPUESTO` ,\n"
            + "     puesto.`CODIGOCARGOPUESTO`,\n"
            + "     puesto.`FECHAAPROBACION` ,\n"
            + "     puesto.`FECHACREACION` ,\n"
            + "     puesto.`ESTADOPUESTO` \n"
            + "FROM\n"
            + "     `puesto` puesto ",
             nativeQuery = true)
    List<Object[]> PuestosoExcel(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    @Query("SELECT o FROM Puesto o WHERE o.estadopuesto != 0")
    public Iterable<Puesto> listAllActivos();
    
    @Query("SELECT o FROM Puesto o WHERE o.estadopuesto != 0 and o.codigopuesto=:id")
    public Optional<Puesto> getPuestoByIdEmpleado(@Param("id") int dato);
}
