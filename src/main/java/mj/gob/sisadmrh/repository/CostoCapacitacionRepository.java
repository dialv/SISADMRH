/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Capacitador;
import mj.gob.sisadmrh.model.CostoCapacitacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author daniel
 */
public interface CostoCapacitacionRepository extends CrudRepository<CostoCapacitacion, Integer>{
        @Query(value = "SELECT c.* FROM CostoCapacitacion c WHERE c.costopersona LIKE :nom ", nativeQuery = true)
    Iterable<CostoCapacitacion> findByDato(@Param("nom") String dato);

            @Query("SELECT o FROM CostoCapacitacion o WHERE o.estadocostocapacitacion != 0")
            public Iterable<CostoCapacitacion> listAllActivos(); 
        
    
}
