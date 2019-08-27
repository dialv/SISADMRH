/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import java.util.List;
import mj.gob.sisadmrh.model.Hijodiscapacidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author IPalacios
 */
public interface HijosdiscapacidadRepository extends CrudRepository<Hijodiscapacidad, Integer>{
    @Query(value = "SELECT d.* FROM hijodiscapacidad d , empleadohijodiscapacidad ed WHERE d.estadohijos != 0 and d.codigohijodiscapacidad = ed.codigohijodiscapacidad and ed.codigoempleado= :id ", nativeQuery = true)
    Iterable<Hijodiscapacidad> findByDato(@Param("id") int dato);
    
    @Query(value =  " select  e.codigoempleado, e.nombreempleado, p.tipodiscapacidad," +
                    " p.nombrehijodiscapacidad from empleadohijodiscapacidad h" +
                    " inner join empleado e on e.codigoempleado=h.codigoempleado" +
                    " inner join hijodiscapacidad p on h.codigohijodiscapacidad = p.codigohijodiscapacidad ", nativeQuery = true)
     List<Object[]> findhijoscap();
         @Query("SELECT o FROM Hijodiscapacidad o WHERE o.estadohijos != 0")
    public Iterable<Hijodiscapacidad> listAllActivos();    
    
    @Query(value = "SELECT u FROM Hijodiscapacidad u WHERE u.estadohijos != 0 "
            + " and u.nombrehijodiscapacidad = :nomb "
            + " and u.apellidohijodiscapacidad = :ape "
            + " and u.nombrediscapacidad = :disc ", nativeQuery = true)
    
    Iterable<Hijodiscapacidad> findIntegrity(@Param("nomb") String dato, @Param("ape") String ape, @Param("disc") String disc);
    
}
