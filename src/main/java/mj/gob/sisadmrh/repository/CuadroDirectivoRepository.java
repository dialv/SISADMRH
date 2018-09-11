/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Capacitador;
import mj.gob.sisadmrh.model.CuadroDirectivo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author daniel
 */
public interface CuadroDirectivoRepository extends CrudRepository<CuadroDirectivo, Integer>{
//     @Query(value = "SELECT cd.* FROM Cuadrodirectivo capacitador cd WHERE cd.responsablecuadrodirectivo LIKE :nom ", nativeQuery = true)
//    Iterable<CuadroDirectivo> findByDato(@Param("nom") String dato); 
    
    // sierve para buscar los cuadros directivos por area
     @Query(value = "SELECT cd.* FROM cuadrodirectivo cd "
            + "WHERE cd.area LIKE :nom ", nativeQuery = true)
     Iterable<CuadroDirectivo> findByCuadro(@Param("nom") String dato);
    
}
