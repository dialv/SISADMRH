/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

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
}
