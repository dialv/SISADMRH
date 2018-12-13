/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import java.util.List;
import mj.gob.sisadmrh.model.Capacitador;
import mj.gob.sisadmrh.model.Comite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author daniel
 */
public interface ComiteRepository extends PagingAndSortingRepository<Comite, Integer>{
    //para buscar los empleados en comites  
    @Query(value = "SELECT c.* FROM comite c WHERE c.nombreempleado LIKE :nom ", nativeQuery = true)
    Iterable<Comite> findByDato(@Param("nom") String dato);
    
    
    
    // para buscar los comites por nombre

    @Query(value = "SELECT c.* FROM comite c "
            + "WHERE c.nombrecomite LIKE :nom ", nativeQuery = true)
     Iterable<Comite> findByComite(@Param("nom") String dato);
     
     
     
     //consulta para generar el exel
     @Query(value="select  e.nombreempleado,p.nombrepuesto,c.numeroacuerdocomite,c.nombrecomite,c.fechadesdecomite,c.fechahastacomite from empleado e \n" +
" inner join empleadopuesto ep ON ep.codigoempleado=e.codigoempleado inner join puesto p on ep.codigopuesto=p.codigopuesto INNER join comite c on e.codigoempleado=c.codigoempleado\n" +
"WHERE  c.fechadesdecomite>=:FINICIAL\n" +
"and c.fechahastacomite<=:FFINAL "
, nativeQuery = true) 
  List<Object[]> findByeComitesR(@Param("FINICIAL") String finicial, 
                                             @Param("FFINAL") String ffinal);
                                           //  @Param("CODIGO") String codigo);
}
