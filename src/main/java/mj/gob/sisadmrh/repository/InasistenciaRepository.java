/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Inasistencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jorge
 */
public interface InasistenciaRepository  extends CrudRepository<Inasistencia, Integer>{
 @Query(value = "SELECT i.* FROM inasistencia i "
            + "WHERE i.motivoinasistencia LIKE :nom ", nativeQuery = true)
     Iterable<Inasistencia> findByMotivo(@Param("nom") String dato);   
}
