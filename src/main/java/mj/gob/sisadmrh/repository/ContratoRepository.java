/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Contrato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author IPalacios
 */
public interface ContratoRepository extends CrudRepository<Contrato, Integer>{
       @Query(value = "SELECT d.* FROM contrato d  WHERE d.estadocontrato != 0 and d.codigoempleado= :id ", nativeQuery = true)
    Iterable<Contrato> findByDato(@Param("id") int dato);


     @Query("SELECT o FROM Contrato o WHERE o.estadocontrato != 0")
            public Iterable<Contrato> listAllActivos();     
}
