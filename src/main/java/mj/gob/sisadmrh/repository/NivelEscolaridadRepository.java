/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.NivelEscolaridad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface NivelEscolaridadRepository extends CrudRepository<NivelEscolaridad, Integer>{
     
    @Query("SELECT o FROM NivelEscolaridad o WHERE o.estadonivelescolaridad!= 0")
    public Iterable<NivelEscolaridad> listAllActivos(); 
}
