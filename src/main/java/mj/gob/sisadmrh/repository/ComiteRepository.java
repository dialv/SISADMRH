package mj.gob.sisadmrh.repository;

import java.util.List;
import mj.gob.sisadmrh.model.Comite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author daniel
 */
public interface ComiteRepository extends PagingAndSortingRepository<Comite, Integer> {

    //para buscar los empleados en comites  
    @Query(value = "SELECT c.* FROM comite c WHERE c.nombreempleado LIKE :nom ", nativeQuery = true)
    Iterable<Comite> findByDato(@Param("nom") String dato);

    // para buscar los comites por nombre
    @Query(value = "SELECT c.* FROM comite c "
            + "WHERE c.nombrecomite LIKE :nom ", nativeQuery = true)
    Iterable<Comite> findByComite(@Param("nom") String dato);

    //consulta para generar el exel
    @Query(value = "select concat(e.nombreempleado,' ',e.apellidoempleado),"
            + " p.nombrepuesto,c.numeroacuerdocomite,c.nombrecomite,c.fechadesdecomite,"
            + "c.fechahastacomite from empleado e "
            + " inner join puesto p on e.codigopuesto=p.codigopuesto "
            + " inner join comite c on e.codigoempleado=c.codigoempleado "
            + " WHERE   e.estadoempleado!=0 \n" +
"and e.estadoempleado!=2 and e.estadoempleado!=4 and  e.estadoempleado!=5\n" +
" and p.estadopuesto!=0\n" +
" and c.estadocomite!=0 and"
            + "  c.fechadesdecomite>=STR_TO_DATE(:FINICIAL, '%d/%m/%Y')"
            + " and c.fechadesdecomite<=STR_TO_DATE(:FFINAL, '%d/%m/%Y') ",
             nativeQuery = true)
    List<Object[]> findByeComitesR(@Param("FINICIAL") String finicial,
            @Param("FFINAL") String ffinal);

    @Query("SELECT o FROM Comite o WHERE o.estadocomite != 0")
    public Iterable<Comite> listAllActivos();
}
