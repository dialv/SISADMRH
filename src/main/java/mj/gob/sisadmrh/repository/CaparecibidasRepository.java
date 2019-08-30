/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Caparecibidas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author IPalacios
 */
public interface CaparecibidasRepository extends CrudRepository<Caparecibidas, Integer>{
     @Query(value = "SELECT d.* FROM caparecibidas d , empleadocaparecibidas ed WHERE d.estadocapa!=0 and d.codigocaparecibidas = ed.codigocaparecibidas and ed.codigoempleado= :id ", nativeQuery = true)
    Iterable<Caparecibidas> findByDato(@Param("id") int dato);

     @Query("SELECT o FROM Caparecibidas o WHERE o.estadocapa != 0")
            public Iterable<Caparecibidas> listAllActivos(); 
            
              @Query(value = "SELECT c.* FROM caparecibidas c WHERE c.estadocapa!=0 and "
            + " c.tipoevento=:teven  "
            + " and c.especialidad=:esp "
            + " and c.organismo=:cedu ", nativeQuery = true)
    Iterable<Caparecibidas> findIntegrity(@Param("teven") String teven, @Param("esp") String esp, @Param("cedu") String cedu);

    
    
}
