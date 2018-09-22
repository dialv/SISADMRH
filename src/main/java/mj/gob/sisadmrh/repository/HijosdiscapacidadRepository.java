/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Hijodiscapacidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author IPalacios
 */
public interface HijosdiscapacidadRepository extends CrudRepository<Hijodiscapacidad, Integer>{
    @Query(value = "SELECT d.* FROM hijodiscapacidad d , empleadohijodiscapacidad ed WHERE d.codigohijodiscapacidad = ed.codigohijodiscapacidad and ed.codigoempleado= :id ", nativeQuery = true)
    Iterable<Hijodiscapacidad> findByDato(@Param("id") int dato);
}
