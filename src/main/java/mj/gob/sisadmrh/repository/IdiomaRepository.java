/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Idioma;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author IPalacios
 */

public interface IdiomaRepository extends CrudRepository<Idioma, Integer>{
        @Query(value = "SELECT c.* FROM idioma c, empleadoidioma ec WHERE c.estadoidioma != 0 and c.codigoidioma = ec.codigoidioma and ec.codigoempleado= :id ", nativeQuery = true)
    Iterable<Idioma> findByDato(@Param("id") int dato);
    
     @Query("SELECT o FROM Idioma o WHERE o.estadoidioma != 0")
    public Iterable<Idioma> listAllActivos();    
    
    
    @Query(value = "SELECT o FROM Idioma o WHERE o.estadoidioma != 0"
            + "and o.nombreidioma=:nomb"
            + "and o.escribe=:esc"
            + "and o.nivel=:niv", nativeQuery = true)
    
    Iterable<Idioma> findByUbicacion(@Param("nomb") String nomb, @Param("esc") String esc, @Param("niv") String niv);
    
}