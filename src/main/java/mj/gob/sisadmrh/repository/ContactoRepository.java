/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Contacto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author IPalacios
 */

public interface ContactoRepository extends CrudRepository<Contacto, Integer>{
        @Query(value = "SELECT c.* FROM contacto c, empleadocontacto ec WHERE c.estadocontacto!= '0' and c.codigocontacto = ec.codigocontacto and ec.codigoempleado= :id ", nativeQuery = true)
    Iterable<Contacto> findByDato(@Param("id") int dato);
    
    @Query("SELECT o FROM Contacto o WHERE o.estadocontacto != '0'")
    public Iterable<Contacto> listAllActivos();     

}