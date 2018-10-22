/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Dependiente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author IPalacios
 */
//public interface DependienteRepository extends CrudRepository<Dependiente, Integer>{
//    
    public interface DependienteRepository extends CrudRepository<Dependiente, Integer>{
        @Query(value = "SELECT d.* FROM dependiente d , empleadodependiente ed WHERE d.codigodependiente = ed.codigodependiente and ed.codigoempleado= :id ", nativeQuery = true)
    Iterable<Dependiente> findByDato(@Param("id") int dato);
    

    
}
